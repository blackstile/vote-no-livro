package br.com.jesus.miranda.william.votenolivro.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.jesus.miranda.william.votenolivro.beans.Usuario;
import br.com.jesus.miranda.william.votenolivro.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value="save" , method=RequestMethod.POST)
	public void save (Usuario usuario){
		usuarioService.save(usuario);
	}
	
}
