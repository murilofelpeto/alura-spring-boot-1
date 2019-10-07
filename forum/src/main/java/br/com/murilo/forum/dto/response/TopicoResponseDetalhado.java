package br.com.murilo.forum.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import br.com.murilo.forum.entity.StatusTopico;
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
public class TopicoResponseDetalhado {

	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;
	private StatusTopico status;
	private String nomeAutor;
	private List<RespostaResponse> respostas;
	
}
