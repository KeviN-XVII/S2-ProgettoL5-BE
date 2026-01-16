package KevinQuarta.entities;

import java.util.*;
import java.util.stream.Collectors;

public class Collezione {
    private List<Giochi> listaGiochi;

    public Collezione() {
        listaGiochi = new ArrayList<>();

        listaGiochi.add(new Videogiochi(1,"Call of Duty",2022,55,"ps5",12,Genere.FPS));
        listaGiochi.add(new Videogiochi(2,"Fc26",2025,40,"ps5",29,Genere.SPORT));
        listaGiochi.add(new Videogiochi(3,"Nba2k25",2024,52,"ps5",32,Genere.SPORT));
        listaGiochi.add(new Videogiochi(4,"Minecraft",2011,22,"Pc",150,Genere.ADVENTURE));
        listaGiochi.add(new GiochiTavolo(5,"Monopoly",1935,30,8,2));
        listaGiochi.add(new GiochiTavolo(6,"Risiko",1957,25,6,4));
        listaGiochi.add(new GiochiTavolo(7,"Taboo",1989,20,10,1));
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
        return listaGiochi.stream().filter(gioco -> gioco.getId() == id)
                .findFirst()
                .orElse(null);
    }

//    Ricerca per prezzo

    public List<Giochi> ricercaGiocoPrezzo (double prezzo) {
       return listaGiochi.stream().filter(giochi-> giochi.getPrezzo() < prezzo)
               .collect(Collectors.toList());
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


//    Stampa statistiche richieste (numero totale videogiochi,numero totale giochi da tavolo,gioco con prezzo più alto,media dei prezzi)
    public void stampaStatsGiochi(){
//        Tot videogiochi
        int numTotVideoG = listaGiochi.stream()
                .filter(giochi -> giochi instanceof Videogiochi)
                .mapToInt(giochi -> 1).sum();
        System.out.println("Totale di videogiochi presenti è : "+numTotVideoG);
//        Tot giochi da tavolo
        int numTotGiochiT = listaGiochi.stream()
                .filter(giochi -> giochi instanceof GiochiTavolo)
                .mapToInt(giochi -> 1).sum();
        System.out.println("Totale di giochi da tavolo presenti è : "+numTotGiochiT);
//        Gioco più costoso
        List<Giochi> giocoPrezzoMax = listaGiochi.stream()
                .sorted(Comparator.comparing((Giochi g) -> g.getPrezzo()).reversed())
                .collect(Collectors.toList());
        if (!giocoPrezzoMax.isEmpty()) {
            Giochi giocoMax = giocoPrezzoMax.get(0);
            System.out.println("Il gioco con il prezzo più alto è: " + giocoMax.getTitolo() + " e costa: " + giocoMax.getPrezzo());
        } else {
            System.out.println("Lista giochi vuota");
        }

//      Media prezzi giochi
        DoubleSummaryStatistics stats = listaGiochi.stream().mapToDouble(giochi -> giochi.getPrezzo()).summaryStatistics();
        System.out.println("Media prezzi dei giochi : "+stats.getAverage());
        }

    }
