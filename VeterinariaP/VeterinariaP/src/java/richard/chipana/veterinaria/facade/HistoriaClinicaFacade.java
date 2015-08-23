/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richard.chipana.veterinaria.facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import richard.chipana.veterinaria.bean.Asociado;
import richard.chipana.veterinaria.bean.HistoriaClinica;
import richard.chipana.veterinaria.bean.Mascota;

/**
 *
 * @author RICHARD
 */
@Stateless
public class HistoriaClinicaFacade extends AbstractFacade<HistoriaClinica> {

    @PersistenceContext(unitName = "VeterinariaPPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistoriaClinicaFacade() {
        super(HistoriaClinica.class);
    }

    public List<HistoriaClinica> list_HistoriaClinicas(Asociado a, Mascota m) {

        javax.persistence.Query q = em.createQuery(
                "select p from HistoriaClinica p where p.idAsociado =:as AND p.idMascota =:mas "
        );
        q.setParameter("as", a);
        q.setParameter("mas", m);

        return q.getResultList();

    }
}
