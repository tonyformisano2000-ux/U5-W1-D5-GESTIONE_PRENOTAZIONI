package com.example.U5_W1_D5_GESTIONE_PRENOTAZIONI.entities;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
@Entity
@Table(name = "utenti")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "prenotazioni")
public class Utente {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, unique = true)
        private String username;

        @Column(name = "nome_completo", nullable = false)
        private String nomeCompleto;

        @Column(nullable = false, unique = true)
        private String email;

        @OneToMany(mappedBy = "utente")
        private List<Prenotazione> prenotazioni;
}
