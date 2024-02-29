package com.example.flightTickets.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.flightTickets.entities.CompagniaAereaEntity;
import com.example.flightTickets.repositories.CompagniaAereaRepository;

@Service
public class CompagniaAereaService {
                
        @Autowired
        CompagniaAereaRepository repo;
        
        Optional<CompagniaAereaEntity> entity = Optional.ofNullable(new CompagniaAereaEntity());
        
        public List<CompagniaAereaEntity> getAllCompagnie(){
                
                return repo.findAll();
        }
        
        public Optional<CompagniaAereaEntity> getCompagniaById(Long id){
                entity = repo.findById(id);
                System.out.println(entity);
                return entity;
        }
        
        public void updateCompagniaById(CompagniaAereaEntity compagniaAerea){
                Long idCompagnia = compagniaAerea.getIdCompagnia();
                String nomeCompagnia = compagniaAerea.getNomeCompagnia();
                String sede = compagniaAerea.getSede();
                repo.insertCompagniaAerea(idCompagnia, nomeCompagnia, sede);
        }
        
        public void deleteCompagniaById(@PathVariable("id") Long id) {
                repo.deleteById(id);
        }
        
}