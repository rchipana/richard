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

/**
 *
 * @author RICHARD
 */
@Stateless
public class AsociadoFacade extends AbstractFacade<Asociado> {
    @PersistenceContext(unitName = "VeterinariaPPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AsociadoFacade() {
        super(Asociado.class);
    }
    
    
      public List<Asociado> validarDni(String dni) {

        javax.persistence.Query q = em.createQuery("SELECT e FROM Asociado e WHERE e.dni = :dni");
        q.setParameter("dni", dni);
        return q.getResultList();

    }

    public List<Asociado> validarPass(String pass) {
        javax.persistence.Query q = em.createQuery("SELECT e FROM Asociado e WHERE e.password = :password");
        q.setParameter("password", pass);
        return q.getResultList();
    }
    
     /**
     * metodo par buscarAsociado
     *
     * @param s
     * @return
     */
    public List<Asociado> selectLike(String s) {
        if (s == null) {
            s = "";
        }

        javax.persistence.Query q = em.createQuery(
                "select p from Asociado p where (p.nombres like :nombres or p.apeMat  "
                + "like :apeMat or p.apePat like :apePat  or "
                + "p.ruc like :ruc or p.dni like :numDoc "
                + "or CONCAT(p.nombres ,' ', p.apePat ,' ', p.apeMat ) like :apellidos )  "//AND p.activo = 1
        );
        q.setParameter("nombres", "%" + s + "%");
        q.setParameter("apePat", "%" + s + "%");
        q.setParameter("apeMat", "%" + s + "%");     
        q.setParameter("ruc", "%" + s + "%");
        q.setParameter("numDoc", "%" + s + "%");
        q.setParameter("apellidos", "%" + s + "%");
        return q.setMaxResults(20).getResultList();

    }
    
    
}
