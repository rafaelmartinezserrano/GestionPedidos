package com.afdm.gestionpedidos.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class NewCustomerServlet
 */
public class NewCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String customerID = request.getParameter("customerID");
		String companyName = request.getParameter("companyName");
		String contactName = request.getParameter("contactName");
		String contactTitle = request.getParameter("contactTitle");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String region = request.getParameter("region");
		String postalCode = request.getParameter("postalCode");
		String country = request.getParameter("country");
		String phone = ;
		String fax;
	}

}
