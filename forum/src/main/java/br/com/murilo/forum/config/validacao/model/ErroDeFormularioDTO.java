package br.com.murilo.forum.config.validacao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErroDeFormularioDTO {

	private String campo;
	private String mensagem;
}
