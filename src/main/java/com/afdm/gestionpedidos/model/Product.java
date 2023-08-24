package com.afdm.gestionpedidos.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productID;
	@ManyToOne
	@JoinColumn(name="categoryID")
	private Category category;
	private String productName;
	private String quantityPerUnit;
	private double unitPrice;
	private int unitsInStock;
	private int unitsOnOrder;
	private String reorderLevel;
	private boolean discontinued;
	
	public Product() {}

	public Product(Category category, int productID, String productName, String quantityPerUnit, double unitPrice,
			int unitsIntStock, int unitsOnOrder, String reorderLevel, boolean discontinued) {
		
		this.category = category;
		this.productID = productID;
		this.productName = productName;
		this.quantityPerUnit = quantityPerUnit;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsIntStock;
		this.unitsOnOrder = unitsOnOrder;
		this.reorderLevel = reorderLevel;
		this.discontinued = discontinued;
	}
	public Product(Category category,String productName, String quantityPerUnit, double unitPrice,
			int unitsIntStock, int unitsOnOrder, String reorderLevel, boolean discontinued) {
		
		this.category = category;
		this.productName = productName;
		this.quantityPerUnit = quantityPerUnit;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsIntStock;
		this.unitsOnOrder = unitsOnOrder;
		this.reorderLevel = reorderLevel;
		this.discontinued = discontinued;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getQuantityPerUnit() {
		return quantityPerUnit;
	}

	public void setQuantityPerUnit(String quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getUnitsIntStock() {
		return unitsInStock;
	}

	public void setUnitsIntStock(int unitsIntStock) {
		this.unitsInStock = unitsIntStock;
	}

	public int getUnitsOnOrder() {
		return unitsOnOrder;
	}

	public void setUnitsOnOrder(int unitsOnOrder) {
		this.unitsOnOrder = unitsOnOrder;
	}

	public String getReorderLevel() {
		return reorderLevel;
	}

	public void setReorderLevel(String reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public boolean isDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}

	@Override
	public int hashCode() {
		return Objects.hash(productID);
	}

	@Override
	public boolean equals(Object obj) {
		boolean iguales = false;
		if(obj != null && obj instanceof Customer) {
			Product otro = (Product)obj;
			iguales = this.productID == otro.productID;
		}
		return iguales;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [category=").append(category.getCategoryName()).append(", productID=").append(productID)
				.append(", productName=").append(productName).append(", quantityPerUnit=").append(quantityPerUnit)
				.append(", unitPrice=").append(unitPrice).append(", unitsIntStock=").append(unitsInStock)
				.append(", unitsOnOrder=").append(unitsOnOrder).append(", reorderLevel=").append(reorderLevel)
				.append(", discontinued=").append(discontinued).append("]");
		return builder.toString();
	}
	
	
	
}
