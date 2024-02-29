package com.example.flightTickets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.flightTickets.entities.AereoEntity;
import com.example.flightTickets.services.AereoService;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AereoController {
    
    Logger logger = Logger.getLogger(AereoController.class.getName());
    
    @Autowired
    AereoService service;
    
    @GetMapping("/aerei")
    public List<AereoEntity> getAllAerei(){
        return service.getAllAerei();
    }
    
    @GetMapping("/aereo/{id}")
    public Optional<AereoEntity> getAereoById(@PathVariable("id") Long id){
        return service.getAereoById(id);
    }
    
    @Transactional
    @PostMapping("/aereo/insert")
    public void insertAereo(@RequestBody AereoEntity aereo){
    	System.out.println(aereo);
        service.updateAereoById(aereo);
    }
    
    @Transactional
    @PutMapping("/aereo/update/{id}")
    public void updateAereoById(@PathVariable("id") Long id, @RequestBody AereoEntity aereo){
        aereo.setIdAereo(id);
        System.out.println(aereo);
        service.updateAereoById(aereo);
    }
    
    @Transactional
    @DeleteMapping("/aereo/delete/{id}")
    public void deleteAereoById(@PathVariable("id") Long id) {
        service.deleteAereoById(id);
    }
}
