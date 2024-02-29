package com.example.flightTickets.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flightTickets.entities.PrenotazioneEntity;
import com.example.flightTickets.repositories.PrenotazioneRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PrenotazioneService {
                
    @Autowired
    PrenotazioneRepository repo;
        
    public List<PrenotazioneEntity> getAllPrenotazioni(){
        return repo.findAll();
    }
        
    public Optional<PrenotazioneEntity> getPrenotazioneById(Long id){
        return repo.findById(id);
    }
        
    public void updatePrenotazioneById(PrenotazioneEntity prenotazione){
        Long idPrenotazione = prenotazione.getIdPrenotazione();
        String idVolo = prenotazione.getIdVolo();
        Long idCliente = prenotazione.getIdCliente();
        Date dataPrenotazione = prenotazione.getDataPrenotazione();
        Date dataViaggio = prenotazione.getDataViaggio();
        Integer costoFatturato = prenotazione.getCostoFatturato();
        String nomeGiorno = prenotazione.getNomeGiorno();
        repo.insertPrenotazione(idPrenotazione, idVolo, idCliente, dataPrenotazione, dataViaggio, costoFatturato, nomeGiorno);
    }
        
    public void deletePrenotazioneById(Long id) {
        repo.deleteById(id);
    }
}

