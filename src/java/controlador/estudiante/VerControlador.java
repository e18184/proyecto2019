/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.estudiante;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import proyecto.Usuarios;

/**
 *
 * @author alumno
 */
@Controller
@SessionAttributes({"miusuario"})
public class VerControlador {

@RequestMapping("vernotas.htm")
    public ModelAndView vernotas(Model modelo, @ModelAttribute("miusuario") Usuarios usuario) {
        ModelAndView vista = new ModelAndView();
        return vista;
    }

}
