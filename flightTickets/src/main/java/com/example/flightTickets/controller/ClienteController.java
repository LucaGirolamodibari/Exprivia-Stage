package com.example.flightTickets.controller;

import java.util.List;
import java.util.Optional;

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

import com.example.flightTickets.entities.ClienteEntity;
import com.example.flightTickets.services.ClienteService;


@CrossOrigin("http://localhost:4200/")
@RestController
public class ClienteController {

    @Autowired
    ClienteService service;

    @GetMapping("/clienti")
    public List<ClienteEntity> getAllClienti() {
        return service.getAllClienti();
    }

    @GetMapping("/cliente/{id}")
    public Optional<ClienteEntity> getClienteById(@PathVariable("id") Long id) {
        return service.getClienteById(id);
    }

    @PostMapping("/cliente/insert")
    public void insertCliente(@RequestBody ClienteEntity cliente) {
        service.insertCliente(cliente);
    }

    @PutMapping("/cliente/update/{id}")
    public void updateClienteById(@PathVariable("id") Long id, @RequestBody ClienteEntity cliente) {
        cliente.setIdCliente(id);
        service.updateClienteById(cliente);
    }

    @Transactional
    @DeleteMapping("/cliente/delete/{id}")
    public void deleteClienteById(@PathVariable("id") Long id) {
        service.deleteClienteById(id);
    }
}
