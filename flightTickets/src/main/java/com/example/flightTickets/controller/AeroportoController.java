package com.example.flightTickets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.flightTickets.entities.AeroportoEntity;
import com.example.flightTickets.services.AeroportoService;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200/")
@RestController
public class AeroportoController {

    @Autowired
    AeroportoService service;

    @GetMapping("/aeroporti")
    public List<AeroportoEntity> getAllAeroporti() {
        return service.getAllAeroporti();
    }

    @GetMapping("/aeroporto/{id}")
    public Optional<AeroportoEntity> getAeroportoById(@PathVariable("id") Long id) {
        return service.getAeroportoById(id);
    }

    @Transactional
    @PostMapping("/aeroporto/insert")
    public void insertAeroporto(@RequestBody AeroportoEntity aeroporto) {
        service.updateAeroportoById(aeroporto);
    }
    
    @PutMapping("/aeroporto/update/{id}")
    public void updateAeroportoById(@PathVariable("id") Long id, @RequestBody AeroportoEntity aeroporto){
        aeroporto.setIdAeroporto(id);
        service.updateAeroportoById(aeroporto);
    }


    @Transactional
    @DeleteMapping("/aeroporto/delete/{id}")
    public void deleteAeroportoById(@PathVariable("id") Long id) {
        service.deleteAeroportoById(id);
    }
}
