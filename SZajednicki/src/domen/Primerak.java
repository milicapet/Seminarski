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
public class Primerak implements Serializable {

    private Knjiga knjiga;
    private int sifraPrimerka;
    private int godinaIzdanja;
    private int brojIzdanja;
    private Izdavac izdavac;

    public Primerak() {
    }

    public Primerak(Knjiga knjiga, int sifraPrimerka, int godinaIzdanja, int brojIzdanja, Izdavac izdavac) {
        this.knjiga = knjiga;
        this.sifraPrimerka = sifraPrimerka;
        this.godinaIzdanja = godinaIzdanja;
        this.brojIzdanja = brojIzdanja;
        this.izdavac = izdavac;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    public int getSifraPrimerka() {
        return sifraPrimerka;
    }

    public void setSifraPrimerka(int sifraPrimerka) {
        this.sifraPrimerka = sifraPrimerka;
    }

    public int getGodinaIzdanja() {
        return godinaIzdanja;
    }

    public void setGodinaIzdanja(int godinaIzdanja) {
        this.godinaIzdanja = godinaIzdanja;
    }

    public int getBrojIzdanja() {
        return brojIzdanja;
    }

    public void setBrojIzdanja(int brojIzdanja) {
        this.brojIzdanja = brojIzdanja;
    }

    public Izdavac getIzdavac() {
        return izdavac;
    }

    public void setIzdavac(Izdavac izdavac) {
        this.izdavac = izdavac;
    }

    @Override
    public String toString() {
        return "Primerak{" + "knjiga=" + knjiga + ", brojIzdanja=" + brojIzdanja + ", izdavac=" + izdavac + '}';
    }

}
