package com.company.inventory.services;

import org.springframework.http.ResponseEntity;

import com.company.inventory.response.CategoryReponseRest;

public interface ICategoryServices {

	public ResponseEntity<CategoryReponseRest> search();
}
