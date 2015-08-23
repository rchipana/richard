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
@Table(name = "vacuna")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vacuna.findAll", query = "SELECT v FROM Vacuna v"),
    @NamedQuery(name = "Vacuna.findByIdVacuna", query = "SELECT v FROM Vacuna v WHERE v.idVacuna = :idVacuna"),
    @NamedQuery(name = "Vacuna.findByDescripcion", query = "SELECT v FROM Vacuna v WHERE v.descripcion = :descripcion"),
    @NamedQuery(name = "Vacuna.findByEstadoVac", query = "SELECT v FROM Vacuna v WHERE v.estadoVac = :estadoVac")})
public class Vacuna implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVacuna")
    private Integer idVacuna;
    @Size(max = 70)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estado_vac")
    private Integer estadoVac;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVacuna")
    private List<DiagnosticoVacuna> diagnosticoVacunaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVacuna")
    private List<HistoriaClinicaHasVacuna> historiaClinicaHasVacunaList;

    public Vacuna() {
    }

    public Vacuna(Integer idVacuna) {
        this.idVacuna = idVacuna;
    }

    public Integer getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(Integer idVacuna) {
        this.idVacuna = idVacuna;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getEstadoVac() {
        return estadoVac;
    }

    public void setEstadoVac(Integer estadoVac) {
        this.estadoVac = estadoVac;
    }

    @XmlTransient
    public List<DiagnosticoVacuna> getDiagnosticoVacunaList() {
        return diagnosticoVacunaList;
    }

    public void setDiagnosticoVacunaList(List<DiagnosticoVacuna> diagnosticoVacunaList) {
        this.diagnosticoVacunaList = diagnosticoVacunaList;
    }

    @XmlTransient
    public List<HistoriaClinicaHasVacuna> getHistoriaClinicaHasVacunaList() {
        return historiaClinicaHasVacunaList;
    }

    public void setHistoriaClinicaHasVacunaList(List<HistoriaClinicaHasVacuna> historiaClinicaHasVacunaList) {
        this.historiaClinicaHasVacunaList = historiaClinicaHasVacunaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVacuna != null ? idVacuna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vacuna)) {
            return false;
        }
        Vacuna other = (Vacuna) object;
        if ((this.idVacuna == null && other.idVacuna != null) || (this.idVacuna != null && !this.idVacuna.equals(other.idVacuna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.Vacuna[ idVacuna=" + idVacuna + " ]";
    }
    
}
