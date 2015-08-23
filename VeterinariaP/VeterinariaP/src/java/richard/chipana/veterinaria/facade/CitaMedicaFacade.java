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
import richard.chipana.veterinaria.bean.CitaMedica;
import richard.chipana.veterinaria.bean.Empleado;

/**
 *
 * @author RICHARD
 */
@Stateless
public class CitaMedicaFacade extends AbstractFacade<CitaMedica> {

    @PersistenceContext(unitName = "VeterinariaPPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CitaMedicaFacade() {
        super(CitaMedica.class);
    }

    public List<CitaMedica> ListCiMedico(Empleado empleado) {
        javax.persistence.Query q = em.createQuery("SELECT e FROM CitaMedica e WHERE e.idEmpleado = :emple");
        q.setParameter("emple", empleado);
        return q.getResultList();

    }
     public List<CitaMedica> listCiMedicoAso(Asociado asociado) {
        javax.persistence.Query q = em.createQuery("SELECT e FROM CitaMedica e WHERE e.idAsociado = :emple");
        q.setParameter("emple", asociado);
        return q.getResultList();

    }
    /**
     * metodo par buscarCitaMedica
     *
     * @param s
     * @return
     */
    public List<CitaMedica> selectLike(String s) {
        if (s == null) {
            s = "";
        }

        javax.persistence.Query q = em.createQuery(
                "select p from CitaMedica p where (p.idAsociado.nombres like :nombres or p.idAsociado.apeMat  "
                + "like :apeMat or p.idAsociado.apePat like :apePat  or "
                + "p.idAsociado.ruc like :ruc or p.idAsociado.dni like :numDoc "
                + "or CONCAT(p.idAsociado.nombres ,' ', p.idAsociado.apePat ,' ', p.idAsociado.apeMat ) like :apellidos )  "//AND p.activo = 1
        );
        q.setParameter("nombres", "%" + s + "%");
        q.setParameter("apePat", "%" + s + "%");
        q.setParameter("apeMat", "%" + s + "%");
        q.setParameter("ruc", "%" + s + "%");
        q.setParameter("numDoc", "%" + s + "%");
        q.setParameter("apellidos", "%" + s + "%");
        return q.setMaxResults(20).getResultList();

    }

    public List<CitaMedica> listCitas(CitaMedica cm) {
        javax.persistence.Query q = em.createQuery("SELECT e FROM CitaMedica e WHERE e = :id");
        q.setParameter("id", cm);
        return q.getResultList();
    }

}
