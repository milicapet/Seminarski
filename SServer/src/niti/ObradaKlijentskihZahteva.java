/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import java.net.Socket;
import komunikacija.Zahtev;
import komunikacija.Odgovor;
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

            Zahtev zahtev = (Zahtev) primalac.primiZahtev();
            Odgovor odgovor = new Odgovor();

            switch (zahtev.getOperacija()) {
                /*case Operacije.LOGIN:
                    HashMap<Integer, String> mapa = (HashMap<Integer, String>) kz.getParametar();
                    String korisnickoIme = mapa.get(1);
                    String sifra = mapa.get(2);
                    Bibliotekar bibliotekar = Kontroler.getInstance().login(korisnickoIme, sifra);
                    so.setOdgovor(bibliotekar);
                    break;
                case Operacije.VRATI_AUTORE:
                    ArrayList<Autor> autori = Kontroler.getInstance().vratiAutore();
                    so.setOdgovor(autori);
                    break;
                case Operacije.VRATI_IZDAVACE:
                    ArrayList<Izdavac> izdavaci = Kontroler.getInstance().vratiIzdavace();
                    so.setOdgovor(izdavaci);
                    break;
                case Operacije.VRATI_CLANOVE:
                    ArrayList<Clan> clanovi = Kontroler.getInstance().vratiClanove();
                    so.setOdgovor(clanovi);
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
            posiljalac.posaljiOdgovor(odgovor);
        }

    }

    

}
