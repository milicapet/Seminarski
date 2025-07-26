/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import domen.Bibliotekar;
import domen.Clan;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author milic
 */
public class Komunikacija {

    private static Komunikacija instance;
    private Socket s;
    private Posiljalac posiljalac;
    private Primalac primalac;

    private Komunikacija() {
    }

    public static Komunikacija getInstance() {
        if (instance == null) {
            instance = new Komunikacija();
        }
        return instance;
    }

    public void konekcija() {
        try {
            s = new Socket("localhost", 9000);
            posiljalac = new Posiljalac(s);
            primalac = new Primalac(s);
        } catch (IOException ex) {
            System.out.println("Server nije povezan! ");
        }
    }

    public Bibliotekar login(String korisnickoIme, String sifra) {
        Bibliotekar b = new Bibliotekar(korisnickoIme, sifra);
        Zahtev zahtev = new Zahtev(Operacije.LOGIN, b);
        posiljalac.posalji(zahtev);
        Odgovor odg = (Odgovor) primalac.primi();
        b = (Bibliotekar) odg.getOdgovor();
        return b;
    }

    public List<Clan> ucitajPacijente() {
        List<Clan> clanovi = new ArrayList<>();
        Zahtev zahtev = new Zahtev(Operacije.UCITAJ_CLANOVE, null);
        posiljalac.posalji(zahtev);
        Odgovor odg = (Odgovor) primalac.primi();
        clanovi = (List<Clan>) odg.getOdgovor();
        return clanovi;
    }

}
