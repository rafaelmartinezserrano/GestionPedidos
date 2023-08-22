package com.afdm.gestionpedidos.model.dao;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.TypedQuery;



public class CategoryHibernateDAO implements CategoryDAO {
	

	@Override
	public Category findCategoryById(int idCategory) {
		Category category = null;
		Session sesion = DaoUtility.getSession();
		Transaction transaccion = sesion.beginTransaction();
		try {
			category = sesion.get(Category.class, idCategory);
			transaccion.commit();
		} catch(HibernateException e) {			
			e.printStackTrace();
			transaccion.rollback();
		}
		sesion.close();
		return category;
	}

	@Override
	public Category findCategoryByName(String categoryName) {
		Category category = null;
		Session sesion = DaoUtility.getSession();
		Transaction transaccion = sesion.beginTransaction();
		try {
			TypedQuery<Category> busqueda = sesion.createQuery("from Category where categoryName like :categoryName", Category.class);
			busqueda.setParameter("categoryname", "%" + categoryName + "%");
			transaccion.commit();
		} catch(HibernateException e) {			
			e.printStackTrace();
			transaccion.rollback();
		}
		sesion.close();
		return category;
	}

	@Override
	public List<Category> findAllCategory() {
		List<Category> listCategory = null;
		Session sesion = DaoUtility.getSession();
		Transaction transaccion = sesion.beginTransaction();
		try {
			TypedQuery<Category> busqueda = sesion.createQuery("from Category", Category.class);
			listCategory = busqueda.getResultList();
			transaccion.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			transaccion.rollback();
		}
		sesion.close();
		return listCategory;
	}

}
