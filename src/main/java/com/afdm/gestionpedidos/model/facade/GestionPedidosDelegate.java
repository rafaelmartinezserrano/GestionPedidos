package com.afdm.gestionpedidos.model.facade;

import java.util.List;

import com.afdm.gestionpedidos.model.Category;
import com.afdm.gestionpedidos.model.Customer;
import com.afdm.gestionpedidos.model.Employee;
import com.afdm.gestionpedidos.model.Orders;
import com.afdm.gestionpedidos.model.Product;

public interface GestionPedidosDelegate {

	public boolean login(String tipo, String nombre, String apellidos);
	
	public List<Product> findProductByCategory(int idCategory);
	
	public boolean createOrder(Orders pedido);
	
	public Product findProductById(int idProduct);

	public List<Category> findAllCategory();

	public boolean signUpCustomer(Customer customer);

	boolean registerEmployee(Employee employee);

	boolean updateProduct(int idProducto, double price, int stock);
	
	public List<Customer> findAllCustomer();
	
}
