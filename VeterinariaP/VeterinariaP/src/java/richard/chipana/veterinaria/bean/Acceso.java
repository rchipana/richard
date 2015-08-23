/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richard.chipana.veterinaria.bean;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RICHARD
 */
@Entity
@Table(name = "acceso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acceso.findAll", query = "SELECT a FROM Acceso a"),
    @NamedQuery(name = "Acceso.findByIdoacceso", query = "SELECT a FROM Acceso a WHERE a.idoacceso = :idoacceso"),
    @NamedQuery(name = "Acceso.findByEstadoAcc", query = "SELECT a FROM Acceso a WHERE a.estadoAcc = :estadoAcc")})
public class Acceso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idoacceso")
    private Integer idoacceso;
    @Column(name = "estado_acc")
    private Integer estadoAcc;
    @JoinColumn(name = "idTipo_Empleado", referencedColumnName = "idTipo_Empleado")
    @ManyToOne(optional = false)
    private TipoEmpleado idTipoEmpleado;
    @JoinColumn(name = "idopcion", referencedColumnName = "idopcion")
    @ManyToOne(optional = false)
    private Opcion idopcion;

    public Acceso() {
    }

    public Acceso(Integer idoacceso) {
        this.idoacceso = idoacceso;
    }

    public Integer getIdoacceso() {
        return idoacceso;
    }

    public void setIdoacceso(Integer idoacceso) {
        this.idoacceso = idoacceso;
    }

    public Integer getEstadoAcc() {
        return estadoAcc;
    }

    public void setEstadoAcc(Integer estadoAcc) {
        this.estadoAcc = estadoAcc;
    }

    public TipoEmpleado getIdTipoEmpleado() {
        return idTipoEmpleado;
    }

    public void setIdTipoEmpleado(TipoEmpleado idTipoEmpleado) {
        this.idTipoEmpleado = idTipoEmpleado;
    }

    public Opcion getIdopcion() {
        return idopcion;
    }

    public void setIdopcion(Opcion idopcion) {
        this.idopcion = idopcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idoacceso != null ? idoacceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acceso)) {
            return false;
        }
        Acceso other = (Acceso) object;
        if ((this.idoacceso == null && other.idoacceso != null) || (this.idoacceso != null && !this.idoacceso.equals(other.idoacceso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.Acceso[ idoacceso=" + idoacceso + " ]";
    }
    
}
