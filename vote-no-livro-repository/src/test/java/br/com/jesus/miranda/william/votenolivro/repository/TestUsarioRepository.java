package br.com.jesus.miranda.william.votenolivro.repository;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.jesus.miranda.william.votenolivro.beans.Usuario;

public class TestUsarioRepository extends AbstractTest {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Test
	public void testInsertUsuario(){
		UUID uuid = UUID.randomUUID();
		final String email = String.format("%s@hotmail.com", uuid.toString().replace("-", "")); 
		
		Usuario usuario1 =  new Usuario();
		usuario1.setEmail(email);
		usuario1.setNome("William Miranda");
		
		usuarioRepository.save(usuario1);		
		Assert.assertNotNull(usuario1.getId());
		
		Usuario usuario2 = usuarioRepository.findOne(usuario1.getId());
		Assert.assertEquals(usuario1, usuario2);
	}

	
	
}
