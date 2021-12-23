package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;

//@Component //regitra a classe como um componente do Spring
@Service //para ficar mais semanticamente especifico
public class CategoryService {
	
	@Autowired //faz com o spring faça a dependencia de forma transparente
	private CategoryRepository repository;
	
	//método para retornar todos os usuários do banco de dados
	public List<Category> findAll(){
		
		return repository.findAll(); //aqui o repository ja oferece varias operações
	}	
	
	//método para retorna por ID
	public Category findById(Long id) {
		
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}

}
