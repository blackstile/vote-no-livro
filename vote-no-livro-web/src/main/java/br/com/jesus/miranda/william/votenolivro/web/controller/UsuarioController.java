package br.com.jesus.miranda.william.votenolivro.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.jesus.miranda.william.votenolivro.beans.Usuario;
import br.com.jesus.miranda.william.votenolivro.services.impl.UsuarioServiceImpl;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioServiceImpl usuarioService;
	
	@RequestMapping(value="/save" , method=RequestMethod.POST)
	public void save (@RequestBody Usuario usuario){
		usuarioService.save(usuario);
	}
	
}
