package com.example.flightTickets.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.flightTickets.entities.AeroportoEntity;

@Repository
public interface AeroportoRepository extends JpaRepository<AeroportoEntity, Long> {
        
        @Modifying
        @Query(nativeQuery = true, value = "INSERT INTO aeroporto (id_aeroporto, nome_aeroporto, città, nazione, numero_piste ) " +
                "VALUES (:idAeroporto, :nomeAeroporto, :città, :nazione, :numeroPiste)")
        void insertAeroporto(
                @Param("idAeroporto") Long idAeroporto,
                @Param("nomeAeroporto") String nomeAeroporto,
                @Param("città") String città,
                @Param("nazione") String nazione,
                @Param("numeroPiste") Integer numeroPiste
        );


}