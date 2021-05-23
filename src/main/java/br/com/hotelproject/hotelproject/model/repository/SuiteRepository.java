package br.com.hotelproject.hotelproject.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hotelproject.hotelproject.model.entity.Suite;

public interface SuiteRepository extends JpaRepository<Suite, Long> {

}
