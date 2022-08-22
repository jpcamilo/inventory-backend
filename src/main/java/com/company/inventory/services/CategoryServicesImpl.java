package com.company.inventory.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.inventory.dao.ICategoryDao;
import com.company.inventory.model.Category;
import com.company.inventory.response.CategoryReponseRest;

@Service
public class CategoryServicesImpl implements ICategoryServices{

	@Autowired
	private ICategoryDao categoryDao;
	
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<CategoryReponseRest> search() {

		CategoryReponseRest response = new CategoryReponseRest();
		try {
			List<Category> category = (List<Category>) categoryDao.findAll();
			response.getCategoryResponse().setCategory(category);
			response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");
		} catch (Exception e) {
			response.setMetadata("Respuesta nok", "-1", "Error al consultar");
			e.getStackTrace();
			return new ResponseEntity<CategoryReponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
		return new ResponseEntity<CategoryReponseRest>(response,HttpStatus.OK);
	}

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<CategoryReponseRest> searchById(Long id) {
		
		CategoryReponseRest response = new CategoryReponseRest();
		List<Category> list = new ArrayList<>();
		
		try {
			
			Optional<Category> category = categoryDao.findById(id);
			
			if (category.isPresent()) {
				list.add(category.get());
				response.getCategoryResponse().setCategory(list);
				response.setMetadata("Respuesta ok", "00", "Categoria encontrada");
			}else {
				response.setMetadata("Respuesta nok", "-1", "Categoria no encontrada");
				return new ResponseEntity<CategoryReponseRest>(response,HttpStatus.NOT_FOUND);
			}
		
		} catch (Exception e) {
			
			response.setMetadata("Respuesta nok", "-1", "Error al consultar por id");
			e.getStackTrace();
			return new ResponseEntity<CategoryReponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	
		return new ResponseEntity<CategoryReponseRest>(response,HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<CategoryReponseRest> save(Category category) {
		
		CategoryReponseRest response = new CategoryReponseRest();
		List<Category> list = new ArrayList<>();
		
		try {
			
			Category categorySaved = categoryDao.save(category);
			
			if (categorySaved != null) {
				list.add(categorySaved);
				response.setMetadata("Respuesta ok", "00", "Categoria guardada");
				response.getCategoryResponse().setCategory(list);
			}else {
				response.setMetadata("Respuesta nok", "-1", "Categoria no guardada");
				return new ResponseEntity<CategoryReponseRest>(response,HttpStatus.BAD_REQUEST);				
			}
		
		} catch (Exception e) {
			
			response.setMetadata("Respuesta nok", "-1", "Error al guardar categoria");
			e.getStackTrace();
			return new ResponseEntity<CategoryReponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	
		return new ResponseEntity<CategoryReponseRest>(response,HttpStatus.OK);
	}

}
