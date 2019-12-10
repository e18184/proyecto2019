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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import proyecto.Dicta;
import proyecto.GrupoDAO;
import modelo.Programaciones;
import proyecto.Grupo;
import proyecto.Programacion;
import proyecto.ProgramacionDAO;
import proyecto.Usuarios;
import proyecto.UsuariosDAO;

/**
 *
 * @author alumno
 */
@Controller
@SessionAttributes({"miusuario"})
@RequestMapping("cargarnotas.htm")
public class CargarNotasControlador {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView cargarnotas(Model modelo, @RequestParam("id") int id_group, @ModelAttribute("miusuario") Usuarios usuario) {
        ModelAndView vista = new ModelAndView();
        //List<Imparte> listaimparte = null;

        try {
            Grupo grupo = GrupoDAO.getGrupoByORMID(id_group);
            List<Programaciones> listainterna = new ArrayList<Programaciones>();
            Programacion[] estprog = grupo.programacion.toArray();

            for (int i = 0; i < estprog.length; i++) {
                Programaciones prog = new Programaciones();
                prog.setId_prog(estprog[i].getIdprog());
                prog.setId_grupo(estprog[i].getIdcarr().getId_grupo());
                prog.setNotafinal(estprog[i].getNotafinal());
                prog.setNombre(UsuariosDAO.getUsuariosByORMID(estprog[i].getIdusu().getIdusuId()).getNombre());
                prog.setAp(UsuariosDAO.getUsuariosByORMID(estprog[i].getIdusu().getIdusuId()).getApellido1());
                prog.setAm(UsuariosDAO.getUsuariosByORMID(estprog[i].getIdusu().getIdusuId()).getApellido2());
                prog.setId_univ(UsuariosDAO.getUsuariosByORMID(estprog[i].getIdusu().getIdusuId()).getIdusu());
                //System.out.println("prog:  " + estprog[i].getIdusu().getIdusuId());
                //GrupoDAO.getGrupoByORMID(dictadoc[i].getIdcarr().getId_grupo()).getSigla();

                listainterna.add(prog);
            }
            Programaciones nuevoprog = new Programaciones();
            nuevoprog.setLista(listainterna);

            modelo.addAttribute("lista", nuevoprog);

            return vista;
        } catch (PersistentException ex) {
            Logger.getLogger(ListarMateriasControlador.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vista;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView cargarnotasPOST(
            @ModelAttribute("lista") Programaciones[] lista,
            @RequestParam("notafinal")  String notas[],
            @RequestParam("id_prog")  int idprog[]
            ) {

        ModelAndView vista = new ModelAndView();
        System.out.println("lista");
            //System.out.println(notas.length);
            //System.out.println(idprog.length);

       for (int i = 0; i < notas.length; i++) {
            System.out.println(notas[i]);
            System.out.println(idprog[i]);
            //Programacion prognotas = ProgramacionDAO.getProgramacionByORMID(lista[i])    
       }
//        System.out.println("id:" + anuncio.getIdanuncio());
        //AnunciosDAO.save(anuncio);
        return vista;
    }

}
