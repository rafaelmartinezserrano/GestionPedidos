package com.afdm.gestionpedidos.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.afdm.gestionpedidos.model.Product;
import com.afdm.gestionpedidos.model.carrito.Carrito;
import com.afdm.gestionpedidos.model.carrito.CarritoElement;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class DeleteProductFromCarritoServlet
 */
public class DeleteProductFromCarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Carrito carrito = (Carrito)request.getSession().getAttribute("carrito");
		int productId = Integer.parseInt(request.getParameter("prod"));
		System.out.println("*******" + productId);
		PrintWriter salida = response.getWriter();
		if (carrito.removeFromCarrito(productId)) {
				request.getSession().setAttribute("carrito", carrito);
				ObjectMapper mapeador = new ObjectMapper();
				String json = mapeador.writeValueAsString(carrito);
				response.setContentType("application/json;charset=utf-8");
				salida.write(json);
		} else {
			System.out.println("NO SE HA ELIMINADO");
		}
	
		salida.close();
	}

}
