/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import cordinator.Cordinator;
import forme.GlavnaForma;

/**
 *
 * @author milic
 */
public class GlavnaFormaController {

    private final GlavnaForma gf;

    public GlavnaFormaController(GlavnaForma gf) {
        this.gf = gf;
        addActionListeners();
    }

    private void addActionListeners() {
        
        
    }

    public void otvoriFormu() {
        gf.setVisible(true);
        gf.getjLabelUlogovani().setText(Cordinator.getInstance().getUlogovani().getKorisnickoIme());
    }

}
