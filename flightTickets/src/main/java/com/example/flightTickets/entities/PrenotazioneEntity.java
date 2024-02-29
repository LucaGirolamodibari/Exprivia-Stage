package com.example.flightTickets.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "PRENOTAZIONE")
public class PrenotazioneEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPrenotazione;

	private String idVolo;

	private Long idCliente;

	private Date dataPrenotazione;

	private Date dataViaggio;

	private Integer costoFatturato;

	private String nomeGiorno;

	public Long getIdPrenotazione() {
		return idPrenotazione;
	}

	public void setIdPrenotazione(Long id) {
		this.idPrenotazione = id;
	}

	public String getIdVolo() {
		return idVolo;
	}

	public void setIdVolo(String idVolo) {
		this.idVolo = idVolo;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Date getDataPrenotazione() {
		return dataPrenotazione;
	}

	public void setDataPrenotazione(Date dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}

	public Date getDataViaggio() {
		return dataViaggio;
	}

	public void setDataViaggio(Date dataViaggio) {
		this.dataViaggio = dataViaggio;
	}

	public Integer getCostoFatturato() {
		return costoFatturato;
	}

	public void setCostoFatturato(Integer costoFatturato) {
		this.costoFatturato = costoFatturato;
	}

	public String getNomeGiorno() {
		return nomeGiorno;
	}

	public void setNomeGiorno(String nomeGiorno) {
		this.nomeGiorno = nomeGiorno;
	}

	

}
