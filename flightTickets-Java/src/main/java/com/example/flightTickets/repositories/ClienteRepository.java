package com.example.flightTickets.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.flightTickets.entities.ClienteEntity;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO cliente(id_cliente, nome, indirizzo, num_telefono, eta) " +
            "VALUES (:idCliente, :nome, :indirizzo, :numTelefono, :eta)")
    void insertCliente(
    	    @Param("idCliente") Long idCliente,
    	    @Param("nome") String nome,
    	    @Param("indirizzo") String indirizzo,
    	    @Param("numTelefono") String numTelefono,
    	    @Param("eta") Integer eta
    	);

}

