package com.andre.helpdeskback.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.andre.helpdeskback.services.exceptions.DataIntegrityViolationException;
import com.andre.helpdeskback.services.exceptions.ObjectnotFoundException;
import com.andre.helpdeskback.services.exceptions.ValidationError;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectnotFoundException.class)
	public ResponseEntity<StandardError> objectnotFoundException(ObjectnotFoundException ex, HttpServletRequest request){
		
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Object Not Found",
				ex.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException ex, HttpServletRequest request){
		
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Violação de dados",
				ex.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validatinError(MethodArgumentNotValidException ex, HttpServletRequest request){
		
		ValidationError errors = new ValidationError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), 
				"Validtion Error", "Erro na validação dos campos", request.getRequestURI());
		for(FieldError x :  ex.getBindingResult().getFieldErrors()) {
			errors.addErrors(x.getField(), x.getDefaultMessage());
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
		
	}

}
