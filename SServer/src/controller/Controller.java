/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.Autor;
import domen.Bibliotekar;
import domen.Clan;
import domen.Izdavac;
import domen.Knjiga;
import domen.Primerak;
import java.util.List;
import operacija.autori.UcitajAutoreSO;
import operacija.clanovi.IzmeniClanaSO;
import operacija.clanovi.KreirajClanaSO;
import operacija.clanovi.ObrisiClanaSO;
import operacija.clanovi.UcitajClanoveSO;
import operacija.izdavaci.UcitajIzdavaceSO;
import operacija.knjige.KreirajKnjiguSO;
import operacija.knjige.UcitajKnjigeSO;
import operacija.knjige.primerci.ObrisiPrimerakSO;
import operacija.knjige.primerci.UcitajPrimerkeSO;
import operacija.login.LoginOperacija;

/**
 *
 * @author milic
 */
public class Controller {

    private static Controller instance;

    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public Bibliotekar login(Bibliotekar b) throws Exception {
        LoginOperacija operacija = new LoginOperacija();
        operacija.izvrsi(b, null);
        System.out.println("KLASA Controller: " + operacija.getBibliotekar());
        return operacija.getBibliotekar();
    }

    public List<Clan> ucitajClanove() throws Exception {
        UcitajClanoveSO operacija = new UcitajClanoveSO();
        operacija.izvrsi(null, null);
        System.out.println("KLASA Controller: " + operacija.getClanovi());
        return operacija.getClanovi();
    }

    public void obrisiClana(Clan c) throws Exception {
        ObrisiClanaSO operacija = new ObrisiClanaSO();
        operacija.izvrsi(c, null);
    }

    public void dodajClana(Clan c) throws Exception {
        KreirajClanaSO operacija = new KreirajClanaSO();
        operacija.izvrsi(c, null);
    }

    public void izmeniClana(Clan c1) throws Exception {
        IzmeniClanaSO operacija = new IzmeniClanaSO();
        operacija.izvrsi(c1, null);
    }

    public List<Knjiga> ucitajKnjige() throws Exception {
        UcitajKnjigeSO operacija = new UcitajKnjigeSO();
        operacija.izvrsi(new Knjiga(), "");
        System.out.println("KLASA Controller: " + operacija.getKnjige());
        return operacija.getKnjige();

    }

    public List<Primerak> ucitajPrimerke(int sifraKnjige) throws Exception {
        UcitajPrimerkeSO operacija = new UcitajPrimerkeSO();
        operacija.izvrsi(sifraKnjige, null);
        System.out.println("KLASA Controller: " + operacija.getPrimerci());
        return operacija.getPrimerci();
    }

    public List<Autor> ucitajAutore() throws Exception {
        UcitajAutoreSO operacija = new UcitajAutoreSO();
        operacija.izvrsi(new Autor(), "");
        System.out.println("KLASA Controller: " + operacija.getAutori());
        return operacija.getAutori();
    }

    public List<Izdavac> ucitajIzdavace() throws Exception {
        UcitajIzdavaceSO operacija = new UcitajIzdavaceSO();
        operacija.izvrsi(new Izdavac(), "");
        System.out.println("KLASA Controller: " + operacija.getIzdavaci());
        return operacija.getIzdavaci();
    }

    public void dodajKnjigu(Knjiga k) throws Exception {
        KreirajKnjiguSO operacija = new KreirajKnjiguSO();
        operacija.izvrsi(k, null);
    }

    public void obrisiPrimerak(Primerak p) throws Exception {
        ObrisiPrimerakSO operacija = new ObrisiPrimerakSO();
        operacija.izvrsi(p, null);
    }

}
