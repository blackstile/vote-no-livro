package br.com.jesus.miranda.william.votenolivro.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Livro extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String titulo;
	private String imagem;
	@Lob
	@Column(length=5000)
	private String descricao;
	
	public Livro() {}
	
	public Livro(String titulo, String imagem, String descricao) {
		this.titulo = titulo;
		this.imagem = imagem;
		this.descricao = descricao;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Livro titulo(String titulo) {
		setTitulo(titulo);
		return this;
	}

	public Livro imagemPath(String imagemPath){
		setImagem(imagemPath);
		return this;
	}
	
	public Livro descricao(String descricao){
		setDescricao(descricao);
		return this;
	}
}
