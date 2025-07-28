/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Autor;
import domen.Izdavac;
import forme.DodajKnjiguForma;
import forme.FormaMod;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
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
        dkf.addBtnDodajKnjiguActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                int brClanskeKarte = Integer.parseInt(dkf.getjTextFieldBrClanskeKarte().getText().trim());
                String ime = dkf.getjTextFieldIme().getText().trim();
                String prezime = dkf.getjTextFieldPrezime().getText().trim();
                String adresa = dkf.getjTextFieldAdresa().getText().trim();
                String brTel = dkf.getjTextFieldBrTel().getText().trim();
                Clan c = new Clan(brClanskeKarte, ime, prezime, adresa, brTel);
                try {
                    Komunikacija.getInstance().dodajClana(c);
                    JOptionPane.showMessageDialog(dcf, "Sistem je kreirao člana", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                    dkf.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Sistem ne može da kreira člana", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                }*/
            }
        });
        dkf.addBtnIzmeniKnjiguActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {/*
                int brClanskeKarte = Integer.parseInt(dcf.getjTextFieldBrClanskeKarte().getText().trim());
                String ime = dkf.getjTextFieldIme().getText().trim();
                String prezime = dkf.getjTextFieldPrezime().getText().trim();
                String adresa = dkf.getjTextFieldAdresa().getText().trim();
                String brTel = dkf.getjTextFieldBrTel().getText().trim();
                Clan c = new Clan(brClanskeKarte, ime, prezime, adresa, brTel);
                try {
                    Komunikacija.getInstance().izmeniClana(c);
                    JOptionPane.showMessageDialog(null, "Sistem je zapamtio člana", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                    dkf.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Sistem ne može da izmeni člana", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                }*/
            }
        });

    }

    public void otvoriFormu(FormaMod mod) {
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
                dkf.getjButtonIzmeniKnjigu().setEnabled(true);/*
                Clan c = (Clan) Cordinator.getInstance().vratiParam("clan");
                dkf.getjTextFieldBrClanskeKarte().setText(String.valueOf(c.getBrojClanskeKarte()));
                dkf.getjTextFieldIme().setText(c.getIme());
                dkf.getjTextFieldPrezime().setText(c.getPrezime());
                dkf.getjTextFieldAdresa().setText(c.getAdresa());
                dkf.getjTextFieldBrTel().setText(c.getBrojTelefona());*/
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
