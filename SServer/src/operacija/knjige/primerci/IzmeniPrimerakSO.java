/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.knjige.primerci;

import domen.Primerak;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author milic
 */
public class IzmeniPrimerakSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Primerak)) {
            throw new Exception("Sistem ne može da kreira primerak");
        }
        Primerak p = (Primerak) param;
        /*if (p.getSifraPrimerka() == null || p.getSifraPrimerka().isEmpty()) {
            throw new Exception("Sistem ne može da kreira primerak");
        }*/
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.edit((Primerak)param);
    }

}
