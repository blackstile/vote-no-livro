package br.com.jesus.miranda.william.votenolivro.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Usuario extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(nullable=false)
	@NotBlank(message="{usuario.nome.requerido}")
	private String nome;
	
	@Column(nullable=false)
	@NotBlank(message="{usuario.email.requerido}")
	@Email(message="{usuario.email.invalido}")
	private String email;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Usuario email(String email){
		setEmail(email);
		return this;
	}
	
	public Usuario nome(String nome){
		setNome(nome);
		return this;
	}

}
