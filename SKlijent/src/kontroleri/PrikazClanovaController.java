/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Clan;
import forme.PrikazClanovaForma;
import forme.model.ModelTabeleClan;
import java.util.List;
import komunikacija.Komunikacija;

/**
 *
 * @author milic
 */
public class PrikazClanovaController {

    private final PrikazClanovaForma pcf;

    public PrikazClanovaController(PrikazClanovaForma pcf) {
        this.pcf = pcf;
    }

    public void otvoriFormu() {
        pripremiFormu();
        pcf.setVisible(true);
        
    }

    private void pripremiFormu() {
        List<Clan> clanovi = Komunikacija.getInstance().ucitajPacijente();
        ModelTabeleClan mtc = new ModelTabeleClan(clanovi);
        pcf.getjTableClanovi().setModel(mtc);
    }

}
