/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Clan;
import forme.PrikazClanovaForma;
import forme.model.ModelTabeleClan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author milic
 */
public class PrikazClanovaController {

    private final PrikazClanovaForma pcf;

    public PrikazClanovaController(PrikazClanovaForma pcf) {
        this.pcf = pcf;
        addActionListeners();
    }

    public void otvoriFormu() {
        pripremiFormu();
        pcf.setVisible(true);
    }

    private void pripremiFormu() {
        List<Clan> clanovi = Komunikacija.getInstance().ucitajClanove();
        ModelTabeleClan mtc = new ModelTabeleClan(clanovi);
        pcf.getjTableClanovi().setModel(mtc);
    }

    private void addActionListeners() {
        pcf.addBtnObrisiActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selRed = pcf.getjTableClanovi().getSelectedRow();
                if (selRed == -1) {
                    JOptionPane.showMessageDialog(pcf, "Sistem ne može da izbriše člana", "GREŠKA!", JOptionPane.ERROR_MESSAGE);
                } else {
                    ModelTabeleClan mtc = (ModelTabeleClan) pcf.getjTableClanovi().getModel();
                    Clan c = mtc.getLista().get(selRed);
                    try {
                        Komunikacija.getInstance().obrisiClana(c);
                        JOptionPane.showMessageDialog(null, "Sistem je izbrisao podatke o članu", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                        pripremiFormu();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Sistem ne moeže da izbriše člana", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

    }

}
