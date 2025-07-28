/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import cordinator.Cordinator;
import domen.Autor;
import domen.Bibliotekar;
import domen.Clan;
import domen.Izdavac;
import domen.Knjiga;
import domen.Primerak;
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

    public List<Clan> ucitajClanove() {
        List<Clan> clanovi = new ArrayList<>();
        Zahtev zahtev = new Zahtev(Operacije.UCITAJ_CLANOVE, null);
        posiljalac.posalji(zahtev);
        Odgovor odg = (Odgovor) primalac.primi();
        clanovi = (List<Clan>) odg.getOdgovor();
        return clanovi;
    }

    public void obrisiClana(Clan c) throws Exception {
        Zahtev zahtev = new Zahtev(Operacije.OBRISI_CLANA, c);
        posiljalac.posalji(zahtev);
        Odgovor odg = (Odgovor) primalac.primi();
        if (odg.getOdgovor() == null) {
            System.out.println("Uspesno obrisano");
            //JOptionPane.showMessageDialog(null, "Sistem je izbrisao podatke o članu", "USPEH", JOptionPane.INFORMATION_MESSAGE);
        } else {
            //JOptionPane.showMessageDialog(null, "Sistem ne moeže da izbriše člana", "GREŠKA", JOptionPane.ERROR_MESSAGE);
            System.out.println("Greska u brisanju");
            ((Exception) odg.getOdgovor()).printStackTrace();
            throw new Exception("GREŠKA");
        }
    }

    public void dodajClana(Clan c) {
        Zahtev zahtev = new Zahtev(Operacije.DODAJ_CLANA, c);
        posiljalac.posalji(zahtev);
        Odgovor odg = (Odgovor) primalac.primi();
        if (odg.getOdgovor() == null) {
            System.out.println("Uspesno dodato");
        } else {
            System.out.println("Greska u brisanju");
        }
    }

    public void izmeniClana(Clan c) {
        Zahtev zahtev = new Zahtev(Operacije.IZMENI_CLANA, c);
        posiljalac.posalji(zahtev);
        Odgovor odg = (Odgovor) primalac.primi();
        if (odg.getOdgovor() == null) {
            System.out.println("Uspesno izmenjeno");
            Cordinator.getInstance().osveziFormu();
        } else {
            System.out.println("Greska u izmeni");
        }
    }

    public List<Knjiga> ucitajKnjige() {
        List<Knjiga> knjige = new ArrayList<>();
        Zahtev zahtev = new Zahtev(Operacije.UCITAJ_KNJIGE, "");
        posiljalac.posalji(zahtev);
        Odgovor odg = (Odgovor) primalac.primi();
        knjige = (List<Knjiga>) odg.getOdgovor();
        return knjige;        
    }

    public List<Primerak> ucitajPrimerke(int sifraKnjige) {
        List<Primerak> primerci = new ArrayList<>();
        Zahtev zahtev = new Zahtev(Operacije.UCITAJ_PRIMERKE, sifraKnjige);
        posiljalac.posalji(zahtev);
        Odgovor odg = (Odgovor) primalac.primi();
        primerci = (List<Primerak>) odg.getOdgovor();
        return primerci;                
    }

    public List<Autor> ucitajAutore() {
        List<Autor> autori = new ArrayList<>();
        Zahtev zahtev = new Zahtev(Operacije.UCITAJ_AUTORE, "");
        posiljalac.posalji(zahtev);
        Odgovor odg = (Odgovor) primalac.primi();
        autori = (List<Autor>) odg.getOdgovor();
        return autori;  
    }

    public List<Izdavac> ucitajIzdavace() {
        List<Izdavac> izdavaci = new ArrayList<>();
        Zahtev zahtev = new Zahtev(Operacije.UCITAJ_IZDAVACE, "");
        posiljalac.posalji(zahtev);
        Odgovor odg = (Odgovor) primalac.primi();
        izdavaci = (List<Izdavac>) odg.getOdgovor();
        return izdavaci;  
    }

}
