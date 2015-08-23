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
import richard.chipana.veterinaria.bean.Empleado;

/**
 *
 * @author RICHARD
 */
@Stateless
public class EmpleadoFacade extends AbstractFacade<Empleado> {

    @PersistenceContext(unitName = "VeterinariaPPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpleadoFacade() {
        super(Empleado.class);
    }

    public List<Empleado> loginEmpleado(String dni, String clave) {

        javax.persistence.Query q = em.createQuery(
                "select p from Empleado p where p.dni =:dni AND p.password =:clave "
        );
        q.setParameter("dni", dni);
        q.setParameter("clave", clave);

        return q.getResultList();

    }

    public List<Empleado> validarDni(String dni) {

        javax.persistence.Query q = em.createQuery("SELECT e FROM Empleado e WHERE e.dni = :dni");
        q.setParameter("dni", dni);
        return q.getResultList();

    }

    public List<Empleado> validarPass(String pass) {
        javax.persistence.Query q = em.createQuery("SELECT e FROM Empleado e WHERE e.password = :password");
        q.setParameter("password", pass);
        return q.getResultList();
    }

    public List<Empleado> listEmplxTipo() {

        // @SuppressWarnings("JPQLValidation")
        javax.persistence.Query ql = em.createQuery("SELECT e FROM Empleado e WHERE e.idTipoEmpleado.idTipoEmpleado = 2");
        return ql.getResultList();
    }

    
    /**
     * metodo par buscarEmpleado
     *
     * @param s
     * @return
     */
    public List<Empleado> selectLike(String s) {
        if (s == null) {
            s = "";
        }

        javax.persistence.Query q = em.createQuery(
                "select p from Empleado p where (p.nomEmp like :nombres or p.apeMatEmp  "
                + "like :apeMat or p.apePatEmp like :apePat"
                + " or p.dni like :numDoc "
                + "or CONCAT(p.nomEmp ,' ', p.apePatEmp ,' ', p.apeMatEmp ) like :apellidos )  "//AND p.activo = 1
        );
        q.setParameter("nombres", "%" + s + "%");
        q.setParameter("apePat", "%" + s + "%");
        q.setParameter("apeMat", "%" + s + "%");     
        q.setParameter("numDoc", "%" + s + "%");
        q.setParameter("apellidos", "%" + s + "%");
        return q.setMaxResults(20).getResultList();

    }
}
