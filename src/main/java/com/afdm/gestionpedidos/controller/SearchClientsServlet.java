package com.afdm.gestionpedidos.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.afdm.gestionpedidos.model.Category;
import com.afdm.gestionpedidos.model.Customer;
import com.afdm.gestionpedidos.model.facade.GestionPedidosDelegate;
import com.afdm.gestionpedidos.model.facade.GestionPedidosFacade;

/**
 * Servlet implementation class SearchClientsServlet
 */
public class SearchClientsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionPedidosDelegate facade = new GestionPedidosFacade();
		
		try {
			List<Customer> clientList = facade.findAllCustomer();
			request.setAttribute("clientList", clientList);
			request.getRequestDispatcher("listaClientes.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
