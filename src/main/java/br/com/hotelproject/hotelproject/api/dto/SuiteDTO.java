package br.com.hotelproject.hotelproject.api.dto;

import br.com.hotelproject.hotelproject.model.enums.StatusQuarto;

public class SuiteDTO {
	
	protected Long idSuite;
	protected String nomeSuite;
	protected StatusQuarto statusQuarto;
	protected String email;
	
	public SuiteDTO() {
		super();
	}

	public SuiteDTO(Long idSuite, String nomeSuite, StatusQuarto statusQuarto, String email) {
		super();
		this.idSuite = idSuite;
		this.nomeSuite = nomeSuite;
		this.statusQuarto = statusQuarto;
		this.email = email;
	}

	public Long getIdSuite() {
		return idSuite;
	}

	public void setIdSuite(Long idSuite) {
		this.idSuite = idSuite;
	}

	public String getNomeSuite() {
		return nomeSuite;
	}

	public void setNomeSuite(String nomeSuite) {
		this.nomeSuite = nomeSuite;
	}

	public StatusQuarto getStatusQuarto() {
		return statusQuarto;
	}

	public void setStatusQuarto(StatusQuarto statusQuarto) {
		this.statusQuarto = statusQuarto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
