package br.com.hotelproject.hotelproject.model.repository;

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
	public void testaValidacaoEmail() {
		
		Usuario usuario = new Usuario("user@test.com","user");
		
		entityManager.persist(usuario);
		
		boolean valida = usuarioRepository.existsByEmail(usuario.getEmail());
		
		Assertions.assertThat(valida).isTrue();
		
	}
	
	@Test
	public void testaCadastroUsuario() {
		
		Usuario usuario = new Usuario("John Doe", "user@test.com", "user", 120);
		
		Usuario teste = usuarioRepository.save(usuario);
		
		Assertions.assertThat(teste.getIdUsuario()).isNotNull();
		
	}
	
//	@Test
//	public void testaAutenticacaoUsuario() {
//		
//		Usuario usuario = new Usuario("user@test.com", "user");
//		
//		Usuario teste = entityManager.persist(usuario);
//		
//		Assertions.assertThat(teste).asList();
//		
//	}

}
