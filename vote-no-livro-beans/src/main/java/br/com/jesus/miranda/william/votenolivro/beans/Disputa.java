package br.com.jesus.miranda.william.votenolivro.beans;

public class Disputa extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Livro livro1;
	private Livro livro2;
	
	public Disputa() {
	}
	
	
	public Disputa(Livro livro1, Livro livro2) {
		super();
		this.livro1 = livro1;
		this.livro2 = livro2;
	}

	public Livro getLivro1() {
		return livro1;
	}
	public void setLivro1(Livro livro1) {
		this.livro1 = livro1;
	}
	public Livro getLivro2() {
		return livro2;
	}
	public void setLivro2(Livro livro2) {
		this.livro2 = livro2;
	}
	
	
}
