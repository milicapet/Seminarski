/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import domen.Knjiga;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author milic
 */
public class ModelTabeleKnjige extends AbstractTableModel {

    List<Knjiga> lista;
    String[] kolone = {"sifraKnjige", "naziv", "opis"};

    public ModelTabeleKnjige(List<Knjiga> lista) {
        this.lista = lista;
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
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Knjiga k = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return k.getSifraKnjige();
            case 1:
                return k.getNaziv();
            case 2:
                return k.getOpis();
            default:
                return "return";
        }
    }

    public List<Knjiga> getLista() {
        return lista;
    }

    public void setLista(List<Knjiga> lista) {
        this.lista = lista;
    }

}
