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
public class Autor implements ApstraktniDomenskiObjekat {

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

    @Override
    public String vratiNazivTabele() {
        return "autor";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            int sifraAutora = rs.getInt("autor.sifraAutora");
            String ime = rs.getString("autor.ime");
            String prezime = rs.getString("autor.prezime");
            String biografija = rs.getString("autor.biografija");

            Autor a = new Autor(sifraAutora, ime, prezime, biografija);
            lista.add(a);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "sifraAutora,ime,prezime,biografija";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return sifraAutora + ",'" + ime + "','" + prezime + "','" + biografija + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "autor.sifraAutora=" + sifraAutora;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "sifraAutora=" + sifraAutora + ",ime='" + ime + "',prezime='" + prezime
                + "',biografija='" + biografija + "'";
    }

}
