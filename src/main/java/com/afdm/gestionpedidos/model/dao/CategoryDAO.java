package com.afdm.gestionpedidos.model.dao;

import java.util.List;

import com.afdm.gestionpedidos.model.*;

public interface CategoryDAO {

	public Category findCategoryById(int idCategory);
	
	public Category findCategoryByName(String categoryName);
	
	public List<Category> findAllCategory();
	
}
