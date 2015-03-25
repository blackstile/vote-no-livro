package br.com.jesus.miranda.william.votenolivro.services.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jesus.miranda.william.votenolivro.beans.Usuario;
import br.com.jesus.miranda.william.votenolivro.repository.UsuarioRepository;
import br.com.jesus.miranda.william.votenolivro.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Transactional
	public boolean save(Usuario usuario){
		return usuarioRepository.save(usuario).getId() != null;
	}
	
}
