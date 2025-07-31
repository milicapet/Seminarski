/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.pozajmice;

import domen.Pozajmica;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author milic
 */
public class UcitajPozajmiceSO extends ApstraktnaGenerickaOperacija {

    private List<Pozajmica> pozajmice;

    public List<Pozajmica> getPozajmice() {
        return pozajmice;
    }

    @Override
    protected void preduslovi(Object param) throws Exception {

    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        pozajmice = broker.getAll(new Pozajmica(), null);
    }

}
