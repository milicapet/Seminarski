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
public class Izdavac implements ApstraktniDomenskiObjekat {

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

    @Override
    public String vratiNazivTabele() {
        return "izdavac";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            int sifraIzdavaca = rs.getInt("izdavac.sifraIzdavaca");
            String naziv = rs.getString("izdavac.naziv");
            String adresa = rs.getString("izdavac.adresa");

            Izdavac i = new Izdavac(sifraIzdavaca, naziv, adresa);
            lista.add(i);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "sifraIzdavaca,naziv,adresa";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return sifraIzdavaca + ",'" + naziv + "','" + adresa + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "izdavac.sifraIzdavaca=" + sifraIzdavaca;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "sifraIzdavaca=" + sifraIzdavaca + ",naziv='" + naziv + "',adresa='" + adresa + "'";
    }

}
