package br.com.hotelproject.hotelproject.api.dto;

public class AtualizaStatusDTO {
	
	protected String status;

	public AtualizaStatusDTO() {
		super();
	}

	public AtualizaStatusDTO(String status) {
		super();
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
