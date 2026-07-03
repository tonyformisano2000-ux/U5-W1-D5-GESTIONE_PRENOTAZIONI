package com.example.U5_W1_D5_GESTIONE_PRENOTAZIONI.service;
import lombok.RequiredArgsConstructor;
import com.example.U5_W1_D5_GESTIONE_PRENOTAZIONI.entities.Edificio;
import com.example.U5_W1_D5_GESTIONE_PRENOTAZIONI.entities.Postazione;
import com.example.U5_W1_D5_GESTIONE_PRENOTAZIONI.entities.TipoPostazione;
import com.example.U5_W1_D5_GESTIONE_PRENOTAZIONI.repository.PostazioneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostazioneService {

    private final PostazioneRepository postazioneRepository;

    public Postazione salvaPostazione(Postazione postazione) {
        return postazioneRepository.save(postazione);
    }

    public List<Postazione> findAll() {
        return postazioneRepository.findAll();
    }

    public List<Postazione> findByTipo(TipoPostazione tipo) {
        return postazioneRepository.findByTipo(tipo);
    }

    public List<Postazione> findByEdficio(Edificio edificio) {
        return postazioneRepository.findByEdificio(edificio);
    }

    public List<Postazione> findByRegione(String regione) {
        return postazioneRepository.findByEdificio_Regione(regione);
    }

    public List<Postazione> findByProvincia(String provincia) {
        return postazioneRepository.findByEdificio_Provincia(provincia);
    }

    public List<Postazione> findByCitta(String citta) {
        return postazioneRepository.findByEdificio_Citta(citta);
    }


}