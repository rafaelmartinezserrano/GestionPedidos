package com.afdm.gestionpedidos.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.afdm.gestionpedidos.model.Customer;
import com.afdm.gestionpedidos.model.OrderDetail;
import com.afdm.gestionpedidos.model.Orders;
import com.afdm.gestionpedidos.model.carrito.Carrito;
import com.afdm.gestionpedidos.model.carrito.CarritoElement;
import com.afdm.gestionpedidos.model.facade.GestionPedidosDelegate;
import com.afdm.gestionpedidos.model.facade.GestionPedidosFacade;

/**
 * Servlet implementation class CarritoCompraServlet
 */
public class CarritoCompraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Carrito carrito = (Carrito)request.getSession().getAttribute("carrito");
		String customerID = carrito.getIdCustomer();
		GestionPedidosDelegate fachada = new GestionPedidosFacade();
		Customer customer = fachada.findCustommerById(customerID);
		List<CarritoElement> listaCarrito =	carrito.getListOD();
		Orders order = new Orders(customer, null, new ArrayList<OrderDetail>(), LocalDate.now(), null, null, 0.0, customer.getContactName(), customer.getAddress(), customer.getCity(), customer.getRegion(), customer.getPostalCode(), customer.getCountry());
		for (CarritoElement carritoElemento : listaCarrito) {
			OrderDetail orderdetail = new OrderDetail(carritoElemento.getProduct(), carritoElemento.getProduct().getUnitPrice(), carritoElemento.getQuantity(), 0.0, order);	
			order.addOD(orderdetail);
			
		}
		fachada.createOrder(order);
		response.sendRedirect("principal.jsp");
	/*	crear el order;
		recorrer esa lista;
		para cada carritoelement convertiro en OD
		añadir el od alñ order*/
		
	}


}
