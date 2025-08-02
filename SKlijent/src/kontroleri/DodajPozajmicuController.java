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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
        dpf.addCmbKnjigeActionListener(new ActionListener() {
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
            public void actionPerformed(ActionEvent e) {
                try {
                    Clan clan = (Clan) dpf.getjComboBoxClanovi().getSelectedItem();
                    Knjiga knjiga = (Knjiga) dpf.getjComboBoxKnjige().getSelectedItem();
                    Primerak primerak = (Primerak) dpf.getjComboBoxPrimerci().getSelectedItem();
                    System.out.println("PRIMERAK IZ CMB " + primerak + " Sif Knjige " + primerak.getKnjiga().getSifraKnjige());
                    String datUzStr = dpf.getjTextFieldDatUzimanja().getText().trim();
                    String datVrStr = dpf.getjTextFieldDatVracanja().getText().trim();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                    Date datumUzimanja = sdf.parse(datUzStr);
                    Date datumVracanja = null;
                    if (datVrStr != null && !datVrStr.trim().isEmpty()) {
                        datumVracanja = sdf.parse(datVrStr);
                    }
                    Pozajmica p = new Pozajmica(primerak, clan, datumUzimanja, datumVracanja);
                    Komunikacija.getInstance().dodajPozajmicu(p);
                    JOptionPane.showMessageDialog(dpf, "Sistem je zapamtio pozajmicu.", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                    dpf.dispose();
                } catch (ParseException ex) {
                    ex.printStackTrace();
                    System.out.println("DATUM FORMATIRANJE GRESKA");
                    Logger.getLogger(DodajPozajmicuController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Sistem ne može da zapamti pozajmicu", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        dpf.addBtnIzmeniActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Clan clan = (Clan) dpf.getjComboBoxClanovi().getSelectedItem();
                    Knjiga knjiga = (Knjiga) dpf.getjComboBoxKnjige().getSelectedItem();
                    Primerak primerak = (Primerak) dpf.getjComboBoxPrimerci().getSelectedItem();
                    System.out.println("PRIMERAK IZ CMB " + primerak + " Sif Knjige " + primerak.getKnjiga().getSifraKnjige());
                    String datUzStr = dpf.getjTextFieldDatUzimanja().getText().trim();
                    String datVrStr = dpf.getjTextFieldDatVracanja().getText().trim();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                    Date datumUzimanja = sdf.parse(datUzStr);
                    Date datumVracanja = null;
                    if (datVrStr != null && !datVrStr.trim().isEmpty()) {
                        datumVracanja = sdf.parse(datVrStr);
                    }
                    Pozajmica p = new Pozajmica(primerak, clan, datumUzimanja, datumVracanja);

                    Komunikacija.getInstance().izmeniPozajmicu(p);
                    JOptionPane.showMessageDialog(null, "Sistem je zapamtio pozajmicu", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                    Cordinator.getInstance().osveziFormuPrikazPozajmica();
                    dpf.dispose();
                } catch (ParseException ex) {
                    ex.printStackTrace();
                    System.out.println("DATUM FORMATIRANJE GRESKA");
                    Logger.getLogger(DodajPozajmicuController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Sistem ne može da zapamti pozajmicu", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public void otvoriFormu(FormaMod mod) {
        if (mod == FormaMod.DODAJ) {
            JOptionPane.showMessageDialog(null, "Sistem je kreirao pozajmicu", "USPEH", JOptionPane.INFORMATION_MESSAGE);
        }
        if (mod == FormaMod.IZMENI) {
            JOptionPane.showMessageDialog(null, "Sistem je učitao pozajmicu", "USPEH", JOptionPane.INFORMATION_MESSAGE);
        }
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
                dpf.setTitle("Dodaj pozajmicu forma");
                break;
            case IZMENI:
                dpf.getjButtonDodaj().setVisible(false);
                dpf.getjButtonIzmeni().setVisible(true);
                dpf.getjButtonIzmeni().setEnabled(true);
                dpf.setTitle("Izmeni pozajmicu forma");
                Pozajmica p = (Pozajmica) Cordinator.getInstance().vratiParam("pozajmica_za_izmenu");
                dpf.getjComboBoxClanovi().setSelectedItem(p.getClan());
                dpf.getjComboBoxKnjige().setSelectedItem(p.getPrimerak().getKnjiga());
                dpf.getjComboBoxPrimerci().setSelectedItem(p.getPrimerak());
                dpf.getjTextFieldDatUzimanja().setText(formatirajDatum(p.getDatumUzimanja()));
                dpf.getjComboBoxClanovi().setEnabled(false);
                dpf.getjComboBoxKnjige().setEnabled(false);
                dpf.getjComboBoxPrimerci().setEnabled(false);
                dpf.getjTextFieldDatUzimanja().setEnabled(false);
                dpf.getjTextFieldDatVracanja().setText(formatirajDatum(p.getDatumVracanja()));
                dpf.getjComboBoxClanovi().setEnabled(false);
                dpf.getjComboBoxKnjige().setEnabled(false);
                dpf.getjComboBoxPrimerci().setEnabled(false);
                dpf.getjTextFieldDatUzimanja().setEnabled(false);
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

    private String formatirajDatum(Date datum) {
        if (datum == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return sdf.format(datum);
    }

}
