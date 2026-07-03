package com.example.U5_W1_D5_GESTIONE_PRENOTAZIONI.repository;

import com.example.U5_W1_D5_GESTIONE_PRENOTAZIONI.entities.Edificio;
import com.example.U5_W1_D5_GESTIONE_PRENOTAZIONI.entities.Postazione;
import com.example.U5_W1_D5_GESTIONE_PRENOTAZIONI.entities.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

    List<Postazione> findByTipoAndEdificio_Nome(TipoPostazione tipo, String nome);
    List<Postazione> findByEdificio(Edificio edificio);
    List<Postazione> findByEdificio_Citta(String citta);
    List<Postazione> findByTipo(TipoPostazione tipo);
    List<Postazione> findByTipoAndEdificio_Regione(TipoPostazione tipo, String regione);
    List<Postazione> findByTipoAndEdificio_Provincia(TipoPostazione tipo, String provincia);
    List<Postazione> findByTipoAndEdificio_Citta(TipoPostazione tipo, String citta);
    List<Postazione> findByEdificio_Provincia(String provincia);
    List<Postazione> findByEdificio_Regione(String regione);
}