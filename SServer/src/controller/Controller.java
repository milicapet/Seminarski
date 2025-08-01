/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.Autor;
import domen.AutorKnjiga;
import domen.Bibliotekar;
import domen.Clan;
import domen.Izdavac;
import domen.Knjiga;
import domen.Pozajmica;
import domen.Primerak;
import java.util.List;
import operacija.autoriknjige.UcitajAutorKnjigeSO;
import operacija.autori.UcitajAutoreSO;
import operacija.autoriknjige.IzmeniAutoreZaKnjiguSO;
import operacija.clanovi.IzmeniClanaSO;
import operacija.clanovi.KreirajClanaSO;
import operacija.clanovi.ObrisiClanaSO;
import operacija.clanovi.UcitajClanoveSO;
import operacija.izdavaci.UcitajIzdavaceSO;
import operacija.knjige.IzmeniKnjiguSO;
import operacija.autoriknjige.KreirajAutorKnjigaSO;
import operacija.autoriknjige.UcitajAutoreKnjigeSO;
import operacija.knjige.KreirajKnjiguSO;
import operacija.knjige.UcitajKnjigeSO;
import operacija.knjige.primerci.IzmeniPrimerakSO;
import operacija.knjige.primerci.KreirajPrimerakSO;
import operacija.knjige.primerci.ObrisiPrimerakSO;
import operacija.knjige.primerci.UcitajPrimerkeSO;
import operacija.login.LoginOperacija;
import operacija.pozajmice.IzmeniPozajmicuSO;
import operacija.pozajmice.KreirajPozajmicuSO;
import operacija.pozajmice.ObrisiPozajmicuSO;
import operacija.pozajmice.UcitajPozajmiceSO;

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

    public void izmeniPrimerak(Primerak p1) throws Exception {
        IzmeniPrimerakSO operacija = new IzmeniPrimerakSO();
        operacija.izvrsi(p1, null);
    }

    public void dodajPrimerak(Primerak p2) throws Exception {
        KreirajPrimerakSO operacija = new KreirajPrimerakSO();
        operacija.izvrsi(p2, null);
    }

    public void izmeniKnjigu(Knjiga k1) throws Exception {
        IzmeniKnjiguSO operacija = new IzmeniKnjiguSO();
        operacija.izvrsi(k1, null);
    }

    public List<AutorKnjiga> ucitajAutorKnjige() throws Exception {
        UcitajAutorKnjigeSO operacija = new UcitajAutorKnjigeSO();
        operacija.izvrsi(new AutorKnjiga(), "");
        return operacija.getAutorKnjige();
    }

    public List<Pozajmica> ucitajPozajmice() throws Exception {
        UcitajPozajmiceSO operacija = new UcitajPozajmiceSO();
        operacija.izvrsi(new Pozajmica(), "");
        System.out.println("CONTROLLER " + operacija.getPozajmice());
        return operacija.getPozajmice();
    }

    public void obrisiPozajmicu(Pozajmica p) throws Exception {
        ObrisiPozajmicuSO operacija = new ObrisiPozajmicuSO();
        operacija.izvrsi(p, null);
    }

    public void dodajPozajmicu(Pozajmica p) throws Exception {
        KreirajPozajmicuSO operacija = new KreirajPozajmicuSO();
        operacija.izvrsi(p, null);
    }

    public void izmeniPozajmicu(Pozajmica poz) throws Exception {
        IzmeniPozajmicuSO operacija = new IzmeniPozajmicuSO();
        operacija.izvrsi(poz, null);
    }

    public void dodajAutoreZaKnjigu(List<AutorKnjiga> ak) throws Exception {
        KreirajAutorKnjigaSO operacija = new KreirajAutorKnjigaSO();
        operacija.izvrsi(ak, null);
    }

    public List<Autor> ucitajAutoreKnjige(int sifraKnjige2) throws Exception {
        UcitajAutoreKnjigeSO operacija = new UcitajAutoreKnjigeSO();
        operacija.izvrsi(sifraKnjige2, null);
        System.out.println("KLASA Controller: " + operacija.getAutoriKnjige());
        return operacija.getAutoriKnjige();
    }

    public void izmeniAutoreZaKnjigu(List<AutorKnjiga> ak2) throws Exception {
        IzmeniAutoreZaKnjiguSO operacija = new IzmeniAutoreZaKnjiguSO();
        operacija.izvrsi(ak2, null);
    }

}
