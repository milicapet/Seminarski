/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.autori;

import domen.Autor;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author milic
 */
public class UcitajAutoreSO extends ApstraktnaGenerickaOperacija {

    private List<Autor> autori;

    public List<Autor> getAutori() {
        return autori;
    }

    @Override
    protected void preduslovi(Object param) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        autori = broker.getAll(new Autor(), "");
    }

}
