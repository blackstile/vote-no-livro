package br.com.jesus.miranda.william.votenolivro.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.jesus.miranda.william.votenolivro.beans.Ranking;
import br.com.jesus.miranda.william.votenolivro.beans.Voto;
import br.com.jesus.miranda.william.votenolivro.repository.VotoRepository;
import br.com.jesus.miranda.william.votenolivro.services.VotoService;

@Service
public class VotoServiceImpl implements VotoService{

	@Autowired
	private VotoRepository votoRepository;
	
	@Transactional
	public boolean save(Voto voto){
		return votoRepository.save(voto).getId() != null;
	}

	public List<Ranking> getRanking() {
		return votoRepository.getRankingLivro();
	}
	
}
