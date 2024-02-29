package com.example.flightTickets.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flightTickets.entities.ClienteEntity;
import com.example.flightTickets.repositories.ClienteRepository;

@Service
public class ClienteService {
                
    @Autowired
    ClienteRepository repo;
        
    public List<ClienteEntity> getAllClienti() {      
        return repo.findAll();
    }
        
    public Optional<ClienteEntity> getClienteById(Long id) {
        return repo.findById(id);
    }
        
    public void insertCliente(ClienteEntity cliente) {
        repo.save(cliente);
    }
        
    public void updateClienteById(ClienteEntity cliente) {
        repo.save(cliente);
    }
        
    public void deleteClienteById(Long id) {
        repo.deleteById(id);
    }
}
