package com.example.flightTickets.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.flightTickets.entities.ClienteEntity;
import com.example.flightTickets.entities.UtenteEntity;
import com.example.flightTickets.repositories.UtenteRepository;

@Service
public class UtenteService {
        
    @Autowired
    UtenteRepository repo;

    @Autowired
    ClienteService clienteService;
    
    public List<UtenteEntity> getAllUtenti(){
        return repo.findAll();
    }
    
    public Optional<UtenteEntity> getUtenteById(Long id){
        return repo.findById(id);
    }
    
    public void insertUtente(UtenteEntity utente) {
        repo.save(utente);
    }
    
    public void updateUtente(UtenteEntity utente) {
        repo.save(utente);
    }
    
    public void deleteUtenteById(Long id) {
        repo.deleteById(id);
    }

    @Transactional
    public void registerUserAndClient(UtenteEntity utente, ClienteEntity cliente) {
        UtenteEntity savedUtente = repo.save(utente);
        cliente.setIdCliente(savedUtente.getIdCliente()); 
        clienteService.insertCliente(cliente); 
    }

    public boolean loginUtente(String email, String password) {
        Optional<UtenteEntity> utente = repo.findByEmailAndPassword(email, password);
        return utente.isPresent();
    }
}
