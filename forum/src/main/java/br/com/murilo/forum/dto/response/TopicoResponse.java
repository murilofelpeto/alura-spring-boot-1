package br.com.murilo.forum.dto.response;

import java.time.LocalDateTime;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class TopicoResponse {

	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;	
}
