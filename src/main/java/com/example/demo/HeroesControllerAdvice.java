package com.example.demo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HeroesControllerAdvice extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value = {IllegalArgumentException.class,IllegalStateException.class})
	protected ResponseEntity<Object> handlerConflict(RuntimeException e, WebRequest request) {
		String bodyOfResponse = e.getLocalizedMessage();
		return handleExceptionInternal(e,bodyOfResponse,new HttpHeaders(),HttpStatus.CONFLICT,request);
	}
	@ExceptionHandler(value = {Exception.class})
	protected ResponseEntity<Object> handlerBadRequest(Exception e){
		String bodyOfResponse = e.getLocalizedMessage();
		return ResponseEntity.badRequest().body(bodyOfResponse);
	}
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		String bodyOfResponse = ex.getLocalizedMessage();
		return ResponseEntity.badRequest().body(bodyOfResponse);
	}
}
