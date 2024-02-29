package com.example.flightTickets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.flightTickets.entities.ClienteEntity;
import com.example.flightTickets.entities.UtenteEntity;
import com.example.flightTickets.services.ClienteService;
import com.example.flightTickets.services.UtenteService;

@RestController
@CrossOrigin("http://localhost:4200")
public class RegistrationController {
        
    @Autowired
    UtenteService utenteService;
    
    @Autowired
    ClienteService clienteService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUserAndClient(@RequestBody RegistrationRequest request) {
        try {
            ClienteEntity cliente = request.getCliente();
            cliente.setIdCliente(null);
            clienteService.insertCliente(cliente);
            
            UtenteEntity utente = request.getUtente();
            utente.setIdCliente(cliente.getIdCliente());
            utenteService.insertUtente(utente);

            return ResponseEntity.ok("Registrazione completata con successo");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore durante la registrazione: " + e.getMessage());
        }
    }
}


class RegistrationRequest {
    private UtenteEntity utente;
    private ClienteEntity cliente;
    
	public ClienteEntity getCliente() {
		return cliente;
	}
	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}
	public UtenteEntity getUtente() {
		return utente;
	}
	public void setUtente(UtenteEntity utente) {
		this.utente = utente;
	}

    
}
