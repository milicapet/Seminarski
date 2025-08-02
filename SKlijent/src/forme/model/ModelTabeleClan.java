/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import domen.Clan;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author milic
 */
public class ModelTabeleClan extends AbstractTableModel {

    List<Clan> lista;
    String[] kolone = {"Broj članske karte", "Ime", "Prezime", "Adresa", "Broj telefona"};

    public ModelTabeleClan(List<Clan> lista) {
        this.lista = lista;
    }

    public List<Clan> getLista() {
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

    public List<Clan> pretrazi(String brClanskeKarte, String ime, String prezime, String adresa, String brTel) {
        System.out.println("LISTA ORIGINAL" + lista);
        List<Clan> filteredList = lista.stream()
                .filter(c -> (brClanskeKarte == null || brClanskeKarte.isEmpty()) || (String.valueOf(c.getBrojClanskeKarte())).contains(brClanskeKarte))
                .filter(c -> (ime == null || ime.isEmpty() || c.getIme().toLowerCase().contains(ime.toLowerCase())))
                .filter(c -> (prezime == null || prezime.isEmpty() || c.getPrezime().toLowerCase().contains(prezime.toLowerCase())))
                .filter(c -> (adresa == null || adresa.isEmpty() || c.getAdresa().toLowerCase().contains(adresa.toLowerCase())))
                .filter(c -> (brTel == null || brTel.isEmpty() || c.getBrojTelefona().toLowerCase().contains(brTel.toLowerCase())))
                .collect(Collectors.toList());
        lista = filteredList;
        System.out.println("FILTRIRANA LISTA " + filteredList);
        fireTableDataChanged();
        return lista;
    }

}
