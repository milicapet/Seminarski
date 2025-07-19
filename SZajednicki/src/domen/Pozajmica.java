/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

/**
 *
 * @author milic
 */
public class Pozajmica implements ApstraktniDomenskiObjekat {

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

    @Override
    public String vratiNazivTabele() {
        return "pozajmica";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "sifraKnjige,sifraPrimerka,brojClanskeKarte,datumUzimanja,datumVracanja";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return primerak.getKnjiga().getSifraKnjige() + "," + primerak.getSifraPrimerka() + ","
                + clan.getBrojClanskeKarte() + ",'" + datumUzimanja + "','" + datumVracanja + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "pozajmica.sifraKnjige=" + primerak.getKnjiga().getSifraKnjige() + " AND pozajmica.sifraPrimerka="
                + primerak.getSifraPrimerka() + " AND pozajmica.brojClanskeKarte=" + clan.getBrojClanskeKarte()
                + " AND pozajmica.datumUzimanja=" + datumUzimanja;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "sifraKnjige=" + primerak.getKnjiga().getSifraKnjige() + ",sifraPrimerka=" + primerak.getSifraPrimerka()
                + ",brojClanskeKarte=" + clan.getBrojClanskeKarte() + ",datumUzimanja='" + datumUzimanja
                + "',datumVracanja='" + datumVracanja + "'";
    }

}
