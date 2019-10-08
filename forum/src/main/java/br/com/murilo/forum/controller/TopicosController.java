package br.com.murilo.forum.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.murilo.forum.dto.request.TopicoRequest;
import br.com.murilo.forum.dto.request.TopicoRequestUpdate;
import br.com.murilo.forum.dto.response.TopicoResponse;
import br.com.murilo.forum.dto.response.TopicoResponseDetalhado;
import br.com.murilo.forum.facade.TopicoFacade;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

	@Autowired
	private TopicoFacade facade;

	@GetMapping
	@Cacheable(value = "findAll")
	public ResponseEntity<Page<TopicoResponse>> findAll(
			@PageableDefault(page = 0, size = 10, direction = Direction.ASC, sort = "id") Pageable paginacao) {
		
		Page<TopicoResponse> topicos = facade.findAll(paginacao);
		return new ResponseEntity<>(topicos, HttpStatus.OK);
	}

	@GetMapping("/cursos/{nomeCurso}")
	@Cacheable(value = "findByCursoNome")
	public ResponseEntity<List<TopicoResponse>> findByCursoNome(@PathVariable(value = "nomeCurso") String nomeCurso) {
		return new ResponseEntity<>(facade.findByCursoNome(nomeCurso), HttpStatus.OK);
	}

	@PostMapping
	@CacheEvict(allEntries = true, value = {"findByCursoNome", "findAll"})
	public ResponseEntity<TopicoResponse> cadastrar(@RequestBody @Valid TopicoRequest request) {
		return new ResponseEntity<>(facade.salvarTopico(request), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TopicoResponseDetalhado> detalhar(@PathVariable(value = "id") Long id) {
		return new ResponseEntity<>(facade.findById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@CacheEvict(allEntries = true, value = {"findByCursoNome", "findAll"})
	public ResponseEntity<TopicoResponse> atualizar(@PathVariable(value = "id") Long id,
			@RequestBody @Valid TopicoRequestUpdate request) {
		return new ResponseEntity<>(facade.update(id, request), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	@CacheEvict(allEntries = true, value = {"findByCursoNome", "findAll"})
	public void delete(@PathVariable(value = "id") Long id) {
		facade.delete(id);
	}

}
