/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cordinator;

import domen.Bibliotekar;
import forme.DodajClanaForma;
import forme.DodajKnjiguForma;
import forme.DodajPrimerakForma;
import forme.FormaMod;
import forme.GlavnaForma;
import forme.LoginForma;
import forme.PrikazClanovaForma;
import forme.PrikazKnjigaForma;
import java.util.HashMap;
import java.util.Map;
import kontroleri.DodajClanaController;
import kontroleri.DodajKnjiguController;
import kontroleri.DodajPrimerakController;
import kontroleri.GlavnaFormaController;
import kontroleri.LoginController;
import kontroleri.PrikazClanovaController;
import kontroleri.PrikazKnjigaController;

/**
 *
 * @author milic
 */
public class Cordinator {

    private static Cordinator instance;
    private Bibliotekar ulogovani;
    private LoginController loginController;
    private GlavnaFormaController glavnaFormaController;
    private PrikazClanovaController prikazClanovaController;
    private DodajClanaController dodajClanaController;
    private Map<String, Object> parametri;
    private PrikazKnjigaController prikazKnjigaController;
    private DodajKnjiguController dodajKnjiguController;
    private DodajPrimerakController dodajPrimerakController;

    private Cordinator() {
        parametri = new HashMap<>();
    }

    public static Cordinator getInstance() {
        if (instance == null) {
            instance = new Cordinator();
        }
        return instance;
    }

    public void otvoriLoginFormu() {
        loginController = new LoginController(new LoginForma());
        loginController.otvoriFormu();
    }

    public void otvoriGlavnuFormu() {
        glavnaFormaController = new GlavnaFormaController(new GlavnaForma());
        glavnaFormaController.otvoriFormu();
    }

    public void otvoriPrikazClanovaFormu() {
        prikazClanovaController = new PrikazClanovaController(new PrikazClanovaForma());
        prikazClanovaController.otvoriFormu();
    }

    public void otvoriDodajClanaFormu() {
        dodajClanaController = new DodajClanaController(new DodajClanaForma());
        dodajClanaController.otvoriFormu(FormaMod.DODAJ);
    }

    public Bibliotekar getUlogovani() {
        return ulogovani;
    }

    public void setUlogovani(Bibliotekar ulogovani) {
        this.ulogovani = ulogovani;
    }

    public void dodajParam(String s, Object o) {
        parametri.put(s, o);
    }

    public Object vratiParam(String s) {
        return parametri.get(s);
    }

    public void otvoriIzmeniClanaFormu() {
        dodajClanaController = new DodajClanaController(new DodajClanaForma());
        dodajClanaController.otvoriFormu(FormaMod.IZMENI);
    }

    public void osveziFormuPrikazClanova() {
        prikazClanovaController.osveziFormu();
    }

    public void otvoriPrikazKnjigaFormu() {
        prikazKnjigaController = new PrikazKnjigaController(new PrikazKnjigaForma());
        prikazKnjigaController.otvoriFormu();
    }

    public void otvoriDodajKnjiguFormu() {
        dodajKnjiguController = new DodajKnjiguController(new DodajKnjiguForma());
        dodajKnjiguController.otvoriFormu(FormaMod.DODAJ);
    }

    public void otvoriIzmeniPrimerakFormu() {
        dodajPrimerakController = new DodajPrimerakController(new DodajPrimerakForma());
        dodajPrimerakController.otvoriFormu(FormaMod.IZMENI);
    }

    public void otvoriDodajPrimerakFormu() {
        dodajPrimerakController = new DodajPrimerakController(new DodajPrimerakForma());
        dodajPrimerakController.otvoriFormu(FormaMod.DODAJ);
    }

    public void otvoriDodajKnjiguFormu(FormaMod formaMod) {
        dodajKnjiguController = new DodajKnjiguController(new DodajKnjiguForma());
        dodajKnjiguController.otvoriFormu(formaMod);
    }

    public void osveziFormuPrikazKnjiga() {
        prikazKnjigaController.osveziFormu();
    }

}
