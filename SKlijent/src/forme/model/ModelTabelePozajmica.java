/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import domen.Pozajmica;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author milic
 */
public class ModelTabelePozajmica extends AbstractTableModel {

    List<Pozajmica> lista;
    String[] kolone = {"Šifra knjige", "Šifra primerka", "Broj članske karte", "Datum uzimanja", "Datum vraćanja"};

    public ModelTabelePozajmica(List<Pozajmica> lista) {
        this.lista = lista;
    }

    public List<Pozajmica> getLista() {
        return lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pozajmica p = lista.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return p.getPrimerak().getKnjiga().getSifraKnjige();
            case 1:
                return p.getPrimerak().getSifraPrimerka();
            case 2:
                return p.getClan().getBrojClanskeKarte();
            case 3:
                return formatirajDatum(p.getDatumUzimanja());
            case 4:
                return formatirajDatum(p.getDatumVracanja());
            default:
                return "return";
        }

    }

    private String formatirajDatum(Date datum) {
        if (datum == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return sdf.format(datum);
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void obrisiPozajmicu(Pozajmica p) {
        lista.remove(p);
        fireTableDataChanged();
    }

}
