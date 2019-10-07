package br.com.murilo.forum.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.murilo.forum.dto.request.TopicoRequest;
import br.com.murilo.forum.dto.response.TopicoResponse;
import br.com.murilo.forum.facade.TopicoFacade;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

	@Autowired
	private TopicoFacade facade;

	@GetMapping
	public ResponseEntity<List<TopicoResponse>> findAll() {
		return new ResponseEntity<>(facade.findAll(), HttpStatus.OK);
	}

	@GetMapping("/cursos/{nomeCurso}")
	public ResponseEntity<List<TopicoResponse>> findByCursoNome(@PathVariable(value = "nomeCurso") String nomeCurso) {
		return new ResponseEntity<>(facade.findByCursoNome(nomeCurso), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<TopicoResponse> cadastrar(@RequestBody @Valid TopicoRequest request) {
		return new ResponseEntity<>(facade.salvarTopico(request), HttpStatus.CREATED);
	}

}
