package com.afdm.gestionpedidos.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.afdm.gestionpedidos.model.Employee;
import com.afdm.gestionpedidos.model.Product;
import com.afdm.gestionpedidos.model.facade.GestionPedidosDelegate;
import com.afdm.gestionpedidos.model.facade.GestionPedidosFacade;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FindProductByCategoryServlet
 */
public class FindProductByCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String busqueda = request.getParameter("busqueda");
		//Employee employee = (Employee) request.getSession().getAttribute("");
		GestionPedidosDelegate fachada = new GestionPedidosFacade();
		
		//pasar busqueda de String a int, para meterlo como parametro cuando llamo al metodo de la fachada
		System.out.println(busqueda);
		int busquedaIdCategory = Integer.parseInt(busqueda);
		List<Product> lista = fachada.findProductByCategory(busquedaIdCategory);
		ObjectMapper mapeador = new ObjectMapper();
		String json = mapeador.writeValueAsString(lista);
		response.setContentType(json);
		PrintWriter salida = response.getWriter();
		salida.write(json);
		salida.close();
		
		
	}

}
