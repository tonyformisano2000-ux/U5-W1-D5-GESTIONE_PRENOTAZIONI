package com.example.U5_W1_D5_GESTIONE_PRENOTAZIONI.repository;
import com.example.U5_W1_D5_GESTIONE_PRENOTAZIONI.entities.Postazione;
import com.example.U5_W1_D5_GESTIONE_PRENOTAZIONI.entities.Prenotazione;
import com.example.U5_W1_D5_GESTIONE_PRENOTAZIONI.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrenotazioneRepository
        extends JpaRepository<Prenotazione, Long> {

    boolean existsByUtenteAndDataPrenotazione(
            Utente utente,
            LocalDate dataPrenotazione
    );

    boolean existsByPostazioneAndDataPrenotazione(
            Postazione postazione,
            LocalDate dataPrenotazione
    );

    List<Prenotazione> findByUtente(Utente utente);
    List<Prenotazione> findByDataPrenotazione(LocalDate dataPrenotazione);

}
