/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.izdavaci;

import domen.Izdavac;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author milic
 */
public class UcitajIzdavaceSO extends ApstraktnaGenerickaOperacija {

    private List<Izdavac> izdavaci;

    public List<Izdavac> getIzdavaci() {
        return izdavaci;
    }

    @Override
    protected void preduslovi(Object param) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        izdavaci = broker.getAll(param, kljuc);
    }

}
