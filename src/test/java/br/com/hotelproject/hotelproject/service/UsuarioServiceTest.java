package br.com.hotelproject.hotelproject.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.hotelproject.hotelproject.exceptions.AutenticacaoException;
import br.com.hotelproject.hotelproject.exceptions.EmailJaCadastradoException;
import br.com.hotelproject.hotelproject.model.entity.Usuario;
import br.com.hotelproject.hotelproject.model.repository.UsuarioRepository;
import br.com.hotelproject.hotelproject.model.service.UsuarioService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UsuarioServiceTest {

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Test(expected = Test.None.class)
	public void testaValidaEmail() {
		
		usuarioRepository.deleteAll();
		
		usuarioService.validaEmail("email@email.com");
		
	}
	
	@Test(expected = EmailJaCadastradoException.class)
	public void testaEmailCadastrado() {
		
		Usuario usuario = new Usuario("John Doe", "email@email.com", "000", 12);
		
		usuarioRepository.save(usuario);
		
		usuarioService.validaEmail("email@email.com");
		
	}
	
	@Test(expected = Test.None.class)
	public void testaCadastraUsuario() {
		
		Usuario usuario = new Usuario("John Doe", "email@email.com", "000", 12);
		
		usuarioService.cadastraUsuario(usuario);
	
		
		
	}
	
	@Test(expected = Test.None.class)
	public void testaValidaUsuarioValido() {
	
		usuarioService.autenticarUsuario("email@email.com", "000");
		
	}
	
	@Test(expected = AutenticacaoException.class)
	public void testaValidaUsuarioInvalido() {
		
		usuarioService.autenticarUsuario("email1@email.com", "001");
		
	}
	
}
