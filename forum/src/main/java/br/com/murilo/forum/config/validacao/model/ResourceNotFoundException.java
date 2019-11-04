package br.com.murilo.forum.config.validacao.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 3416494899578771361L;
	
	public ResourceNotFoundException(String exception) {
		super(exception);
	}
}
