/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;

/**
 *
 * @author milic
 */
public class AutorKnjiga implements Serializable {

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

}
