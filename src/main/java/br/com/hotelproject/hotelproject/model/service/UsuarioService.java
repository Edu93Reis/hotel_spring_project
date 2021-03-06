package br.com.hotelproject.hotelproject.model.service;

import java.util.Optional;

import br.com.hotelproject.hotelproject.model.entity.Usuario;

public interface UsuarioService {
	
	Usuario autenticarUsuario(String email, String senha);
	
	Usuario cadastraUsuario(Usuario usuario);
	
	void validaEmail(String email);

	Optional<Usuario> obterPorId(Long id);

	void deletar(Usuario entity);

}
