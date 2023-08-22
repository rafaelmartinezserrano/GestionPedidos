package com.afdm.gestionpedidos.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Orders {
	private Customer customer;
	private Employee employee;
	private List<OrderDetail> orderDetail = new ArrayList<>();
	private int orderID;
	private LocalDate orderDate;
	private LocalDate requiredDate;
	private LocalDate shippedDate;
	private String freight;
	private String shipName;
	private String shipAddress;
	private String shipCity;
	private String shipRegion;
	private String shipPostalCode;
	private String shipCountry;
	
	public Orders() {}

	public Orders(Customer customer, Employee employee, List<OrderDetail> orderDetail, int orderID, LocalDate orderDate,
			LocalDate requiredDate, LocalDate shippedDate, String freight, String shipName, String shipAddress,
			String shipCity, String shipRegion, String shipPostalCode, String shipCountry) {
		
		this.customer = customer;
		this.employee = employee;
		this.orderDetail = orderDetail;
		this.orderID = orderID;
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;
		this.shippedDate = shippedDate;
		this.freight = freight;
		this.shipName = shipName;
		this.shipAddress = shipAddress;
		this.shipCity = shipCity;
		this.shipRegion = shipRegion;
		this.shipPostalCode = shipPostalCode;
		this.shipCountry = shipCountry;
	}
	
	public Orders(Customer customer, Employee employee, List<OrderDetail> orderDetail, LocalDate orderDate,
			LocalDate requiredDate, LocalDate shippedDate, String freight, String shipName, String shipAddress,
			String shipCity, String shipRegion, String shipPostalCode, String shipCountry) {
		
		this.customer = customer;
		this.employee = employee;
		this.orderDetail = orderDetail;
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;
		this.shippedDate = shippedDate;
		this.freight = freight;
		this.shipName = shipName;
		this.shipAddress = shipAddress;
		this.shipCity = shipCity;
		this.shipRegion = shipRegion;
		this.shipPostalCode = shipPostalCode;
		this.shipCountry = shipCountry;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<OrderDetail> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(List<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(LocalDate requiredDate) {
		this.requiredDate = requiredDate;
	}

	public LocalDate getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(LocalDate shippedDate) {
		this.shippedDate = shippedDate;
	}

	public String getFreight() {
		return freight;
	}

	public void setFreight(String freight) {
		this.freight = freight;
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public String getShipAddress() {
		return shipAddress;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}

	public String getShipCity() {
		return shipCity;
	}

	public void setShipCity(String shipCity) {
		this.shipCity = shipCity;
	}

	public String getShipRegion() {
		return shipRegion;
	}

	public void setShipRegion(String shipRegion) {
		this.shipRegion = shipRegion;
	}

	public String getShipPostalCode() {
		return shipPostalCode;
	}

	public void setShipPostalCode(String shipPostalCode) {
		this.shipPostalCode = shipPostalCode;
	}

	public String getShipCountry() {
		return shipCountry;
	}

	public void setShipCountry(String shipCountry) {
		this.shipCountry = shipCountry;
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderID);
	}

	@Override
	public boolean equals(Object obj) {
		boolean iguales = false;
		if(obj != null && obj instanceof Orders) {
			Orders otro = (Orders)obj;
			iguales = this.orderID == otro.orderID;
		}
		return iguales;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Orders [customer=").append(customer.getCustomerID()).append(", employee=").append(employee.getEmployeeID())
				.append(", orderDetail=").append(orderDetail).append(", orderID=").append(orderID)
				.append(", orderDate=").append(orderDate).append(", requiredDate=").append(requiredDate)
				.append(", shippedDate=").append(shippedDate).append(", freight=").append(freight).append(", shipName=")
				.append(shipName).append(", shipAddress=").append(shipAddress).append(", shipCity=").append(shipCity)
				.append(", shipRegion=").append(shipRegion).append(", shipPostalCode=").append(shipPostalCode)
				.append(", shipCountry=").append(shipCountry).append("]");
		return builder.toString();
	}
	
	
	
	
}
