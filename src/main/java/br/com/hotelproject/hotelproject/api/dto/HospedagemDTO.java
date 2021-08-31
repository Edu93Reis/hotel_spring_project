package br.com.hotelproject.hotelproject.api.dto;

import java.time.LocalDate;
import java.util.Date;

public class HospedagemDTO {

	protected LocalDate dataHospedagemIni;
	protected LocalDate dataHospedagemFim;
	protected String email;
	protected Long idQuarto;
	
	public HospedagemDTO(LocalDate dataHospedagemIni, LocalDate dataHospedagemFim, String email, Long idQuarto) {
		super();
		this.dataHospedagemIni = dataHospedagemIni;
		this.dataHospedagemFim = dataHospedagemFim;
		this.email = email;
		this.idQuarto = idQuarto;
	}

	public LocalDate getDataHospedagemIni() {
		return dataHospedagemIni;
	}

	public void setDataHospedagemIni(LocalDate dataHospedagemIni) {
		this.dataHospedagemIni = dataHospedagemIni;
	}

	public LocalDate getDataHospedagemFim() {
		return dataHospedagemFim;
	}

	public void setDataHospedagemFim(LocalDate dataHospedagemFim) {
		this.dataHospedagemFim = dataHospedagemFim;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getIdQuarto() {
		return idQuarto;
	}

	public void setIdQuarto(Long idQuarto) {
		this.idQuarto = idQuarto;
	}
	
}
