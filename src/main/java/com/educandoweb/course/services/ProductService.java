package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;

//@Component //regitra a classe como um componente do Spring
@Service //para ficar mais semanticamente especifico
public class ProductService {
	
	@Autowired //faz com o spring faça a dependencia de forma transparente
	private ProductRepository repository;
	
	//método para retornar todos os usuários do banco de dados
	public List<Product> findAll(){
		
		return repository.findAll(); //aqui o repository ja oferece varias operações
	}	
	
	//método para retorna por ID
	public Product findById(Long id) {
		
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}

}
