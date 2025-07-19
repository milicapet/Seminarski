/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import forme.ServerskaForma;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author milic
 */
public class OsveziNit extends Thread {

    ServerskaForma sf;

    public OsveziNit(ServerskaForma sf) {
        this.sf = sf;
    }

    @Override
    public void run() {
        while (true) {
            sf.izvrsiUpit();
            try {
                sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(OsveziNit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
