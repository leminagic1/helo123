package ba.unsa.etf.rpr;

import java.util.ArrayList;

public class Artikal {
    private String sifra;
    private String naziv;
    private double cijena;


    public Artikal() {
    }
    public Artikal(String podatak){
        String[] artikal = podatak.split(",");
        sifra = artikal[0];
        naziv = artikal[1];
        cijena = Double.parseDouble(artikal[2]);
    }
    public void setSifra(String sifra) {
        this.sifra = sifra;
    }


    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    public String getSifra() {
        return sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public double getCijena() {
        return cijena;
    }


    public Artikal(String sifra, String naziv, double cijena) {

        if(sifra == "")
            throw new IllegalArgumentException("Sifra je prazna");
        if (naziv == "")
            throw new IllegalArgumentException("Naziv je prazan");
        if(cijena <=0 )
            throw new IllegalArgumentException("Cijena je negativna");

    }

    @Override
    public String toString(){
        String sifra=this.sifra+","+naziv+","+cijena;
        return sifra;
    }



    public static ArrayList<Artikal> izbaciDuplikate(ArrayList<Artikal> artikli){
        for (int i = 0; i < artikli.size(); i++) {
            for (int j = i+1; j < artikli.size();j++) {
                if(artikli.get(i).equals(artikli.get(j)))artikli.remove(j);
            }
        }
        return artikli;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Artikal)) return false;

        Artikal artikal = (Artikal) o;

        if (Double.compare(artikal.getCijena(), getCijena()) != 0) return false;
        if (getSifra() != null ? !getSifra().equals(artikal.getSifra()) : artikal.getSifra() != null) return false;
        return getNaziv() != null ? getNaziv().equals(artikal.getNaziv()) : artikal.getNaziv() == null;
    }


}

