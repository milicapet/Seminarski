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
public class Clan implements Serializable {

    private int brojClanskeKarte;
    private String ime;
    private String prezime;
    private String adresa;
    private String brojTelefona;

    public Clan() {
    }

    public Clan(int brojClanskeKarte, String ime, String prezime, String adresa, String brojTelefona) {
        this.brojClanskeKarte = brojClanskeKarte;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.brojTelefona = brojTelefona;
    }

    public int getBrojClanskeKarte() {
        return brojClanskeKarte;
    }

    public void setBrojClanskeKarte(int brojClanskeKarte) {
        this.brojClanskeKarte = brojClanskeKarte;
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

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    @Override
    public String toString() {
        return "Clan{" + "ime=" + ime + ", prezime=" + prezime + '}';
    }

}
