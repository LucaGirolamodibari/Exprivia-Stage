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
import com.example.flightTickets.entities.VoloEntity;
import com.example.flightTickets.services.VoloService;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class VoloController {
    
    Logger logger = Logger.getLogger(VoloController.class.getName());
    
    @Autowired
    VoloService service;
    
    @GetMapping("/voli")
    public List<VoloEntity> getAllVolos(){
        return service.getAllVolos();
    }
    
    @GetMapping("/volo/{id}")
    public Optional<VoloEntity> getVoloById(@PathVariable("id") String id){
        return service.getVoloById(id);
    }
    
    @Transactional
    @PostMapping("/volo/insert")
    public void insertVolo(@RequestBody VoloEntity volo){
    	System.out.println(volo);
        service.updateVoloById(volo);
    }
    
    @Transactional
    @PutMapping("/volo/update/{id}")
    public void updateVoloById(@PathVariable("id") String id, @RequestBody VoloEntity volo){
    	System.out.println(volo);
        service.updateVoloById(volo);
    }
   
    
    @Transactional
    @DeleteMapping("/volo/delete/{id}")
    public void deleteVoloById(@PathVariable("id") String id) {
        service.deleteVoloById(id);
    }
}
