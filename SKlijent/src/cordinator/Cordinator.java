/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cordinator;

import domen.Bibliotekar;
import forme.GlavnaForma;
import forme.LoginForma;
import kontroleri.GlavnaFormaController;
import kontroleri.LoginController;

/**
 *
 * @author milic
 */
public class Cordinator {

    private static Cordinator instance;
    private Bibliotekar ulogovani;
    private LoginController loginController;
    private GlavnaFormaController glavnaFormaController;

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

    public Bibliotekar getUlogovani() {
        return ulogovani;
    }

    public void setUlogovani(Bibliotekar ulogovani) {
        this.ulogovani = ulogovani;
    }
    
    

}
