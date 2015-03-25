package br.com.jesus.miranda.william.votenolivro.web.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.jesus.miranda.william.votenolivro.beans.Combinacao;
import br.com.jesus.miranda.william.votenolivro.beans.Ranking;
import br.com.jesus.miranda.william.votenolivro.beans.Voto;
import br.com.jesus.miranda.william.votenolivro.services.VotoService;

@RestController
@RequestMapping(value="voto")
@SuppressWarnings("unchecked")
public class VotoController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private VotoService votoService;
	 
	
	@RequestMapping(value="salvar", method=RequestMethod.POST)
	public boolean votar(@RequestBody Voto voto){
		boolean saved = votoService.save(voto);
		if(saved){
			removeCombinacao();
			gerenciarMeusVotos(voto);
		}
		return saved;
	}
	
	@RequestMapping(value="getRanking", method=RequestMethod.GET)
	public @ResponseBody List<Ranking> getRanking(){
		return votoService.getRanking();
	}

	private void gerenciarMeusVotos(Voto voto) {
		List<Voto> meusVotos = (List<Voto>) session.getAttribute("meusVotos");
		if (meusVotos == null){
			meusVotos = Arrays.asList(voto);
		}
		session.setAttribute("meusVotos", meusVotos);
	}

	private void removeCombinacao() {
		List<Combinacao> listaCombinacao = (List<Combinacao>) session.getAttribute("listaCombinacoes");
		if (listaCombinacao != null && listaCombinacao.iterator().hasNext()){
			listaCombinacao.remove(0);
		}
	}
	
}
