package com.example.flightTickets.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.flightTickets.entities.VoloEntity;

@Repository
public interface VoloRepository extends JpaRepository<VoloEntity, String> {
        
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO volo (id_volo, id_aeroporto_origine, id_aeroporto_destinazione, id_aeroporto_scalo, id_aereo, posti_prenotati, posti_disponibili, costo_base) " +
            "VALUES (:idVolo, :idAeroportoOrigine, :idAeroportoDestinazione, :idAeroportoScalo, :idAereo, :postiPrenotati, :postiDisponibili, :costoBase)")
    void insertVolo(
            @Param("idVolo") String idVolo,
            @Param("idAeroportoOrigine") Long idAeroportoOrigine,
            @Param("idAeroportoDestinazione") Long idAeroportoDestinazione,
            @Param("idAeroportoScalo") Long idAeroportoScalo,
            @Param("idAereo") Long idAereo,
            @Param("postiPrenotati") Integer postiPrenotati,
            @Param("postiDisponibili") Integer postiDisponibili,
            @Param("costoBase") Integer costoBase
    );
}
