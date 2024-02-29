package com.example.flightTickets.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "COMPAGNIA_AEREA")
public class CompagniaAereaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompagnia;

    private String nomeCompagnia;

    private String sede;

	public Long getIdCompagnia() {
		return idCompagnia;
	}

	public void setIdCompagnia(Long idCompagnia) {
		this.idCompagnia = idCompagnia;
	}

	public String getNomeCompagnia() {
		return nomeCompagnia;
	}

	public void setNomeCompagnia(String nomeCompagnia) {
		this.nomeCompagnia = nomeCompagnia;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

    

}
