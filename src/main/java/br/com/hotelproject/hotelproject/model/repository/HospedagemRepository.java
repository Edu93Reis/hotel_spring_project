package br.com.hotelproject.hotelproject.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hotelproject.hotelproject.model.entity.Hospedagem;

public interface HospedagemRepository extends JpaRepository<Hospedagem, Long> {

}
