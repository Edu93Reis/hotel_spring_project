package br.com.hotelproject.hotelproject.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hotelproject.hotelproject.api.dto.UsuarioDTO;
import br.com.hotelproject.hotelproject.exceptions.AutenticacaoException;
import br.com.hotelproject.hotelproject.exceptions.EmailJaCadastradoException;
import br.com.hotelproject.hotelproject.model.entity.Usuario;
import br.com.hotelproject.hotelproject.model.service.UsuarioService;



@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	
	private UsuarioService usuarioService;
	
	private UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@PostMapping("autenticar")
	public ResponseEntity autenticar( @RequestBody UsuarioDTO dto ) {
		
		Usuario usuario = new Usuario(dto.getNome(), dto.getEmail(), dto.getSenha(), dto.getIdade());
		
		try {
			Usuario usuarioAutenticado = usuarioService.autenticarUsuario(usuario.getNome(), usuario.getSenha());
			
			return ResponseEntity.ok(usuarioAutenticado);
		}catch(AutenticacaoException e) {
			return ResponseEntity.badRequest().body(e.getMessage()); 
		}
		
	}
	
	@PostMapping
	public ResponseEntity salvar( @RequestBody UsuarioDTO dto ) {
		
		Usuario usuario = new Usuario(dto.getNome(), dto.getEmail(), dto.getSenha(), dto.getIdade());
		
		try {
			
			Usuario usuarioSalvo = usuarioService.cadastraUsuario(usuario);
			
			return new ResponseEntity(usuarioSalvo, HttpStatus.CREATED);
			
		}catch(EmailJaCadastradoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}

	@DeleteMapping("{id}")
	public ResponseEntity deletar( @PathVariable("id") Long id ) {
		return usuarioService.obterPorId(id).map( entity ->{
						usuarioService.deletar(entity);
						return new ResponseEntity( HttpStatus.NO_CONTENT );
					}).orElseGet( () -> 
								new ResponseEntity("Lançamento não encontrado", HttpStatus.BAD_REQUEST)
							);
	}

}
