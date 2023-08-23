package com.afdm.gestionpedidos.model.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
			
			TypedQuery<Product> query = session.createQuery("FROM product WHERE productName LIKE :productname AND discontinued = TRUE", Product.class);
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
		
		List<Product> products = null;
		
		Session session = DaoUtility.getSession();
		Transaction transaction = session.beginTransaction();
		
		try {
			
			TypedQuery<Product> query = session.createQuery("FROM product p WHERE category = :categoryId AND discontinued = TRUE", Product.class);
			query.setParameter("categoryId", categoryId);
			products = query.getResultList();
			transaction.commit();
					
		} catch(HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}
		
		return products;
	}

}
