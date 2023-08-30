package com.afdm.gestionpedidos.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.afdm.gestionpedidos.model.Product;
import com.afdm.gestionpedidos.model.facade.GestionPedidosFacade;

/**
 * Servlet implementation class LoadProductServlet
 */
public class LoadProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productId = request.getParameter("busquedaId");
		int id = Integer.parseInt(productId);
		
		GestionPedidosFacade facade = new GestionPedidosFacade();
		
		Product product = null;
		
		try {
			
			product = facade.findProductById(id);
			
			if(product != null) {
				
				request.setAttribute("product", product);
				request.getRequestDispatcher("modificarProducto.jsp").forward(request, response);
				
			} 
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}


}
