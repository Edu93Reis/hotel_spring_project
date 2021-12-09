package br.com.hotelproject.hotelproject.model.service.impl;

import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.hotelproject.hotelproject.exceptions.RegraNegocioException;
import br.com.hotelproject.hotelproject.model.entity.Hospedagem;
import br.com.hotelproject.hotelproject.model.repository.HospedagemRepository;
import br.com.hotelproject.hotelproject.model.service.HospedagemService;

@Service
public class HospedagemServiceImpl implements HospedagemService {
	
	HospedagemRepository hospedagemRepository;
	
	public HospedagemServiceImpl(HospedagemRepository hospedagemRepository) {
		super();
		this.hospedagemRepository = hospedagemRepository;
		
	}

	@Override
	@Transactional
	public Hospedagem cadastraHospedagem(Hospedagem hospedagem) {
		validar(hospedagem);
		return hospedagemRepository.save(hospedagem);
	}

	@Override
	@Transactional
	public void deletaHospedagem(Hospedagem hospedagem) {
		Objects.requireNonNull(hospedagem.getIdQuarto());
		hospedagemRepository.delete(hospedagem);
	}

	@Override
	@Transactional
	public void atualizaHospedagem(Hospedagem hospedagem) {
		atualizar(hospedagem);
	}
	
	@Override
	public Hospedagem atualizar(Hospedagem hospedagem) {
		Objects.requireNonNull(hospedagem.getIdQuarto());
		validar(hospedagem);
		return hospedagemRepository.save(hospedagem);
	}

	private void validar(Hospedagem hospedagem) {

		if(hospedagem.getDataHospedagemIni() == null) {
			throw new RegraNegocioException("Informe data válida!");
		}
		
		if(hospedagem.getDataHospedagemFim() == null) {
			throw new RegraNegocioException("Informe data válida!");
		}
		
		if(hospedagem.getEmail() == null || hospedagem.getEmail().trim().equalsIgnoreCase("")) {
			throw new RegraNegocioException("Informe e-mail válido!");
		}
		
	}

	@Override
	public Optional<Hospedagem> obterPorId(Long id) {
		return hospedagemRepository.findById(id);
	}
	
	

}
