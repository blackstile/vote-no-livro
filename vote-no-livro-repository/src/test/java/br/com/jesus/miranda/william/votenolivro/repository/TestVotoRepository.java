package br.com.jesus.miranda.william.votenolivro.repository;

import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.jesus.miranda.william.votenolivro.beans.Livro;
import br.com.jesus.miranda.william.votenolivro.beans.Ranking;
import br.com.jesus.miranda.william.votenolivro.beans.Usuario;
import br.com.jesus.miranda.william.votenolivro.beans.Voto;

public class TestVotoRepository extends AbstractTest {
	
	@Autowired
	private VotoRepository votoRepository;
	
	@Autowired 
	private LivroRepository livroRepository;
	
	@Autowired 
	private UsuarioRepository usuarioRepository;
	
	
	@Test
	public void testSaveVoto(){
		Livro l1 = livroRepository.findOne(1l);
		Livro l2 = livroRepository.findOne(2l);
		Voto voto =  new Voto();
		voto.setPrimeiraOpcao(l1);
		voto.setSegundaOpcao(l2);
		voto.setOpcaoEscolhida(l1);
		List<Usuario> usuarios =  usuarioRepository.findAll();
		Integer position = new Random().nextInt(usuarios.size()-1);
		voto.setUsuario(usuarios.get(position));
		votoRepository.save(voto);
	}

	@Test
	public void testGetRanking(){
		List<Ranking> rankings =  votoRepository.getRankingLivro();
		for (Ranking ranking : rankings) {
			System.out.println(ranking);
		}
		Assert.assertNotNull(rankings);
		Assert.assertTrue(rankings.size() > 0 );
		
	}
}
