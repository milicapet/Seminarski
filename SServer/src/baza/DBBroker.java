/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import domen.Autor;
import domen.Bibliotekar;
import domen.Clan;
import domen.Izdavac;
import domen.Knjiga;
import domen.Primerak;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author milic
 */
public class DBBroker {

    public Bibliotekar login(String korisnickoIme, String sifra) {

        String upit = "SELECT * FROM bibliotekar";
        try {

            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Bibliotekar bibliotekar = new Bibliotekar(rs.getString("korisnickoIme"), rs.getString("sifra"));
                if (bibliotekar.getKorisnickoIme().equals(korisnickoIme) && bibliotekar.getSifra().equals(sifra)) {
                    return bibliotekar;
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public ArrayList<Autor> vratiAutore() {

        ArrayList<Autor> lista = new ArrayList<>();
        String upit = "SELECT * FROM Autor";
        try {

            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);

            while (rs.next()) {
                Autor autor = new Autor(rs.getInt("sifraAutora"), rs.getString("ime"), rs.getString("prezime"), rs.getString("biografija"));
                lista.add(autor);

            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;

    }

    public ArrayList<Izdavac> vratiIzdavace() {
        ArrayList<Izdavac> lista = new ArrayList<>();
        String upit = "SELECT * FROM Izdavac";
        try {

            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);

            while (rs.next()) {

                Izdavac izdavac = new Izdavac(rs.getInt("sifraIzdavaca"), rs.getString("naziv"), rs.getString("adresa"));
                lista.add(izdavac);

            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public ArrayList<Clan> vratiClanove() {
        ArrayList<Clan> lista = new ArrayList<>();
        String upit = "SELECT * FROM Clan";
        try {

            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);

            while (rs.next()) {
                Clan clan = new Clan(rs.getInt("brojClanskeKarte"), rs.getString("ime"), rs.getString("prezime"), rs.getString("adresa"), rs.getString("brojTelefona"));
                lista.add(clan);

            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;

    }

    /*public ArrayList<Knjiga> vratiKnjige() {
        ArrayList<Knjiga> lista = new ArrayList<>();
        String upit = "SELECT * FROM Knjiga";
        try {

            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);

            while (rs.next()) {
                Knjiga knjiga = new Knjiga(rs.getInt("sifraKnjige"), rs.getString("naziv"), rs.getString("opis"));
                lista.add(knjiga);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;

    }*/

    /*public ArrayList<Primerak> vratiPrimerke() {
        ArrayList<Primerak> lista = new ArrayList<>();
        String upit = "SELECT * FROM Primerak";
        try {

            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);

            while (rs.next()) {
                Primerak primerak = new Primerak(rs.getInt("sifraKnjige"), rs.getInt("sifraPrimerka"), rs.getInt("godinaIzdanja"), rs.getInt("brojIzdanja"), rs.getInt("sifraIzdavaca"));
                lista.add(primerak);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }*/

}
