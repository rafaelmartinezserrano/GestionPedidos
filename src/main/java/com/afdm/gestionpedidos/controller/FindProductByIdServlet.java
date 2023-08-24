package com.afdm.gestionpedidos.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.afdm.gestionpedidos.model.Product;
import com.afdm.gestionpedidos.model.facade.GestionPedidosDelegate;
import com.afdm.gestionpedidos.model.facade.GestionPedidosFacade;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class FindProductByIdServlet
 */
public class FindProductByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String busqueda = request.getParameter("busquedaId");		
		GestionPedidosDelegate fachada = new GestionPedidosFacade();
		
	//System.out.println(busqueda);
		int busquedaId = Integer.parseInt(busqueda);
		
		Product producto = fachada.findProductById(busquedaId);
		
	//System.out.println(producto);
		ObjectMapper mapeador = new ObjectMapper();
		String json = mapeador.writeValueAsString(producto);
	//System.out.println(json);
		response.setContentType("application/json;charset=utf-8");
		PrintWriter salida = response.getWriter();
		salida.write(json);
		salida.close();		
				
	}

}
