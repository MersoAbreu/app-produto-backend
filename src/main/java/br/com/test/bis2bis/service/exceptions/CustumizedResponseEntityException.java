package br.com.test.bis2bis.service.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@RestControllerAdvice
public class CustumizedResponseEntityException {

	
	@ExceptionHandler(ProdutoNotFoundException.class)
	public ResponseEntity<Object> allProdutoNotFoundException(ProdutoNotFoundException ex, WebRequest request){
		return new ResponseEntity<Object>(
				new ExceptionResponse(ex.getMessage(), request.getDescription(false), LocalDateTime.now()),
				HttpStatus.NOT_FOUND);
				
	}
	
}
