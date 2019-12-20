package controlador.estudiante;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.orm.PersistentException;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import proyecto.Grupo;
import proyecto.GrupoDAO;
import proyecto.Programacion;
import proyecto.ProgramacionDAO;
import proyecto.Usuarios;

@RequestMapping("eliminarProgramacion.htm")
@SessionAttributes({"miusuario"})
public class EliminarProgramcaionConstructor {
    @RequestMapping(method=RequestMethod.GET)
        public ModelAndView EliminarCurso(){
            ModelAndView vista = new ModelAndView();
//            vista.setViewName("eliminarProgramacion");
//            Programacion programar=null;
//            programar = ProgramacionDAO.getProgramacionByORMID(Idprog);
//            vista.addObject("variable",programar);
//      return vista;
//  }
//         @RequestMapping(method=RequestMethod.POST)
//  public ModelAndView modificarMadrePOST(@ModelAttribute("Programacion") Programacion progra) throws PersistentException {
//      ModelAndView vista = new ModelAndView();
//      System.out.println("idProg:"+progra.getIdprog());
//      System.out.println("IdUusuario:"+progra.getIdusu());
//      System.out.println("Estado:"+progra.getEstado());
//
//      ProgramacionDAO.delete(progra);
      return vista;
  } 
}