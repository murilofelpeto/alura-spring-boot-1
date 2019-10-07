package br.com.murilo.forum.entity.builders;

import java.time.LocalDateTime;
import java.util.List;

import br.com.murilo.forum.entity.Curso;
import br.com.murilo.forum.entity.Resposta;
import br.com.murilo.forum.entity.StatusTopico;
import br.com.murilo.forum.entity.Topico;
import br.com.murilo.forum.entity.Usuario;

public class TopicoBuilder {

	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;
	private StatusTopico status;
	private Usuario autor;
	private Curso curso;
	private List<Resposta> respostas;
	
	public TopicoBuilder comID(Long id) {
		this.id = id;
		return this;
	}
	
	public TopicoBuilder comTitulo(String titulo) {
		this.titulo = titulo;
		return this;
	}
	
	public TopicoBuilder comMensagem(String mensagem) {
		this.mensagem = mensagem;
		return this;
	}
	
	public TopicoBuilder criadoAgora() {
		this.dataCriacao = LocalDateTime.now();
		return this;
	}
	
	public TopicoBuilder comStatus(StatusTopico status) {
		this.status = status;
		return this;
	}
	
	public TopicoBuilder usuario(Usuario usuario) {
		this.autor = usuario;
		return this;
	}
	
	public TopicoBuilder noCurso(Curso curso) {
		this.curso = curso;
		return this;
	}
	
	public TopicoBuilder quaisRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
		return this;
	}
	
	public Topico build() {
		Topico topico = new Topico();
		topico.setAutor(this.autor);
		topico.setCurso(this.curso);
		topico.setDataCriacao(this.dataCriacao);
		topico.setId(this.id);
		topico.setMensagem(this.mensagem);
		topico.setRespostas(this.respostas);
		topico.setStatus(this.status);
		topico.setTitulo(this.titulo);
		return topico;
	}
}
