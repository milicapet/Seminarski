/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.pozajmice;

import domen.Pozajmica;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author milic
 */
public class KreirajPozajmicuSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Pozajmica)) {
            throw new Exception("Sistem ne može da kreira pozajmicu");
        }
        Pozajmica p = (Pozajmica) param;
        if (p.getClan() == null ) {
            throw new Exception("Sistem ne može da kreira pozajmicu");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.add((Pozajmica) param);
    }

}
