/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richard.chipana.veterinaria.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import richard.chipana.veterinaria.bean.CitaServicio;

/**
 *
 * @author RICHARD
 */
@Stateless
public class CitaServicioFacade extends AbstractFacade<CitaServicio> {
    @PersistenceContext(unitName = "VeterinariaPPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CitaServicioFacade() {
        super(CitaServicio.class);
    }
    
}
