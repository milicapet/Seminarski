/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import cordinator.Cordinator;
import domen.Clan;
import forme.DodajClanaForma;
import forme.FormaMod;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author milic
 */
public class DodajClanaController {

    private final DodajClanaForma dcf;

    public DodajClanaController(DodajClanaForma dcf) {
        this.dcf = dcf;
        addActionListeners();
    }

    private void addActionListeners() {
        dcf.addBtnDodajActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int brClanskeKarte = Integer.parseInt(dcf.getjTextFieldBrClanskeKarte().getText().trim());
                String ime = dcf.getjTextFieldIme().getText().trim();
                String prezime = dcf.getjTextFieldPrezime().getText().trim();
                String adresa = dcf.getjTextFieldAdresa().getText().trim();
                String brTel = dcf.getjTextFieldBrTel().getText().trim();
                Clan c = new Clan(brClanskeKarte, ime, prezime, adresa, brTel);
                try {
                    Komunikacija.getInstance().dodajClana(c);
                    JOptionPane.showMessageDialog(dcf, "Sistem je kreirao člana", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                    dcf.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Sistem ne može da kreira člana", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        dcf.addBtnIzmeniActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int brClanskeKarte = Integer.parseInt(dcf.getjTextFieldBrClanskeKarte().getText().trim());
                String ime = dcf.getjTextFieldIme().getText().trim();
                String prezime = dcf.getjTextFieldPrezime().getText().trim();
                String adresa = dcf.getjTextFieldAdresa().getText().trim();
                String brTel = dcf.getjTextFieldBrTel().getText().trim();
                Clan c = new Clan(brClanskeKarte, ime, prezime, adresa, brTel);
                try {
                    Komunikacija.getInstance().izmeniClana(c);
                    JOptionPane.showMessageDialog(null, "Sistem je zapamtio člana", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                    dcf.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Sistem ne može da izmeni člana", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

    public void otvoriFormu(FormaMod mod) {
        pripremiFormu(mod);
        dcf.setVisible(true);
    }

    private void pripremiFormu(FormaMod mod) {
        switch (mod) {
            case DODAJ:
                dcf.getjButtonIzmeni().setVisible(false);
                dcf.getjButtonDodaj().setVisible(true);
                dcf.getjButtonDodaj().setEnabled(true);
                dcf.setTitle("Dodaj člana forma");
                break;
            case IZMENI:
                dcf.getjButtonDodaj().setVisible(false);
                dcf.getjButtonIzmeni().setVisible(true);
                dcf.getjButtonIzmeni().setEnabled(true);
                dcf.setTitle("Izmeni člana forma");
                Clan c = (Clan) Cordinator.getInstance().vratiParam("clan");
                dcf.getjTextFieldBrClanskeKarte().setText(String.valueOf(c.getBrojClanskeKarte()));
                dcf.getjTextFieldIme().setText(c.getIme());
                dcf.getjTextFieldPrezime().setText(c.getPrezime());
                dcf.getjTextFieldAdresa().setText(c.getAdresa());
                dcf.getjTextFieldBrTel().setText(c.getBrojTelefona());
                break;
            default:
                throw new AssertionError();
        }
    }

}
