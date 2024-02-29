package com.example.flightTickets.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.flightTickets.entities.UtenteEntity;
import com.example.flightTickets.services.UtenteService;

@RestController
@CrossOrigin("http://localhost:4200")
public class UtenteController {
        
    @Autowired
    UtenteService service;
    
    @GetMapping("/utenti")
    public List<UtenteEntity> getAllUtenti(){
        return service.getAllUtenti();
    }
    
    @GetMapping("/utente/{id}")
    public Optional<UtenteEntity> getUtenteById(@PathVariable("id") Long id){
        return service.getUtenteById(id);
    }
    
    @PostMapping("/utente/insert")
    public void insertUtente(@RequestBody UtenteEntity utente){
        service.insertUtente(utente);
    }
    
    @PutMapping("/utente/update/{id}")
    public void updateUtente(@PathVariable("id") Long id, @RequestBody UtenteEntity utente){
        utente.setIdCliente(id);
        service.updateUtente(utente);
    }
    
    @DeleteMapping("/utente/delete/{id}")
    public void deleteUtenteById(@PathVariable("id") Long id) {
        service.deleteUtenteById(id);
    }
    @PostMapping("/utente/login")
    public boolean loginUtente(@RequestBody UtenteEntity utente) {
        return service.loginUtente(utente.getEmail(), utente.getPassword());
    }

}
