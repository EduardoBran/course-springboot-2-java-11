package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

//@Component //regitra a classe como um componente do Spring
@Service //para ficar mais semanticamente especifico
public class UserService {
	
	@Autowired //faz com o spring faça a dependencia de forma transparente
	private UserRepository repository;
	
	//método para retornar todos os usuários do banco de dados
	public List<User> findAll(){
		
		return repository.findAll(); //aqui o repository ja oferece varias operações
	}	
	
	//método para retorna por ID
	public User findById(Long id) {
		
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {
		
		return repository.save(obj);
	}
}
