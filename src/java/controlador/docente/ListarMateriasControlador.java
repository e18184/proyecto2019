/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.docente;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Imparte;
import org.orm.PersistentException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import proyecto.Dicta;
import proyecto.GrupoDAO;
import proyecto.Usuarios;

/**
 *
 * @author alumno
 */
@Controller
@SessionAttributes({"miusuario"})
@RequestMapping("listarnotas.htm")
public class ListarMateriasControlador {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listarnotas(Model modelo, @ModelAttribute("miusuario") Usuarios usuario) {
        ModelAndView vista = new ModelAndView();
        //List<Imparte> listaimparte = null;

        try {
            List<Imparte> listainterna = new ArrayList<Imparte>();
            Dicta[] dictadoc = usuario.getDocentes().dicta.toArray();
            for (int i = 0; i < dictadoc.length; i++) {
                if (dictadoc[i].getEstado()) {
                    Imparte impart = new Imparte();
                    impart.setGestion(dictadoc[i].getGestion());
                    impart.setMateria(GrupoDAO.getGrupoByORMID(dictadoc[i].getIdcarr().getId_grupo()).getNombre());
                    impart.setSigla(GrupoDAO.getGrupoByORMID(dictadoc[i].getIdcarr().getId_grupo()).getSigla());
                    impart.setGrupo(GrupoDAO.getGrupoByORMID(dictadoc[i].getIdcarr().getId_grupo()).getGrupo());

                    impart.setId_dicta(dictadoc[i].getIddicta());
                    impart.setId_grupo(GrupoDAO.getGrupoByORMID(dictadoc[i].getIdcarr().getId_grupo()).getId_grupo());
                    impart.setId_usu(usuario.getIdusu());
                    //System.out.println(GrupoDAO.getGrupoByORMID(dictadoc[i].getIdcarr().getId_grupo()).getId_grupo());
                    //GrupoDAO.getGrupoByORMID(dictadoc[i].getIdcarr().getId_grupo()).getSigla();

                    listainterna.add(impart);
                }
            }
            Imparte nuevoimparte = new Imparte();
            nuevoimparte.setLista(listainterna);

            modelo.addAttribute("lista", nuevoimparte);

            return vista;
        } catch (PersistentException ex) {
            Logger.getLogger(ListarMateriasControlador.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vista;
    }
}
