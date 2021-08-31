package br.com.hotelproject.hotelproject.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hotelproject.hotelproject.api.dto.HospedagemDTO;
import br.com.hotelproject.hotelproject.exceptions.RegraNegocioException;
import br.com.hotelproject.hotelproject.model.entity.Hospedagem;
import br.com.hotelproject.hotelproject.model.service.HospedagemService;
import br.com.hotelproject.hotelproject.model.service.SuiteService;

@RestController
@RequestMapping("api/hospedagem")
public class HospedagemController {

	private HospedagemService service;
	private SuiteService suiteService;
	
	public HospedagemController(HospedagemService service, SuiteService suiteService) {
		this.service = service;
		this.suiteService = suiteService;
	}
	
	@PostMapping
	public ResponseEntity cadastraHospedagem( @RequestBody HospedagemDTO dto) {
		try {
			Hospedagem hospedagem = converter(dto);
			hospedagem = service.cadastraHospedagem(hospedagem);
			
			return new ResponseEntity(hospedagem, HttpStatus.CREATED);
		}catch(RegraNegocioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity atualizarHospedagem( @PathVariable("id") Long id, @RequestBody HospedagemDTO dto) {
		return service.obterPorId(id).map( entity -> {
				try {
					Hospedagem hospedagem = converter(dto);
					hospedagem.setIdQuarto(id);
					service.atualizaHospedagem(hospedagem);
					return ResponseEntity.ok(hospedagem);
				}catch(RegraNegocioException e) {
					return ResponseEntity.badRequest().body(e.getMessage());
				}
		}).orElseGet( () -> new ResponseEntity("Hospedagem não encontrada!", HttpStatus.BAD_REQUEST));
	}

	private Hospedagem converter(HospedagemDTO dto) {
		Hospedagem hosp = new Hospedagem();
		
		hosp.setDataHospedagemFim(dto.getDataHospedagemFim());
		hosp.setDataHospedagemIni(dto.getDataHospedagemIni());
		hosp.setEmail(dto.getEmail());
		hosp.setIdQuarto(dto.getIdQuarto());
		
		return hosp;
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity deletar( @PathVariable("id") Long id) {
		return service.obterPorId(id).map( entity -> {
			service.deletaHospedagem(entity);
			return new ResponseEntity( HttpStatus.NO_CONTENT);
		}).orElseGet( () -> new ResponseEntity("Hospedagem não encontrada", HttpStatus.BAD_REQUEST));
	}
	
}
