/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import cordinator.Cordinator;
import domen.Pozajmica;
import forme.FormaMod;
import forme.PrikazPozajmicaForma;
import forme.model.ModelTabelePozajmica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author milic
 */
public class PrikazPozajmicaController {

    private final PrikazPozajmicaForma ppf;

    public PrikazPozajmicaController(PrikazPozajmicaForma ppf) {
        this.ppf = ppf;
        addActionListeners();
        addMouseListeners();
    }

    public void otvoriFormu() {
        pripremiFormu();
        ppf.setVisible(true);
    }

    public void osveziFormu() {
        pripremiFormu();
    }

    private void pripremiFormu() {
        List<Pozajmica> pozajmice = Komunikacija.getInstance().ucitajPozajmice();
        System.out.println("PRIPREMI FORMU: " + pozajmice);
        ModelTabelePozajmica mtp = new ModelTabelePozajmica(pozajmice);
        ppf.getjTablePozajmice().setModel(mtp);
    }

    private void addActionListeners() {
        ppf.addBtnObrisiActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selRed = ppf.getjTablePozajmice().getSelectedRow();
                if (selRed == -1) {
                    JOptionPane.showMessageDialog(ppf, "Sistem ne može da učita pozajmicu", "GREŠKA!", JOptionPane.ERROR_MESSAGE);
                } else {
                    ModelTabelePozajmica mtp = (ModelTabelePozajmica) ppf.getjTablePozajmice().getModel();
                    Pozajmica p = mtp.getLista().get(selRed);
                    try {
                        Komunikacija.getInstance().obrisiPozajmicu(p);
                        JOptionPane.showMessageDialog(null, "Sistem je izbrisao podatke o pozajmici", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                        mtp.obrisiPozajmicu(p);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Sistem ne može da izbriše pozajmicu", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        ppf.addBtnIzmeniActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selRed = ppf.getjTablePozajmice().getSelectedRow();
                if (selRed == -1) {
                    JOptionPane.showMessageDialog(ppf, "Sistem ne može da učita pozajmicu", "GREŠKA!", JOptionPane.ERROR_MESSAGE);
                } else {
                    ModelTabelePozajmica mtp = (ModelTabelePozajmica) ppf.getjTablePozajmice().getModel();
                    Pozajmica p = mtp.getLista().get(selRed);
                                    System.out.println("\n\n POZAJMICA u PRIKAZU " + p);
                    Cordinator.getInstance().dodajParam("pozajmica_za_izmenu", p);
                    Cordinator.getInstance().otvoriIzmeniPozajmicuFormu();
                }
            }
        });

    }

    private void addMouseListeners() {
    }

}
