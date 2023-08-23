package com.afdm.gestionpedidos.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.afdm.gestionpedidos.model.Customer;

import jakarta.persistence.TypedQuery;

public class CustomerHibernateDAO implements CustomerDAO{

	@Override
	public Customer findCustomerById(String customerId) {
		Customer customer = null;
		Session session = DaoUtility.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			customer = session.get(Customer.class, customerId);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}
		session.close();
		return customer;
	}

	@Override
	public List<Customer> findCustomerByCompanyName(String companyName) {
		List<Customer> customersByCompanyNameList = new ArrayList<>();
		Session session = DaoUtility.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			TypedQuery<Customer> sentence = session.createQuery("select c from Customer c where companyName like :name", Customer.class);
			sentence.setParameter("name", "%" + companyName + "%");
			customersByCompanyNameList = sentence.getResultList();
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}
		session.close();
		return customersByCompanyNameList;
	}

	@Override
	public List<Customer> findAllCustomer() {
		List<Customer> customersList = new ArrayList<>();
		Session session = DaoUtility.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			TypedQuery<Customer> sentence = session.createQuery("select c from Customer c", Customer.class);
			customersList = sentence.getResultList();
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}
		session.close();
		return customersList;
	}
}
