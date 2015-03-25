package br.com.jesus.miranda.william.votenolivro.services;

import java.util.List;

import br.com.jesus.miranda.william.votenolivro.beans.Combinacao;
import br.com.jesus.miranda.william.votenolivro.beans.Disputa;

public interface LivroService {

	List<Combinacao> getCombinacoes();

	Disputa getDisputa(Long idLivro1, Long idLivro2);

}
