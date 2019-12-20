/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.estudiante;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import javax.servlet.http.HttpSession;
import modelo.Progrupo;
import org.orm.PersistentException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import proyecto.Proyectos;
import proyecto.Usuarios;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import proyecto.Programacion;
import proyecto.ProgramacionDAO;
import proyecto.ProyectosDAO;

/**
 *
 * @author RODRIGO
 */
@Controller
@SessionAttributes({"miusuario"})
@RequestMapping("subirarchivo.htm")
public class SubirArchivoControlador {

    private int idprog;

    public int getIdprog() {
        return idprog;
    }

    public void setIdprog(int idprog) {
        this.idprog = idprog;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView vernotas(
            Model modelo,
            @ModelAttribute("miusuario") Usuarios usuario,
            @RequestParam("id") int idprog
    ) throws PersistentException {
        ModelAndView vista = null;
        if (usuario.getActivo()) {
            vista = new ModelAndView("subirarchivo");
            //modelo.addAttribute("lista", nuevoprog);
            Proyectos proy = new Proyectos();
            setIdprog(idprog);
            vista.addObject("proyecto", proy);
            System.out.println("id progra" + idprog);
            return vista;
        } else {
            vista = new ModelAndView("bottom");
            return vista;
        }
    }

    private void borrarProyecto(String idproy) throws PersistentException {
        Proyectos proyecto = ProyectosDAO.getProyectosByORMID(idproy);

        ProyectosDAO.deleteAndDissociate(proyecto);

    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView subirarchivoPOST(
            @ModelAttribute("proyecto") @Validated Proyectos proyecto,
            BindingResult result,
            @ModelAttribute("miusuario") Usuarios usuario,
            @RequestParam("archivo") CommonsMultipartFile file,
            HttpSession session
    ) throws Exception {
        ModelAndView vista = new ModelAndView();
        Proyectos[] listproy = ProyectosDAO.listProyectosByQuery(null, null);
        proyecto.setProgramacion(ProgramacionDAO.getProgramacionByORMID(getIdprog()));

        for (int i = 0; i < listproy.length; i++) {
            if (listproy[i].getProgramacion() == proyecto.getProgramacion()) {
                Proyectos sproy = ProyectosDAO.getProyectosByORMID(listproy[i].getIdproyecto());
                sproy.setIdproyecto(listproy[i].getIdproyecto());
                //sproy.setArea(listproy[i].getArea());
                //sproy.setDocentesidusu(listproy[i].getDocentesidusu());
                //sproy.setNota(listproy[i].getNota());
                sproy.setTitulo(proyecto.getTitulo());
                sproy.setResumen(proyecto.getResumen());
                sproy.setEstado(proyecto.getEstado());
                if (!file.isEmpty()) {
                    //borrarProyecto(listproy[i].getIdproyecto());
                    String path = session.getServletContext().getRealPath("/images");
                    String filename = file.getOriginalFilename();
                    //System.out.println("subir " + filename);
                    //System.out.println("subir " + file.getSize());
                    try {
                        byte barr[] = file.getBytes();
                        BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(path + "/" + filename));
                        bout.write(barr);
                        bout.flush();
                        bout.close();
                        sproy.setArchivo(path + "/" + filename);
                        System.out.println("titulo" + sproy.getTitulo());
                        System.out.println("resumen" + sproy.getResumen());
                        System.out.println("programacion" + sproy.getProgramacion());
                        System.out.println("id " + sproy.getIdproyecto());
                        System.out.println("subir " + sproy.getArchivo());
                        System.out.println("subir " + sproy.getDocentesidusu());
                        System.out.println("subir " + sproy.getArea());
                        System.out.println("subir " + sproy.getEstado());
                        System.out.println("subir " + sproy.getNota());

                    } catch (Exception e) {
                        System.out.println(e);
                    }
                        ProyectosDAO.save(sproy);
                }

            }
        }

        //return new ModelAndView("realizaranuncio", "filename", path + "/" + filename);
        return vista;
    }

}
