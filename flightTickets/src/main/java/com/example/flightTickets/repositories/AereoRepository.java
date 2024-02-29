package com.example.flightTickets.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.flightTickets.entities.AereoEntity;

@Repository
public interface AereoRepository extends JpaRepository<AereoEntity, Long> {
        
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO aereo (id_aereo, id_compagnia, modello, stato, posti_totali, capienza_merci, note) " +
            "VALUES (:idAereo, :idCompagnia, :modello, :stato, :postiTotali, :capienzaMerci, :note)")
    void insertAereo(
            @Param("idAereo") Long idAereo,
            @Param("idCompagnia") Long idCompagnia,
            @Param("modello") String modello,
            @Param("stato") boolean stato,
            @Param("postiTotali") Integer postiTotali,
            @Param("capienzaMerci") Integer capienzaMerci,
            @Param("note") String note
    );
}
