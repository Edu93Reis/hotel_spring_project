package br.com.hotelproject.hotelproject.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hotelproject.hotelproject.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	boolean existsByEmail(String email);
	
	boolean existsByEmailAndSenha(String email, String senha);

	Usuario findByEmailAndSenha(String email, String senha);

}
