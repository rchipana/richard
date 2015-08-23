/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richard.chipana.veterinaria.bean;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author RICHARD
 */
@Entity
@Table(name = "tipo_empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEmpleado.findAll", query = "SELECT t FROM TipoEmpleado t"),
    @NamedQuery(name = "TipoEmpleado.findByIdTipoEmpleado", query = "SELECT t FROM TipoEmpleado t WHERE t.idTipoEmpleado = :idTipoEmpleado"),
    @NamedQuery(name = "TipoEmpleado.findByDescripTipoEmp", query = "SELECT t FROM TipoEmpleado t WHERE t.descripTipoEmp = :descripTipoEmp"),
    @NamedQuery(name = "TipoEmpleado.findByObsTipoEmp", query = "SELECT t FROM TipoEmpleado t WHERE t.obsTipoEmp = :obsTipoEmp"),
    @NamedQuery(name = "TipoEmpleado.findByEstadoTie", query = "SELECT t FROM TipoEmpleado t WHERE t.estadoTie = :estadoTie")})
public class TipoEmpleado implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoEmpleado")
    private Collection<Menu> menuCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipo_Empleado")
    private Integer idTipoEmpleado;
    @Size(max = 45)
    @Column(name = "descrip_tipo_emp")
    private String descripTipoEmp;
    @Size(max = 45)
    @Column(name = "obs_tipo_emp")
    private String obsTipoEmp;
    @Column(name = "estado_tie")
    private Integer estadoTie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoEmpleado")
    private List<Permiso> permisoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoEmpleado")
    private List<Empleado> empleadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoEmpleado")
    private List<Acceso> accesoList;

    public TipoEmpleado() {
    }

    public TipoEmpleado(Integer idTipoEmpleado) {
        this.idTipoEmpleado = idTipoEmpleado;
    }

    public Integer getIdTipoEmpleado() {
        return idTipoEmpleado;
    }

    public void setIdTipoEmpleado(Integer idTipoEmpleado) {
        this.idTipoEmpleado = idTipoEmpleado;
    }

    public String getDescripTipoEmp() {
        return descripTipoEmp;
    }

    public void setDescripTipoEmp(String descripTipoEmp) {
        this.descripTipoEmp = descripTipoEmp;
    }

    public String getObsTipoEmp() {
        return obsTipoEmp;
    }

    public void setObsTipoEmp(String obsTipoEmp) {
        this.obsTipoEmp = obsTipoEmp;
    }

    public Integer getEstadoTie() {
        return estadoTie;
    }

    public void setEstadoTie(Integer estadoTie) {
        this.estadoTie = estadoTie;
    }

    @XmlTransient
    public List<Permiso> getPermisoList() {
        return permisoList;
    }

    public void setPermisoList(List<Permiso> permisoList) {
        this.permisoList = permisoList;
    }

    @XmlTransient
    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    @XmlTransient
    public List<Acceso> getAccesoList() {
        return accesoList;
    }

    public void setAccesoList(List<Acceso> accesoList) {
        this.accesoList = accesoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoEmpleado != null ? idTipoEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEmpleado)) {
            return false;
        }
        TipoEmpleado other = (TipoEmpleado) object;
        if ((this.idTipoEmpleado == null && other.idTipoEmpleado != null) || (this.idTipoEmpleado != null && !this.idTipoEmpleado.equals(other.idTipoEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.TipoEmpleado[ idTipoEmpleado=" + idTipoEmpleado + " ]";
    }

    @XmlTransient
    public Collection<Menu> getMenuCollection() {
        return menuCollection;
    }

    public void setMenuCollection(Collection<Menu> menuCollection) {
        this.menuCollection = menuCollection;
    }
    
}
