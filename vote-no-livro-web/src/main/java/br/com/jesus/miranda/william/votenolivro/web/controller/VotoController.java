package br.com.jesus.miranda.william.votenolivro.web.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.jesus.miranda.william.votenolivro.beans.Combinacao;
import br.com.jesus.miranda.william.votenolivro.beans.Livro;
import br.com.jesus.miranda.william.votenolivro.beans.Ranking;
import br.com.jesus.miranda.william.votenolivro.beans.Voto;
import br.com.jesus.miranda.william.votenolivro.services.VotoService;
import br.com.jesus.miranda.william.votenolivro.web.util.LogUtil;

import com.google.common.base.Function;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimaps;

@RestController
@RequestMapping(value = "voto")
@SuppressWarnings("unchecked")
public class VotoController {

	private static final LogUtil log = LogUtil.getLog(VotoController.class);

	@Autowired
	private HttpSession session;

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private VotoService votoService;

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public @ResponseBody
	boolean votar(@RequestBody Voto voto, ModelAndView model) {
		boolean saved = votoService.save(voto);
		if (saved) {
			removeCombinacao();
			gerenciarMeusVotos(voto);
		}
		return saved;
	}

	@RequestMapping(value = "obter-ranking", method = RequestMethod.GET)
	public @ResponseBody
	List<Ranking> getRankingGeral() {
		return votoService.getRanking();
	}

	@RequestMapping(value = "obter-meus-votos", method = RequestMethod.GET)
	public @ResponseBody
	List<Ranking> getMeusVotos() {
		List<Voto> meusVotos = (List<Voto>) session.getAttribute("meusVotos");
		return gerarRanking(meusVotos);
	}

	/**
	 * Gera o ranking para os votos feito pelo usuario
	 * @param listaVotos
	 * @return
	 */
	private List<Ranking> gerarRanking(List<Voto> listaVotos){
		List<Ranking> rankings = new ArrayList<Ranking>();
		
		if (listaVotos == null) return rankings;
		
		ListMultimap<Livro, Voto> groupedVotos = Multimaps.index(listaVotos, new Function<Voto, Livro>() {  
			public Livro apply(Voto voto) {  
				return voto.getOpcaoEscolhida();  
			}  
		});
		
		for (Entry<Livro,Collection<Voto>> entry : groupedVotos.asMap().entrySet()){
			rankings.add(new Ranking(entry.getKey() , (long) entry.getValue().size())); 
		}
		return rankings;
		
	}
	
	@RequestMapping(value = "iniciar-nova-votacao", method = RequestMethod.GET)
	public void novaVotacao() {
		session.removeAttribute("listaCombinacoes");
	}

	private void gerenciarMeusVotos(Voto voto) {
		List<Voto> meusVotos = (List<Voto>) session.getAttribute("meusVotos");

		if (meusVotos == null) {
			meusVotos = new ArrayList<Voto>();
		}
		meusVotos.add(voto);
		log.debug("Meus Votos %s", meusVotos);
		session.setAttribute("meusVotos", meusVotos);
	}

	private void removeCombinacao() {
		List<Combinacao> listaCombinacao = (List<Combinacao>) session.getAttribute("listaCombinacoes");
		if (listaCombinacao != null && listaCombinacao.iterator().hasNext()) {
			listaCombinacao.remove(0);
		}
		log.debug("Lista de Combinacao %s", listaCombinacao);
	}
}
