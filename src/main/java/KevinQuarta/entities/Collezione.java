package KevinQuarta.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collezione {
    List<Giochi> listaGiochi;

    public Collezione() {
        listaGiochi = new ArrayList<>();
    }

//    Controllo aggiungendo un gioco non abbia lo stesso ID

    public void aggiungiGioco(Giochi giocoAgg) {
        boolean giocoEsistente = listaGiochi.stream()
                .anyMatch(giocoGiaPresente -> giocoGiaPresente.getId() == giocoAgg.getId());
        if (giocoEsistente == true) {
            System.out.println("L'id è già presente nella lista di giochi");
        } else {
            listaGiochi.add(giocoAgg);
            System.out.println("Gioco aggiunto con successo!!");
        }
    }

//    Ricerca per id
    public Giochi riceraGiocoId (int id) {
        return listaGiochi.stream().filter(gioco -> gioco.getId() == id).findFirst().orElse(null);
    }

//    Ricerca per prezzo

    public List<Giochi> ricercaGiocoPrezzo (double prezzo) {
       return listaGiochi.stream().filter(giochi-> giochi.getPrezzo() < prezzo).collect(Collectors.toList());
    }

//    Ricerca per numero giocatori
    public List<Giochi> ricercaGiocoNumGiocatori (int numG) {
        return listaGiochi.stream().filter(giochi -> giochi instanceof GiochiTavolo)
                .map(giochi->((GiochiTavolo) giochi))
                .filter(giochiT->giochiT.getNumGiocatori()==numG)
                .collect(Collectors.toList());
    }

//    Rimuovi elemento tramite parametro Id
    public boolean rimuoviGiocoId (int id) {
        boolean giocoRimosso = listaGiochi.removeIf(gioco -> gioco.getId() == id);
        if (giocoRimosso == true) {
            System.out.println("Gioco rimosso correttamente dalla lista!");
        } else {
            System.out.println("Gioco non trovato..prova un altro id");
        }
        return giocoRimosso;
    }

//    Modifica gioco esistente,ricerca tramite id

    public boolean modificaGiocoId (int id) {
        
    }

}
