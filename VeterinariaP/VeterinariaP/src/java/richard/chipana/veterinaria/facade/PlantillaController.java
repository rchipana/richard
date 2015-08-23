/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richard.chipana.veterinaria.facade;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import richard.chipana.veterinaria.bean.Empleado;

/**
 *
 * @author rchipana
 */
@ManagedBean
@ViewScoped
public class PlantillaController implements Serializable {

    public void validarSesion() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Empleado empleado = (Empleado) context.getExternalContext().getSessionMap().get("empleado");
            if (empleado == null) {
                context.getExternalContext().redirect("login.xhtml");
            }
        } catch (Exception e) {
        }

    }

    
}
