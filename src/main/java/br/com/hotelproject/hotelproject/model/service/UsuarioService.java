package br.com.hotelproject.hotelproject.model.service;

import br.com.hotelproject.hotelproject.model.entity.Usuario;

public interface UsuarioService {
	
	Usuario autenticarUsuario(String email, String senha);
	
	void cadastraUsuario(Usuario usuario);
	
	void validaEmail(String email);

}
