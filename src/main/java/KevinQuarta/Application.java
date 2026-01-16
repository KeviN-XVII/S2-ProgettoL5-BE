package KevinQuarta;

import KevinQuarta.entities.*;

import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Collezione collezione = new Collezione();
        boolean esci = false;

        while (!esci) {
            System.out.println("--- MENU ---");
            System.out.println("Scegli l'opzione da utilizzare inserendo il numero");
            System.out.println("1. Aggiungi gioco nella lista ");
            System.out.println("2. Ricerca gioco inserendo l'ID");
            System.out.println("3. Ricerca giochi con prezzo inferiore");
            System.out.println("4. Ricerca giochi da tavolo inserendo numero di giocatori");
            System.out.println("5. Rimuovi gioco inserendo l'ID");
            System.out.println("6. Modifica un gioco già esistente");
            System.out.println("7. Stampa lista completa di giochi presenti");
            System.out.println("0. Interrompi");
            System.out.print("Digita il numero: ");
            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
//                1 aggiungi gioco
                case 1 -> {
                    System.out.print("ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Titolo: ");
                    String titolo = scanner.nextLine();
                    System.out.print("Anno pubblicazione: ");
                    int anno = Integer.parseInt(scanner.nextLine());
                    System.out.print("Prezzo: ");
                    double prezzo = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Seleziona il tipo di gioco 1=Videogioco 2=GiochiTavolo : ");
                    int tipo = Integer.parseInt(scanner.nextLine());
                    if (tipo == 1) {
                        System.out.print("Piattaforma: ");
                        String piattaforma = scanner.nextLine();
                        System.out.print("Durata: ");
                        int durata = Integer.parseInt(scanner.nextLine());
                        Genere genere = null;
                        boolean genereValido = false;
                        while (!genereValido) {
                            try {
                                System.out.print("Genere (ACTION,RPG,FPS,ADVENTURE,SPORT): ");
                                String genereString = scanner.nextLine();
                                genere = Genere.valueOf(genereString.toUpperCase());
                                genereValido = true;
                            } catch (Exception e) {
                                System.out.println("Genere non valido! Riprova.");
                            }
                        }
                        Videogiochi nuovoVideogioco = new Videogiochi(id, titolo, anno, prezzo, piattaforma, durata, genere);
                        collezione.aggiungiGioco(nuovoVideogioco);

                    } else if (tipo == 2) {
                        System.out.print("Numero giocatori: ");
                        int numG = Integer.parseInt(scanner.nextLine());
                        System.out.print("Durata partita: ");
                        int durataPartita = Integer.parseInt(scanner.nextLine());
                        GiochiTavolo nuovoGiocoT = new GiochiTavolo(id, titolo, anno, prezzo, numG, durataPartita);
                        collezione.aggiungiGioco(nuovoGiocoT);
                    }
                }
//                  ricerca con id
                case 2 -> {
                    System.out.print("Inserisci ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    Giochi gioco = collezione.riceraGiocoId(id);
                    if (gioco != null) {
                        System.out.println("questo è il gioco : "+gioco);
                    } else {
                    System.out.println("Gioco non trovato.");
                    }
                }
//                  ricerca con prezzo massimo
                case 3 -> {
                    System.out.print("inserisci prezzo massimo: ");
                    double prezzoMax = scanner.nextDouble();
                    scanner.nextLine();
                    List<Giochi> giochi = collezione.ricercaGiocoPrezzo(prezzoMax);
                    if (giochi.isEmpty()) {
                        System.out.println("Nessun gioco trovato con prezzo inferiore a " + prezzoMax);
                    } else {
                        giochi.forEach(game -> System.out.println(game));
                    }
                }
//                  ricerca in base al numero di giocatori
                case 4 -> {
                    System.out.print("Inserisci numero giocatori: ");
                    int numG =Integer.parseInt(scanner.nextLine());
                    List<Giochi> giochiT = collezione.ricercaGiocoNumGiocatori(numG);
                    if (giochiT.isEmpty()) {
                        System.out.println("Nessun gioco trovato per " + numG + " giocatori.");
                    } else {
                        giochiT.forEach(game -> System.out.println(game));
                    }
                }
//              rimuovere gioco tramite ID
                case 5 -> {
                    System.out.print("Inserisci ID per rimuovere/cancellare il gioco dalla listta: ");
                    int idRimuovi = Integer.parseInt(scanner.nextLine());
                    boolean rimosso = collezione.rimuoviGiocoId(idRimuovi);
                    if (!rimosso) {
                        System.out.println("Gioco non trovato.");
                    }
                }

                case 6 -> {


                }

                case 7 -> collezione.stampaStatsGiochi();

                case 0 -> esci = true;

                default -> System.out.println("Scelta non valida");
            }
        }
        scanner.close();
    }
}
