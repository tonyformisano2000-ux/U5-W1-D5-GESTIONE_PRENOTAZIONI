package com.example.U5_W1_D5_GESTIONE_PRENOTAZIONI.repository;

import com.example.U5_W1_D5_GESTIONE_PRENOTAZIONI.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {

    boolean existsByEmail(String email);

    Optional<Utente> findByUsername(String username);
    boolean existsByUsername(String username);

    Optional<Utente> findByEmail(String email);
}