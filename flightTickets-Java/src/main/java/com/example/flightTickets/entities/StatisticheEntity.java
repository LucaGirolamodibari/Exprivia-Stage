package com.example.flightTickets.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "STATISTICHE")
public class StatisticheEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String idVolo;

	private Integer numPrenotazioni;

	private Integer etaMediaPasseggeri;

	private Integer numMaggiorenni;

	private Integer numMinorenni;

	private Integer totEuroFatturato;

	public String getIdVolo() {
		return idVolo;
	}

	public void setIdVolo(String idVolo) {
		this.idVolo = idVolo;
	}

	public Integer getNumPrenotazioni() {
		return numPrenotazioni;
	}

	public void setNumPrenotazioni(Integer numPrenotazioni) {
		this.numPrenotazioni = numPrenotazioni;
	}

	public Integer getEtàMediaPasseggeri() {
		return etaMediaPasseggeri;
	}

	public void setEtàMediaPasseggeri(Integer etàMediaPasseggeri) {
		this.etaMediaPasseggeri = etàMediaPasseggeri;
	}

	public Integer getNumMaggiorenni() {
		return numMaggiorenni;
	}

	public void setNumMaggiorenni(Integer numMaggiorenni) {
		this.numMaggiorenni = numMaggiorenni;
	}

	public Integer getNumMinorenni() {
		return numMinorenni;
	}

	public void setNumMinorenni(Integer numMinorenni) {
		this.numMinorenni = numMinorenni;
	}

	public Integer getTotEuroFatturato() {
		return totEuroFatturato;
	}

	public void setTotEuroFatturato(Integer totEuroFatturato) {
		this.totEuroFatturato = totEuroFatturato;
	}

}
