/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.knjige;

import domen.Knjiga;
import domen.Primerak;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author milic
 */
public class IzmeniKnjiguSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Knjiga)) {
            throw new Exception("Sistem ne može da izmeni knjigu");
        }
        Knjiga k = (Knjiga) param;
        if (k.getNaziv() == null || k.getNaziv().isEmpty()) {
            throw new Exception("Sistem ne može da izmeni knjigu");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        Knjiga k = (Knjiga) param;
        broker.edit(k);

        String uslov = " JOIN izdavac ON primerak.sifraIzdavaca = izdavac.sifraIzdavaca"
                + " WHERE primerak.sifraKnjige = " + k.getSifraKnjige() + " ";
        List<Primerak> stariPrimerci = broker.getAll(new Primerak(), uslov);
        for (Primerak p : stariPrimerci) {
            broker.delete(p);
        }

        List<Primerak> noviPrimerci = k.getPrimerci();
        for (Primerak p : noviPrimerci) {
            broker.add(p);
        }
    }

}
