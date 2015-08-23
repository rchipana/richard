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
@Table(name = "diagnostico_vacuna")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiagnosticoVacuna.findAll", query = "SELECT d FROM DiagnosticoVacuna d"),
    @NamedQuery(name = "DiagnosticoVacuna.findByIdDiagnosticoVacuna", query = "SELECT d FROM DiagnosticoVacuna d WHERE d.idDiagnosticoVacuna = :idDiagnosticoVacuna"),
    @NamedQuery(name = "DiagnosticoVacuna.findByEstadoDvac", query = "SELECT d FROM DiagnosticoVacuna d WHERE d.estadoDvac = :estadoDvac")})
public class DiagnosticoVacuna implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDiagnostico_Vacuna")
    private Integer idDiagnosticoVacuna;
    @Column(name = "estado_dvac")
    private Integer estadoDvac;
    @JoinColumn(name = "idDiagnostico", referencedColumnName = "idDiagnostico")
    @ManyToOne(optional = false)
    private Diagnostico idDiagnostico;
    @JoinColumn(name = "idVacuna", referencedColumnName = "idVacuna")
    @ManyToOne(optional = false)
    private Vacuna idVacuna;
    @JoinColumn(name = "idHistoria_Clinica", referencedColumnName = "idHistoria_Clinica")
    @ManyToOne(optional = false)
    private HistoriaClinica idHistoriaClinica;

    public DiagnosticoVacuna() {
    }

    public DiagnosticoVacuna(Integer idDiagnosticoVacuna) {
        this.idDiagnosticoVacuna = idDiagnosticoVacuna;
    }

    public Integer getIdDiagnosticoVacuna() {
        return idDiagnosticoVacuna;
    }

    public void setIdDiagnosticoVacuna(Integer idDiagnosticoVacuna) {
        this.idDiagnosticoVacuna = idDiagnosticoVacuna;
    }

    public Integer getEstadoDvac() {
        return estadoDvac;
    }

    public void setEstadoDvac(Integer estadoDvac) {
        this.estadoDvac = estadoDvac;
    }

    public Diagnostico getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(Diagnostico idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
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
        hash += (idDiagnosticoVacuna != null ? idDiagnosticoVacuna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagnosticoVacuna)) {
            return false;
        }
        DiagnosticoVacuna other = (DiagnosticoVacuna) object;
        if ((this.idDiagnosticoVacuna == null && other.idDiagnosticoVacuna != null) || (this.idDiagnosticoVacuna != null && !this.idDiagnosticoVacuna.equals(other.idDiagnosticoVacuna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.DiagnosticoVacuna[ idDiagnosticoVacuna=" + idDiagnosticoVacuna + " ]";
    }
    
}
