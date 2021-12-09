package br.com.hotelproject.hotelproject.model.service;

import java.util.List;
import java.util.Optional;

import br.com.hotelproject.hotelproject.model.entity.Suite;
import br.com.hotelproject.hotelproject.model.enums.StatusQuarto;

public interface SuiteService {

	//funciona como um isb, fornecendo o contrato das classes a serem implementadas
	Suite registrarSuite(Suite suite);
	Suite atualizarSuite(Suite suite);
	void deletarSuite(Suite suite);
	void atualizarStatusSuite(Suite suite, StatusQuarto status);
	Optional<Suite> obterPorId(Long id);
	List<Suite> buscar(Suite suiteFiltro);
	
}
