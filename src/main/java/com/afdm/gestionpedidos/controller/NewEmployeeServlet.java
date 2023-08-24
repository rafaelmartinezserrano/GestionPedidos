package com.afdm.gestionpedidos.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

import com.afdm.gestionpedidos.model.Employee;
import com.afdm.gestionpedidos.model.facade.GestionPedidosDelegate;
import com.afdm.gestionpedidos.model.facade.GestionPedidosFacade;

/**
 * Servlet implementation class NewEmployeeServlet
 */
public class NewEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String title = request.getParameter("title");
		String titleOfCourtesy = request.getParameter("titleOfCourtesy");
		LocalDate birthDate = LocalDate.parse(request.getParameter("birthDate"));
		LocalDate hireDate = LocalDate.parse(request.getParameter("hireDate"));
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String region = request. getParameter("region");
		String postalCode = request.getParameter("postalCode");
		String country = request.getParameter("country");
		String homePhone = request.getParameter("homePhone");
		String extension = request.getParameter("extension");
		String photo = request.getParameter("photo");
		String notes = request.getParameter("notes");
		String photoPath = request.getParameter("photoPath");
		
		Employee newEmployee = new Employee(lastName, firstName, title, titleOfCourtesy, birthDate, hireDate, address, city, region, postalCode, country, homePhone, extension, photo, notes, photoPath);
		
		GestionPedidosDelegate facade = new GestionPedidosFacade();
		try {
			boolean registered = facade.registerEmployee(newEmployee);
			if(registered) {
				request.getRequestDispatcher("").forward(request, response);
			} else {
				request.setAttribute("error", "Lo sentimos!! Hubo un error al intentar dar de alta el Empleado. Por favor, vuelva a intentarlo.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
