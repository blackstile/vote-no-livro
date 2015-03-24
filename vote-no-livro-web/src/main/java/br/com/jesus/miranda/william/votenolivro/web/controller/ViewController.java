package br.com.jesus.miranda.william.votenolivro.web.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.jesus.miranda.william.votenolivro.services.DatabaseInitializeService;

@Controller
@RequestMapping(value="/view")
public class ViewController {
	
	@Autowired
	DatabaseInitializeService databaseInit;
	
	@RequestMapping(value="/init")
	public void init(HttpServletResponse response){
		databaseInit.insertLivros();
		response.setStatus(HttpStatus.OK.value());
	}
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index(HttpSession session){
		return "index";
	}

}
