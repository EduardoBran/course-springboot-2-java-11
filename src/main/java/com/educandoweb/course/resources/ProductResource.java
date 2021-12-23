package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.services.ProductService;

@RestController //Para falar que está classe é um recurso web que é implementado por um controlador Rest
@RequestMapping(value = "/products") //nome para o recurso
public class ProductResource {
	
	@Autowired //dependência para o service
	private ProductService service;
	
	//método para testar se está funcionando o recurso users
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		
		List<Product> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") //indica que vai aceitar um ID dentro da url
	public ResponseEntity<Product> findById(@PathVariable Long id){
		
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}	
}
