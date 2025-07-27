/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Knjiga;
import domen.Primerak;
import forme.PrikazKnjigaForma;
import forme.model.ModelTabeleKnjige;
import forme.model.ModelTabelePrimerak;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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
        addMouseListeners();
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

        List<Primerak> primerci = new ArrayList<>();
        ModelTabelePrimerak mtp = new ModelTabelePrimerak(primerci);
        pkf.getjTablePrimerci().setModel(mtp);
    }

    private void addActionListeners() {

    }

    private void addMouseListeners() {
        pkf.getjTableKnjige().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int red = pkf.getjTableKnjige().getSelectedRow();
                if(red!=-1){
                    ModelTabeleKnjige mtk = (ModelTabeleKnjige) pkf.getjTableKnjige().getModel();
                    Knjiga k = mtk.getLista().get(red);
                    List<Primerak> primerci = Komunikacija.getInstance().ucitajPrimerke(k.getSifraKnjige());
                    ModelTabelePrimerak mtp = new ModelTabelePrimerak(primerci);
                    pkf.getjTablePrimerci().setModel(mtp);
                }
                
                
            }
        
         
        
        });
    }

}
