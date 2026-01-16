package KevinQuarta.entities;

public class GiochiTavolo extends Giochi{
    private int numGiocatori;
    private int durataPartita;

    public GiochiTavolo(int id,String titolo,int annoPubblicazione,double prezzo,int numGiocatori, int durataPartita) {
        super(id,titolo,annoPubblicazione,prezzo);
        this.numGiocatori =numGiocatori;
        this.durataPartita = durataPartita;
    }

    public int getNumGiocatori() {
        return numGiocatori;
    }

    public void setNumGiocatori(int numGiocatori) {
        this.numGiocatori = numGiocatori;
    }

    public int getDurataPartita() {
        return durataPartita;
    }

    public void setDurataPartita(int durataPartita) {
        this.durataPartita = durataPartita;
    }

    @Override
    public String toString() {
        return "GiochiTavolo{" +
                "numGiocatori=" + numGiocatori +
                ", durataPartita=" + durataPartita +
                '}';
    }
}
