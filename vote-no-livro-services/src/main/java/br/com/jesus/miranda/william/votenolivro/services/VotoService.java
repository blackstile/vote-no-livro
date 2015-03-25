package br.com.jesus.miranda.william.votenolivro.services;

import java.util.List;

import br.com.jesus.miranda.william.votenolivro.beans.Ranking;
import br.com.jesus.miranda.william.votenolivro.beans.Voto;

public interface VotoService {

	boolean save(Voto voto);
	
	List<Ranking> getRanking();

}
