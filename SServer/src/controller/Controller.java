/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.Bibliotekar;
import domen.Clan;
import java.util.List;
import operacija.clanovi.IzmeniClanaSO;
import operacija.clanovi.KreirajClanaSO;
import operacija.clanovi.ObrisiClanaSO;
import operacija.clanovi.UcitajClanoveSO;
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

}
