package com.carlosworkshopmongo.resouces.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.carlosworkshopmongo.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice // isso quer dizer que esta classe é responsavel para tratar possiveis erros que possa acontecer na minha requisicoes
public class ResourceExceptionHandler {
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandartError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandartError err =new StandartError(System.currentTimeMillis(), status.value(), "nao encontardos", e.getMessage(), request.getRequestURI());
	    return ResponseEntity.status(status).body(err);
	}

}
