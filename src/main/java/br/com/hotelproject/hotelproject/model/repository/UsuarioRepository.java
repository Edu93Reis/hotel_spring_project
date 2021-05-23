package br.com.hotelproject.hotelproject.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hotelproject.hotelproject.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	boolean existsByEmail(String email);
	
	boolean existsByEmailAndSenha(String email, String senha);
	
	Optional<Usuario> findByEmail(String email);

	Optional<Usuario> findByEmailAndSenha(String email, String senha);

}
