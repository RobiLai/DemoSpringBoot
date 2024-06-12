package com.demo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.demo.exception.DuplicateException;
import com.demo.exception.NotFoundException;
import com.demo.model.ErrorResponse;

@RestController
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(DuplicateException.class)
	public ResponseEntity<ErrorResponse> getDuplicateExceptionError(Exception ex){
		
		ErrorResponse errore = new ErrorResponse();
		
		errore.setCodice(HttpStatus.CONFLICT.value());
		errore.setMessaggio(((DuplicateException)ex).getMessaggio());
		
		return new ResponseEntity<ErrorResponse> (errore, new HttpHeaders(), HttpStatusCode.valueOf(409));
		
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorResponse> getNotFoundExceptionError(Exception ex){
		
		ErrorResponse errore = new ErrorResponse();
		
		errore.setCodice(HttpStatus.NOT_FOUND.value());
		errore.setMessaggio(((NotFoundException)ex).getMessaggio());
		
		return new ResponseEntity<ErrorResponse> (errore, new HttpHeaders(), HttpStatusCode.valueOf(404));
		
	}

}
