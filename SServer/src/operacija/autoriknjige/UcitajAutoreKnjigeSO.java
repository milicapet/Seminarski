/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.autoriknjige;

import domen.Autor;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author milic
 */
public class UcitajAutoreKnjigeSO extends ApstraktnaGenerickaOperacija {

    private List<Autor> autoriKnjige;

    public List<Autor> getAutoriKnjige() {
        return autoriKnjige;
    }

    @Override
    protected void preduslovi(Object param) throws Exception {

    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        String uslov = " JOIN autorknjiga ON autor.sifraAutora=autorknjiga.sifraAutora "
                + "WHERE autorknjiga.sifraKnjige=" + (int) param + " ";
        autoriKnjige = broker.getAll(new Autor(), uslov);
    }

}
