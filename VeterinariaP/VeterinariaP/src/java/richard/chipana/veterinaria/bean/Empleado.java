/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richard.chipana.veterinaria.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author RICHARD
 */
@Entity
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByIdEmpleado", query = "SELECT e FROM Empleado e WHERE e.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "Empleado.findByDni", query = "SELECT e FROM Empleado e WHERE e.dni = :dni"),
    @NamedQuery(name = "Empleado.findByNomEmp", query = "SELECT e FROM Empleado e WHERE e.nomEmp = :nomEmp"),
    @NamedQuery(name = "Empleado.findByApePatEmp", query = "SELECT e FROM Empleado e WHERE e.apePatEmp = :apePatEmp"),
    @NamedQuery(name = "Empleado.findByApeMatEmp", query = "SELECT e FROM Empleado e WHERE e.apeMatEmp = :apeMatEmp"),
    @NamedQuery(name = "Empleado.findByFechaIngEmp", query = "SELECT e FROM Empleado e WHERE e.fechaIngEmp = :fechaIngEmp"),
    @NamedQuery(name = "Empleado.findByEstadoEmp", query = "SELECT e FROM Empleado e WHERE e.estadoEmp = :estadoEmp"),
    @NamedQuery(name = "Empleado.findByEmailEmp", query = "SELECT e FROM Empleado e WHERE e.emailEmp = :emailEmp"),
    @NamedQuery(name = "Empleado.findByGeneroEmp", query = "SELECT e FROM Empleado e WHERE e.generoEmp = :generoEmp"),
    @NamedQuery(name = "Empleado.findByFechaNaciEmp", query = "SELECT e FROM Empleado e WHERE e.fechaNaciEmp = :fechaNaciEmp"),
    @NamedQuery(name = "Empleado.findByPassword", query = "SELECT e FROM Empleado e WHERE e.password = :password")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEmpleado")
    private Integer idEmpleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "dni")
    private String dni;
    @Size(max = 45)
    @Column(name = "nom_emp")
    private String nomEmp;
    @Size(max = 45)
    @Column(name = "ape_pat_emp")
    private String apePatEmp;
    @Size(max = 45)
    @Column(name = "ape_mat_emp")
    private String apeMatEmp;
    @Column(name = "fecha_ing_emp")
    @Temporal(TemporalType.DATE)
    private Date fechaIngEmp;
    @Column(name = "estado_emp")
    private Integer estadoEmp;
    @Size(max = 45)
    @Column(name = "email_emp")
    private String emailEmp;
    @Size(max = 45)
    @Column(name = "genero_emp")
    private String generoEmp;
    @Column(name = "fecha_naci_emp")
    @Temporal(TemporalType.DATE)
    private Date fechaNaciEmp;
    @Size(max = 60)
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleado")
    private List<Permiso> permisoList;
    @JoinColumn(name = "idTipo_Empleado", referencedColumnName = "idTipo_Empleado")
    @ManyToOne(optional = false)
    private TipoEmpleado idTipoEmpleado;
    @JoinColumn(name = "idHorario", referencedColumnName = "idHorario")
    @ManyToOne(optional = false)
    private Horario idHorario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleado")
    private List<CitaMedica> citaMedicaList;

    public Empleado() {
    }

    public String getNombreCompleto() {
        return nomEmp + " " + apePatEmp + " " + apeMatEmp;
    }

    public Empleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empleado(Integer idEmpleado, String dni) {
        this.idEmpleado = idEmpleado;
        this.dni = dni;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNomEmp() {
        return nomEmp;
    }

    public void setNomEmp(String nomEmp) {
        this.nomEmp = nomEmp;
    }

    public String getApePatEmp() {
        return apePatEmp;
    }

    public void setApePatEmp(String apePatEmp) {
        this.apePatEmp = apePatEmp;
    }

    public String getApeMatEmp() {
        return apeMatEmp;
    }

    public void setApeMatEmp(String apeMatEmp) {
        this.apeMatEmp = apeMatEmp;
    }

    public Date getFechaIngEmp() {
        return fechaIngEmp;
    }

    public void setFechaIngEmp(Date fechaIngEmp) {
        this.fechaIngEmp = fechaIngEmp;
    }

    public Integer getEstadoEmp() {
        return estadoEmp;
    }

    public void setEstadoEmp(Integer estadoEmp) {
        this.estadoEmp = estadoEmp;
    }

    public String getEmailEmp() {
        return emailEmp;
    }

    public void setEmailEmp(String emailEmp) {
        this.emailEmp = emailEmp;
    }

    public String getGeneroEmp() {
        return generoEmp;
    }

    public void setGeneroEmp(String generoEmp) {
        this.generoEmp = generoEmp;
    }

    public Date getFechaNaciEmp() {
        return fechaNaciEmp;
    }

    public void setFechaNaciEmp(Date fechaNaciEmp) {
        this.fechaNaciEmp = fechaNaciEmp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public List<CitaMedica> getCitaMedicaList() {
        return citaMedicaList;
    }

    public void setCitaMedicaList(List<CitaMedica> citaMedicaList) {
        this.citaMedicaList = citaMedicaList;
    }

    public List<Permiso> getPermisoList() {
        return permisoList;
    }

    public void setPermisoList(List<Permiso> permisoList) {
        this.permisoList = permisoList;
    }

    public TipoEmpleado getIdTipoEmpleado() {
        return idTipoEmpleado;
    }

    public void setIdTipoEmpleado(TipoEmpleado idTipoEmpleado) {
        this.idTipoEmpleado = idTipoEmpleado;
    }

    public Horario getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Horario idHorario) {
        this.idHorario = idHorario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.Empleado[ idEmpleado=" + idEmpleado + " ]";
    }

}
