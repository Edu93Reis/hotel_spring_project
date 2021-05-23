package br.com.hotelproject.hotelproject.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.hotelproject.hotelproject.model.repository.UsuarioRepository;
import br.com.hotelproject.hotelproject.model.service.UsuarioService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UsuarioServiceTest {

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	
}
