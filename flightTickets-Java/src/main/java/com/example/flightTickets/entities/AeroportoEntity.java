package com.example.flightTickets.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "AEROPORTO")
public class AeroportoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAeroporto;

	private String nomeAeroporto;

	private String città;

	private String nazione;

	private Integer numeroPiste;

	public Long getIdAeroporto() {
		return idAeroporto;
	}

	public void setIdAeroporto(Long idAeroporto) {
		this.idAeroporto = idAeroporto;
	}

	public String getNomeAeroporto() {
		return nomeAeroporto;
	}

	public void setNomeAeroporto(String nomeAeroporto) {
		this.nomeAeroporto = nomeAeroporto;
	}

	public String getCittà() {
		return città;
	}

	public void setCittà(String città) {
		this.città = città;
	}

	public String getNazione() {
		return nazione;
	}

	public void setNazione(String nazione) {
		this.nazione = nazione;
	}

	public Integer getNumeroPiste() {
		return numeroPiste;
	}

	public void setNumeroPiste(Integer numeroPiste) {
		this.numeroPiste = numeroPiste;
	}

}
