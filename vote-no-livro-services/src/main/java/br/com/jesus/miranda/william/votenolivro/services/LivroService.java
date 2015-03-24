package br.com.jesus.miranda.william.votenolivro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jesus.miranda.william.votenolivro.beans.Combinacao;
import br.com.jesus.miranda.william.votenolivro.beans.Disputa;
import br.com.jesus.miranda.william.votenolivro.repository.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	
	public List<Combinacao> getCombinacoes(){
		return livroRepository.getCombinacoes();
	}
	
	public Disputa getDisputa(Long idLivro1, Long idLivro2){
		return livroRepository.getDisputa(idLivro1, idLivro2);
	}

}
