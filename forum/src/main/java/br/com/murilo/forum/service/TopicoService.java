package br.com.murilo.forum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.murilo.forum.entity.Topico;
import br.com.murilo.forum.repository.TopicoRepository;

@Service
public class TopicoService {

	@Autowired
	private TopicoRepository repository;

	public List<Topico> findAll() {
		return repository.findAll();
	}
	
	public List<Topico> findByCursoNome(String nomeCurso){
		return repository.findByCursoNome(nomeCurso);
	}
	
	public Topico salvar(Topico topico) {
		return repository.save(topico);
	}

	public Topico findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Tópico não encontrado!"));
	}

	public Topico atualizar(Topico topico) {
		return repository.save(topico);
	}

	public void delete(Topico topico) {
		repository.delete(topico);
	}
}
