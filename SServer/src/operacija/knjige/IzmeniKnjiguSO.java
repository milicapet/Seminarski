/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.knjige;

import domen.Knjiga;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author milic
 */
public class IzmeniKnjiguSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Knjiga)) {
            throw new Exception("Sistem ne može da kreira knjigu");
        }
        Knjiga k = (Knjiga) param;
        if (k.getNaziv() == null || k.getNaziv().isEmpty()) {
            throw new Exception("Sistem ne može da kreira knjigu");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        //broker.edit((Knjiga) param);
    }

}
