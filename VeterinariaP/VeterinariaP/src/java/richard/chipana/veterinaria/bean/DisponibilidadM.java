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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RICHARD
 */
@Entity
@Table(name = "disponibilidad_m")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DisponibilidadM.findAll", query = "SELECT d FROM DisponibilidadM d"),
    @NamedQuery(name = "DisponibilidadM.findByIdDisponibilidadm", query = "SELECT d FROM DisponibilidadM d WHERE d.idDisponibilidadm = :idDisponibilidadm"),
    @NamedQuery(name = "DisponibilidadM.findByFechaDispM", query = "SELECT d FROM DisponibilidadM d WHERE d.fechaDispM = :fechaDispM"),
    @NamedQuery(name = "DisponibilidadM.findByHoraDispM", query = "SELECT d FROM DisponibilidadM d WHERE d.horaDispM = :horaDispM"),
    @NamedQuery(name = "DisponibilidadM.findByEstado", query = "SELECT d FROM DisponibilidadM d WHERE d.estado = :estado"),
    @NamedQuery(name = "DisponibilidadM.findByEstadoDim", query = "SELECT d FROM DisponibilidadM d WHERE d.estadoDim = :estadoDim")})
public class DisponibilidadM implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDisponibilidad_m")
    private Integer idDisponibilidadm;
    @Size(max = 45)
    @Column(name = "fecha_disp_m")
    private String fechaDispM;
    @Size(max = 45)
    @Column(name = "hora_disp_m")
    private String horaDispM;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @Column(name = "estado_dim")
    private Integer estadoDim;
    @JoinColumn(name = "idSede", referencedColumnName = "idSede")
    @ManyToOne(optional = false)
    private Sede idSede;

    public DisponibilidadM() {
    }

    public DisponibilidadM(Integer idDisponibilidadm) {
        this.idDisponibilidadm = idDisponibilidadm;
    }

    public Integer getIdDisponibilidadm() {
        return idDisponibilidadm;
    }

    public void setIdDisponibilidadm(Integer idDisponibilidadm) {
        this.idDisponibilidadm = idDisponibilidadm;
    }

    public String getFechaDispM() {
        return fechaDispM;
    }

    public void setFechaDispM(String fechaDispM) {
        this.fechaDispM = fechaDispM;
    }

    public String getHoraDispM() {
        return horaDispM;
    }

    public void setHoraDispM(String horaDispM) {
        this.horaDispM = horaDispM;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getEstadoDim() {
        return estadoDim;
    }

    public void setEstadoDim(Integer estadoDim) {
        this.estadoDim = estadoDim;
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
        hash += (idDisponibilidadm != null ? idDisponibilidadm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DisponibilidadM)) {
            return false;
        }
        DisponibilidadM other = (DisponibilidadM) object;
        if ((this.idDisponibilidadm == null && other.idDisponibilidadm != null) || (this.idDisponibilidadm != null && !this.idDisponibilidadm.equals(other.idDisponibilidadm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.DisponibilidadM[ idDisponibilidadm=" + idDisponibilidadm + " ]";
    }
    
}
