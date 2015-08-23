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
@Table(name = "disponibilidad_s")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DisponibilidadS.findAll", query = "SELECT d FROM DisponibilidadS d"),
    @NamedQuery(name = "DisponibilidadS.findByIdDisponibilidads", query = "SELECT d FROM DisponibilidadS d WHERE d.idDisponibilidads = :idDisponibilidads"),
    @NamedQuery(name = "DisponibilidadS.findByFechaDispS", query = "SELECT d FROM DisponibilidadS d WHERE d.fechaDispS = :fechaDispS"),
    @NamedQuery(name = "DisponibilidadS.findByHoraDispS", query = "SELECT d FROM DisponibilidadS d WHERE d.horaDispS = :horaDispS"),
    @NamedQuery(name = "DisponibilidadS.findByEstadoDip", query = "SELECT d FROM DisponibilidadS d WHERE d.estadoDip = :estadoDip")})
public class DisponibilidadS implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDisponibilidad_s")
    private Integer idDisponibilidads;
    @Size(max = 45)
    @Column(name = "fecha_disp_s")
    private String fechaDispS;
    @Size(max = 45)
    @Column(name = "hora_disp_s")
    private String horaDispS;
    @Column(name = "estado_dip")
    private Integer estadoDip;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
    @ManyToOne(optional = false)
    private Producto idProducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDisponibilidads")
    private List<CitaServicio> citaServicioList;

    public DisponibilidadS() {
    }

    public DisponibilidadS(Integer idDisponibilidads) {
        this.idDisponibilidads = idDisponibilidads;
    }

    public Integer getIdDisponibilidads() {
        return idDisponibilidads;
    }

    public void setIdDisponibilidads(Integer idDisponibilidads) {
        this.idDisponibilidads = idDisponibilidads;
    }

    public String getFechaDispS() {
        return fechaDispS;
    }

    public void setFechaDispS(String fechaDispS) {
        this.fechaDispS = fechaDispS;
    }

    public String getHoraDispS() {
        return horaDispS;
    }

    public void setHoraDispS(String horaDispS) {
        this.horaDispS = horaDispS;
    }

    public Integer getEstadoDip() {
        return estadoDip;
    }

    public void setEstadoDip(Integer estadoDip) {
        this.estadoDip = estadoDip;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
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
        hash += (idDisponibilidads != null ? idDisponibilidads.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DisponibilidadS)) {
            return false;
        }
        DisponibilidadS other = (DisponibilidadS) object;
        if ((this.idDisponibilidads == null && other.idDisponibilidads != null) || (this.idDisponibilidads != null && !this.idDisponibilidads.equals(other.idDisponibilidads))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.DisponibilidadS[ idDisponibilidads=" + idDisponibilidads + " ]";
    }
    
}
