/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
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
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            int sifraKnjige = rs.getInt("pozajmica.sifraKnjige");
            int sifraPrimerka = rs.getInt("pozajmica.sifraPrimerka");
            int brojClanskeKarte = rs.getInt("pozajmica.brojClanskeKarte");
            java.sql.Date datUzSQL = rs.getDate("pozajmica.datumUzimanja");
            java.sql.Date datVrSQL = rs.getDate("pozajmica.datumVracanja");
            java.util.Date datUzUtil = new java.util.Date(datUzSQL.getTime());
            java.util.Date datVrUtil = datVrSQL != null ? new java.util.Date(datVrSQL.getTime()) : null;
            Primerak primerak = new Primerak();
            primerak.setSifraPrimerka(sifraPrimerka);
            Knjiga knjiga = new Knjiga();
            knjiga.setSifraKnjige(sifraKnjige);
            primerak.setKnjiga(knjiga);
            Clan clan = new Clan();
            clan.setBrojClanskeKarte(brojClanskeKarte);
            Pozajmica p = new Pozajmica(primerak, clan, datUzUtil, datVrUtil);
            lista.add(p);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "sifraKnjige,sifraPrimerka,brojClanskeKarte,datumUzimanja,datumVracanja";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        String datumVracanjaZaUbacivanje = (datumVracanja != null)
                ? "'" + new java.sql.Date(datumVracanja.getTime()).toString() + "'"
                : "NULL";
        return primerak.getKnjiga().getSifraKnjige() + "," + primerak.getSifraPrimerka() + ","
                + clan.getBrojClanskeKarte() + ",'" + new java.sql.Date(datumUzimanja.getTime()) + "'," + datumVracanjaZaUbacivanje;
    }

    @Override
    public String vratiPrimarniKljuc() {
        java.sql.Date sqlDatUz = new java.sql.Date(datumUzimanja.getTime());
        return "pozajmica.sifraKnjige=" + primerak.getKnjiga().getSifraKnjige() + " AND pozajmica.sifraPrimerka="
                + primerak.getSifraPrimerka() + " AND pozajmica.brojClanskeKarte=" + clan.getBrojClanskeKarte()
                + " AND pozajmica.datumUzimanja='" + sqlDatUz + "'";
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
