package br.com.jesus.miranda.william.votenolivro.beans;

public class Combinacao extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Long idLivro1;
	private final Long idLivro2;
	
	public Combinacao(Long idLivro1, Long idLivro2) {
		super();
		this.idLivro1 = idLivro1;
		this.idLivro2 = idLivro2;
	}

	public Long getIdLivro1() {
		return idLivro1;
	}

	public Long getIdLivro2() {
		return idLivro2;
	}
	
}
