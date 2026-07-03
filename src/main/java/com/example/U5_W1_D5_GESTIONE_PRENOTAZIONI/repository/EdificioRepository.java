package com.example.U5_W1_D5_GESTIONE_PRENOTAZIONI.repository;

import com.example.U5_W1_D5_GESTIONE_PRENOTAZIONI.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long> {

    Optional<Edificio> findByNome(String nome);

    List<Edificio> findByCitta(String citta);

    List<Edificio> findByRegione(String regione);
    List<Edificio> findByProvincia(String provincia);
    List<Edificio> findByRegioneAndProvincia(String regione, String provincia);
}
