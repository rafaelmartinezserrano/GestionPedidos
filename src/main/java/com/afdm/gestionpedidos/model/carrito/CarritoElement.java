package com.afdm.gestionpedidos.model.carrito;

import java.util.Objects;

import com.afdm.gestionpedidos.model.Product;

public class CarritoElement {
	
	private Product product;
	private int quantity;
	
	public CarritoElement(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}
	
	public CarritoElement(Product product) {
		super();
		this.product = product;
		this.quantity = 1;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CarritoElement [product=" + product + ", quantity=" + quantity + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(product);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarritoElement other = (CarritoElement) obj;
		return Objects.equals(product, other.product);
	}
	
	
	

}
