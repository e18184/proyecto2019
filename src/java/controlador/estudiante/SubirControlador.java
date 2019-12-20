/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.estudiante;

import java.util.ArrayList;
import java.util.List;
import modelo.Progrupo;
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
import proyecto.Universitarios;
import proyecto.Usuarios;

/**
 *
 * @author alumno
 */
@Controller
@SessionAttributes({"miusuario"})
@RequestMapping("subir.htm")
public class SubirControlador {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView vernotas(Model modelo, @ModelAttribute("miusuario") Usuarios usuario) throws PersistentException {
        ModelAndView vista = null;
        if (usuario.getActivo()) {
            List<Progrupo> listainterna = new ArrayList<Progrupo>();
            Programacion[] listprog = ProgramacionDAO.listProgramacionByQuery(null, null);
            Grupo[] listgrup = GrupoDAO.listGrupoByQuery(null, null);

            Progrupo programacion = new Progrupo();
            for (int i = 0; i < listprog.length; i++) {
                //System.out.println("usuario" + listprog[i].getIdusu().getIdusuId());
                //System.out.println("session" + usuario.getUniversitarios().getIdusuId());
                if (usuario.getUniversitarios().getIdusuId() == listprog[i].getIdusu().getIdusuId()) {
                    programacion.setGestion(listprog[i].getGestion());
                    programacion.setIdprog(listprog[i].getIdprog());
                    for (int j = 0; j < listgrup.length; j++) {
                        if (listgrup[j].getId_grupo() == listprog[i].getIdcarr().getId_grupo()) {
                            programacion.setId_grupo(listgrup[i].getId_grupo());
                            programacion.setSigla(listgrup[i].getSigla());
                            programacion.setNombre(listgrup[i].getNombre());
                            listainterna.add(programacion);
                        }
                    }
                }

            }
            vista = new ModelAndView("subir");
            Progrupo nuevoprog = new Progrupo();
            nuevoprog.setLista(listainterna);
            modelo.addAttribute("lista", nuevoprog);
            return vista;
        } else {
            vista = new ModelAndView("bottom");
            return vista;
        }
    }

}
