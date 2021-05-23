package br.com.hotelproject.hotelproject.model.repository;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.hotelproject.hotelproject.model.entity.Usuario;

@SpringBootTest
 @RunWith( SpringRunner.class)
public class UsuarioRepositoryTest {
	
	@Autowired
	public UsuarioRepository usuarioRepository;
	
	@Test
	public void testaValidacaoEmail() {
		
		Usuario usuario = new Usuario("user@test.com","user");
		
		boolean valida = usuarioRepository.existsByEmail(usuario.getEmail());
		
		Assertions.assertThat(valida).isTrue();
		
	}
	
	@Test
	public void testaCadastroUsuario() {
		
		Usuario usuario = new Usuario(null, "John Doe", "user@test.com", "user", 120);
		
		Usuario teste = usuarioRepository.save(usuario);
		
		Assertions.assertThat(teste).asList();
		
	}
	
	@Test
	public void testaAutenticacaoUsuario() {
		
		Usuario usuario = new Usuario("user@test.com", "user");
		
		Usuario teste = usuarioRepository.save(usuario);
		
		Assertions.assertThat(teste).asList();
		
	}

}
