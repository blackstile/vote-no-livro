package br.com.jesus.miranda.william.votenolivro.repository;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.jesus.miranda.william.votenolivro.beans.Disputa;
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

	@Before
	public void init() {
		long idLivro1, idLivro2, idLivro3;
		idLivro1 = livroRepository.save(new Livro().titulo("Livro Test 1").descricao("descricao livro teste 1")).getId();
		idLivro2 = livroRepository.save(new Livro().titulo("Livro Test 2").descricao("descricao livro teste 2")).getId();
		idLivro3 = livroRepository.save(new Livro().titulo("Livro Test 3").descricao("descricao livro teste 3")).getId();
		saveVotoFromDisputa(livroRepository.getDisputa(idLivro1, idLivro2));
		saveVotoFromDisputa(livroRepository.getDisputa(idLivro2, idLivro3));
		saveVotoFromDisputa(livroRepository.getDisputa(idLivro1, idLivro3));
		usuarioRepository.save(new Usuario().nome("William Miranda de Jesus").email(generateEmail()));
		usuarioRepository.save(new Usuario().nome("Benjamin Gama de Jesus").email(generateEmail()));

	}
	
	private String generateEmail(){
		return String.format("%s@%s", UUID.randomUUID().toString(), "gmail.com");
	}

	@Test
	public void testSaveVoto() {
		Livro l1 = livroRepository.findOne(1l);
		Livro l2 = livroRepository.findOne(2l);
		Voto voto = new Voto();
		voto.setPrimeiraOpcao(l1);
		voto.setSegundaOpcao(l2);
		voto.setOpcaoEscolhida(l1);
		List<Usuario> usuarios = usuarioRepository.findAll();
		Integer position = new Random().nextInt(usuarios.size() - 1);
		voto.setUsuario(usuarios.get(position));
		votoRepository.save(voto);
	}

	@Test
	public void testGetRanking() {
		List<Ranking> rankings = votoRepository.getRankingLivro();
		for (Ranking ranking : rankings) {
			System.out.println(ranking);
		}
		Assert.assertNotNull(rankings);
		Assert.assertTrue(rankings.size() > 0);

	}
	
	private void saveVotoFromDisputa(Disputa disputa) {
		Voto voto = new Voto();
		voto.setOpcaoEscolhida(disputa.getLivro2());
		voto.setPrimeiraOpcao(disputa.getLivro1());
		voto.setSegundaOpcao(disputa.getLivro2());
		votoRepository.save(voto);
	}
}
