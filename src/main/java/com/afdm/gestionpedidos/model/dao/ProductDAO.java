package com.afdm.gestionpedidos.model.dao;

import java.util.List;

import com.afdm.gestionpedidos.model.*;

public interface ProductDAO {

	public Product findProductById(int idProduct);
	
	public List<Product> findProductByName(String productName);
	
	public List<Product> findProductByCategory(int categoryId);

	public boolean updateProduct(Product producto);
}
