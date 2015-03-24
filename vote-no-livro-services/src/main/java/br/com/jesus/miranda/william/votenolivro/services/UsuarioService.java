package br.com.jesus.miranda.william.votenolivro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jesus.miranda.william.votenolivro.beans.Usuario;
import br.com.jesus.miranda.william.votenolivro.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public boolean save(Usuario usuario){
		return usuarioRepository.save(usuario).getId() != null;
	}
	
}
