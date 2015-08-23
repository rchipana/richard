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
@Table(name = "historia_clinica_has_vacuna")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoriaClinicaHasVacuna.findAll", query = "SELECT h FROM HistoriaClinicaHasVacuna h"),
    @NamedQuery(name = "HistoriaClinicaHasVacuna.findByIdHistoriaClinicahasVacuna", query = "SELECT h FROM HistoriaClinicaHasVacuna h WHERE h.idHistoriaClinicahasVacuna = :idHistoriaClinicahasVacuna"),
    @NamedQuery(name = "HistoriaClinicaHasVacuna.findByEstadoHvac", query = "SELECT h FROM HistoriaClinicaHasVacuna h WHERE h.estadoHvac = :estadoHvac")})
public class HistoriaClinicaHasVacuna implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdHistoria_Clinica_has_Vacuna")
    private Integer idHistoriaClinicahasVacuna;
    @Column(name = "estado_hvac")
    private Integer estadoHvac;
    @JoinColumn(name = "idVacuna", referencedColumnName = "idVacuna")
    @ManyToOne(optional = false)
    private Vacuna idVacuna;
    @JoinColumn(name = "idHistoria_Clinica", referencedColumnName = "idHistoria_Clinica")
    @ManyToOne(optional = false)
    private HistoriaClinica idHistoriaClinica;

    public HistoriaClinicaHasVacuna() {
    }

    public HistoriaClinicaHasVacuna(Integer idHistoriaClinicahasVacuna) {
        this.idHistoriaClinicahasVacuna = idHistoriaClinicahasVacuna;
    }

    public Integer getIdHistoriaClinicahasVacuna() {
        return idHistoriaClinicahasVacuna;
    }

    public void setIdHistoriaClinicahasVacuna(Integer idHistoriaClinicahasVacuna) {
        this.idHistoriaClinicahasVacuna = idHistoriaClinicahasVacuna;
    }

    public Integer getEstadoHvac() {
        return estadoHvac;
    }

    public void setEstadoHvac(Integer estadoHvac) {
        this.estadoHvac = estadoHvac;
    }

    public Vacuna getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(Vacuna idVacuna) {
        this.idVacuna = idVacuna;
    }

    public HistoriaClinica getIdHistoriaClinica() {
        return idHistoriaClinica;
    }

    public void setIdHistoriaClinica(HistoriaClinica idHistoriaClinica) {
        this.idHistoriaClinica = idHistoriaClinica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistoriaClinicahasVacuna != null ? idHistoriaClinicahasVacuna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoriaClinicaHasVacuna)) {
            return false;
        }
        HistoriaClinicaHasVacuna other = (HistoriaClinicaHasVacuna) object;
        if ((this.idHistoriaClinicahasVacuna == null && other.idHistoriaClinicahasVacuna != null) || (this.idHistoriaClinicahasVacuna != null && !this.idHistoriaClinicahasVacuna.equals(other.idHistoriaClinicahasVacuna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.HistoriaClinicaHasVacuna[ idHistoriaClinicahasVacuna=" + idHistoriaClinicahasVacuna + " ]";
    }
    
}
