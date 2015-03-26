package br.com.jesus.miranda.william.votenolivro.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Voto extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Usuario usuario;
	@ManyToOne
	private Livro primeiraOpcao;
	@ManyToOne
	private Livro segundaOpcao;
	@ManyToOne
	private Livro opcaoEscolhida;
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Livro getPrimeiraOpcao() {
		return primeiraOpcao;
	}
	public void setPrimeiraOpcao(Livro primeiraOpcao) {
		this.primeiraOpcao = primeiraOpcao;
	}
	public Livro getSegundaOpcao() {
		return segundaOpcao;
	}
	public void setSegundaOpcao(Livro segundaOpcao) {
		this.segundaOpcao = segundaOpcao;
	}
	public Livro getOpcaoEscolhida() {
		return opcaoEscolhida;
	}
	public void setOpcaoEscolhida(Livro opcaoEscolhida) {
		this.opcaoEscolhida = opcaoEscolhida;
	}
	public Long getId() {
		return id;
	}
	
	public Voto primeiraOpcao(Livro opcao) {
		setPrimeiraOpcao(opcao);
		return this;
	}
	public Voto segundaOpcao(Livro opcao) {
		setSegundaOpcao(opcao);
		return this;
	}
	public Voto opcaoEscolhida(Livro opcao) {
		setOpcaoEscolhida(opcao);
		return this;
	}
}
