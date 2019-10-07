package br.com.murilo.forum.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.murilo.forum.converter.Converter;
import br.com.murilo.forum.dto.request.TopicoRequest;
import br.com.murilo.forum.dto.response.TopicoResponse;
import br.com.murilo.forum.entity.Curso;
import br.com.murilo.forum.entity.Topico;
import br.com.murilo.forum.entity.builders.TopicoBuilder;
import br.com.murilo.forum.service.CursoService;
import br.com.murilo.forum.service.TopicoService;

@Component
public class TopicoFacade {

	@Autowired
	private TopicoService topicoService;

	@Autowired
	private CursoService cursoService;

	public List<TopicoResponse> findAll() {
		return Converter.parseListObjects(topicoService.findAll(), TopicoResponse.class);
	}

	public List<TopicoResponse> findByCursoNome(String nomeCurso) {
		return Converter.parseListObjects(topicoService.findByCursoNome(nomeCurso), TopicoResponse.class);
	}

	public TopicoResponse salvarTopico(TopicoRequest request) {
		Curso curso = cursoService.findByNome(request.getNomeCurso());
		Topico topico = new TopicoBuilder()
				.comMensagem(request.getMensagem())
				.comTitulo(request.getTitulo())
				.noCurso(curso)
				.criadoAgora()
				.build();
		return Converter.parseObject(topicoService.salvar(topico), TopicoResponse.class);
	}

}
