/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.tribunal;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import modelo.Obs;
import org.orm.PersistentException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import proyecto.Etapas;
import proyecto.EtapasDAO;
import proyecto.Observaciones;
import proyecto.ObservacionesDAO;
import proyecto.TribunalDAO;
import proyecto.Usuarios;

@Controller
@RequestMapping("observaciones.htm")
@SessionAttributes({"miusuario"})
public class ObservacionesControlador {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView observaciones(@ModelAttribute("miusuario") Usuarios usuario) {
        ModelAndView vista = new ModelAndView();
        Obs observacion = new Obs();
        try {
            Etapas[] etapas = EtapasDAO.listEtapasByQuery(null, null);
            observacion.setLista(etapas);
        } catch (PersistentException ex) {
            Logger.getLogger(ObservacionesControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        vista.addObject("observaciones", observacion);

        return vista;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView realizaObservacionesPOST(
            @ModelAttribute("observaciones") @Validated Obs observacion,
            BindingResult result,
            @ModelAttribute("miusuario") Usuarios usuario,
            @RequestParam("archivo") CommonsMultipartFile file,
            HttpSession session
    ) throws Exception {
         int id = (int) (new Date().getTime()/1000);
        ModelAndView vista = new ModelAndView();
        System.out.println("idobs "+id);
        Observaciones observ = new Observaciones();
       // System.out.println(usuario.getDocentes().getIdusuId());
        observ.setTribunal(TribunalDAO.getTribunalByORMID(usuario.getDocentes().getIdusuId()));
        observ.setEtapas(EtapasDAO.getEtapasByORMID(observacion.getIdetapa()));
        observ.setID(id);
        //System.out.println("etapas   "+observacion.getIdetapa());
        observ.setObservaciones(observacion.getObservacion());
        observ.setFecha(observacion.getFecha());
        observ.setArchivo(observacion.getArchivo());
        //System.out.println(observacion.getFecha());

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
                observ.setArchivo(path + "/" + filename);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        System.out.println("id " + observ.getID());
        System.out.println("etapas " + observ.getEtapas());
        System.out.println("tribunal " + observ.getTribunal());
        
        System.out.println("ob " + observ.getObservaciones());
        System.out.println("fecha " + observ.getFecha());
        System.out.println("archi " + observ.getArchivo());
        ObservacionesDAO.save(observ);

//        observaciones.setObservaciones("");
//        observaciones.setFecha("");
//        observaciones.setArchivo("");
        //return new ModelAndView("realizaranuncio", "filename", path + "/" + filename);
        return vista;
    }
}
