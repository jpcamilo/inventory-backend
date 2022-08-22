package com.company.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.inventory.model.Category;
import com.company.inventory.response.CategoryReponseRest;
import com.company.inventory.services.ICategoryServices;

@CrossOrigin(origins = {"http://localhost:4200"})
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

	/**
	 * saved categories
	 * @param Category
	 * @return
	 */
	@PostMapping("/categories")
	public ResponseEntity<CategoryReponseRest> saved(@RequestBody Category category){
		
		ResponseEntity<CategoryReponseRest> response = service.save(category);
		return response;
				
	}
	
	/**
	 * update categories
	 * @param category
	 * @param id
	 * @return
	 */
	@PutMapping("/categories/{id}")
	public ResponseEntity<CategoryReponseRest> update(@RequestBody Category category, @PathVariable Long id){
		
		ResponseEntity<CategoryReponseRest> response = service.update(category, id);
		return response;
				
	}

	/**
	 * delete category
	 * @param id
	 * @return
	 */
	@DeleteMapping("/categories/{id}")
	public ResponseEntity<CategoryReponseRest> delete(@PathVariable Long id){
		
		ResponseEntity<CategoryReponseRest> response = service.deleteById(id);
		return response;
				
	}

}
