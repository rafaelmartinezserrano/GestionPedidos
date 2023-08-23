package com.afdm.gestionpedidos.model.facade;

import java.util.List;

import com.afdm.gestionpedidos.model.Customer;
import com.afdm.gestionpedidos.model.Employee;
import com.afdm.gestionpedidos.model.Orders;
import com.afdm.gestionpedidos.model.Product;
import com.afdm.gestionpedidos.model.dao.CustomerDAO;
import com.afdm.gestionpedidos.model.dao.CustomerHibernateDAO;
import com.afdm.gestionpedidos.model.dao.EmployeeDAO;
import com.afdm.gestionpedidos.model.dao.EmployeeHibernateDAO;
import com.afdm.gestionpedidos.model.dao.ProductHibernateDAO;

public class GestionPedidosFacade implements GestionPedidosDelegate {

	@Override
	public boolean login(String tipo, String nombre, String apellidos) {
		boolean correcto = false;
		if (tipo.equals("customer")) {
			CustomerDAO dao = new CustomerHibernateDAO();
			Customer customer = dao.findCustomerById(nombre);
			correcto = customer != null;
		} else if (tipo.equals("employee")) {
			EmployeeDAO dao = new EmployeeHibernateDAO();
			Employee employee = dao.findEmployeeByName(nombre, apellidos);
			correcto = employee != null;
		}
		return correcto;
	}

	@Override
	public List<Product> findProductByCategory(int idCategory) {
		
		return null;
	}

	@Override
	public boolean createOrder(Orders pedido) {

		return false;
	}

	@Override
	public Product findProductById(int idProduct) {

		return null;
	}




}
