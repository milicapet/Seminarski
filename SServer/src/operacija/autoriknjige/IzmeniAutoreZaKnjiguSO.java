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
public class IzmeniAutoreZaKnjiguSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
        /*if (param == null || !(param instanceof AutorKnjiga)) {
            throw new Exception("Sistem ne može da izmeni autore za knjigu");
        }
        Knjiga k = (Knjiga) param;
        if (k.getNaziv() == null || k.getNaziv().isEmpty()) {
            throw new Exception("Sistem ne može da kreira knjigu");
        }*/
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        List<AutorKnjiga> noviAutoriKnjige = (List<AutorKnjiga>) param;

        String uslov = " JOIN autor ON autor.sifraAutora = autorknjiga.sifraAutora "
                + "JOIN knjiga ON knjiga.sifraKnjige = autorknjiga.sifraKnjige"
                + " WHERE autorknjiga.sifraKnjige = " + noviAutoriKnjige.get(0).getKnjiga().getSifraKnjige() + " ";

        List<AutorKnjiga> stariAutoriKnjige = broker.getAll(new AutorKnjiga(), uslov);
        for (AutorKnjiga ak : stariAutoriKnjige) {
            broker.delete(ak);
        }

        for (AutorKnjiga ak : noviAutoriKnjige) {
            broker.add(ak);
        }
    }

}
