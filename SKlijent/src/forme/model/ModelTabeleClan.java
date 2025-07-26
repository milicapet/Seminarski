/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import domen.Clan;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author milic
 */
public class ModelTabeleClan extends AbstractTableModel {

    List<Clan> lista;
    String[] kolone = {"brojClanskeKarte", "ime", "prezime", "adresa", "brojTelefona"};

    public ModelTabeleClan(List<Clan> lista) {
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        Clan c = lista.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return c.getBrojClanskeKarte();
            case 1:
                return c.getIme();
            case 2:
                return c.getPrezime();
            case 3:
                return c.getAdresa();
            case 4:
                return c.getBrojTelefona();
            default:
                return "return";
        }

    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

}
