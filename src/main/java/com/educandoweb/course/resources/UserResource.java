package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

@RestController //Para falar que está classe é um recurso web que é implementado por um controlador Rest
@RequestMapping(value = "/users") //nome para o recurso
public class UserResource {
	
	//método para testar se está funcionando o recurso users
	@GetMapping
	public ResponseEntity<User> findAll(){
		
		User u = new User(1L, "maria", "maria@gmail.com", "99999999", "12345");
		return ResponseEntity.ok().body(u);
	}
}
