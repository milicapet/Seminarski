/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author milic
 */
public class AutorKnjiga implements ApstraktniDomenskiObjekat {

    private Autor autor;
    private Knjiga knjiga;

    public AutorKnjiga() {
    }

    public AutorKnjiga(Autor autor, Knjiga knjiga) {
        this.autor = autor;
        this.knjiga = knjiga;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    @Override
    public String toString() {
        return "AutorKnjiga{" + "autor=" + autor + ", knjiga=" + knjiga + '}';
    }

    @Override
    public String vratiNazivTabele() {
        return "autorknjiga";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            int sifraAutora = rs.getInt("autorknjiga.sifraAutora");
            String ime = rs.getString("autor.ime");
            String prezime = rs.getString("autor.prezime");
            String biografija = rs.getString("autor.biografija");
            Autor a = new Autor(sifraAutora, ime, prezime, biografija);

            int sifraKnjige = rs.getInt("autorknjiga.sifraKnjige");
            String naziv = rs.getString("knjiga.naziv");
            String opis = rs.getString("knjiga.opis");
            Knjiga k = new Knjiga(sifraKnjige, naziv, opis, null);

            AutorKnjiga ak = new AutorKnjiga(a,k);
            lista.add(ak);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "sifraAutora,sifraKnjige";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return autor.getSifraAutora() + "," + knjiga.getSifraKnjige();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "autorknjiga.sifraAutora=" + autor.getSifraAutora()
                + " AND autorknjiga.sifraKnjige=" + knjiga.getSifraKnjige();
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "sifraAutora=" + autor.getSifraAutora() + ",sifraKnjige=" + knjiga.getSifraKnjige();
    }

}
