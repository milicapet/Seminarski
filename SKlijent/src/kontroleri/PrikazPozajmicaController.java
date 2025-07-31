/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Pozajmica;
import forme.PrikazPozajmicaForma;
import forme.model.ModelTabelePozajmica;
import java.util.List;
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

    private void addActionListeners() {/*
        pkf.addBtnObrisiPrimerakActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selRed = pkf.getjTablePrimerci().getSelectedRow();
                if (selRed == -1) {
                    JOptionPane.showMessageDialog(pkf, "Nije odabran primerak za brisanje", "GREŠKA!", JOptionPane.ERROR_MESSAGE);
                } else {
                    ModelTabelePrimerak mtp = (ModelTabelePrimerak) pkf.getjTablePrimerci().getModel();
                    Primerak p = mtp.getLista().get(selRed);
                    try {
                        Komunikacija.getInstance().obrisiPrimerak(p);
                        JOptionPane.showMessageDialog(null, "Sistem je izbrisao podatke o primerku", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                        mtp.obrisiPrimerak(p);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Sistem ne može da izbriše primerak", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
               pkf.addBtnIzmeniKnjiguActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selRed = pkf.getjTableKnjige().getSelectedRow();
                if (selRed == -1) {
                    JOptionPane.showMessageDialog(pkf, "Nije odabrana knjiga za izmenu", "GREŠKA!", JOptionPane.ERROR_MESSAGE);
                } else {
                    ModelTabeleKnjige mtk = (ModelTabeleKnjige) pkf.getjTableKnjige().getModel();
                    Knjiga k = mtk.getLista().get(selRed);
                    List<Primerak> primerci = Komunikacija.getInstance().ucitajPrimerke(k.getSifraKnjige());
                    k.setPrimerci(primerci);
                    Cordinator.getInstance().dodajParam("knjiga_za_izmenu", k);
                    Cordinator.getInstance().otvoriDodajKnjiguFormu(FormaMod.IZMENI);
                }
            }
        });
        */
    }

    private void addMouseListeners() {/*
        pkf.getjTableKnjige().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int red = pkf.getjTableKnjige().getSelectedRow();
                if (red != -1) {
                    ModelTabeleKnjige mtk = (ModelTabeleKnjige) pkf.getjTableKnjige().getModel();
                    Knjiga k = mtk.getLista().get(red);
                    List<Primerak> primerci = Komunikacija.getInstance().ucitajPrimerke(k.getSifraKnjige());
                    ModelTabelePrimerak mtp = new ModelTabelePrimerak(primerci);
                    pkf.getjTablePrimerci().setModel(mtp);
                }
            }
        });*/
    }

}
