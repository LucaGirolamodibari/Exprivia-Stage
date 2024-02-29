package com.example.flightTickets.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class ClienteEntity {


	    @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq")
	    @SequenceGenerator(name = "cliente_seq", sequenceName = "CLIENTE_SEQ", allocationSize = 1)
	    
	    @JsonIgnore
	    private Long idCliente;

	    private String nome;

	    private String indirizzo;

	    private String numTelefono;

	    private Integer eta;

	    
	    public Long getIdCliente() {
	        return idCliente;
	    }

	    public void setIdCliente(Long idCliente) {
	        this.idCliente = idCliente;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    public String getIndirizzo() {
	        return indirizzo;
	    }

	    public void setIndirizzo(String indirizzo) {
	        this.indirizzo = indirizzo;
	    }

	    public String getNumTelefono() {
	        return numTelefono;
	    }

	    public void setNumTelefono(String numTelefono) {
	        this.numTelefono = numTelefono;
	    }

	    public Integer getEtà() {
	        return eta;
	    }

	    public void setEtà(Integer eta) {
	        this.eta = eta;
	    }
	}

