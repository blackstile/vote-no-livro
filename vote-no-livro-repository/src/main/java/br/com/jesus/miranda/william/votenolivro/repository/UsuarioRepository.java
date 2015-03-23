package br.com.jesus.miranda.william.votenolivro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jesus.miranda.william.votenolivro.beans.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Usuario findByEmail(String email);
	List<Usuario> findByNome(String nome);
}
