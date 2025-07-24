/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author milic
 */
public class Bibliotekar implements ApstraktniDomenskiObjekat {

    private String korisnickoIme;
    private String sifra;

    public Bibliotekar() {
    }

    public Bibliotekar(String korisnickoIme, String sifra) {
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bibliotekar other = (Bibliotekar) obj;
        if (!Objects.equals(this.korisnickoIme, other.korisnickoIme)) {
            return false;
        }
        return Objects.equals(this.sifra, other.sifra);
    }

    @Override
    public String vratiNazivTabele() {
        return "bibliotekar";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            String korisnickoIme = rs.getString("bibliotekar.korisnickoIme");
            String sifra = rs.getString("bibliotekar.sifra");

            Bibliotekar b = new Bibliotekar(korisnickoIme, sifra);
            lista.add(b);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "korisnickoIme,sifra";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'" + korisnickoIme + "','" + sifra + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "bibliotekar.korisnickoIme=" + korisnickoIme;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "korisnickoIme='" + korisnickoIme + "',sifra='" + sifra + "'";
    }

}
