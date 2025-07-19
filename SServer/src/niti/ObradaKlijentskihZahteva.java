/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import domen.Autor;
import domen.Bibliotekar;
import domen.Clan;
import domen.Izdavac;
import domen.Knjiga;
import domen.Primerak;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.Operacije;
import logika.Kontroler;
import komunikacija.Zahtev;
import komunikacija.Odgovor;

/**
 *
 * @author milic
 */
public class ObradaKlijentskihZahteva extends Thread {

    Socket s;

    public ObradaKlijentskihZahteva(Socket socket) {
        s = socket;
    }

    @Override
    public void run() {

        while (true) {

            Zahtev kz = primiZahtev();
            Odgovor so = new Odgovor();

            switch (kz.getOperacija()) {
                case Operacije.LOGIN:
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
                /*case Operacije.VRATI_KNJIGE:
                    ArrayList<Knjiga> knjige = Kontroler.getInstance().vratiKnjige();
                    so.setOdgovor(knjige);
                    break;*/
                /*case Operacije.VRATI_PRIMERKE:
                    ArrayList<Primerak> primerci = Kontroler.getInstance().vratiPrimerke();
                    so.setOdgovor(primerci);
                    break;*/
            }

            posaljiOdgovor(so);

        }

    }

    private Zahtev primiZahtev() {
        try {
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            return (Zahtev) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private void posaljiOdgovor(Odgovor so) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(so);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
