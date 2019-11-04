package br.com.murilo.forum.config.validacao.model;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ErroDeAutenticacaoException  extends AuthenticationException {

	private static final long serialVersionUID = 9143050293252058625L;

	public ErroDeAutenticacaoException(String exception) {
		super(exception);
	}
}
