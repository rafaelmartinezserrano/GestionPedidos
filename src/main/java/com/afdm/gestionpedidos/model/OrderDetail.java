package com.afdm.gestionpedidos.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="OrderDetail")
public class OrderDetail {
	@Id
	
	@Transient
	private int idOrderDetail;
	@ManyToOne
	@JoinColumn(name="productID")
	private Product product;
	private double unitPrice;
	private int quantity;
	private double discount;
	private static int contador =0;
	
	public OrderDetail() {}
	
	public OrderDetail(Product product, double unitPrice, int quantity, double discount) {
		this.idOrderDetail = contador;
		this.product = product;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.discount = discount;
		contador++;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderDetail [product=").append(product.getProductName()).append(", unitPrice=").append(unitPrice)
				.append(", quantity=").append(quantity).append(", discount=").append(discount).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(idOrderDetail);
	}

	@Override
	public boolean equals(Object obj) {
		boolean iguales = false;
		if(obj != null && obj instanceof Customer) {
			OrderDetail otro = (OrderDetail)obj;
			iguales = this.idOrderDetail == otro.idOrderDetail;
		}
		return iguales;
	}
	
	
	
	
	
}
