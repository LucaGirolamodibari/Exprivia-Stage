package com.example.flightTickets.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flightTickets.entities.AereoEntity;
import com.example.flightTickets.repositories.AereoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AereoService {
                
    @Autowired
    AereoRepository repo;
        
    public List<AereoEntity> getAllAerei(){
        return repo.findAll();
    }
        
    public Optional<AereoEntity> getAereoById(Long id){
        return repo.findById(id);
    }
        
    public void updateAereoById(AereoEntity aereo){
        Long idAereo = aereo.getIdAereo();
        Long idCompagnia = aereo.getCompagniaAerea().getIdCompagnia(); 
        String modello = aereo.getModello();
        boolean stato = aereo.isStato();
        Integer postiTotali = aereo.getPostiTotali();
        Integer capienzaMerci = aereo.getCapienzaMerci();
        String note = aereo.getNote();
        repo.insertAereo(idAereo, idCompagnia, modello, stato, postiTotali, capienzaMerci, note);
    }
        
    public void deleteAereoById(Long id) {
        repo.deleteById(id);
    }
}
