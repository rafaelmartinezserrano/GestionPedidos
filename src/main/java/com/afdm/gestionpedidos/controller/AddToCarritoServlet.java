package com.afdm.gestionpedidos.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.afdm.gestionpedidos.model.carrito.Carrito;
import com.afdm.gestionpedidos.model.carrito.CarritoElement;
import com.afdm.gestionpedidos.model.Product;

import com.afdm.gestionpedidos.model.facade.GestionPedidosDelegate;
import com.afdm.gestionpedidos.model.facade.GestionPedidosFacade;

/**
 * Servlet implementation class AddToCarritoServlet
 */
public class AddToCarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String productId = request.getParameter("productId");
		String quantity = request.getParameter("quantity");
		Carrito carrito = (Carrito)request.getSession().getAttribute("carrito");
		
		GestionPedidosDelegate facade = new GestionPedidosFacade();
		try {
			Product product = facade.findProductById(Integer.parseInt(productId));
			CarritoElement carritoElement = new CarritoElement(product, Integer.parseInt(quantity));
			
			carrito.addToCarrito(carritoElement);
			
			request.getSession().setAttribute("carrito", carrito);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
