package br.com.murilo.forum.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TopicoRequest {

	@NotNull
	@NotEmpty
	@Length(min = 5)
	private String titulo;
	
	@NotNull
	@NotEmpty
	@Length(min = 5)
	private String mensagem;
	
	@NotNull
	@NotEmpty
	@Length(min = 5)
	private String nomeCurso;
}
