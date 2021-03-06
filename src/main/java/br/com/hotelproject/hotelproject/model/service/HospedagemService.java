package br.com.hotelproject.hotelproject.model.service;

import java.util.Optional;

import br.com.hotelproject.hotelproject.model.entity.Hospedagem;

public interface HospedagemService {
	
	Hospedagem cadastraHospedagem(Hospedagem hospedagem);
	void deletaHospedagem(Hospedagem hospedagem);
	void atualizaHospedagem(Hospedagem hospedagem);
	Optional<Hospedagem> obterPorId(Long id);
	Hospedagem atualizar(Hospedagem hospedagem);

}
