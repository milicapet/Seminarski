/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import cordinator.Cordinator;
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
                        JOptionPane.showMessageDialog(null, "Sistem ne može da izbriše člana", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        pcf.addBtnIzmeniActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selRed = pcf.getjTableClanovi().getSelectedRow();
                if (selRed == -1) {
                    JOptionPane.showMessageDialog(pcf, "Sistem ne može da učita člana", "GREŠKA!", JOptionPane.ERROR_MESSAGE);
                } else {
                    ModelTabeleClan mtc = (ModelTabeleClan) pcf.getjTableClanovi().getModel();
                    Clan c = mtc.getLista().get(selRed);
                    Cordinator.getInstance().dodajParam("clan", c);
                    Cordinator.getInstance().otvoriIzmeniClanaFormu();
                }
            }
        });
        pcf.addBtnPretraziActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String brClanskeKarte = pcf.getjTextFieldBrClanskeKarte().getText().trim();
                String ime = pcf.getjTextFieldIme().getText().trim();
                String prezime = pcf.getjTextFieldPrezime().getText().trim();
                String adresa = pcf.getjTextFieldAdresa().getText().trim();
                String brTel = pcf.getjTextFieldBrTel().getText().trim();
                System.out.println("brCLanskeKarte " + brClanskeKarte + "DUZINA STRINGA" + brClanskeKarte.length());
                ModelTabeleClan mtc = (ModelTabeleClan) pcf.getjTableClanovi().getModel();
                List<Clan> filtriranaLista = mtc.pretrazi(brClanskeKarte, ime, prezime, adresa, brTel);
                if (filtriranaLista.size() != 0) {
                    JOptionPane.showMessageDialog(pcf, "Sistem je našao članove po zadatoj vrednosti", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(pcf, "Sistem ne može da nađe članove po zadatoj vrednosti", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        pcf.addBtnResetujActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pripremiFormu();
            }
        });
    }

    public void osveziFormu() {
        pripremiFormu();
    }

}
