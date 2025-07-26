/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import cordinator.Cordinator;
import domen.Clan;
import forme.DodajClanaForma;
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
                    JOptionPane.showMessageDialog(null, "Sistem ne moeže da kreira člana", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public void otvoriFormu() {
        dcf.setVisible(true);
    }

}
