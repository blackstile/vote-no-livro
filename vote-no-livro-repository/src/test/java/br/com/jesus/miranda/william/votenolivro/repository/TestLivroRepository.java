package br.com.jesus.miranda.william.votenolivro.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.jesus.miranda.william.votenolivro.beans.Combinacao;
import br.com.jesus.miranda.william.votenolivro.beans.Livro;

public class TestLivroRepository extends AbstractTest {

	@Autowired
	private LivroRepository livroRepository;

	@Test
	public void testSaveLivro() {
		{
			Livro livro = new Livro();
			livro.setTitulo("Java como programar");
			livro.setDescricao("O pior livro de Java que eu ja comprei");
			livroRepository.save(livro);
			Assert.assertNotNull(livro.getId());
		}
		{
			Livro livro = new Livro();
			livro.setTitulo("Use a cabeça JAVA");
			livro.setDescricao("Livro de java com uma leitura mais agradavél.");
			livroRepository.save(livro);
			Assert.assertNotNull(livro.getId());
		}
	}
	
	@Test
	public void testGetCombinacoes(){
		List<Combinacao> combinacoes =  livroRepository.getCombinacoes();
		Assert.assertNotNull(combinacoes);
		for (Combinacao combinacao : combinacoes) {
			System.out.println(combinacao);
		}
	}
	
	@Test
	public void testGetListId(){
		List<Long> ids =  livroRepository.getListaIdLivros();
		for (Long id : ids) {
			System.out.println(id);
		}
	}
}
