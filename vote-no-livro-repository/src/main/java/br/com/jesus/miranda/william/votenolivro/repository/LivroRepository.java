package br.com.jesus.miranda.william.votenolivro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.jesus.miranda.william.votenolivro.beans.Combinacao;
import br.com.jesus.miranda.william.votenolivro.beans.Disputa;
import br.com.jesus.miranda.william.votenolivro.beans.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

	@Query("Select new br.com.jesus.miranda.william.votenolivro.beans.Combinacao(l1.id, l2.id) from Livro l1, Livro l2 where l1 <> l2")
	List<Combinacao> getCombinacoes();
	
	@Query("Select new br.com.jesus.miranda.william.votenolivro.beans.Disputa(l1, l2) from Livro l1, Livro l2 where l1.id = :idLivro1 and l2.id = :idLivro2")
	Disputa getDisputa(@Param("idLivro1") Long idLivro1, @Param("idLivro2") Long idLivro2);
	
	@Query("Select livro.id from Livro livro")
	List<Long> getListaIdLivros();
	
}
