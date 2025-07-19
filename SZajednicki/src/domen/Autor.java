/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;

/**
 *
 * @author milic
 */
public class Autor implements Serializable {

    private int sifraAutora;
    private String ime;
    private String prezime;
    private String biografija;

    public Autor() {
    }

    public Autor(int sifraAutora, String ime, String prezime, String biografija) {
        this.sifraAutora = sifraAutora;
        this.ime = ime;
        this.prezime = prezime;
        this.biografija = biografija;
    }

    public int getSifraAutora() {
        return sifraAutora;
    }

    public void setSifraAutora(int sifraAutora) {
        this.sifraAutora = sifraAutora;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getBiografija() {
        return biografija;
    }

    public void setBiografija(String biografija) {
        this.biografija = biografija;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

}
