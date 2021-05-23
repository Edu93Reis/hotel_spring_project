package br.com.hotelproject.hotelproject.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@Entity
@Table(name="Hospedagem",schema="hotel")
public class Hospedagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Hospedagem;
	
	@Column(name = "dataHospedagem_Ini")
	@Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
	private LocalDate dataHospedagemIni;
	
	@Column(name = "dataHospedagem_Fim")
	@Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
	private LocalDate dataHospedagemFim;
	
//	@OneToMany
	@JoinColumn(name = "email")
	private String email;
	
//	@OneToOne
	@JoinColumn(name = "idQuarto")
	private Long idQuarto;

	public Hospedagem() {
		super();
	}

	public Hospedagem(Long hospedagem, LocalDate dataHospedagemIni, LocalDate dataHospedagemFim, String email,
			Long idQuarto) {
		super();
		Hospedagem = hospedagem;
		this.dataHospedagemIni = dataHospedagemIni;
		this.dataHospedagemFim = dataHospedagemFim;
		this.email = email;
		this.idQuarto = idQuarto;
	}

	public Long getHospedagem() {
		return Hospedagem;
	}

	public void setHospedagem(Long hospedagem) {
		Hospedagem = hospedagem;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Hospedagem == null) ? 0 : Hospedagem.hashCode());
		result = prime * result + ((dataHospedagemFim == null) ? 0 : dataHospedagemFim.hashCode());
		result = prime * result + ((dataHospedagemIni == null) ? 0 : dataHospedagemIni.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((idQuarto == null) ? 0 : idQuarto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hospedagem other = (Hospedagem) obj;
		if (Hospedagem == null) {
			if (other.Hospedagem != null)
				return false;
		} else if (!Hospedagem.equals(other.Hospedagem))
			return false;
		if (dataHospedagemFim == null) {
			if (other.dataHospedagemFim != null)
				return false;
		} else if (!dataHospedagemFim.equals(other.dataHospedagemFim))
			return false;
		if (dataHospedagemIni == null) {
			if (other.dataHospedagemIni != null)
				return false;
		} else if (!dataHospedagemIni.equals(other.dataHospedagemIni))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idQuarto == null) {
			if (other.idQuarto != null)
				return false;
		} else if (!idQuarto.equals(other.idQuarto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Hospedagem [Hospedagem=" + Hospedagem + ", dataHospedagemIni=" + dataHospedagemIni
				+ ", dataHospedagemFim=" + dataHospedagemFim + ", email=" + email + ", idQuarto=" + idQuarto + "]";
	}
	
}
