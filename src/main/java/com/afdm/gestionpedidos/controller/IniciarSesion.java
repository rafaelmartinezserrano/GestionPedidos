package com.afdm.gestionpedidos.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.afdm.gestionpedidos.model.facade.GestionPedidosDelegate;



/**
 * Servlet implementation class IniciarSesion
 */
public class IniciarSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * 
     */
    public IniciarSesion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tipo = request.getParameter("tipo");
		String nombre = request.getParameter("firstName");
		String apellidos = request.getParameter("lastName");
		String customerID = request.getParameter("customerID");
		GestionPedidosDelegate fachada = null;
		try {
		fachada.login(tipo, nombre, apellidos);
			if (employee != null) {
				request.getSession().setAttribute("employee", employee);
				response.sendRedirect("principal.jsp");
			} else {
				request.setAttribute("Error", "Datos no encontrados.");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} catch (ConexionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

	
	}


