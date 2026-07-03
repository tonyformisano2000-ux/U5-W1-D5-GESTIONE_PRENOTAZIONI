package com.example.U5_W1_D5_GESTIONE_PRENOTAZIONI.service;
import lombok.RequiredArgsConstructor;
import com.example.U5_W1_D5_GESTIONE_PRENOTAZIONI.entities.Edificio;
import com.example.U5_W1_D5_GESTIONE_PRENOTAZIONI.repository.EdificioRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EdificioService {
    private final EdificioRepository edificioRepository;
    public Edificio salvaEdificio(Edificio edificio){
        return edificioRepository.save(edificio);
    }
    public List<Edificio> findAll() {
        return edificioRepository.findAll();
    }
    public List<Edificio> findByRegione(String regione) {
        return edificioRepository.findByRegione(regione);
    }
    public List<Edificio> findByProvincia(String provincia) {
        return edificioRepository.findByProvincia(provincia);
    }
    public List<Edificio> findByCitta(String citta) {
        return edificioRepository.findByCitta(citta);
    }
    public Edificio findByName(String nome) {
        return edificioRepository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("Edificio non trovato: " + nome));
    }
}
