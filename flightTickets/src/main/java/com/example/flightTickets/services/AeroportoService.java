package com.example.flightTickets.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flightTickets.entities.AeroportoEntity;
import com.example.flightTickets.repositories.AeroportoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AeroportoService {

    @Autowired
    AeroportoRepository repo;

    Optional<AeroportoEntity> entity = Optional.ofNullable(new AeroportoEntity());

    public List<AeroportoEntity> getAllAeroporti() {
        return repo.findAll();
    }

    public Optional<AeroportoEntity> getAeroportoById(Long id) {
        entity = repo.findById(id);
        System.out.println(entity);
        return entity;
    }

    public void updateAeroportoById(AeroportoEntity aeroporto) {
        Long idAeroporto = aeroporto.getIdAeroporto();
        String nomeAeroporto = aeroporto.getNomeAeroporto();
        String città = aeroporto.getCittà();
        String nazione = aeroporto.getNazione();
        Integer numeroPiste = aeroporto.getNumeroPiste();
        repo.insertAeroporto(idAeroporto, nomeAeroporto, città, nazione, numeroPiste);
    }

    public void deleteAeroportoById(Long id) {
        repo.deleteById(id);
    }
}
