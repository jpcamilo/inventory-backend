package com.company.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.inventory.response.CategoryReponseRest;
import com.company.inventory.services.ICategoryServices;

@RestController
@RequestMapping("/api/v1")
public class CategoryRestController {

	@Autowired
	private ICategoryServices service;
	
	/**
	 * get all the categories
	 * @return
	 */
	@GetMapping("/categories")
	public ResponseEntity<CategoryReponseRest> searchCategories(){
		
		ResponseEntity<CategoryReponseRest> response = service.search();
		return response;
				
	}
	
	/**
	 * get categories by id
	 * @param id
	 * @return
	 */
	@GetMapping("/categories/{id}")
	public ResponseEntity<CategoryReponseRest> searchCategoriesById(@PathVariable Long id){
		
		ResponseEntity<CategoryReponseRest> response = service.searchById(id);
		return response;
				
	}	
}
