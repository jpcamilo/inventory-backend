package com.company.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.inventory.response.CategoryReponseRest;
import com.company.inventory.services.ICategoryServices;

@RestController
@RequestMapping("/api/v1")
public class CategoryRestController {

	@Autowired
	private ICategoryServices service;
	
	@GetMapping("/categories")
	public ResponseEntity<CategoryReponseRest> searchCategories(){
		
		ResponseEntity<CategoryReponseRest> response = service.search();
		return response;
				
	}
}
