package com.afdm.gestionpedidos.model.dao;

import java.util.List;

import com.afdm.gestionpedidos.model.*;

public interface CustomerDAO {

	public Customer findCustomerById(String customerId);
	
	public List<Customer> findCustomerByCompanyName(String companyName);
	
	public List<Customer> findAllCustomer();
	
	public boolean  registerCustomer(Customer customer);
	
}
