package br.com.jesus.miranda.william.votenolivro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jesus.miranda.william.votenolivro.beans.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

	
	
}
