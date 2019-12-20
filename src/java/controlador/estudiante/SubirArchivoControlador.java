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
                
                proyecto.setIdproyecto(listproy[i].getIdproyecto());
                proyecto.setArea(listproy[i].getArea());
                proyecto.setDocentesidusu(listproy[i].getDocentesidusu());
                proyecto.setNota(listproy[i].getNota());
                if (!file.isEmpty()) {
                    borrarProyecto(listproy[i].getIdproyecto());
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
                        proyecto.setArchivo(path + "/" + filename);
                        System.out.println("titulo" + proyecto.getTitulo());
                        System.out.println("resumen" + proyecto.getResumen());
                        System.out.println("programacion" + proyecto.getProgramacion());
                        System.out.println("id " + proyecto.getIdproyecto());
                        System.out.println("subir " + proyecto.getArchivo());
                        System.out.println("subir " + proyecto.getDocentesidusu());
                        System.out.println("subir " + proyecto.getArea());
                        System.out.println("subir " + proyecto.getEstado());
                        System.out.println("subir " + proyecto.getNota());
                        ProyectosDAO.save(proyecto);

                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }

            }
        }

        //return new ModelAndView("realizaranuncio", "filename", path + "/" + filename);
        return vista;
    }

}
