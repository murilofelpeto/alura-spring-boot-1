package br.com.murilo.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.murilo.forum.entity.Curso;
import br.com.murilo.forum.repository.CursoRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository repository;
	
	public Curso findByNome(String nome) {
		return repository.findByNome(nome).orElseThrow(() -> new RuntimeException("Curso não encontrado"));
	}
}
