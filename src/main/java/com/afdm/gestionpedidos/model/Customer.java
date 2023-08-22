package com.afdm.gestionpedidos.model;

import java.util.Objects;

public class Customer {
	private int customerID;
	private String companyName;
	private String contactName;
	private String contactTitle;
	private String address;
	private String city;
	private String region;
	private String postalCode;
	private String country;
	private String phone;
	private String fax;
	
	public Customer () {}
	public Customer(int customerID, String companyName, String contactName, String contactTitle, String address,
			String city, String region, String postalCode, String country, String phone, String fax) {
		this.customerID = customerID;
		this.companyName = companyName;
		this.contactName = contactName;
		this.contactTitle = contactTitle;
		this.address = address;
		this.city = city;
		this.region = region;
		this.postalCode = postalCode;
		this.country = country;
		this.phone = phone;
		this.fax = fax;
	}
	
	public Customer(String companyName, String contactName, String contactTitle, String address,
			String city, String region, String postalCode, String country, String phone, String fax) {
		this.companyName = companyName;
		this.contactName = contactName;
		this.contactTitle = contactTitle;
		this.address = address;
		this.city = city;
		this.region = region;
		this.postalCode = postalCode;
		this.country = country;
		this.phone = phone;
		this.fax = fax;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactTitle() {
		return contactTitle;
	}
	public void setContactTitle(String contactTitle) {
		this.contactTitle = contactTitle;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	@Override
	public int hashCode() {
		return Objects.hash(customerID);
	}
	@Override
	public boolean equals(Object obj) {
		boolean iguales = false;
		if(obj != null && obj instanceof Customer) {
			Customer otro = (Customer)obj;
			iguales = this.customerID == otro.customerID;
		}
		return iguales;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [customerID=").append(customerID).append(", companyName=").append(companyName)
				.append(", contactName=").append(contactName).append(", contactTitle=").append(contactTitle)
				.append(", address=").append(address).append(", city=").append(city).append(", region=").append(region)
				.append(", postalCode=").append(postalCode).append(", country=").append(country).append(", phone=")
				.append(phone).append(", fax=").append(fax).append("]");
		return builder.toString();
	}
	
	
	
}
