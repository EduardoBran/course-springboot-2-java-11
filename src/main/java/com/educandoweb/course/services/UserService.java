package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		
		return repository.save(obj);
	}
	
	public void delete (Long id) {
		
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id); //exceção específica
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj) { //recebe um long Id para saber qual id sera atualizada e tb um User obj para saber quais dados serão atualizados
		
		try { 
			User entity = repository.getOne(id); //getById() 
			updateData(entity, obj);
			return repository.save(entity);
		}
		catch (EntityNotFoundException e) {
			
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {

		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());		
	}	
}
