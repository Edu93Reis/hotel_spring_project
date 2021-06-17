package br.com.hotelproject.hotelproject.model.repository;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.hotelproject.hotelproject.model.entity.Usuario;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")//busca application-"test"//corrigir config
@DataJpaTest//usa commmit e rollback
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UsuarioRepositoryTest {
	
	@Autowired
	public UsuarioRepository usuarioRepository;
	
	@Autowired
	TestEntityManager entityManager;
	
	@Test
	public void testaValidacaoEmailTrue() {
		
		Usuario usuario = criarUsuario();
		
		entityManager.persist(usuario);
		
		boolean valida = usuarioRepository.existsByEmail(usuario.getEmail());
		
		Assertions.assertThat(valida).isTrue();
		
	}
	
	@Test
	public void testaValidacaoEmailFalse() {
		
		boolean valida = usuarioRepository.existsByEmail("teste@any.com");
		
		Assertions.assertThat(valida).isFalse();
		
	}
	
	public Usuario criarUsuario() {
		return new Usuario("John Doe", "user@test.com", "user", 120);
	}
	
	@Test
	public void testaCadastroUsuario() {
		
		Usuario usuario = criarUsuario();
		
		Usuario teste = usuarioRepository.save(usuario);
		
		Assertions.assertThat(teste.getIdUsuario()).isNotNull();
		
	}
	
	public void buscaUsuarioPorEmailTrue() {
		
		Usuario usuario = criarUsuario();
		entityManager.persist(usuario);
		
		Optional<Usuario> result = usuarioRepository.findByEmail(usuario.getEmail());
		
		Assertions.assertThat(result.isPresent()).isTrue();
		
	}
	
	public void buscaUsuarioPorEmailFalse() {
		
		Optional<Usuario> result = usuarioRepository.findByEmail("teste@any.com");
		
		Assertions.assertThat(result.isPresent()).isFalse();
		
	}
	
}
