package com.educandoweb.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping //anotation para quando vai inserir novos dados
	public ResponseEntity<User> insert(@RequestBody User obj){ //anotation para dizer que o obj chegue no modo Json na hora de fazer a requisição
		
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); //necessario para que dê o 201 created no post
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}") //anotation para deletar
	public ResponseEntity<Void> delete(@PathVariable Long id){ //<Void> pq nao vai retornar nenhum corpo, vai apenas deletar.
	
		service.delete(id);
		return ResponseEntity.noContent().build();
	}	
}
