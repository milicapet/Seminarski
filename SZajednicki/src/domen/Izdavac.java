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
public class Izdavac implements Serializable {

    private int sifraIzdavaca;
    private String naziv;
    private String adresa;

    public Izdavac() {
    }

    public Izdavac(int sifraIzdavaca, String naziv, String adresa) {
        this.sifraIzdavaca = sifraIzdavaca;
        this.naziv = naziv;
        this.adresa = adresa;
    }

    public int getSifraIzdavaca() {
        return sifraIzdavaca;
    }

    public void setSifraIzdavaca(int sifraIzdavaca) {
        this.sifraIzdavaca = sifraIzdavaca;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return "Izdavac{" + "naziv=" + naziv + '}';
    }

}
