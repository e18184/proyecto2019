/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import proyecto.Etapas;
import java.util.*;

/**
 *
 * @author RODRIGO
 */
public class Obs {
    private String observacion;
    private String fecha;
    private String archivo;
    private int idetapa;
    private Etapas[] lista;

    public int getIdetapa() {
        return idetapa;
    }

    public void setIdetapa(int idetapa) {
        this.idetapa = idetapa;
    }

    
    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public Etapas[] getLista() {
        return lista;
    }

    public void setLista(Etapas[] lista) {
        this.lista = lista;
    }


    
}
