package com.afdm.gestionpedidos.model.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

import com.afdm.gestionpedidos.model.Category;
import com.afdm.gestionpedidos.model.Orders;
import com.afdm.gestionpedidos.model.Product;

import jakarta.persistence.TypedQuery;

public class ProductHibernateDAO implements ProductDAO {

	@Override
	public Product findProductById(int idProduct) {
		
		Product product = null;
		
		Session session = DaoUtility.getSession();
		Transaction transaction = session.beginTransaction();
		
		try {
			product = session.get(Product.class, idProduct);
			transaction.commit();
			
		} catch(HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}
		
		session.clear();
		
		return product;
	}

	@Override
	public List<Product> findProductByName(String productName) {
		
		List<Product> products = null;
		
		Session session = DaoUtility.getSession();
		Transaction transaction = session.beginTransaction();
		
		try {
			
			TypedQuery<Product> query = session.createQuery("FROM Product WHERE productName LIKE :productname AND discontinued = FALSE", Product.class);
			query.setParameter("productName", productName + "%");
			products = query.getResultList();
			transaction.commit();
					
		} catch(HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}
		
		return products;

	}

	@Override
	public List<Product> findProductByCategory(int categoryId) {
		
		Category category = new Category(categoryId, null, null);
		
		List<Product> products = null;
		
		Session session = DaoUtility.getSession();
		Transaction transaction = session.beginTransaction();
		
		try {
			
			TypedQuery<Product> query = session.createQuery("FROM Product p WHERE category = :category AND discontinued = FALSE", Product.class);
			query.setParameter("category", category);
			products = query.getResultList();
			transaction.commit();
					
		} catch(HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}
		
		return products;
	}

	@Override
	public boolean updateProduct(int idProduct, double price, int stock) {
		
		boolean insertado = true;
		Session sesion = DaoUtility.getSession();
		Transaction transaction = sesion.beginTransaction();
		try {
			MutationQuery query = sesion.createMutationQuery("update Product p set p.unitPrice = :precio, p.unitsInStock = :stock where p.productID = :productID");
			query.setParameter("precio", price);
			query.setParameter("stock", stock);
			query.setParameter("productID", idProduct);
			query.executeUpdate();
			transaction.commit();
			sesion.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
			insertado = false;
		}
		return insertado;
	}

}
