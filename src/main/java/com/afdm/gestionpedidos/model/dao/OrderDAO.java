package com.afdm.gestionpedidos.model.dao;

import java.time.LocalDate;
import java.util.List;

import com.afdm.gestionpedidos.model.*;

public interface OrderDAO {

	public Orders findOrderById(int orderId);
	
	public List<Orders> findOrdersByCustomer(String customerId);
	
	public Orders insertOrder(Orders order);

	public void deleteOrderById (int orderId);

	public Orders editOrder (Orders order);
	
}
