package modelo;

import java.util.List;

public class Programaciones {

    private String notafinal;
    private String estado;
    private String nombre;
    private String ap;
    private String am;
    private int id_prog;
    private int id_univ;
    private int id_grupo;
    public List<Programaciones> lista;

    public int getId_univ() {
        return id_univ;
    }

    public void setId_univ(int id_univ) {
        this.id_univ = id_univ;
    }

    public String getNotafinal() {
        return notafinal;
    }

    public void setNotafinal(String notafinal) {
        this.notafinal = notafinal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAp() {
        return ap;
    }

    public void setAp(String ap) {
        this.ap = ap;
    }

    public String getAm() {
        return am;
    }

    public void setAm(String am) {
        this.am = am;
    }

    public int getId_prog() {
        return id_prog;
    }

    public void setId_prog(int id_prog) {
        this.id_prog = id_prog;
    }

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public List<Programaciones> getLista() {
        return lista;
    }

    public void setLista(List<Programaciones> lista) {
        this.lista = lista;
    }

}
