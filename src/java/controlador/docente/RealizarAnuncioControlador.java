/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.docente;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.orm.PersistentException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import proyecto.Anuncios;
import proyecto.Usuarios;
import proyecto.UsuariosDAO;
import proyecto.AnunciosDAO;

/**
 *
 * @author alumno
 */
@Controller
@SessionAttributes({"miusuario"})
@RequestMapping("realizaranuncio.htm")
public class RealizarAnuncioControlador {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView realizaranuncio() {
        ModelAndView vista = new ModelAndView();
        vista.setViewName("realizaranuncio");
        Anuncios anuncio = new Anuncios();
//      asignamos al atributo titulo un valor por defecto
//        anuncio.setTitulo("Introduzca Titulo");
//      asigmos al atributo nombre un valor por defecto 
//        anuncio.setMensaje("Introduzca Mensaje");
//        anuncio.setEstado(true);
//        anuncio.setFecha("121119");
//        anuncio.setArchivo("imagen.jpg");
        vista.addObject("anuncio", anuncio);
        return vista;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView realizaranuncioPOST(@ModelAttribute("anuncio") Anuncios anuncio, @ModelAttribute("miusuario") Usuarios usuario) {
        ModelAndView vista = new ModelAndView();

        anuncio.setORM_Usuarios(usuario);
//        System.out.println("id:" + anuncio.getIdanuncio());
//        System.out.println("titulo:" + anuncio.getTitulo());
//        System.out.println("estado:" + anuncio.getEstado());
//        System.out.println("mensaje:" + anuncio.getMensaje());
//        System.out.println("fecha:" + anuncio.getFecha());
//        System.out.println("archivo:" + anuncio.getArchivo());
//        System.out.println("usuarios:" + anuncio.getUsuarios());
        try {
            AnunciosDAO.save(anuncio);
        } catch (PersistentException ex) {
            Logger.getLogger(RealizarAnuncioControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        anuncio.setTitulo("");
        anuncio.setMensaje("");
        anuncio.setEstado(false);
        anuncio.setFecha("01/12/2019");
        anuncio.setArchivo("documento.pdf");
        return vista;
    }
}
