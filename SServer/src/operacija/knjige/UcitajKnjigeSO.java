/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.knjige;

import domen.Knjiga;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author milic
 */
public class UcitajKnjigeSO extends ApstraktnaGenerickaOperacija {

    private List<Knjiga> knjige;

    public List<Knjiga> getKnjige() {
        return knjige;
    }

    @Override
    protected void preduslovi(Object param) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        knjige = broker.getAll(param, kljuc);
    }

}
