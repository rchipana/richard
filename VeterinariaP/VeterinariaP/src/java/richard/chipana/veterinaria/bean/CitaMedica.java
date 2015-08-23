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
@Table(name = "cita_medica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CitaMedica.findAll", query = "SELECT c FROM CitaMedica c"),
    @NamedQuery(name = "CitaMedica.findByIdCitamedica", query = "SELECT c FROM CitaMedica c WHERE c.idCitamedica = :idCitamedica"),
    @NamedQuery(name = "CitaMedica.findByFechaInicio", query = "SELECT c FROM CitaMedica c WHERE c.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "CitaMedica.findByFechaFin", query = "SELECT c FROM CitaMedica c WHERE c.fechaFin = :fechaFin"),
    @NamedQuery(name = "CitaMedica.findByDescripcion", query = "SELECT c FROM CitaMedica c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "CitaMedica.findByEstadoCita", query = "SELECT c FROM CitaMedica c WHERE c.estadoCita = :estadoCita"),
    @NamedQuery(name = "CitaMedica.findByEstadoCit", query = "SELECT c FROM CitaMedica c WHERE c.estadoCit = :estadoCit")})
public class CitaMedica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCita_medica")
    private Integer idCitamedica;
    
    @Column(name = "fechaInicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "fechaFin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
//    @Column(name = "fechaInicio")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date fechaInicio;
//    @Column(name = "fechaFin")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date fechaFin;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 45)
    @Column(name = "estado_cita")
    private String estadoCita;
    @Column(name = "estado_cit")
    private Integer estadoCit;
    @JoinColumn(name = "idMascota", referencedColumnName = "idMascota")
    @ManyToOne(optional = false)
    private Mascota idMascota;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCitamedica")
    private List<Diagnostico> diagnosticoList;
    @JoinColumn(name = "idAsociado", referencedColumnName = "idAsociado")
    @ManyToOne(optional = false)
    private Asociado idAsociado;
    @JoinColumn(name = "idEmpleado", referencedColumnName = "idEmpleado")
    @ManyToOne(optional = false)
    private Empleado idEmpleado;
   @Column(name = "horaIni")
   @Temporal(TemporalType.TIMESTAMP)
   private Date horaIni;
//    @Column(name = "horaFin")
//    @Temporal(TemporalType.TIME)
//    private Date horaFin;

    public CitaMedica() {
    }

   public Date getHoraIni() {
       return horaIni;
    }

   public void setHoraIni(Date horaIni) {
       this.horaIni = horaIni;
    }
//
//    public Date getHoraFin() {
//        return horaFin;
//    }
//
//    public void setHoraFin(Date horaFin) {
//        this.horaFin = horaFin;
//    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    
    
    public Asociado getIdAsociado() {
        return idAsociado;
    }

    public void setIdAsociado(Asociado idAsociado) {
        this.idAsociado = idAsociado;
    }

    public CitaMedica(Integer idCitamedica) {
        this.idCitamedica = idCitamedica;
    }

    public Integer getIdCitamedica() {
        return idCitamedica;
    }

    public void setIdCitamedica(Integer idCitamedica) {
        this.idCitamedica = idCitamedica;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstadoCita() {
        return estadoCita;
    }

    public void setEstadoCita(String estadoCita) {
        this.estadoCita = estadoCita;
    }

    public Integer getEstadoCit() {
        return estadoCit;
    }

    public void setEstadoCit(Integer estadoCit) {
        this.estadoCit = estadoCit;
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
        hash += (idCitamedica != null ? idCitamedica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CitaMedica)) {
            return false;
        }
        CitaMedica other = (CitaMedica) object;
        if ((this.idCitamedica == null && other.idCitamedica != null) || (this.idCitamedica != null && !this.idCitamedica.equals(other.idCitamedica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.CitaMedica[ idCitamedica=" + idCitamedica + " ]";
    }

}
