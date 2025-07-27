/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author milic
 */
public class Knjiga implements ApstraktniDomenskiObjekat {

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

    @Override
    public String vratiNazivTabele() {
        return "knjiga";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            int sifraKnjige = rs.getInt("knjiga.sifraKnjige");
            String naziv = rs.getString("knjiga.naziv");
            String opis = rs.getString("knjiga.opis");

            Knjiga k = new Knjiga(sifraKnjige, naziv, opis, null);
            lista.add(k);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "sifraKnjige,naziv,opis";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return sifraKnjige + ",'" + naziv + "','" + opis + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "knjiga.sifraKnjige=" + sifraKnjige;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "sifraKnjige=" + sifraKnjige + ",naziv='" + naziv + "',opis='" + opis + "'";
    }

}
