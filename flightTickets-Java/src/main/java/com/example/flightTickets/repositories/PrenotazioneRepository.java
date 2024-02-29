package com.example.flightTickets.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.flightTickets.entities.PrenotazioneEntity;

@Repository
public interface PrenotazioneRepository extends JpaRepository<PrenotazioneEntity, Long> {
        
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO prenotazione (id_prenotazione, id_volo, id_cliente, data_prenotazione, data_viaggio, costo_fatturato, nome_giorno) " +
            "VALUES (:idPrenotazione, :idVolo, :idCliente, :dataPrenotazione, :dataViaggio, :costoFatturato, :nomeGiorno)")
    void insertPrenotazione(
            @Param("idPrenotazione") Long idPrenotazione,
            @Param("idVolo") String idVolo,
            @Param("idCliente") Long idCliente,
            @Param("dataPrenotazione") Date dataPrenotazione,
            @Param("dataViaggio") Date dataViaggio,
            @Param("costoFatturato") Integer costoFatturato,
            @Param("nomeGiorno") String nomeGiorno
    );
}
