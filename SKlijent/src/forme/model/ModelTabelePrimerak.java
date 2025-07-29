/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import domen.Primerak;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author milic
 */
public class ModelTabelePrimerak extends AbstractTableModel {

    List<Primerak> lista;
    String[] kolone = {"sifraPrimerka", "godinaIzdanja", "brojIzdanja", "izdavac"};

    public ModelTabelePrimerak(List<Primerak> lista) {
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
        Primerak p = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getSifraPrimerka();
            case 1:
                return p.getGodinaIzdanja();
            case 2:
                return p.getBrojIzdanja();
            case 3:
                return p.getIzdavac().getNaziv();
            default:
                return "return";
        }
    }

    public List<Primerak> getLista() {
        return lista;
    }

    public void setLista(List<Primerak> lista) {
        this.lista = lista;
    }

    public void dodajPrimerak(Primerak p) {
        lista.add(p);
        fireTableDataChanged();
    }

    public void obrisiPrimerak(Primerak p) {
        lista.remove(p);
        fireTableDataChanged();
    }

}
