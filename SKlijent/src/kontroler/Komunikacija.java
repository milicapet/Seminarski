/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.Zahtev;
import komunikacija.Odgovor;

/**
 *
 * @author milic
 */
public class Komunikacija {

    private static Komunikacija instance;
    private Socket s;

    private Komunikacija() {
        try {
            s = new Socket("localhost", 9000);
        } catch (IOException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Komunikacija getInstance() {
        if (instance == null) {
            instance = new Komunikacija();
        }
        return instance;
    }
    
    public Odgovor primiOdgovor() {
        try {
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            return (Odgovor) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void posaljiZahtev(Zahtev kz) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(kz);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
