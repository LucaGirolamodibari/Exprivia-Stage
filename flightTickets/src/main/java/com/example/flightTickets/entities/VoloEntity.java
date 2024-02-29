package com.example.flightTickets.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "VOLO")
public class VoloEntity {

	@Id
	private String idVolo;

	private Long idAeroportoOrigine;

	private Long idAeroportoDestinazione;

	private Long idAeroportoScalo;

	private Long idAereo;

	private Integer postiPrenotati;

	private Integer postiDisponibili;

	private Integer costoBase;

	public String getIdVolo() {
		return idVolo;
	}

	public void setIdVolo(String idVolo) {
		this.idVolo = idVolo;
	}

	public Long getIdAeroportoOrigine() {
		return idAeroportoOrigine;
	}

	public void setIdAeroportoOrigine(Long idAeroportoOrigine) {
		this.idAeroportoOrigine = idAeroportoOrigine;
	}

	public Long getIdAeroportoDestinazione() {
		return idAeroportoDestinazione;
	}

	public void setIdAeroportoDestinazione(Long idAeroportoDestinazione) {
		this.idAeroportoDestinazione = idAeroportoDestinazione;
	}

	public Long getIdAeroportoScalo() {
		return idAeroportoScalo;
	}

	public void setIdAeroportoScalo(Long idAeroportoScalo) {
		this.idAeroportoScalo = idAeroportoScalo;
	}

	public Long getIdAereo() {
		return idAereo;
	}

	public void setIdAereo(Long idAereo) {
		this.idAereo = idAereo;
	}

	public Integer getPostiPrenotati() {
		return postiPrenotati;
	}

	public void setPostiPrenotati(Integer postiPrenotati) {
		this.postiPrenotati = postiPrenotati;
	}

	public Integer getPostiDisponibili() {
		return postiDisponibili;
	}

	public void setPostiDisponibili(Integer postiDisponibili) {
		this.postiDisponibili = postiDisponibili;
	}

	public Integer getCostoBase() {
		return costoBase;
	}

	public void setCostoBase(Integer costoBase) {
		this.costoBase = costoBase;
	}

}
