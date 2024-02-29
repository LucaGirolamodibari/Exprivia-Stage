package com.example.flightTickets.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.flightTickets.entities.UtenteEntity;

@Repository
public interface UtenteRepository extends JpaRepository<UtenteEntity, Long> {
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO utente (id_cliente, email, password) " +
            "VALUES (:idCliente, :email, :password)")
    void insertUtente(
            @Param("idCliente") Long idCliente,
            @Param("email") String email,
            @Param("password") String password
    );

	Optional<UtenteEntity> findByEmailAndPassword(String email, String password);
}
