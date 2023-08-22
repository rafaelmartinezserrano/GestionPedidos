package com.afdm.gestionpedidos.model.dao;

import java.util.List;

import com.afdm.gestionpedidos.model.*;

public interface EmployeeDAO {

	public Employee findEmployeeById(int employeeId);
	
	public Employee findEmployeeByName(String firstName, String lastName);
	
	public List<Employee> findAllEmployee();
	
}
