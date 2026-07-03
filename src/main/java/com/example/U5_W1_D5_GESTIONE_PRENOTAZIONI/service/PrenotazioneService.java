package com.example.U5_W1_D5_GESTIONE_PRENOTAZIONI.service;
import lombok.RequiredArgsConstructor;
import com.example.U5_W1_D5_GESTIONE_PRENOTAZIONI.entities.Postazione;
import com.example.U5_W1_D5_GESTIONE_PRENOTAZIONI.entities.Prenotazione;
import com.example.U5_W1_D5_GESTIONE_PRENOTAZIONI.entities.Utente;
import com.example.U5_W1_D5_GESTIONE_PRENOTAZIONI.repository.PrenotazioneRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
@Service
@RequiredArgsConstructor
public class PrenotazioneService {

    private final PrenotazioneRepository prenotazioneRepository;

    public Prenotazione creaPrenotazione(Utente utente, Postazione postazione, LocalDate dataPrenotazione) {
        if (prenotazioneRepository.existsByUtenteAndDataPrenotazione(utente, dataPrenotazione)) {
            throw new RuntimeException("L'utente ha già una prenotazione per questa data.");
        }

        if (prenotazioneRepository.existsByPostazioneAndDataPrenotazione(postazione, dataPrenotazione)) {
            throw new RuntimeException("La postazione è già prenotata per questa data.");
        }

        Prenotazione prenotazione = Prenotazione.builder()
                .utente(utente)
                .postazione(postazione)
                .dataPrenotazione(dataPrenotazione)
                .build();

        return prenotazioneRepository.save(prenotazione);
    }
}