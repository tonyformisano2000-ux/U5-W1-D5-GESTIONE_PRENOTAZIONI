package com.example.U5_W1_D5_GESTIONE_PRENOTAZIONI.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "postazioni")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "edificio")
public class Postazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String codice;

    @Column(nullable = false)
    private String descrizione;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoPostazione tipo;

    @Column(name = "numero_massimo_occupanti", nullable = false)
    private int numeroMassimoOccupanti;

    @ManyToOne
    @JoinColumn(name = "edificio_id",nullable = false)
    private Edificio edificio;
}
