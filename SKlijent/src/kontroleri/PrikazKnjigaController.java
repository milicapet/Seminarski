/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Knjiga;
import forme.PrikazKnjigaForma;
import forme.model.ModelTabeleKnjige;
import java.util.List;
import komunikacija.Komunikacija;

/**
 *
 * @author milic
 */
public class PrikazKnjigaController {
    private final PrikazKnjigaForma pkf;

    public PrikazKnjigaController(PrikazKnjigaForma pkf) {
        this.pkf = pkf;
        addActionListeners();
    }
    
    public void otvoriFormu() {
        pripremiFormu();
        pkf.setVisible(true);
    }
    
    public void osveziFormu() {
        pripremiFormu();
    }

    private void pripremiFormu() {
        List<Knjiga> knjige = Komunikacija.getInstance().ucitajKnjige();
        ModelTabeleKnjige mtk = new ModelTabeleKnjige(knjige);
        pkf.getjTableKnjige().setModel(mtk);
    }

    private void addActionListeners() {
     
        
        
    }
    
}
