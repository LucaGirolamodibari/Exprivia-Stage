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
import org.springframework.web.bind.annotation.RestController;

import com.example.flightTickets.entities.CompagniaAereaEntity;
import com.example.flightTickets.services.CompagniaAereaService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.transaction.Transactional;

@CrossOrigin("http://localhost:4200/")
@RestController
public class CompagniaAereaController {
        
        @Autowired
        CompagniaAereaService service;
        
        @GetMapping("/compagnie")
        public List<CompagniaAereaEntity> getAllCompagnie(){
                return service.getAllCompagnie();
        }
        
        @GetMapping("/compagnia/{id}")
        public Optional<CompagniaAereaEntity> getCompagniaById(@PathVariable("id") Long id){
                return service.getCompagniaById(id);
        }
        
        
        @Transactional
        @PostMapping("/compagnia/insert")
        public void updateCompagniaById(@RequestBody CompagniaAereaEntity compagniaAerea){
                service.updateCompagniaById(compagniaAerea);
        }
        
        @PutMapping("/compagnia/update/{id}")
        public void updateCompagniaAereaById(@PathVariable("id") Long id, @RequestBody CompagniaAereaEntity compagniaAerea){
        	compagniaAerea.setIdCompagnia(id);
            service.updateCompagniaById(compagniaAerea);
        }
        
        @Transactional
        @DeleteMapping("/compagnia/delete/{id}")
        public void deleteCompagniaById(@PathVariable("id") Long id) {
                service.deleteCompagniaById(id);
        }

}