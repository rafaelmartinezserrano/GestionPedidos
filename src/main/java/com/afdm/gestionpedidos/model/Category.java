package com.afdm.gestionpedidos.model;

import java.util.Objects;

public class Category {
	private int categoryID;
	private String categoryName;
	private String description;
	
	public Category() {}
	
	public Category(int categoryID, String categoryName, String description) {
		this.categoryID = categoryID;
		this.categoryName = categoryName;
		this.description = description;
	}
	
	public Category(String categoryName, String description) {
		this.categoryName = categoryName;
		this.description = description;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoryID);
	}

	@Override
	public boolean equals(Object obj) {
		boolean iguales = false;
		if(obj != null & obj instanceof Category) {
			Category otra = (Category)obj;
			iguales = this.categoryID == otra.categoryID;
		}
		return iguales;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Category [categoryID=").append(categoryID).append(", categoryName=").append(categoryName)
				.append(", description=").append(description).append("]");
		return builder.toString();
	}
	
	
	
}
