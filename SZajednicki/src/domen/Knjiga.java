/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author milic
 */
public class Knjiga implements Serializable {

    private int sifraKnjige;
    private String naziv;
    private String opis;
    private List<Primerak> primerci;

    public Knjiga() {
    }

    public Knjiga(int sifraKnjige, String naziv, String opis, List<Primerak> primerci) {
        this.sifraKnjige = sifraKnjige;
        this.naziv = naziv;
        this.opis = opis;
        this.primerci = primerci;
    }

    public int getSifraKnjige() {
        return sifraKnjige;
    }

    public void setSifraKnjige(int sifraKnjige) {
        this.sifraKnjige = sifraKnjige;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public List<Primerak> getPrimerci() {
        return primerci;
    }

    public void setPrimerci(List<Primerak> primerci) {
        this.primerci = primerci;
    }

    @Override
    public String toString() {
        return "Knjiga{" + "naziv=" + naziv + '}';
    }

}
