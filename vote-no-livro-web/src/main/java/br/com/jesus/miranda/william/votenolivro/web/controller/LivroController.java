package br.com.jesus.miranda.william.votenolivro.web.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.jesus.miranda.william.votenolivro.beans.Combinacao;
import br.com.jesus.miranda.william.votenolivro.beans.Disputa;
import br.com.jesus.miranda.william.votenolivro.services.LivroService;

@RestController
@RequestMapping(value="/livro")
public class LivroController {
	
	
	@Autowired 
	private LivroService livroService;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping(value="/disputa",  method=RequestMethod.GET)
	public @ResponseBody Disputa getLivrosDisputa(HttpServletResponse response){
		Disputa disputa =  getDisputa();
		if (disputa == null){
			response.setStatus(HttpStatus.NO_CONTENT.value());
		}
		return disputa;
	}

	@SuppressWarnings("unchecked")
	private List<Combinacao> getCombinacoes() {
		List<Combinacao> listaCombinacao = (List<Combinacao>) session.getAttribute("listaCombinacoes");
		if (listaCombinacao == null){
			listaCombinacao =  livroService.getCombinacoes();
		}
		if (listaCombinacao != null && !listaCombinacao.isEmpty()){
			Collections.shuffle(listaCombinacao);
			session.setAttribute("listaCombinacoes", listaCombinacao);
		}
		return  listaCombinacao;
	}
	
	private Disputa getDisputa(){
		Disputa disputa = null;
		List<Combinacao> listaCombinacao =  getCombinacoes();
		if (listaCombinacao != null && !listaCombinacao.isEmpty()){
			Combinacao combinacao =  listaCombinacao.remove(0);
			disputa =  livroService.getDisputa(combinacao.getIdLivro1(), combinacao.getIdLivro2());
		}
		return disputa;
	}

}
