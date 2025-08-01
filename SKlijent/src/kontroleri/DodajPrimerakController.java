/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import cordinator.Cordinator;
import domen.Izdavac;
import domen.Knjiga;
import domen.Primerak;
import forme.DodajPrimerakForma;
import forme.FormaMod;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author milic
 */
public class DodajPrimerakController {

    private final DodajPrimerakForma dpf;

    public DodajPrimerakController(DodajPrimerakForma dpf) {
        this.dpf = dpf;
        addActionListeners();
    }

    public void otvoriFormu(FormaMod mod) {
        pripremiFormu(mod);
        dpf.setVisible(true);
    }

    private void pripremiFormu(FormaMod mod) {
        dpf.getjTextFieldSifraKnjige().setEnabled(false);
        Primerak p = (Primerak) Cordinator.getInstance().vratiParam("primerak");
        dpf.getjTextFieldSifraKnjige().setText(String.valueOf(p.getKnjiga().getSifraKnjige()));

        popuniComboBox();
        switch (mod) {
            case DODAJ:
                dpf.getjButtonIzmeni().setVisible(false);
                dpf.getjButtonDodaj().setVisible(true);
                dpf.getjButtonDodaj().setEnabled(true);
                dpf.setTitle("Dodaj primerak forma");
                break;
            case IZMENI:
                dpf.getjButtonDodaj().setVisible(false);
                dpf.getjButtonIzmeni().setVisible(true);
                dpf.getjButtonIzmeni().setEnabled(true);
                dpf.setTitle("Izmeni primerak forma");
                dpf.getjTextFieldSifraPrimerka().setText(String.valueOf(p.getSifraPrimerka()));
                dpf.getjTextFieldBrIzdanja().setEnabled(false);
                dpf.getjTextFieldGodIzdanja().setText(String.valueOf(p.getGodinaIzdanja()));
                dpf.getjTextFieldBrIzdanja().setText(String.valueOf(p.getBrojIzdanja()));
                dpf.getJComboBoxIzdavac().setSelectedItem(p.getIzdavac());

                break;
            default:
                throw new AssertionError();
        }
    }

    private void popuniComboBox() {
        List<Izdavac> izdavaci = Komunikacija.getInstance().ucitajIzdavace();
        dpf.getJComboBoxIzdavac().removeAllItems();
        for (Izdavac i : izdavaci) {
            dpf.getJComboBoxIzdavac().addItem(i);
        }
    }

    private void addActionListeners() {
        dpf.addBtnDodajActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sifraPrimerka = Integer.parseInt(dpf.getjTextFieldSifraPrimerka().getText().trim());
                int godIzdanja = Integer.parseInt(dpf.getjTextFieldGodIzdanja().getText().trim());
                int brIzdanja = Integer.parseInt(dpf.getjTextFieldBrIzdanja().getText().trim());
                Izdavac izdavac = (Izdavac) dpf.getJComboBoxIzdavac().getSelectedItem();
                Primerak p = new Primerak();
                p.setSifraPrimerka(sifraPrimerka);
                p.setGodinaIzdanja(godIzdanja);
                p.setBrojIzdanja(brIzdanja);
                p.setIzdavac(izdavac);

                try {
                    Komunikacija.getInstance().dodajPrimerak(p);
                    JOptionPane.showMessageDialog(dpf, "Sistem je kreirao primerak", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                    dpf.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Sistem ne može da kreira primerak", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        dpf.addBtnIzmeniActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sifraKnjige = Integer.parseInt(dpf.getjTextFieldSifraKnjige().getText().trim());
                int sifraPrimerka = Integer.parseInt(dpf.getjTextFieldSifraPrimerka().getText().trim());
                int godIzdanja = Integer.parseInt(dpf.getjTextFieldGodIzdanja().getText().trim());
                int brIzdanja = Integer.parseInt(dpf.getjTextFieldBrIzdanja().getText().trim());
                Izdavac izdavac = (Izdavac) dpf.getJComboBoxIzdavac().getSelectedItem();
                Knjiga knjiga = new Knjiga();
                knjiga.setSifraKnjige(sifraKnjige);
                Primerak p = new Primerak(knjiga, sifraPrimerka, godIzdanja, brIzdanja, izdavac);

                try {
                    Komunikacija.getInstance().izmeniPrimerak(p);
                    JOptionPane.showMessageDialog(null, "Sistem je izmenio primerak", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                    dpf.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Sistem ne može da izmeni primerak", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

}
