/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.Bibliotekar;
import operacija.login.LoginOperacija;

/**
 *
 * @author milic
 */
public class Controller {

    private static Controller instance;

    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public Bibliotekar login(Bibliotekar b) throws Exception {
        LoginOperacija operacija = new LoginOperacija();
        operacija.izvrsi(b, null);
        System.out.println("KLASA Controller: " + operacija.getBibliotekar());
        return operacija.getBibliotekar();
    }

}
