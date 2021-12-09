package br.com.hotelproject.hotelproject.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.hotelproject.hotelproject.model.enums.StatusQuarto;

@Entity
@Table(name = "Suite")//, schema="hotel")
public class Suite {

	private Suite suite;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSuite;
	
	private String nomeSuite;
	
	@Column(name="StatusQuarto")
	@Enumerated(value=EnumType.STRING)
	private StatusQuarto statusQuarto;
	
	private String email;

	public Suite() {
		super();
	}

	public Suite(Long idSuite, String nomeSuite, StatusQuarto statusQuarto, String email) {
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

	@Override
	public String toString() {
		return "Suite [idSuite=" + idSuite + ", nomeSuite=" + nomeSuite + ", statusQuarto=" + statusQuarto + ", email="
				+ email + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((idSuite == null) ? 0 : idSuite.hashCode());
		result = prime * result + ((nomeSuite == null) ? 0 : nomeSuite.hashCode());
		result = prime * result + ((statusQuarto == null) ? 0 : statusQuarto.hashCode());
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
		Suite other = (Suite) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idSuite == null) {
			if (other.idSuite != null)
				return false;
		} else if (!idSuite.equals(other.idSuite))
			return false;
		if (nomeSuite == null) {
			if (other.nomeSuite != null)
				return false;
		} else if (!nomeSuite.equals(other.nomeSuite))
			return false;
		if (statusQuarto != other.statusQuarto)
			return false;
		return true;
	}

	public void setSuite(Suite suite) {
		this.suite = suite;
	}
	
	public Suite getSuite() {
		return suite;
	}
	
}
