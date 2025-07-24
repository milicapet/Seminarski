/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Bibliotekar;
import forme.LoginForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author milic
 */
public class LoginController {

    private final LoginForma lf;

    public LoginController(LoginForma lf) {
        this.lf = lf;
        addActionListeners();
    }

    private void addActionListeners() {
        lf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prijava(e);
            }

            private void prijava(ActionEvent e) {
                String korisnickoIme = lf.getjTextFieldKorisnickoIme().getText().trim();
                String sifra = String.valueOf(lf.getjPasswordField1().getPassword());

                Komunikacija.getInstance().konekcija();
                Bibliotekar ulogovani = Komunikacija.getInstance().login(korisnickoIme, sifra);

                if (ulogovani == null) {
                    JOptionPane.showMessageDialog(lf, "Prijava neuspešna! ", "GREŠKA", JOptionPane.ERROR_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(lf, "Prijava uspešna! ", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                    lf.dispose();
                }
            }
        });

    }

    public void otvoriFormu() {
        lf.setVisible(true);
    }

}
