package com.afdm.gestionpedidos.model.dao;

import java.util.List;

import com.afdm.gestionpedidos.model.*;

public interface OrderDAO {

	public Order findOrderById(int orderId);
	
	public List<Order> findOrdersByCustomer(String customerId);
	
	public Order insertOrder(Order order);
	
}
