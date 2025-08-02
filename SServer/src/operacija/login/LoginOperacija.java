/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.login;

import domen.Bibliotekar;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author milic
 */
public class LoginOperacija extends ApstraktnaGenerickaOperacija {

    Bibliotekar bibliotekar;

    public Bibliotekar getBibliotekar() {
        return bibliotekar;
    }

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Bibliotekar)) {
            throw new Exception("Sistem ne može da uloguje bibliotekara");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        List<Bibliotekar> sviBibliotekari = broker.getAll((Bibliotekar) param, null);
        System.out.println("KLASA LoginOperacija SO " + sviBibliotekari);
        if (sviBibliotekari.contains((Bibliotekar) param)) {
            for (Bibliotekar b : sviBibliotekari) {
                if (b.equals((Bibliotekar) param)) {
                    bibliotekar = b;
                }
            }
        } else {
            bibliotekar = null;
        }
    }

}
