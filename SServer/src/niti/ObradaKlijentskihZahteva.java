/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import controller.Controller;
import domen.Autor;
import domen.Bibliotekar;
import domen.Clan;
import domen.Izdavac;
import domen.Knjiga;
import domen.Primerak;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.Zahtev;
import komunikacija.Odgovor;
import komunikacija.Operacije;
import komunikacija.Posiljalac;
import komunikacija.Primalac;

/**
 *
 * @author milic
 */
public class ObradaKlijentskihZahteva extends Thread {

    Socket socket;
    Posiljalac posiljalac;
    Primalac primalac;

    public ObradaKlijentskihZahteva(Socket socket) {
        this.socket = socket;
        posiljalac = new Posiljalac(socket);
        primalac = new Primalac(socket);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Zahtev zahtev = (Zahtev) primalac.primi();
                Odgovor odgovor = new Odgovor();
                switch (zahtev.getOperacija()) {
                    case Operacije.LOGIN:
                        Bibliotekar b = (Bibliotekar) zahtev.getParametar();
                        b = Controller.getInstance().login(b);
                        odgovor.setOdgovor(b);
                        break;
                    case Operacije.UCITAJ_CLANOVE:
                        List<Clan> clanovi = Controller.getInstance().ucitajClanove();
                        odgovor.setOdgovor(clanovi);
                        break;
                    case Operacije.OBRISI_CLANA:
                        try {
                        Clan c = (Clan) zahtev.getParametar();
                        Controller.getInstance().obrisiClana(c);
                        odgovor.setOdgovor(null);
                    } catch (Exception e) {
                        odgovor.setOdgovor(e);
                    }
                    break;
                    case Operacije.DODAJ_CLANA:
                        Clan c = (Clan) zahtev.getParametar();
                        Controller.getInstance().dodajClana(c);
                        odgovor.setOdgovor(null);
                        break;
                    case Operacije.IZMENI_CLANA:
                        Clan c1 = (Clan) zahtev.getParametar();
                        Controller.getInstance().izmeniClana(c1);
                        odgovor.setOdgovor(null);
                        break;
                    case Operacije.UCITAJ_KNJIGE:
                        List<Knjiga> knjige = Controller.getInstance().ucitajKnjige();
                        odgovor.setOdgovor(knjige);
                        break;
                    case Operacije.UCITAJ_PRIMERKE:
                        int sifraKnjige = (int) zahtev.getParametar();
                        List<Primerak> primerci = Controller.getInstance().ucitajPrimerke(sifraKnjige);
                        odgovor.setOdgovor(primerci);
                        break;
                    case Operacije.UCITAJ_AUTORE:
                        List<Autor> autori = Controller.getInstance().ucitajAutore();
                        odgovor.setOdgovor(autori);
                        break;
                    case Operacije.UCITAJ_IZDAVACE:
                        List<Izdavac> izdavaci = Controller.getInstance().ucitajIzdavace();
                        odgovor.setOdgovor(izdavaci);
                        break;

                    default:
                        System.out.println("GRESKA, TA OPERACIJA NE POSTOJI!");
                }
                posiljalac.posalji(odgovor);
            } catch (Exception ex) {
                Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
