package com.afdm.gestionpedidos.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.afdm.gestionpedidos.model.Category;
import com.afdm.gestionpedidos.model.facade.GestionPedidosDelegate;
import com.afdm.gestionpedidos.model.facade.GestionPedidosFacade;

/**
 * Servlet implementation class BusquedaCategoryServlet
 */
public class BusquedaCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GestionPedidosDelegate facade = new GestionPedidosFacade();
		
		try {
			List<Category> categoryList = facade.findAllCategory();
			request.setAttribute("categoryList", categoryList);
			request.getRequestDispatcher("BusquedaCategory.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
