package com.afdm.gestionpedidos.model.facade;

import java.util.List;

import com.afdm.gestionpedidos.model.*;

public interface GestionPedidosDelegate {

	public boolean login();
	
	public List<Product> findProductByCategory(int idCategory);
	
	public boolean createOrder(Order pedido);
	
	public Product findProductById(int idProduct);
	
	
	
}
