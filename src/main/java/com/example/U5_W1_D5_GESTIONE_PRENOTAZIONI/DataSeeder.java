package com.example.U5_W1_D5_GESTIONE_PRENOTAZIONI;
import com.example.U5_W1_D5_GESTIONE_PRENOTAZIONI.entities.*;
import com.example.U5_W1_D5_GESTIONE_PRENOTAZIONI.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {
    private final PostazioneService postazioneService;
    private final UtenteService utenteService;
    private final EdificioService edificioService;
    private final PrenotazioneService prenotazioneService;

    @Override
    public void run(String... args) {
        // Edifici

        Edificio milano = new Edificio();
        milano.setNome("Sede Milano");
        milano.setIndirizzo("Via Roma, 1");
        milano.setCitta("Milano");
        milano.setProvincia("MI");
        milano.setRegione("Lombardia");
        milano = edificioService.salvaEdificio(milano);


        // Postazioni
        Postazione p1 = new Postazione();
        p1.setCodice("MI-001");
        p1.setDescrizione("Postazione open space vicino finestra");
        p1.setTipo(TipoPostazione.OPEN_SPACE);
        p1.setNumeroMassimoOccupanti(1);
        p1.setEdificio(milano);
        p1 = postazioneService.salvaPostazione(p1);
        Postazione p2 = new Postazione();
        p2.setCodice("MI-002");
        p2.setDescrizione("Ufficio privato piano 2");
        p2.setTipo(TipoPostazione.PRIVATO);
        p2.setNumeroMassimoOccupanti(1);
        p2.setEdificio(milano);
        p2 = postazioneService.salvaPostazione(p2);

        // Utenti
        Utente mario = new Utente();
        mario.setUsername("mrossi");
        mario.setNomeCompleto("Mario Rossi");
        mario.setEmail("mario.rossi@email.com");
        mario = utenteService.registraUtente(mario);

        Utente laura = new Utente();
        laura.setUsername("lbianchi");
        laura.setNomeCompleto("Laura Bianchi");
        laura.setEmail("laura.bianchi@email.com");
        laura = utenteService.registraUtente(laura);

        // Prenotazioni
        prenotazioneService.creaPrenotazione(mario, p1, LocalDate.now().plusDays(1));
        prenotazioneService.creaPrenotazione(laura, p2, LocalDate.now().plusDays(1));
        prenotazioneService.creaPrenotazione(mario, p1, LocalDate.now().plusDays(3));
    }
}