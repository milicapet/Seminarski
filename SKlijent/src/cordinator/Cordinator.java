/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cordinator;

import domen.Bibliotekar;
import forme.DodajClanaForma;
import forme.GlavnaForma;
import forme.LoginForma;
import forme.PrikazClanovaForma;
import kontroleri.DodajClanaController;
import kontroleri.GlavnaFormaController;
import kontroleri.LoginController;
import kontroleri.PrikazClanovaController;

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

    private Cordinator() {
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
        dodajClanaController.otvoriFormu();
    }

    public Bibliotekar getUlogovani() {
        return ulogovani;
    }

    public void setUlogovani(Bibliotekar ulogovani) {
        this.ulogovani = ulogovani;
    }


}
