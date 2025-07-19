/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author milic
 */
public class Pozajmica implements Serializable {

    private Primerak primerak;
    private Clan clan;
    private Date datumUzimanja;
    private Date datumVracanja;

    public Pozajmica() {
    }

    public Pozajmica(Primerak primerak, Clan clan, Date datumUzimanja, Date datumVracanja) {
        this.primerak = primerak;
        this.clan = clan;
        this.datumUzimanja = datumUzimanja;
        this.datumVracanja = datumVracanja;
    }

    public Primerak getPrimerak() {
        return primerak;
    }

    public void setPrimerak(Primerak primerak) {
        this.primerak = primerak;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public Date getDatumUzimanja() {
        return datumUzimanja;
    }

    public void setDatumUzimanja(Date datumUzimanja) {
        this.datumUzimanja = datumUzimanja;
    }

    public Date getDatumVracanja() {
        return datumVracanja;
    }

    public void setDatumVracanja(Date datumVracanja) {
        this.datumVracanja = datumVracanja;
    }

    @Override
    public String toString() {
        return "Pozajmica{" + "primerak=" + primerak + ", clan=" + clan + ", datumUzimanja=" + datumUzimanja + ", datumVracanja=" + datumVracanja + '}';
    }

}
