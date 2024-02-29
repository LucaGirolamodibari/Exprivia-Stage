package com.example.flightTickets.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "AEREO")
public class AereoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAereo;

    @ManyToOne
    @JoinColumn(name = "id_compagnia", nullable = false)
    private CompagniaAereaEntity compagniaAerea;

    private String modello;

    private boolean stato;

    private Integer postiTotali;

    private Integer capienzaMerci;

    private String note;


    public Long getIdAereo() {
        return idAereo;
    }

    public void setIdAereo(Long idAereo) {
        this.idAereo = idAereo;
    }

    public CompagniaAereaEntity getCompagniaAerea() {
        return compagniaAerea;
    }

    public void setCompagniaAerea(CompagniaAereaEntity compagniaAerea) {
        this.compagniaAerea = compagniaAerea;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public boolean isStato() {
        return stato;
    }

    public void setStato(boolean stato) {
        this.stato = stato;
    }

    public Integer getPostiTotali() {
        return postiTotali;
    }

    public void setPostiTotali(Integer postiTotali) {
        this.postiTotali = postiTotali;
    }

    public Integer getCapienzaMerci() {
        return capienzaMerci;
    }

    public void setCapienzaMerci(Integer capienzaMerci) {
        this.capienzaMerci = capienzaMerci;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}