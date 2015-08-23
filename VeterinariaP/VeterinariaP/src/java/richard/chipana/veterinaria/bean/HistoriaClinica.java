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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author RICHARD
 */
@Entity
@Table(name = "historia_clinica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoriaClinica.findAll", query = "SELECT h FROM HistoriaClinica h"),
    @NamedQuery(name = "HistoriaClinica.findByIdHistoriaClinica", query = "SELECT h FROM HistoriaClinica h WHERE h.idHistoriaClinica = :idHistoriaClinica"),
    @NamedQuery(name = "HistoriaClinica.findByFechaReg", query = "SELECT h FROM HistoriaClinica h WHERE h.fechaReg = :fechaReg"),
    @NamedQuery(name = "HistoriaClinica.findByPeso", query = "SELECT h FROM HistoriaClinica h WHERE h.peso = :peso"),
    @NamedQuery(name = "HistoriaClinica.findByTalla", query = "SELECT h FROM HistoriaClinica h WHERE h.talla = :talla"),
    @NamedQuery(name = "HistoriaClinica.findByMucosas", query = "SELECT h FROM HistoriaClinica h WHERE h.mucosas = :mucosas"),
    @NamedQuery(name = "HistoriaClinica.findByAnamnesis", query = "SELECT h FROM HistoriaClinica h WHERE h.anamnesis = :anamnesis"),
    @NamedQuery(name = "HistoriaClinica.findByOtroconsultorio", query = "SELECT h FROM HistoriaClinica h WHERE h.otroconsultorio = :otroconsultorio"),
    @NamedQuery(name = "HistoriaClinica.findByTratamiento", query = "SELECT h FROM HistoriaClinica h WHERE h.tratamiento = :tratamiento"),
    @NamedQuery(name = "HistoriaClinica.findByEstadoHis", query = "SELECT h FROM HistoriaClinica h WHERE h.estadoHis = :estadoHis")})
public class HistoriaClinica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idHistoria_Clinica")
    private Integer idHistoriaClinica;
    @Column(name = "fecha_reg")
    @Temporal(TemporalType.DATE)
    private Date fechaReg;
    @Size(max = 45)
    @Column(name = "peso")
    private String peso;
    @Size(max = 45)
    @Column(name = "talla")
    private String talla;
    @Size(max = 45)
    @Column(name = "mucosas")
    private String mucosas;
    @Size(max = 45)
    @Column(name = "anamnesis")
    private String anamnesis;
    @Column(name = "otroconsultorio")
    private Integer otroconsultorio;
    @Size(max = 45)
    @Column(name = "tratamiento")
    private String tratamiento;
    @Column(name = "estado_his")
    private Integer estadoHis;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHistoriaClinica")
    private List<DiagnosticoVacuna> diagnosticoVacunaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHistoriaClinica")
    private List<HistoriaClinicaHasVacuna> historiaClinicaHasVacunaList;
    @JoinColumn(name = "idMascota", referencedColumnName = "idMascota")
    @ManyToOne(optional = false)
    private Mascota idMascota;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHistoriaClinica")
    private List<Diagnostico> diagnosticoList;
    @JoinColumn(name = "idAsociado", referencedColumnName = "idAsociado")
    @ManyToOne(optional = false)
    private Asociado idAsociado;

    public HistoriaClinica() {
    }

    public Asociado getIdAsociado() {
        return idAsociado;
    }

    public void setIdAsociado(Asociado idAsociado) {
        this.idAsociado = idAsociado;
    }

    
    
    public HistoriaClinica(Integer idHistoriaClinica) {
        this.idHistoriaClinica = idHistoriaClinica;
    }

    public Integer getIdHistoriaClinica() {
        return idHistoriaClinica;
    }

    public void setIdHistoriaClinica(Integer idHistoriaClinica) {
        this.idHistoriaClinica = idHistoriaClinica;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getMucosas() {
        return mucosas;
    }

    public void setMucosas(String mucosas) {
        this.mucosas = mucosas;
    }

    public String getAnamnesis() {
        return anamnesis;
    }

    public void setAnamnesis(String anamnesis) {
        this.anamnesis = anamnesis;
    }

    public Integer getOtroconsultorio() {
        return otroconsultorio;
    }

    public void setOtroconsultorio(Integer otroconsultorio) {
        this.otroconsultorio = otroconsultorio;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Integer getEstadoHis() {
        return estadoHis;
    }

    public void setEstadoHis(Integer estadoHis) {
        this.estadoHis = estadoHis;
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

    public Mascota getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Mascota idMascota) {
        this.idMascota = idMascota;
    }

    @XmlTransient
    public List<Diagnostico> getDiagnosticoList() {
        return diagnosticoList;
    }

    public void setDiagnosticoList(List<Diagnostico> diagnosticoList) {
        this.diagnosticoList = diagnosticoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistoriaClinica != null ? idHistoriaClinica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoriaClinica)) {
            return false;
        }
        HistoriaClinica other = (HistoriaClinica) object;
        if ((this.idHistoriaClinica == null && other.idHistoriaClinica != null) || (this.idHistoriaClinica != null && !this.idHistoriaClinica.equals(other.idHistoriaClinica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.HistoriaClinica[ idHistoriaClinica=" + idHistoriaClinica + " ]";
    }

}
