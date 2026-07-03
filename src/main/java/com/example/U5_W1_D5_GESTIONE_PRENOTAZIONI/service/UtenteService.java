package com.example.U5_W1_D5_GESTIONE_PRENOTAZIONI.service;

import lombok.RequiredArgsConstructor;
import com.example.U5_W1_D5_GESTIONE_PRENOTAZIONI.entities.Utente;
import com.example.U5_W1_D5_GESTIONE_PRENOTAZIONI.repository.UtenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UtenteService {

    private final UtenteRepository utenteRepository;

    public Utente registraUtente(Utente utente) {
        if (utenteRepository.existsByUsername(utente.getUsername())) {
            throw new RuntimeException("Username già esistente: " + utente.getUsername());
        }

        if (utenteRepository.existsByEmail(utente.getEmail())) {
            throw new RuntimeException("Email già esistente: " + utente.getEmail());
        }

        return utenteRepository.save(utente);
    }

    public List<Utente> findAll() {
        return utenteRepository.findAll();
    }
}