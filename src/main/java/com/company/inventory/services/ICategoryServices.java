package com.company.inventory.services;

import org.springframework.http.ResponseEntity;

import com.company.inventory.model.Category;
import com.company.inventory.response.CategoryReponseRest;

public interface ICategoryServices {

	public ResponseEntity<CategoryReponseRest> search();
	
	public ResponseEntity<CategoryReponseRest> searchById(Long id);
	
	public ResponseEntity<CategoryReponseRest> save(Category category);
}
