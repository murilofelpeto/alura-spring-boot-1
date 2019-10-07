package br.com.murilo.forum.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Resposta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String mensagem;
	private LocalDateTime dataCriacao;
	
	@ManyToOne
	private Topico topico;

	@ManyToOne
	private Usuario autor;
	private Boolean solucao;

	public Resposta() {
		this.solucao = false;
	}
}
