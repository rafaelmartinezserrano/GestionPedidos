package com.afdm.gestionpedidos.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.afdm.gestionpedidos.model.Category;
import com.afdm.gestionpedidos.model.Product;
import com.afdm.gestionpedidos.model.facade.GestionPedidosDelegate;
import com.afdm.gestionpedidos.model.facade.GestionPedidosFacade;


public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Category category = (Category)request.getAttribute("category");
		int idProducto = Integer.parseInt(request.getParameter("productID"));
		double price = Double.parseDouble(request.getParameter("unitPrice"));
		int stock = Integer.parseInt(request.getParameter("unitsInStock"));
		GestionPedidosDelegate facade = new GestionPedidosFacade();
		
		try {	
			boolean modificado = facade.updateProduct(idProducto, price, stock);
			
			if(modificado) {				
				request.setAttribute("mensaje","Se ha modificado correctamente");
			} else {
				request.setAttribute("mensaje", "No se ha podido modificar");
			}
			
			request.getRequestDispatcher("modificarProducto.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	
	}

}
