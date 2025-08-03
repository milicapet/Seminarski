/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author milic
 */
public class Primerak implements ApstraktniDomenskiObjekat {

    private Knjiga knjiga;
    private int sifraPrimerka;
    private int godinaIzdanja;
    private int brojIzdanja;
    private Izdavac izdavac;

    public Primerak() {
    }

    public Primerak(Knjiga knjiga, int sifraPrimerka, int godinaIzdanja, int brojIzdanja, Izdavac izdavac) {
        this.knjiga = knjiga;
        this.sifraPrimerka = sifraPrimerka;
        this.godinaIzdanja = godinaIzdanja;
        this.brojIzdanja = brojIzdanja;
        this.izdavac = izdavac;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    public int getSifraPrimerka() {
        return sifraPrimerka;
    }

    public void setSifraPrimerka(int sifraPrimerka) {
        this.sifraPrimerka = sifraPrimerka;
    }

    public int getGodinaIzdanja() {
        return godinaIzdanja;
    }

    public void setGodinaIzdanja(int godinaIzdanja) {
        this.godinaIzdanja = godinaIzdanja;
    }

    public int getBrojIzdanja() {
        return brojIzdanja;
    }

    public void setBrojIzdanja(int brojIzdanja) {
        this.brojIzdanja = brojIzdanja;
    }

    public Izdavac getIzdavac() {
        return izdavac;
    }

    public void setIzdavac(Izdavac izdavac) {
        this.izdavac = izdavac;
    }

    @Override
    public String toString() {
        return sifraPrimerka + ", " + godinaIzdanja + ", " + brojIzdanja + ", " + izdavac + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Primerak other = (Primerak) obj;
        if (this.sifraPrimerka != other.sifraPrimerka) {
            return false;
        }
        return Objects.equals(this.knjiga, other.knjiga);
    }

    @Override
    public String vratiNazivTabele() {
        return "primerak";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            int sifraKnjige = rs.getInt("primerak.sifraKnjige");
            Knjiga k = new Knjiga();
            k.setSifraKnjige(sifraKnjige);

            int sifraPrimerka = rs.getInt("primerak.sifraPrimerka");
            int godinaIzdanja = rs.getInt("primerak.godinaIzdanja");
            int brojIzdanja = rs.getInt("primerak.brojIzdanja");

            int sifraIzdavaca = rs.getInt("primerak.sifraIzdavaca");
            /*String naziv = rs.getString("izdavac.naziv");
            String adresa = rs.getString("izdavac.adresa");*/
            Izdavac izdavac = new Izdavac();
            izdavac.setSifraIzdavaca(sifraIzdavaca);
            /*izdavac.setNaziv(naziv);
            izdavac.setAdresa(adresa);*/

            Primerak p = new Primerak();
            p.setKnjiga(k);
            p.setSifraPrimerka(sifraPrimerka);
            p.setGodinaIzdanja(godinaIzdanja);
            p.setBrojIzdanja(brojIzdanja);
            p.setIzdavac(izdavac);
            lista.add(p);
        }
        return lista;

    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "sifraKnjige,sifraPrimerka,godinaIzdanja,brojIzdanja,sifraIzdavaca";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return knjiga.getSifraKnjige() + "," + sifraPrimerka + "," + godinaIzdanja + "," + brojIzdanja + "," + izdavac.getSifraIzdavaca();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "primerak.sifraKnjige=" + knjiga.getSifraKnjige() + " AND primerak.sifraPrimerka=" + sifraPrimerka;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "sifraKnjige=" + knjiga.getSifraKnjige() + ",sifraPrimerka=" + sifraPrimerka + ",godinaIzdanja="
                + godinaIzdanja + ",brojIzdanja=" + brojIzdanja + ",sifraIzdavaca=" + izdavac.getSifraIzdavaca();
    }

}
