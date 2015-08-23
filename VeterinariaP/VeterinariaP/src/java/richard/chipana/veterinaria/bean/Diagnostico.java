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
@Table(name = "diagnostico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diagnostico.findAll", query = "SELECT d FROM Diagnostico d"),
    @NamedQuery(name = "Diagnostico.findByIdDiagnostico", query = "SELECT d FROM Diagnostico d WHERE d.idDiagnostico = :idDiagnostico"),
    @NamedQuery(name = "Diagnostico.findByFecha", query = "SELECT d FROM Diagnostico d WHERE d.fecha = :fecha"),
    @NamedQuery(name = "Diagnostico.findByPeso", query = "SELECT d FROM Diagnostico d WHERE d.peso = :peso"),
    @NamedQuery(name = "Diagnostico.findByTalla", query = "SELECT d FROM Diagnostico d WHERE d.talla = :talla"),
    @NamedQuery(name = "Diagnostico.findByAtendidoPor", query = "SELECT d FROM Diagnostico d WHERE d.atendidoPor = :atendidoPor"),
    @NamedQuery(name = "Diagnostico.findByMucosas", query = "SELECT d FROM Diagnostico d WHERE d.mucosas = :mucosas"),
    @NamedQuery(name = "Diagnostico.findByMotivo", query = "SELECT d FROM Diagnostico d WHERE d.motivo = :motivo"),
    @NamedQuery(name = "Diagnostico.findByExamenCli", query = "SELECT d FROM Diagnostico d WHERE d.examenCli = :examenCli"),
    @NamedQuery(name = "Diagnostico.findByDiagnostico", query = "SELECT d FROM Diagnostico d WHERE d.diagnostico = :diagnostico"),
    @NamedQuery(name = "Diagnostico.findByAnalisisSolicitados", query = "SELECT d FROM Diagnostico d WHERE d.analisisSolicitados = :analisisSolicitados"),
    @NamedQuery(name = "Diagnostico.findByTratamiento", query = "SELECT d FROM Diagnostico d WHERE d.tratamiento = :tratamiento"),
    @NamedQuery(name = "Diagnostico.findByProximaCita", query = "SELECT d FROM Diagnostico d WHERE d.proximaCita = :proximaCita"),
    @NamedQuery(name = "Diagnostico.findByEstadoDia", query = "SELECT d FROM Diagnostico d WHERE d.estadoDia = :estadoDia")})
public class Diagnostico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDiagnostico")
    private Integer idDiagnostico;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 45)
    @Column(name = "peso")
    private String peso;
    @Size(max = 45)
    @Column(name = "talla")
    private String talla;
    @Size(max = 45)
    @Column(name = "atendido_por")
    private String atendidoPor;
    @Size(max = 45)
    @Column(name = "mucosas")
    private String mucosas;
    @Size(max = 45)
    @Column(name = "motivo")
    private String motivo;
    @Size(max = 500)
    @Column(name = "examen_cli")
    private String examenCli;
    @Size(max = 500)
    @Column(name = "diagnostico")
    private String diagnostico;
    @Size(max = 45)
    @Column(name = "analisis_solicitados")
    private String analisisSolicitados;
    @Size(max = 500)
    @Column(name = "tratamiento")
    private String tratamiento;
    @Size(max = 45)
    @Column(name = "proxima_cita")
    private String proximaCita;
    @Column(name = "estado_dia")
    private Integer estadoDia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDiagnostico")
    private List<DiagnosticoVacuna> diagnosticoVacunaList;
    @JoinColumn(name = "idCita_medica", referencedColumnName = "idCita_medica")
    @ManyToOne(optional = true)
    private CitaMedica idCitamedica;
    @JoinColumn(name = "idHistoria_Clinica", referencedColumnName = "idHistoria_Clinica")
    @ManyToOne(optional = false)
    private HistoriaClinica idHistoriaClinica;

    public Diagnostico() {
    }

    public Diagnostico(Integer idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public Integer getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(Integer idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public String getAtendidoPor() {
        return atendidoPor;
    }

    public void setAtendidoPor(String atendidoPor) {
        this.atendidoPor = atendidoPor;
    }

    public String getMucosas() {
        return mucosas;
    }

    public void setMucosas(String mucosas) {
        this.mucosas = mucosas;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getExamenCli() {
        return examenCli;
    }

    public void setExamenCli(String examenCli) {
        this.examenCli = examenCli;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getAnalisisSolicitados() {
        return analisisSolicitados;
    }

    public void setAnalisisSolicitados(String analisisSolicitados) {
        this.analisisSolicitados = analisisSolicitados;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getProximaCita() {
        return proximaCita;
    }

    public void setProximaCita(String proximaCita) {
        this.proximaCita = proximaCita;
    }

    public Integer getEstadoDia() {
        return estadoDia;
    }

    public void setEstadoDia(Integer estadoDia) {
        this.estadoDia = estadoDia;
    }

    @XmlTransient
    public List<DiagnosticoVacuna> getDiagnosticoVacunaList() {
        return diagnosticoVacunaList;
    }

    public void setDiagnosticoVacunaList(List<DiagnosticoVacuna> diagnosticoVacunaList) {
        this.diagnosticoVacunaList = diagnosticoVacunaList;
    }

    public CitaMedica getIdCitamedica() {
        return idCitamedica;
    }

    public void setIdCitamedica(CitaMedica idCitamedica) {
        this.idCitamedica = idCitamedica;
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
        hash += (idDiagnostico != null ? idDiagnostico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diagnostico)) {
            return false;
        }
        Diagnostico other = (Diagnostico) object;
        if ((this.idDiagnostico == null && other.idDiagnostico != null) || (this.idDiagnostico != null && !this.idDiagnostico.equals(other.idDiagnostico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.Diagnostico[ idDiagnostico=" + idDiagnostico + " ]";
    }

}
