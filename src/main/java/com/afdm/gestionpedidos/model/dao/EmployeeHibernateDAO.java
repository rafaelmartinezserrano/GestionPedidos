package com.afdm.gestionpedidos.model.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.afdm.gestionpedidos.model.Employee;
import jakarta.persistence.TypedQuery;

public class EmployeeHibernateDAO implements EmployeeDAO{

	@Override
	public Employee findEmployeeById(int employeeId) {
		Employee empleado = null;
		Session sesion = DaoUtility.getSession();
		Transaction transaccion = sesion.beginTransaction();
		try {
			empleado = sesion.get(Employee.class, employeeId); 
			transaccion.commit();
		}  catch (HibernateException e) {
			e.printStackTrace();
			transaccion.rollback();
		}
		sesion.close();
		return empleado;
	}

	@Override
	public Employee findEmployeeByName(String firstName, String lastName) {
		Employee empleado = new Employee();
		Session sesion = DaoUtility.getSession();
		Transaction transaccion = sesion.beginTransaction();
		try {
			TypedQuery<Employee> consulta = sesion.createQuery("from Employee where FirstName like :firstName and LastName 			like :lastName", Employee.class);
			consulta.setParameter("firstName", "%"+firstName+"%");
			consulta.setParameter("lastName", "%"+lastName+"%");
			empleado = consulta.getSingleResult();
			transaccion.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			transaccion.rollback();
			
		}
		sesion.close();
		return empleado;		
	}

	@Override
	public List<Employee> findAllEmployee() {
		List<Employee> listEmployee = null;
		Session sesion = DaoUtility.getSession();
		Transaction transaccion = sesion.beginTransaction();
		try {
			TypedQuery<Employee> consulta = sesion.createQuery("from Employee", Employee.class);
			listEmployee = consulta.getResultList();
			transaccion.commit();
		} catch (HibernateException e) {	
			e.printStackTrace();
			transaccion.rollback();
		}
		sesion.close();
		return listEmployee;		
	}
	
	@Override
	public boolean registerEmployee(Employee empleado) {
		boolean register = true;
		
		Session sesion = DaoUtility.getSession();
		Transaction transaccion = sesion.beginTransaction();
		try {
			sesion.persist(empleado);
			transaccion.commit();
			sesion.close();
		} catch(HibernateException e){
			e.printStackTrace();
			transaccion.rollback();
			register= false;
		}
		
		return register;
	}
	
}
