package br.com.hotelproject.hotelproject.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hotelproject.hotelproject.model.entity.Suite;

public interface SuiteRepository extends JpaRepository<Suite, Long> {
	
	Optional<Suite> findByIdSuite(Long idSuite);

}
