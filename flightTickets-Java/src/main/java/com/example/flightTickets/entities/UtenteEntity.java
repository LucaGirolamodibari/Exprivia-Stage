package com.example.flightTickets.entities;

import org.mindrot.jbcrypt.BCrypt;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "utente")
public class UtenteEntity {

    @Id
    private Long id_cliente;

    private String email;

    private String password;

    @JsonIgnore
    public Long getIdCliente() {
        return id_cliente;
    }

    public void setIdCliente(Long idCliente) {
        this.id_cliente = idCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        // Cripta la password prima di impostarla
        this.password = encryptPassword(password);
    }

    // Metodo per criptare la password utilizzando BCrypt
    private String encryptPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
