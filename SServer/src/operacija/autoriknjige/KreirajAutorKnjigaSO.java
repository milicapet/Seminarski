/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.autoriknjige;

import domen.AutorKnjiga;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author milic
 */
public class KreirajAutorKnjigaSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
        /*if (param == null || !(param instanceof AutorKnjiga)) {
            throw new Exception("Sistem ne može da kreira primerak");
        }
        AutorKnjiga p = (AutorKnjiga) param;
        if (k.getNaziv() == null || k.getNaziv().isEmpty()) {
            throw new Exception("Sistem ne može da kreira knjigu");
        } */    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        List<AutorKnjiga> autoriknjige = (List<AutorKnjiga>) param;
        for (AutorKnjiga ak : autoriknjige) {
            broker.add(ak);
        }
    }

}
