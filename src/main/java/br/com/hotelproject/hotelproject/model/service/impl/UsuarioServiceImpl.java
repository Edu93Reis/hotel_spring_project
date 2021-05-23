package br.com.hotelproject.hotelproject.model.service.impl;

import org.springframework.stereotype.Service;

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
		Usuario user = null;
		try {
			if(usuarioRepository.existsByEmailAndSenha(email, senha)) {
				user = new Usuario();
				user = usuarioRepository.findByEmailAndSenha(email, senha);
			}
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public void cadastraUsuario(Usuario usuario) {
		
		try {
			validaEmail(usuario.getEmail());
			
			usuarioRepository.save(usuario);
			
		}catch(Throwable e) {
			e.getMessage();
		}
		
	}

	@Override
	public void validaEmail(String email) {
		
		if(usuarioRepository.existsByEmail(email)) {
			throw new EmailJaCadastradoException("Usuário já cadastrado para este e-mail!");
		}
		
	}

}
