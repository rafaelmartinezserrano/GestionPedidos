package com.afdm.gestionpedidos.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.afdm.gestionpedidos.model.Product;
import com.afdm.gestionpedidos.model.carrito.Carrito;
import com.afdm.gestionpedidos.model.carrito.CarritoElement;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChangeQuantityFromCarritoServlet
 */
public class ChangeQuantityFromCarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cantidad = Integer.parseInt(request.getParameter("cant"));
		int idProducto = Integer.parseInt(request.getParameter("idProduct"));
		Carrito carrito = (Carrito)request.getSession().getAttribute("carrito");
		CarritoElement elemento = new CarritoElement(new Product(idProducto), cantidad);
		boolean modificado = carrito.modifyCarrito(elemento);
		request.getSession().setAttribute("carrito", carrito);
		response.setContentType("application/json;charset=utf-8");
		PrintWriter salida = response.getWriter();
		salida.write(Boolean.toString(modificado));
		salida.close();
	}

}
