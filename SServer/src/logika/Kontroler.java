/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logika;

import baza.DBBroker;
import domen.Autor;
import domen.Bibliotekar;
import domen.Clan;
import domen.Izdavac;
import domen.Knjiga;
import domen.Primerak;
import java.util.ArrayList;

/**
 *
 * @author milic
 */
public class Kontroler {

    private static Kontroler instance;
    private DBBroker dbb;

    private Kontroler() {
        dbb = new DBBroker();
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public Bibliotekar login(String korisnickoIme, String sifra) {
        return dbb.login(korisnickoIme, sifra);
    }

    public ArrayList<Autor> vratiAutore() {
        return dbb.vratiAutore();
    }

    public ArrayList<Izdavac> vratiIzdavace() {
        return dbb.vratiIzdavace();
    }

    public ArrayList<Clan> vratiClanove() {
        return dbb.vratiClanove();
    }

    /*public ArrayList<Knjiga> vratiKnjige() {
        return dbb.vratiKnjige();
    }*/

    /*public ArrayList<Primerak> vratiPrimerke() {
        return dbb.vratiPrimerke();
    }*/

}
