package com.example.flightTickets.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flightTickets.entities.VoloEntity;
import com.example.flightTickets.repositories.VoloRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VoloService {
                
    @Autowired
    VoloRepository repo;
        
    public List<VoloEntity> getAllVolos(){
        return repo.findAll();
    }
        
    public Optional<VoloEntity> getVoloById(String id){
        return repo.findById(id);
    }
        
    public void updateVoloById(VoloEntity volo){
        String idVolo = volo.getIdVolo();
        Long idAeroportoOrigine = volo.getIdAeroportoOrigine();
        Long idAeroportoDestinazione = volo.getIdAeroportoDestinazione();
        Long idAeroportoScalo = volo.getIdAeroportoScalo();
        Long idAereo = volo.getIdAereo();
        Integer postiPrenotati = volo.getPostiPrenotati();
        Integer postiDisponibili = volo.getPostiDisponibili();
        Integer costoBase = volo.getCostoBase();
        repo.insertVolo(idVolo, idAeroportoOrigine, idAeroportoDestinazione, idAeroportoScalo, idAereo, postiPrenotati, postiDisponibili, costoBase);
    }
        
    public void deleteVoloById(String id) {
        repo.deleteById(id);
    }
}
