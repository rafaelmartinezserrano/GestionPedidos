package com.afdm.gestionpedidos.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.afdm.gestionpedidos.model.carrito.Carrito;
import com.afdm.gestionpedidos.model.facade.GestionPedidosDelegate;
import com.afdm.gestionpedidos.model.facade.GestionPedidosFacade;

/**
 * Servlet implementation class IniciarSesion
 */
public class IniciarSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String tipo = request.getParameter("tipo");
		String nombre = request.getParameter("nombreEmpleado");
		String apellidos = request.getParameter("apellidosEmpleado");
		String customerID = request.getParameter("nombreCliente");
		System.out.println(tipo);
		GestionPedidosDelegate fachada = new GestionPedidosFacade();
		boolean login = false;
		if (tipo.equals("employee")) {
			login = fachada.login(tipo, nombre, apellidos);
		} else {
			login = fachada.login(tipo, customerID, null);
		}
		if (login) {
			request.getSession().setAttribute("usuario", nombre);
			
			
			if(tipo.equals("customer")) {
				Carrito carrito = new Carrito(customerID);
				request.getSession().setAttribute("carrito", carrito);
				
			}
			response.sendRedirect("principal.jsp");
		} else {
			request.setAttribute("error", "Datos no encontrados.");
			request.getRequestDispatcher("inicioSesion.jsp").forward(request, response);
		}

	}

}
