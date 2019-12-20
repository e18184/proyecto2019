/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.estudiante;

import java.util.ArrayList;
import java.util.List;
import modelo.Proynotas;
import org.orm.PersistentException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import proyecto.Grupo;
import proyecto.GrupoDAO;
import proyecto.Programacion;
import proyecto.ProgramacionDAO;
import proyecto.Proyectos;
import proyecto.ProyectosDAO;
import proyecto.Usuarios;

/**
 *
 * @author RODRIGO
 */
@Controller
@SessionAttributes({"miusuario"})
@RequestMapping("vernotas.htm")
public class VerNotasControlador {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView vernotas(Model modelo, @ModelAttribute("miusuario") Usuarios usuario) throws PersistentException {
        ModelAndView vista = null;
        if (usuario.getActivo()) {
            List<Proynotas> listainterna = new ArrayList<Proynotas>();
            Programacion[] listprog = ProgramacionDAO.listProgramacionByQuery(null, null);
            Grupo[] listgrup = GrupoDAO.listGrupoByQuery(null, null);
            Proyectos[] listproy = ProyectosDAO.listProyectosByQuery(null, null);

            Proynotas proynota = new Proynotas();
            proynota.setUsuario(usuario.getNombre() + " " + usuario.getApellido1() + " " + usuario.getApellido2());
            for (int i = 0; i < listprog.length; i++) {
                //System.out.println("usuario" + listprog[i].getIdusu().getIdusuId());
                //System.out.println("session" + usuario.getUniversitarios().getIdusuId());
                if (usuario.getUniversitarios().getIdusuId() == listprog[i].getIdusu().getIdusuId()) {
                        System.out.println("pogra id " + listprog[i].getIdusu().getIdusuId()+" "+listprog[i].getIdusu().getIdusuId());
                    proynota.setIdprog(listprog[i].getIdprog());
                    for (int j = 0; j < listgrup.length; j++) {
                        if (listgrup[j].getId_grupo() == listprog[i].getIdcarr().getId_grupo()) {
                        System.out.println("grupo id " + listgrup[j].getId_grupo()+ " "+ listprog[i].getIdcarr().getId_grupo());
                            proynota.setId_grupo(listgrup[j].getId_grupo());
                            proynota.setNombre(listgrup[j].getNombre());
                            for (int k = 0; k < listproy.length; k++) {

                                System.out.println("proy id " + listproy[k].getProgramacion() + " "+listprog[j]);
                                //if (listproy[k].getProgramacion() == listprog[j]) {
                                    proynota.setNota(listproy[k].getNota());
                                    proynota.setIdproyecto(listproy[k].getIdproyecto());
                                    proynota.setTitulo(listproy[k].getTitulo());
                                    listainterna.add(proynota);
                                //}

                            }
                        }
                    }
                }

            }
            vista = new ModelAndView("vernotas");
            Proynotas listanotas = new Proynotas();
            listanotas.setLista(listainterna);
            modelo.addAttribute("lista", listanotas);
            return vista;
        } else {
            vista = new ModelAndView("bottom");
            return vista;
        }
    }
}
