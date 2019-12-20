package controlador.estudiante;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.orm.PersistentException;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
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
import proyecto.Usuarios;


@RequestMapping("ProgramarTaller.htm")
@SessionAttributes({"miusuario"})
public class ProgramarUnTaller {
    @RequestMapping(method=RequestMethod.GET)
	public ModelAndView Programar(@ModelAttribute("Programacion") Usuarios usuario,Model model) {           
           ModelAndView ver = new ModelAndView();
            
          Grupo[] programar=null;
        try {
            programar = GrupoDAO.listGrupoByQuery(null, null);
            
        } catch (PersistentException ex) {
            Logger.getLogger(ProgramarUnTaller.class.getName()).log(Level.SEVERE, null, ex);
        }
            model.addAttribute("variable", programar);
        return ver;
             
  }
}
