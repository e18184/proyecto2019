package controlador.estudiante;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.orm.PersistentException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import proyecto.Usuarios;
import proyecto.Anuncios;
import proyecto.AnunciosDAO;
import proyecto.UsuariosDAO;


@RequestMapping("VisualizarAnuncios.htm")
@SessionAttributes({"miusuario"})
public class VerAnuncios {
    @RequestMapping(method=RequestMethod.GET)
	public ModelAndView Visualizar(@ModelAttribute("anuncio") Usuarios usuario,Model model) {
            ModelAndView ver = new ModelAndView();
            
          Anuncios[] anuncio=null;
        try {
            anuncio = AnunciosDAO.listAnunciosByQuery(null,null);
            
        } catch (PersistentException ex) {
            Logger.getLogger(VerAnuncios.class.getName()).log(Level.SEVERE, null, ex);
        }
            model.addAttribute("varia",anuncio);
        return ver;
             
  }
}
