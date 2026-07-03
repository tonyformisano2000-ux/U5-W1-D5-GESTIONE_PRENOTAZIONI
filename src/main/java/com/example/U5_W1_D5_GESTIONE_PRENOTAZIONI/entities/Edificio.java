package com.example.U5_W1_D5_GESTIONE_PRENOTAZIONI.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "edificio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "postazioni")
public class Edificio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false)
    private String indirizzo;

    @Column(nullable = false)
    private String citta;

    @Column(nullable = false)
    private String provincia;

    @Column(nullable = false)
    private String regione;

    @OneToMany(mappedBy = "edificio")
    private List<Postazione> postazioni;
}