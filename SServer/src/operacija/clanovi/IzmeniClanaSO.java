/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.clanovi;

import domen.Clan;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author milic
 */
public class IzmeniClanaSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Clan)) {
            throw new Exception("Sistem ne može da kreira člana");
        }
        Clan c = (Clan) param;
        if (c.getIme() == null || c.getIme().isEmpty()) {
            throw new Exception("Sistem ne može da kreira člana");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.edit((Clan) param);
    }

}
