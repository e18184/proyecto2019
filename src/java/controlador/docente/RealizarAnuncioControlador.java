/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.docente;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import proyecto.Anuncios;
import proyecto.AnunciosDAO;
/**
 *
 * @author alumno
 */
public class RealizarAnuncioControlador {

    @RequestMapping("realizaranuncio.htm")
    public ModelAndView realizaranuncio() {
      ModelAndView vista = new ModelAndView();
      vista.setViewName("realizaranuncio");
      Anuncios anuncio = new Anuncios();
//      asignamos al atributo titulo un valor por defecto
//      anuncio.setTitulo("Introduzca Titulo");
//      asigmos al atributo nombre un valor por defecto 
//      anuncio.setMensaje("Introduzca Mensaje");
//      anuncio.setEstado(false);
//      anuncio.setFecha("19/11/2019");
//      anuncio.setArchivo("19/11/2019");
      vista.addObject("anuncio",anuncio);
      
      return vista;
    }
}
