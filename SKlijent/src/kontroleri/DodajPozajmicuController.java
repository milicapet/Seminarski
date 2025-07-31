/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import cordinator.Cordinator;
import domen.Clan;
import domen.Knjiga;
import domen.Pozajmica;
import domen.Primerak;
import forme.DodajPozajmicuForma;
import forme.FormaMod;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import komunikacija.Komunikacija;

/**
 *
 * @author milic
 */
public class DodajPozajmicuController {

    private final DodajPozajmicuForma dpf;

    public DodajPozajmicuController(DodajPozajmicuForma dpf) {
        this.dpf = dpf;
        addActionListeners();
    }

    private void addActionListeners() {
        dpf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Knjiga odabranaKnjiga = (Knjiga) dpf.getjComboBoxKnjige().getSelectedItem();
                if (odabranaKnjiga != null) {
                    dpf.getjComboBoxPrimerci().removeAllItems();
                    List<Primerak> primerci = Komunikacija.getInstance().ucitajPrimerke(odabranaKnjiga.getSifraKnjige());
                    for (Primerak p : primerci) {
                        dpf.getjComboBoxPrimerci().addItem(p);
                    }
                }
            }
        });

        dpf.addBtnDodajActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {/*
                int sifraKnjige = Integer.parseInt(dkf.getjTextFieldSifraKnjige().getText().trim());
                int sifraPrimerka = Integer.parseInt(dkf.getjTextFieldSifraPrimerka().getText().trim());
                int godIzdanja = Integer.parseInt(dkf.getjTextFieldGodinaIzdanja().getText().trim());
                int brIzdanja = Integer.parseInt(dkf.getjTextFieldBrojIzdanja().getText().trim());
                Izdavac i = (Izdavac) dkf.getjComboBoxIzdavaci().getSelectedItem();
                Knjiga k = new Knjiga();
                k.setSifraKnjige(sifraKnjige);
                Primerak p = new Primerak(k, sifraPrimerka, godIzdanja, brIzdanja, i);
                ModelTabelePrimerak mtp = (ModelTabelePrimerak) dkf.getjTablePrimerci().getModel();
                mtp.dodajPrimerak(p);*/
            }
        });
        /*
        dkf.addBtnDodajKnjiguActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sifraKnjige = Integer.parseInt(dkf.getjTextFieldSifraKnjige().getText().trim());
                String naziv = dkf.getjTextFieldNaziv().getText().trim();
                String opis = dkf.getjTextAreaOpis().getText().trim();
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
        dpf.addBtnIzmeniKnjiguActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                
                    int sifraKnjige = Integer.parseInt(dkf.getjTextFieldSifraKnjige().getText().trim());
                    String naziv = dkf.getjTextFieldNaziv().getText().trim();
                    String opis = dkf.getjTextAreaOpis().getText().trim();
                    Autor autor = (Autor) dkf.getjComboBoxAutori().getSelectedItem();
                    ModelTabelePrimerak mtp = (ModelTabelePrimerak) dkf.getjTablePrimerci().getModel();
                    List<Primerak> primerci = mtp.getLista();
                    Knjiga k = new Knjiga(sifraKnjige, naziv, opis, primerci);
                try {
                    Komunikacija.getInstance().izmeniKnjigu(k);
                    JOptionPane.showMessageDialog(null, "Sistem je zapamtio knjigu", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                    Cordinator.getInstance().osveziFormuPrikazKnjiga();
                    dkf.dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Sistem ne može da izmeni knjigu", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                }
            }
        });*/
    }

    public void otvoriFormu(FormaMod mod) {
        popuniComboBoxeve();
        pripremiFormu(mod);
        dpf.setVisible(true);
    }

    private void pripremiFormu(FormaMod mod) {
        switch (mod) {
            case DODAJ:
                dpf.getjButtonIzmeni().setVisible(false);
                dpf.getjButtonDodaj().setVisible(true);
                dpf.getjButtonDodaj().setEnabled(true);

                break;
            case IZMENI:
                dpf.getjButtonDodaj().setVisible(false);
                dpf.getjButtonIzmeni().setVisible(true);
                dpf.getjButtonIzmeni().setEnabled(true);/*
                Pozajmica p = (Pozajmica) Cordinator.getInstance().vratiParam("pozajmica_za_izmenu");
                dpf.getjTextFieldSifraKnjige().setText(String.valueOf(k.getSifraKnjige()));
                dpf.getjTextFieldNaziv().setText(k.getNaziv());
                dpf.getjTextAreaOpis().setText(k.getOpis());
                //dkf.getjComboBoxAutori().setSelectedItem(k.get);
                 */

                break;
            default:
                throw new AssertionError();
        }
    }

    private void popuniComboBoxeve() {
        List<Clan> clanovi = Komunikacija.getInstance().ucitajClanove();
        dpf.getjComboBoxClanovi().removeAllItems();
        for (Clan c : clanovi) {
            dpf.getjComboBoxClanovi().addItem(c);
        }

        List<Knjiga> knjige = Komunikacija.getInstance().ucitajKnjige();
        dpf.getjComboBoxKnjige().removeAllItems();
        for (Knjiga k : knjige) {
            dpf.getjComboBoxKnjige().addItem(k);
        }
    }

}
