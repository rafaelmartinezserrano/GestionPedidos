package com.afdm.gestionpedidos.model.dao;

import java.util.List;

import com.afdm.gestionpedidos.model.*;

public interface OrderDAO {

	public Orders findOrderById(int orderId);
	
	public List<Orders> findOrdersByCustomer(String customerId);
	
	public Orders insertOrder(Orders order);
	
}
