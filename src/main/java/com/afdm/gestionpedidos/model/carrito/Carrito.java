package com.afdm.gestionpedidos.model.carrito;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.afdm.gestionpedidos.model.Product;

public class Carrito {
	
	private String idCustomer;
	private List<CarritoElement> listOD;
	
	

	 public Carrito(String idCustomer, List<CarritoElement> listOD) {
		this.idCustomer = idCustomer;
		this.listOD = listOD;
	}
	 
	 public Carrito(String idCustomer) {
			this.idCustomer = idCustomer;
			this.listOD = new ArrayList<CarritoElement>();
		}
	
	
	public String getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(String idCustomer) {
		this.idCustomer = idCustomer;
	}

	public List<CarritoElement> getListOD() {
		return listOD;
	}

	public void setListOD(List<CarritoElement> listOD) {
		this.listOD = listOD;
	}
	
	
	@Override
	public String toString() {
		return "Carrito [idCustomer=" + idCustomer + ", listOD=" + listOD + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCustomer, listOD);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carrito other = (Carrito) obj;
		return idCustomer == other.idCustomer && Objects.equals(listOD, other.listOD);
	}

	/**
     A�ade producto y cantidad al carrito.
     <p>
     Return true: Producto a�adido.
     <p>
     Return false: Producto no a�adido, cantidad modificada en 1.
     <p>
     */
	public boolean addToCarrito(CarritoElement e){
		boolean insert = true;			
		for(CarritoElement elemento : listOD) {
			if (elemento.equals(e)) {
				elemento.setQuantity(elemento.getQuantity()+e.getQuantity());
				insert = false;
			} 
		}
		if (insert) {
			listOD.add(e);
		}
		return insert;
	}
	
	
	
	public boolean removeFromCarrito(CarritoElement e) {
		return this.listOD.remove(e);
	}
	
	public boolean removeFromCarrito(int idProduct) {
		return this.listOD.remove(new CarritoElement(new Product(idProduct)));
	}
	
	
	public boolean modifyCarrito(CarritoElement e) {
		boolean modified = false;	
		for(CarritoElement elemento : listOD) {
			if (elemento.equals(e)) {
				elemento.setQuantity(e.getQuantity());
				modified = true;
			} 
		}
		return modified;
	}
	
	
	
	
	public double totalCarritoPrice() {
		double total = 0;
		for (CarritoElement elemento : listOD) {
			total += elemento.getProduct().getUnitPrice() * elemento.getQuantity();
		}
		
		return total;
	}
	
}
