/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.knjige.primerci;

import domen.Primerak;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author milic
 */
public class UcitajPrimerkeSO extends ApstraktnaGenerickaOperacija {

    private List<Primerak> primerci;

    public List<Primerak> getPrimerci() {
        return primerci;
    }

    @Override
    protected void preduslovi(Object param) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        String uslov = " JOIN izdavac ON primerak.sifraIzdavaca = izdavac.sifraIzdavaca"
                + " WHERE primerak.sifraKnjige = " + (int) param + " ";
        primerci = broker.getAll(new Primerak(), uslov);
    }

}
