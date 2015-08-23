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
import richard.chipana.veterinaria.bean.Mascota;

/**
 *
 * @author RICHARD
 */
@Stateless
public class MascotaFacade extends AbstractFacade<Mascota> {

    @PersistenceContext(unitName = "VeterinariaPPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MascotaFacade() {
        super(Mascota.class);
    }

    public List<Mascota> list_mascota_Asociado(Asociado asociado) {
        javax.persistence.Query q = em.createQuery(
                "select p from Mascota p where p.idAsociado =:idAsoc "
        );
        q.setParameter("idAsoc", asociado);

        return q.getResultList();

    }

    /**
     * metodo par buscarEmpleado
     *
     * @param s
     * @return
     */
    public List<Mascota> selectLike(String s) {
        if (s == null) {
            s = "";
        }

        javax.persistence.Query q = em.createQuery(
                "select p from Mascota p where (p.idAsociado.nombres like :nombres or p.nombre like :nom or  p.idAsociado.apeMat  "
                + "like :apeMat or p.idAsociado.apePat like :apePat"
                + " or p.idAsociado.dni like :numDoc "
                + "or CONCAT(p.idAsociado.nombres ,' ', p.idAsociado.apePat ,' ', p.idAsociado.apeMat ) like :apellidos) ORDER BY p.idAsociado.nombres  "//AND p.activo = 1
        );
        q.setParameter("nom", "%" + s + "%");
        q.setParameter("nombres", "%" + s + "%");
        q.setParameter("apePat", "%" + s + "%");
        q.setParameter("apeMat", "%" + s + "%");
        q.setParameter("numDoc", "%" + s + "%");
        q.setParameter("apellidos", "%" + s + "%");
        return q.setMaxResults(20).getResultList();

    }

}
