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
		
		Category category = (Category)request.getAttribute("category");
		String productName = request.getParameter("productName");
		String quantity = request.getParameter("quantityPerUnit");
		double price = Double.parseDouble(request.getParameter("unitPrice"));
		int stock = Integer.parseInt(request.getParameter("unitsInStock"));
		int units = Integer.parseInt(request.getParameter("unitsOnOrder"));
		String reorderLevel = request.getParameter("reorderLevel");
		boolean discontinued = 		Boolean.parseBoolean(request.getParameter("discontinued"));
		GestionPedidosDelegate facade = new GestionPedidosFacade();
		
		try {	
			Product updateProduct = new Product(category, productName, quantity,price, stock, units, 			reorderLevel,discontinued);
			boolean modificado = facade.updateProduct(updateProduct);
			
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
