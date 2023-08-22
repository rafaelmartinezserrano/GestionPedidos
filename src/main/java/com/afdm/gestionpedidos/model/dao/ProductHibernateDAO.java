package com.afdm.gestionpedidos.model.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.afdm.gestionpedidos.model.Product

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findProductByCategory(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

}
