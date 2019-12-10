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
public class Imparte {

    private String sigla;
    private String materia;
    private String gestion;
    private String grupo;
    private int id_dicta;
    private int id_usu;
    private int id_grupo;
    public List<Imparte> lista;

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public int getId_dicta() {
        return id_dicta;
    }

    public void setId_dicta(int id_dicta) {
        this.id_dicta = id_dicta;
    }

    public int getId_usu() {
        return id_usu;
    }

    public void setId_usu(int id_usu) {
        this.id_usu = id_usu;
    }

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public List<Imparte> getLista() {
        return lista;
    }

    public void setLista(List<Imparte> lista) {
        this.lista = lista;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getGestion() {
        return gestion;
    }

    public void setGestion(String gestion) {
        this.gestion = gestion;
    }

}
