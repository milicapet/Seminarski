/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import controller.Controller;
import domen.Bibliotekar;
import domen.Clan;
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
                    /*case Operacije.VRATI_AUTORE:
                    ArrayList<Autor> autori = Kontroler.getInstance().vratiAutore();
                    so.setOdgovor(autori);
                    break;
                case Operacije.VRATI_IZDAVACE:
                    ArrayList<Izdavac> izdavaci = Kontroler.getInstance().vratiIzdavace();
                    so.setOdgovor(izdavaci);
                    break;
                
                case Operacije.VRATI_KNJIGE:
                    ArrayList<Knjiga> knjige = Kontroler.getInstance().vratiKnjige();
                    so.setOdgovor(knjige);
                    break;
                case Operacije.VRATI_PRIMERKE:
                    ArrayList<Primerak> primerci = Kontroler.getInstance().vratiPrimerke();
                    so.setOdgovor(primerci);
                    break;*/
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
