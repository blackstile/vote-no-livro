package br.com.jesus.miranda.william.votenolivro.beans;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Ranking extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Livro livro;
	private Long quantidadeVotos;
	
	public Ranking() {
	}
	
	public Ranking(Livro livro, Long quantidadeVotos) {
		super();
		this.livro = livro;
		this.quantidadeVotos = quantidadeVotos;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public Long getQuantidadeVotos() {
		return quantidadeVotos;
	}
	public void setQuantidadeVotos(Long quantidadeVotos) {
		this.quantidadeVotos = quantidadeVotos;
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
}
