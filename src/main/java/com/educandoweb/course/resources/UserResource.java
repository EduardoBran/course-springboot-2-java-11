package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

@RestController //Para falar que está classe é um recurso web que é implementado por um controlador Rest
@RequestMapping(value = "/users") //nome para o recurso
public class UserResource {
	
	@Autowired //dependência para o service
	private UserService service;
	
	//método para testar se está funcionando o recurso users
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		
		List<User> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") //indica que vai aceitar um ID dentro da url
	public ResponseEntity<User> findById(@PathVariable Long id){
		
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}	
}
