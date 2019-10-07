package br.com.murilo.forum.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.murilo.forum.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	Optional<Curso> findByNome(String nomeCurso);
}
