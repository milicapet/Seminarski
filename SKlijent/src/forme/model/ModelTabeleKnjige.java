/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import domen.Autor;
import domen.AutorKnjiga;
import domen.Knjiga;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import komunikacija.Komunikacija;

/**
 *
 * @author milic
 */
public class ModelTabeleKnjige extends AbstractTableModel {

    List<Knjiga> lista;
    List<AutorKnjiga> autoriKnjige;
    String[] kolone = {"sifraKnjige", "naziv", "opis"};

    public ModelTabeleKnjige(List<Knjiga> lista) {
        this.lista = lista;
        autoriKnjige = Komunikacija.getInstance().ucitajAutorKnjige();
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

    public void pretrazi(String sifraKnjige, String naziv, List<Autor> autori) {
        System.out.println("LISTA ORIGINAL" + lista);
        List<Knjiga> filtriraneKnjige = new ArrayList<>();
        for (Knjiga k : lista) {
            if (sifraKnjige != null && !sifraKnjige.isEmpty()) {
                if (!String.valueOf(k.getSifraKnjige()).contains(sifraKnjige)) {
                    continue;
                }
            }
            if (naziv != null && !naziv.isEmpty()) {
                if (!k.getNaziv().toLowerCase().contains(naziv.toLowerCase())) {
                    continue;
                }
            }
            if (autori != null && !autori.isEmpty()) {
                boolean postojiVeza = false;
                for (AutorKnjiga ak : autoriKnjige) {
                    if (ak.getKnjiga().getSifraKnjige() == k.getSifraKnjige()) {
                        for (Autor a : autori) {
                            if (ak.getAutor().getSifraAutora() == a.getSifraAutora()) {
                                postojiVeza = true;
                                break;
                            }
                        }
                    }
                    if (postojiVeza) {
                        break;
                    }
                }
                if (!postojiVeza) {
                    continue; // preskoči knjigu ako nema vezu sa nijednim od izabranih autora
                }
            }
            filtriraneKnjige.add(k);
        }
        lista = filtriraneKnjige;
        System.out.println("FILTRIRANA LISTA " + filtriraneKnjige);
        fireTableDataChanged();
        /*List<Knjiga> filteredList = lista.stream()
                .filter(k -> (sifraKnjige == null || sifraKnjige.isEmpty()) || (String.valueOf(k.getSifraKnjige())).contains(sifraKnjige))
                .filter(k -> (naziv == null || naziv.isEmpty() || k.getNaziv().toLowerCase().contains(naziv.toLowerCase())))
                .filter(k -> (autor == null) || k.getAutor().equals(autor))
                .collect(Collectors.toList());
        lista = filteredList;*/
    }

}
