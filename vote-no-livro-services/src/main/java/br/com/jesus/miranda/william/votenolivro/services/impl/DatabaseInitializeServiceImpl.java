package br.com.jesus.miranda.william.votenolivro.services.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jesus.miranda.william.votenolivro.beans.Livro;
import br.com.jesus.miranda.william.votenolivro.repository.LivroRepository;
import br.com.jesus.miranda.william.votenolivro.services.DatabaseInitializeService;

@Service
public class DatabaseInitializeServiceImpl implements DatabaseInitializeService{

	Log log = LogFactory.getLog(DatabaseInitializeServiceImpl.class);
	
	@Autowired
	private LivroRepository livroRepository;
	
	public void insertLivros(){
		Long total = livroRepository.count();
		if (log.isDebugEnabled()){
			log.debug(String.format("Total de Livros Cadastrados: ", total));
		}
		if (total > 0){
			return ;
		}
		{
			Livro livro = new Livro()
								.titulo("MongoDB: Construa novas aplicações com novas tecnologias")
								.descricao("Nesse livro, Fernando Boaglio vai te ensinar como trabalhar com o MongoDB, principal banco de dados orientado a documentos do mercado. Com ele é possível desenvolver aplicações que atingem alta escalabilidade e de forma tão simples quanto trabalhar com os tradicionais banco de dados relacionais.")
								.imagemPath("mongodb-featured_large.png");
			livroRepository.save(livro);
		}
		{
			Livro livro = new Livro()
								.titulo("Aplicações Java para a web com JSF e JPA")
								.descricao("Neste livro você encontrará as especificações mais utilizadas do Java, explicadas com exemplos práticos e claros que mostram como usar cada tecnologia em separado e como utilizá-las em conjunto.")
								.imagemPath("jsf-jpa-featured_large.png");
			livroRepository.save(livro);
		}
		
		{
			Livro livro = new Livro()
								.titulo("Agile: Desenvolvimento de software com entregas frequentes e foco no valor de negócio")
								.descricao("Nesse livro, André Faria Gomes, renomado coach e líder de equipes, explica como os diferentes sabores de Agile podem fazer um projeto de sucesso.")
								.imagemPath("agile-featured_large.png");
			livroRepository.save(livro);
		}
		
		{
			Livro livro = new Livro()
								.titulo("Thoughtworks Antologia Brasil: Histórias de aprendizado e inovação")
								.descricao("Nesse livro, vários colaboradores da ThoughtWorks passam suas experiências com as mais variadas tecnologias e metodologias. Você vai aprender sobre BDD, testes com JavaScript, inovação em startups, agilidade, técnicas de retrospectivas, técnicas avançadas de trabalho com controle de versão e muito mais.")
								.imagemPath("thoughtworks-antologia-featured_large.png");
			livroRepository.save(livro);
		}
		{
			Livro livro = new Livro()
								.titulo("SOA aplicado: Integrando com web services e além")
								.descricao("Aprenda como integrar sistemas com web services, mensageria assíncrona, orquestração e muito mais de uma maneira prática, focada, onde desde primeiro capítulo você já constrói e se integra a um serviço.")
								.imagemPath("soa-webservices-featured_large.png");
			livroRepository.save(livro);
		}
		
	}
	
}
