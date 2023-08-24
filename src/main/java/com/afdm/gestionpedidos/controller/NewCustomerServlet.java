package com.afdm.gestionpedidos.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.afdm.gestionpedidos.model.Customer;
import com.afdm.gestionpedidos.model.facade.GestionPedidosFacade;

/**
 * Servlet implementation class NewCustomerServlet
 */
public class NewCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean signedUp = false;
		
		String companyName = request.getParameter("companyName");
		String contactName = request.getParameter("contactName");
		String contactTitle = request.getParameter("contactTitle");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String region = request.getParameter("region");
		String postalCode = request.getParameter("postalCode");
		String country = request.getParameter("country");
		String phone = request.getParameter("phone");
		String fax = request.getParameter("fax");
		
		Customer customer = new Customer(companyName, contactName, contactTitle, address, city, region, postalCode, country, phone, fax);
		
		try {
			
			GestionPedidosFacade facade = new GestionPedidosFacade();
			
			signedUp = facade.signUpCustomer(customer);
			
			if (signedUp) {
				
				request.setAttribute("Register", signedUp);
				
			} else {
				
				request.setAttribute("error", "No se ha podido registrar al cliente");
				
			}
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}

}
