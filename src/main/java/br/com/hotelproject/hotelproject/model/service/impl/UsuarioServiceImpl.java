package br.com.hotelproject.hotelproject.model.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.hotelproject.hotelproject.exceptions.AutenticacaoException;
import br.com.hotelproject.hotelproject.exceptions.EmailJaCadastradoException;
import br.com.hotelproject.hotelproject.model.entity.Usuario;
import br.com.hotelproject.hotelproject.model.repository.UsuarioRepository;
import br.com.hotelproject.hotelproject.model.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	UsuarioRepository usuarioRepository;
	
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public Usuario autenticarUsuario(String email, String senha) {
		Optional<Usuario> user = usuarioRepository.findByEmail(email);
		
		if(!user.isPresent()) {
			throw new AutenticacaoException("E-mail inválido!");
		}
		
		if(!user.get().getSenha().equals(senha)) {
			throw new AutenticacaoException("Senha Inválida!");
		}
		
		return user.get();
	}

	@Override
	@Transactional
	public Usuario cadastraUsuario(Usuario usuario) {
		
		validaEmail(usuario.getEmail());
			
		return usuarioRepository.save(usuario);
		
	}

	@Override
	public void validaEmail(String email) {
		
		if(usuarioRepository.existsByEmail(email)) {
			throw new EmailJaCadastradoException("Usuário já cadastrado para este e-mail!");
		}
		
	}

}
