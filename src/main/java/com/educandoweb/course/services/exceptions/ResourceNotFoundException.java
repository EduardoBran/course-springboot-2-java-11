package com.educandoweb.course.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) { //passando o ID do objeto que tentamos localizar e não encontramos
		
		super("Resource not found. Id " + id);
	}
	
}
