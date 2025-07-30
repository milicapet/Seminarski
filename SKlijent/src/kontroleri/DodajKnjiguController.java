/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import cordinator.Cordinator;
import domen.Autor;
import domen.Izdavac;
import domen.Knjiga;
import domen.Primerak;
import forme.DodajKnjiguForma;
import forme.FormaMod;
import forme.model.ModelTabelePrimerak;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author milic
 */
public class DodajKnjiguController {

    private final DodajKnjiguForma dkf;

    public DodajKnjiguController(DodajKnjiguForma dkf) {
        this.dkf = dkf;
        addActionListeners();
    }

    private void addActionListeners() {
        dkf.addBtnDodajPrimerakActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sifraKnjige = Integer.parseInt(dkf.getjTextFieldSifraKnjige().getText().trim());
                int sifraPrimerka = Integer.parseInt(dkf.getjTextFieldSifraPrimerka().getText().trim());
                int godIzdanja = Integer.parseInt(dkf.getjTextFieldGodinaIzdanja().getText().trim());
                int brIzdanja = Integer.parseInt(dkf.getjTextFieldBrojIzdanja().getText().trim());
                Izdavac i = (Izdavac) dkf.getjComboBoxIzdavaci().getSelectedItem();
                Knjiga k = new Knjiga();
                k.setSifraKnjige(sifraKnjige);
                Primerak p = new Primerak(k, sifraPrimerka, godIzdanja, brIzdanja, i);
                ModelTabelePrimerak mtp = (ModelTabelePrimerak) dkf.getjTablePrimerci().getModel();
                mtp.dodajPrimerak(p);
            }
        });
        dkf.addBtnObrisiPrimerakActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selRed = dkf.getjTablePrimerci().getSelectedRow();
                if (selRed != -1) {
                    ModelTabelePrimerak mtp = (ModelTabelePrimerak) dkf.getjTablePrimerci().getModel();
                    Primerak p = mtp.getLista().get(selRed);
                    mtp.obrisiPrimerak(p);
                } else {
                    JOptionPane.showMessageDialog(dkf, "Nije selektovan red za brisanje! ", "GRESKA", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        dkf.addBtnDodajKnjiguActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sifraKnjige = Integer.parseInt(dkf.getjTextFieldSifraKnjige().getText().trim());
                String naziv = dkf.getjTextFieldNaziv().getText().trim();
                String opis = dkf.getjTextFieldOpis().getText().trim();
                Autor autor = (Autor) dkf.getjComboBoxAutori().getSelectedItem();
                ModelTabelePrimerak mtp = (ModelTabelePrimerak) dkf.getjTablePrimerci().getModel();
                List<Primerak> primerci = mtp.getLista();
                Knjiga k = new Knjiga(sifraKnjige, naziv, opis, primerci);
                try {
                    Komunikacija.getInstance().dodajKnjigu(k);
                    JOptionPane.showMessageDialog(dkf, "Sistem je kreirao knjigu.", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                    dkf.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Sistem ne može da kreira knjigu", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        dkf.addBtnIzmeniKnjiguActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sifraKnjige = Integer.parseInt(dkf.getjTextFieldSifraKnjige().getText().trim());
                String naziv = dkf.getjTextFieldNaziv().getText().trim();
                String opis = dkf.getjTextFieldOpis().getText().trim();
                Autor autor = (Autor) dkf.getjComboBoxAutori().getSelectedItem();
                ModelTabelePrimerak mtp = (ModelTabelePrimerak) dkf.getjTablePrimerci().getModel();
                List<Primerak> primerci = mtp.getLista();
                Knjiga k = new Knjiga(sifraKnjige, naziv, opis, primerci);
                try {
                    Komunikacija.getInstance().izmeniKnjigu(k);
                    JOptionPane.showMessageDialog(null, "Sistem je zapamtio knjigu", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                    dkf.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Sistem ne može da izmeni knjigu", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

    public void otvoriFormu(FormaMod mod) {
        ModelTabelePrimerak mtp = new ModelTabelePrimerak(new ArrayList<>());
        dkf.getjTablePrimerci().setModel(mtp);
        popuniComboBoxeve();
        pripremiFormu(mod);
        dkf.setVisible(true);
    }

    private void pripremiFormu(FormaMod mod) {
        switch (mod) {
            case DODAJ:
                dkf.getjButtonIzmeniKnjigu().setVisible(false);
                dkf.getjButtonDodajKnjigu().setVisible(true);
                dkf.getjButtonDodajKnjigu().setEnabled(true);

                break;
            case IZMENI:
                dkf.getjButtonDodajKnjigu().setVisible(false);
                dkf.getjButtonIzmeniKnjigu().setVisible(true);
                dkf.getjButtonIzmeniKnjigu().setEnabled(true);
                Knjiga k = (Knjiga) Cordinator.getInstance().vratiParam("knjiga_za_izmenu");
                dkf.getjTextFieldSifraKnjige().setText(String.valueOf(k.getSifraKnjige()));
                dkf.getjTextFieldNaziv().setText(k.getNaziv());
                dkf.getjTextFieldOpis().setText(k.getOpis());
                //dkf.getjComboBoxAutori().setSelectedItem(k.get);
                ModelTabelePrimerak mtp = new ModelTabelePrimerak(k.getPrimerci());
                dkf.getjTablePrimerci().setModel(mtp);                
                
                break;
            default:
                throw new AssertionError();
        }
    }

    private void popuniComboBoxeve() {
        List<Autor> autori = Komunikacija.getInstance().ucitajAutore();
        dkf.getjComboBoxAutori().removeAllItems();
        dkf.getjComboBoxIzdavaci().removeAllItems();
        for (Autor a : autori) {
            dkf.getjComboBoxAutori().addItem(a);
        }
        List<Izdavac> izdavaci = Komunikacija.getInstance().ucitajIzdavace();
        for (Izdavac i : izdavaci) {
            dkf.getjComboBoxIzdavaci().addItem(i);
        }
    }

}
