package KevinQuarta.entities;

public class Videogiochi extends Giochi{
    private String piattaforma;
    private int durata;
    private Genere genere;

    public Videogiochi (int id,String titolo,int annoPubblicazione,double prezzo,String piattaforma, int durata, Genere genere) {
        super(id,titolo,annoPubblicazione,prezzo);
        this.piattaforma = piattaforma;
        this.durata = durata;
        this.genere = genere;
    }

    public String getPiattaforma() {
        return piattaforma;
    }

    public void setPiattaforma(String piattaforma) {
        this.piattaforma = piattaforma;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Videogiochi{" +
                "id= " + getId() +
                ", titolo= " + getTitolo() +
                ", annoPubblicazione= " + getAnnoPubblicazione() +
                ", prezzo= " + getPrezzo() +
                ", piattaforma='" + piattaforma + '\'' +
                ", durata=" + durata +
                ", genere=" + genere +
                '}';
    }
}
