/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

/**
 *
 * @author RODRIGO
 */
public class Progrupo {
    private int id_grupo;
    private int idprog;
    private String gestion;
    private String nombre;
    private String sigla;
    public List<Progrupo> lista;

    public List<Progrupo> getLista() {
        return lista;
    }

    public void setLista(List<Progrupo> lista) {
        this.lista = lista;
    }

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public int getIdprog() {
        return idprog;
    }

    public void setIdprog(int idprog) {
        this.idprog = idprog;
    }

    public String getGestion() {
        return gestion;
    }

    public void setGestion(String gestion) {
        this.gestion = gestion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
