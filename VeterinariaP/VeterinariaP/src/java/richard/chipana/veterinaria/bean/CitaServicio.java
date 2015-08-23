/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richard.chipana.veterinaria.bean;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RICHARD
 */
@Entity
@Table(name = "cita_servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CitaServicio.findAll", query = "SELECT c FROM CitaServicio c"),
    @NamedQuery(name = "CitaServicio.findByIdCitaservicio", query = "SELECT c FROM CitaServicio c WHERE c.idCitaservicio = :idCitaservicio"),
    @NamedQuery(name = "CitaServicio.findByFechaCitaS", query = "SELECT c FROM CitaServicio c WHERE c.fechaCitaS = :fechaCitaS"),
    @NamedQuery(name = "CitaServicio.findByObsCitaS", query = "SELECT c FROM CitaServicio c WHERE c.obsCitaS = :obsCitaS"),
    @NamedQuery(name = "CitaServicio.findByEstadoCitaS", query = "SELECT c FROM CitaServicio c WHERE c.estadoCitaS = :estadoCitaS"),
    @NamedQuery(name = "CitaServicio.findByEstadoCts", query = "SELECT c FROM CitaServicio c WHERE c.estadoCts = :estadoCts")})
public class CitaServicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCita_servicio")
    private Integer idCitaservicio;
    @Column(name = "fecha_cita_s")
    @Temporal(TemporalType.DATE)
    private Date fechaCitaS;
    @Size(max = 45)
    @Column(name = "obs_cita_s")
    private String obsCitaS;
    @Size(max = 45)
    @Column(name = "estado_cita_s")
    private String estadoCitaS;
    @Column(name = "estado_cts")
    private Integer estadoCts;
    @JoinColumn(name = "idDisponibilidad_s", referencedColumnName = "idDisponibilidad_s")
    @ManyToOne(optional = false)
    private DisponibilidadS idDisponibilidads;
    @JoinColumn(name = "idMascota", referencedColumnName = "idMascota")
    @ManyToOne(optional = false)
    private Mascota idMascota;
    @JoinColumn(name = "idSede", referencedColumnName = "idSede")
    @ManyToOne(optional = false)
    private Sede idSede;

    public CitaServicio() {
    }

    public CitaServicio(Integer idCitaservicio) {
        this.idCitaservicio = idCitaservicio;
    }

    public Integer getIdCitaservicio() {
        return idCitaservicio;
    }

    public void setIdCitaservicio(Integer idCitaservicio) {
        this.idCitaservicio = idCitaservicio;
    }

    public Date getFechaCitaS() {
        return fechaCitaS;
    }

    public void setFechaCitaS(Date fechaCitaS) {
        this.fechaCitaS = fechaCitaS;
    }

    public String getObsCitaS() {
        return obsCitaS;
    }

    public void setObsCitaS(String obsCitaS) {
        this.obsCitaS = obsCitaS;
    }

    public String getEstadoCitaS() {
        return estadoCitaS;
    }

    public void setEstadoCitaS(String estadoCitaS) {
        this.estadoCitaS = estadoCitaS;
    }

    public Integer getEstadoCts() {
        return estadoCts;
    }

    public void setEstadoCts(Integer estadoCts) {
        this.estadoCts = estadoCts;
    }

    public DisponibilidadS getIdDisponibilidads() {
        return idDisponibilidads;
    }

    public void setIdDisponibilidads(DisponibilidadS idDisponibilidads) {
        this.idDisponibilidads = idDisponibilidads;
    }

    public Mascota getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Mascota idMascota) {
        this.idMascota = idMascota;
    }

    public Sede getIdSede() {
        return idSede;
    }

    public void setIdSede(Sede idSede) {
        this.idSede = idSede;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCitaservicio != null ? idCitaservicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CitaServicio)) {
            return false;
        }
        CitaServicio other = (CitaServicio) object;
        if ((this.idCitaservicio == null && other.idCitaservicio != null) || (this.idCitaservicio != null && !this.idCitaservicio.equals(other.idCitaservicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.CitaServicio[ idCitaservicio=" + idCitaservicio + " ]";
    }
    
}
