package controlador.estudiante;

import org.springframework.ui.Model;    
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import proyecto.Usuarios;

@RequestMapping("ProgramarTaller.htm"   )
@SessionAttributes({"miusuario"})
public class ProgramarUnTaller{
    @RequestMapping(method=RequestMethod.GET)
	public ModelAndView Programar(@ModelAttribute("miusuario") Usuarios usuario,Model model) {
            ModelAndView mav = new ModelAndView();           
            mav.setViewName("ProgramarTaller");
            return mav ;

	}
     
}
