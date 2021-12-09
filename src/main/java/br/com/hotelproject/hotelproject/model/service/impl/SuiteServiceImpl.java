package br.com.hotelproject.hotelproject.model.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;

import br.com.hotelproject.hotelproject.exceptions.RegraNegocioException;
import br.com.hotelproject.hotelproject.model.entity.Suite;
import br.com.hotelproject.hotelproject.model.enums.StatusQuarto;
import br.com.hotelproject.hotelproject.model.repository.SuiteRepository;
import br.com.hotelproject.hotelproject.model.service.SuiteService;

public class SuiteServiceImpl implements SuiteService {
	
	SuiteRepository suiteRepository;

	public SuiteServiceImpl(SuiteRepository suiteRepository) {
		super();
		this.suiteRepository = suiteRepository;
	}
	
	private void validar(Suite suite) {
		if(suite.getEmail() == null || suite.getEmail().trim().equalsIgnoreCase("")) {
			throw new RegraNegocioException("Informe e-mail válido!!");
		}
		
		if(suite.getNomeSuite() == null || suite.getNomeSuite().trim().equalsIgnoreCase("")) {
			throw new RegraNegocioException("Informe nome de suíte válido!!");
		}
		
//		if(suite.getStatusQuarto() == null) {
//			throw new RegraNegocioException("Informe status válido!!");
//		}
	}
	
	@Override
	public Suite registrarSuite(Suite suite) {
		validar(suite);
		suite.setStatusQuarto(StatusQuarto.VAGO);
		return suiteRepository.save(suite);
	}

	@Override
	public Suite atualizarSuite(Suite suite) {
		Objects.requireNonNull(suite.getIdSuite());
		validar(suite);
		return suiteRepository.save(suite);
	}

	@Override
	public void deletarSuite(Suite suite) {
		Objects.requireNonNull(suite.getIdSuite());
		suiteRepository.delete(suite);
	}

	@Override
	public void atualizarStatusSuite(Suite suite, StatusQuarto status) {
		Objects.requireNonNull(suite.getIdSuite());
		suite.setStatusQuarto(status);
		suiteRepository.save(suite);
	}

	@Override
	public Optional<Suite> obterPorId(Long id) {
		return suiteRepository.findById(id);
	}

	@Override
	public List<Suite> buscar(Suite suiteFiltro) {
		Example example = Example.of(suiteFiltro,
									 ExampleMatcher.matching()
									 .withIgnoreCase()
									 .withStringMatcher(StringMatcher.CONTAINING)
								);
		return suiteRepository.findAll(example);
	}

}
