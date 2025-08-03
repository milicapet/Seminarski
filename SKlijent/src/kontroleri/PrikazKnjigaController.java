/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import cordinator.Cordinator;
import domen.Autor;
import domen.Knjiga;
import domen.Primerak;
import forme.FormaMod;
import forme.PrikazKnjigaForma;
import forme.model.ModelTabeleKnjige;
import forme.model.ModelTabelePrimerak;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author milic
 */
public class PrikazKnjigaController {

    private final PrikazKnjigaForma pkf;

    public PrikazKnjigaController(PrikazKnjigaForma pkf) {
        this.pkf = pkf;
        addActionListeners();
        addMouseListeners();
    }

    public void otvoriFormu() {
        pripremiFormu();
        pkf.setVisible(true);
    }

    public void osveziFormu() {
        pripremiFormu();
    }

    private void pripremiFormu() {
        List<Autor> autori = Komunikacija.getInstance().ucitajAutore();
        DefaultListModel<Autor> model = new DefaultListModel<>();
        pkf.getjListAutori().removeAll();
        for (Autor a : autori) {
            model.addElement(a);
        }
        pkf.getjListAutori().setModel(model);

        List<Knjiga> knjige = Komunikacija.getInstance().ucitajKnjige();
        ModelTabeleKnjige mtk = new ModelTabeleKnjige(knjige);
        pkf.getjTableKnjige().setModel(mtk);

        List<Primerak> primerci = new ArrayList<>();
        ModelTabelePrimerak mtp = new ModelTabelePrimerak(primerci);
        pkf.getjTablePrimerci().setModel(mtp);
    }

    private void addActionListeners() {
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
        pkf.addBtnIzmeniPrimerakActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selRed = pkf.getjTablePrimerci().getSelectedRow();
                if (selRed == -1) {
                    JOptionPane.showMessageDialog(pkf, "Nije odabran primerak za izmenu", "GREŠKA!", JOptionPane.ERROR_MESSAGE);
                } else {
                    ModelTabelePrimerak mtp = (ModelTabelePrimerak) pkf.getjTablePrimerci().getModel();
                    Primerak p = mtp.getLista().get(selRed);
                    Cordinator.getInstance().dodajParam("primerak", p);
                    Cordinator.getInstance().otvoriIzmeniPrimerakFormu();
                }
            }
        });
        pkf.addBtnDodajPrimerakActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Cordinator.getInstance().dodajParam("primerak", p);
                Cordinator.getInstance().otvoriDodajPrimerakFormu();
            }
        });
        pkf.addBtnIzmeniKnjiguActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selRed = pkf.getjTableKnjige().getSelectedRow();
                if (selRed == -1) {
                    JOptionPane.showMessageDialog(pkf, "Sistem ne može da učita knjigu", "GREŠKA!", JOptionPane.ERROR_MESSAGE);
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
        pkf.addBtnPretraziActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sifraKnjige = pkf.getjTextFieldSifraKnjige().getText().trim();
                String naziv = pkf.getjTextFieldNaziv().getText().trim();
                List<Autor> autori = pkf.getjListAutori().getSelectedValuesList();
                ModelTabeleKnjige mtk = (ModelTabeleKnjige) pkf.getjTableKnjige().getModel();
                List<Knjiga> filtriranaLista = mtk.pretrazi(sifraKnjige, naziv, autori);
                if (filtriranaLista.size() != 0) {
                    JOptionPane.showMessageDialog(pkf, "Sistem je našao knjige po zadatoj vrednosti", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(pkf, "Sistem ne može da nađe knjige po zadatoj vrednosti", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        pkf.addBtnResetujActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pripremiFormu();
            }
        });
    }

    private void addMouseListeners() {
        pkf.getjTableKnjige().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int red = pkf.getjTableKnjige().getSelectedRow();
                if (red != -1) {
                    ModelTabeleKnjige mtk = (ModelTabeleKnjige) pkf.getjTableKnjige().getModel();
                    Knjiga k = mtk.getLista().get(red);
                    List<Primerak> primerci = k.getPrimerci();
                    //List<Primerak> primerci = Komunikacija.getInstance().ucitajPrimerke(k.getSifraKnjige());
                    ModelTabelePrimerak mtp = new ModelTabelePrimerak(primerci);
                    pkf.getjTablePrimerci().setModel(mtp);
                }
            }
        });
    }

}
