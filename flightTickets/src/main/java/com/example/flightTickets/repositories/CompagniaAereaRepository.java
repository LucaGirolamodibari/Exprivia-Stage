package com.example.flightTickets.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.flightTickets.entities.CompagniaAereaEntity;

@Repository
public interface CompagniaAereaRepository extends JpaRepository<CompagniaAereaEntity, Long> {
        
        @Modifying
        @Query(nativeQuery = true, value = "INSERT INTO compagniaAerea (id_compagnia, nome_compagnia, sede) " +
                "VALUES (:idCompagnia, :nomeCompagnia, :sede)")
        void insertCompagniaAerea(
                @Param("idCompagnia") Long idCompagnia,
                @Param("nomeCompagnia") String nomeCompagnia,
                @Param("sede") String sede
        );


}