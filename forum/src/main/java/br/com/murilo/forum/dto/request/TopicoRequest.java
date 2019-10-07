package br.com.murilo.forum.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TopicoRequest {

	private String titulo;
	private String mensagem;
	private String nomeCurso;
}
