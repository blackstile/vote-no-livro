package br.com.jesus.miranda.william.votenolivro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.jesus.miranda.william.votenolivro.beans.Ranking;
import br.com.jesus.miranda.william.votenolivro.beans.Voto;

public interface VotoRepository extends JpaRepository<Voto, Long> {

	@Query("Select new br.com.jesus.miranda.william.votenolivro.beans.Ranking(v.opcaoEscolhida, count(v.opcaoEscolhida.id)) from Voto v group by v.opcaoEscolhida")
	List<Ranking> getRankingLivro();
}
