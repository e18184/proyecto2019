package controlador.estudiante;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import proyecto.Usuarios;


@RequestMapping("formProgramar.htm")
@SessionAttributes({"miusuario"})
public class FormProgramacion {
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView Programar(@ModelAttribute("Programacion") Usuarios usuario,Model model) {           
        ModelAndView ver = new ModelAndView();
        return ver;
        
        
        
    }
}
