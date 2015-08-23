/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richard.chipana.veterinaria.bean;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author RICHARD
 */
@Entity
@Table(name = "sede")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sede.findAll", query = "SELECT s FROM Sede s"),
    @NamedQuery(name = "Sede.findByIdSede", query = "SELECT s FROM Sede s WHERE s.idSede = :idSede"),
    @NamedQuery(name = "Sede.findByDescripcion", query = "SELECT s FROM Sede s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "Sede.findByDireccion", query = "SELECT s FROM Sede s WHERE s.direccion = :direccion"),
    @NamedQuery(name = "Sede.findByEstadoSed", query = "SELECT s FROM Sede s WHERE s.estadoSed = :estadoSed")})
public class Sede implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSede")
    private Integer idSede;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 100)
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "estado_sed")
    private Integer estadoSed;
    @JoinColumn(name = "idDistrito", referencedColumnName = "idDistrito")
    @ManyToOne(optional = false)
    private Distrito idDistrito;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSede")
    private List<DetalleSedeProducto> detalleSedeProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSede")
    private List<DisponibilidadM> disponibilidadMList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSede")
    private List<Auditoria> auditoriaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSede")
    private List<CitaServicio> citaServicioList;

    public Sede() {
    }

    public Sede(Integer idSede) {
        this.idSede = idSede;
    }

    public Integer getIdSede() {
        return idSede;
    }

    public void setIdSede(Integer idSede) {
        this.idSede = idSede;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getEstadoSed() {
        return estadoSed;
    }

    public void setEstadoSed(Integer estadoSed) {
        this.estadoSed = estadoSed;
    }

    public Distrito getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(Distrito idDistrito) {
        this.idDistrito = idDistrito;
    }

    @XmlTransient
    public List<DetalleSedeProducto> getDetalleSedeProductoList() {
        return detalleSedeProductoList;
    }

    public void setDetalleSedeProductoList(List<DetalleSedeProducto> detalleSedeProductoList) {
        this.detalleSedeProductoList = detalleSedeProductoList;
    }

    @XmlTransient
    public List<DisponibilidadM> getDisponibilidadMList() {
        return disponibilidadMList;
    }

    public void setDisponibilidadMList(List<DisponibilidadM> disponibilidadMList) {
        this.disponibilidadMList = disponibilidadMList;
    }

    @XmlTransient
    public List<Auditoria> getAuditoriaList() {
        return auditoriaList;
    }

    public void setAuditoriaList(List<Auditoria> auditoriaList) {
        this.auditoriaList = auditoriaList;
    }

    @XmlTransient
    public List<CitaServicio> getCitaServicioList() {
        return citaServicioList;
    }

    public void setCitaServicioList(List<CitaServicio> citaServicioList) {
        this.citaServicioList = citaServicioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSede != null ? idSede.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sede)) {
            return false;
        }
        Sede other = (Sede) object;
        if ((this.idSede == null && other.idSede != null) || (this.idSede != null && !this.idSede.equals(other.idSede))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.Sede[ idSede=" + idSede + " ]";
    }
    
}
