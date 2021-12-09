package br.com.hotelproject.hotelproject.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.hotelproject.hotelproject.api.dto.AtualizaStatusDTO;
import br.com.hotelproject.hotelproject.api.dto.SuiteDTO;
import br.com.hotelproject.hotelproject.exceptions.RegraNegocioException;
import br.com.hotelproject.hotelproject.model.entity.Suite;
import br.com.hotelproject.hotelproject.model.enums.StatusQuarto;
import br.com.hotelproject.hotelproject.model.service.SuiteService;
import br.com.hotelproject.hotelproject.model.service.UsuarioService;

@RestController //permite usar response body e controller
@RequestMapping("/quartos")
public class SuiteController {

	private UsuarioService userService;
	private SuiteService suiteService;
	
	private SuiteController(SuiteService suiteService) {
		this.suiteService = suiteService;
	}	
	
	@PostMapping
	public ResponseEntity registrar( @RequestBody SuiteDTO dto ) {
		
		Suite suite = new Suite(dto.getIdSuite(), 
								dto.getNomeSuite(), 
								dto.getStatusQuarto(), 
								dto.getEmail());
				
		
		try {
			
			Suite suiteCadastrada = suiteService.registrarSuite(suite);
			
			return new ResponseEntity(suiteCadastrada, HttpStatus.CREATED);
			
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	} 
	
	@PutMapping("/{id}/atualiza-status")
	public ResponseEntity atualizarStatusSuite(@PathVariable("id") Long id, @RequestBody AtualizaStatusDTO dto) {
		return suiteService.obterPorId(id).map( entity -> {
			StatusQuarto status = StatusQuarto.valueOf(dto.getStatus());
			
			if(status == null) {
				return ResponseEntity.badRequest().body("Status invalido!!");
			}
			
			try {
				entity.setStatusQuarto(status);
				suiteService.atualizarSuite(entity);
				return ResponseEntity.ok(entity);
			}catch(RegraNegocioException e){
				return ResponseEntity.badRequest().body(e.getMessage());
			}
		}).orElseGet( () -> new ResponseEntity("Suite não encontrada!", HttpStatus.BAD_REQUEST));
	}
	
	@PutMapping("{id}")
	public ResponseEntity atualizarSuite(@PathVariable("id") Long id, @RequestBody SuiteDTO dto) {
		return suiteService.obterPorId(id).map( entity -> {
					try {
						Suite suite = converter(dto);
						suite.setIdSuite(entity.getIdSuite());
						suiteService.atualizarSuite(suite);
						return ResponseEntity.ok(suite);
					}catch(RegraNegocioException e){
						return ResponseEntity.badRequest().body(e.getMessage());
					}
		} ).orElseGet( () -> new ResponseEntity("Suite não cadastrada", HttpStatus.BAD_REQUEST));
	}
	
	public Suite converter(SuiteDTO dto) {
		Suite suite = new Suite();
		
		suite.setEmail(dto.getEmail());
		suite.setNomeSuite(dto.getNomeSuite());
		suite.setStatusQuarto(dto.getStatusQuarto());
		
		return suite;
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity deletar( @PathVariable("id") Long id ) {
		return suiteService.obterPorId(id).map( entity -> {
				suiteService.deletarSuite(entity);
				return new ResponseEntity( HttpStatus.NO_CONTENT );
			}).orElseGet( () ->
						new ResponseEntity("Suite não cadastrada", HttpStatus.BAD_REQUEST));
	}
	
	@GetMapping
	public ResponseEntity buscar(
			@RequestParam(value="idSuite") Long idSuite,
			@RequestParam(value="nomeSuite") String nomeSuite,
			@RequestParam(value="email", required = false) String email,
			@RequestParam(value="statusQuarto") StatusQuarto statusQuarto) {
		Suite suiteFiltro = new Suite();
		
		suiteFiltro.setEmail(email);
		suiteFiltro.setNomeSuite(nomeSuite);
		suiteFiltro.setStatusQuarto(statusQuarto);
		
		Optional<Suite> suiteRetorno = suiteService.obterPorId(idSuite);
		
		if(suiteRetorno.isPresent()) {
			return ResponseEntity.badRequest().body("Suíte não encontrada. Suíte não encontrada para o id relacionado.");
		}else {
			suiteFiltro.setSuite(suiteRetorno.get());
		}
		
		List<Suite> suite = suiteService.buscar(suiteFiltro);
		
		return ResponseEntity.ok(suite);
		
	}
	
	
//	Optional<Suite> obterPorId(Long id);
	
}
