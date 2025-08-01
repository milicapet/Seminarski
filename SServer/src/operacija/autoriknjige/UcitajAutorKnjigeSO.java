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
public class UcitajAutorKnjigeSO extends ApstraktnaGenerickaOperacija{
    private List<AutorKnjiga> autorKnjige;

    public List<AutorKnjiga> getAutorKnjige() {
        return autorKnjige;
    }

    @Override
    protected void preduslovi(Object param) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        String uslov = " JOIN autor ON autor.sifraAutora = autorknjiga.sifraAutora "
                + "JOIN knjiga ON knjiga.sifraKnjige = autorknjiga.sifraKnjige";
        autorKnjige = broker.getAll((AutorKnjiga)param, uslov);
    }
}
