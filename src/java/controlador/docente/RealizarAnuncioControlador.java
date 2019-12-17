/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.docente;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.orm.PersistentException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import proyecto.Anuncios;
import proyecto.Usuarios;
import proyecto.UsuariosDAO;
import proyecto.AnunciosDAO;

@Controller
@SessionAttributes({"miusuario"})
@RequestMapping("realizaranuncio.htm")
public class RealizarAnuncioControlador {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView realizaranuncio(
            @ModelAttribute("miusuario") Usuarios usuario
    ) {
        ModelAndView vista = null;
        if (usuario.getActivo()) {
            vista = new ModelAndView("realizaranuncio");
            vista.setViewName("realizaranuncio");
            Anuncios anuncio = new Anuncios();

//      asignamos al atributo titulo un valor por defecto
//        anuncio.setTitulo("Introduzca Titulo");
//      asigmos al atributo nombre un valor por defecto 
//        anuncio.setMensaje("Introduzca Mensaje");
//        anuncio.setEstado(true);
//       anuncio.setFecha(fecha.toString());
//        anuncio.setArchivo("imagen.jpg");
            vista.addObject("anuncio", anuncio);
            return vista;
        } else {
            vista = new ModelAndView("bottom");
            return vista;
        }

    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView realizaranuncioPOST(
            @ModelAttribute("anuncio") @Validated Anuncios anuncio,
            BindingResult result,
            @ModelAttribute("miusuario") Usuarios usuario,
            @RequestParam("archivo") CommonsMultipartFile file,
            HttpSession session
    ) throws Exception {
        ModelAndView vista = new ModelAndView();
        anuncio.setORM_Usuarios(usuario);
        System.out.println(anuncio.getFecha());
        System.out.println("subir " + anuncio.getTitulo());
        if (!file.isEmpty()) {
            String path = session.getServletContext().getRealPath("/images");
            String filename = file.getOriginalFilename();
            System.out.println("subir " + filename);
            System.out.println("subir " + file.getSize());
            try {
                byte barr[] = file.getBytes();
                BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(path + "/" + filename));
                bout.write(barr);
                bout.flush();
                bout.close();
                anuncio.setArchivo(path + "/" + filename);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        try {
            AnunciosDAO.save(anuncio);
        } catch (PersistentException ex) {
            Logger.getLogger(RealizarAnuncioControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        anuncio.setTitulo("");
        anuncio.setMensaje("");
        anuncio.setEstado(false);
        anuncio.setFecha("");
        anuncio.setArchivo("");
        //return new ModelAndView("realizaranuncio", "filename", path + "/" + filename);

        return vista;
    }
}
