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
@Table(name = "mascota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mascota.findAll", query = "SELECT m FROM Mascota m"),
    @NamedQuery(name = "Mascota.findByIdMascota", query = "SELECT m FROM Mascota m WHERE m.idMascota = :idMascota"),
    @NamedQuery(name = "Mascota.findByNombre", query = "SELECT m FROM Mascota m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Mascota.findByRuta", query = "SELECT m FROM Mascota m WHERE m.ruta = :ruta"),
    @NamedQuery(name = "Mascota.findByFechaNac", query = "SELECT m FROM Mascota m WHERE m.fechaNac = :fechaNac"),
    @NamedQuery(name = "Mascota.findByFechaIng", query = "SELECT m FROM Mascota m WHERE m.fechaIng = :fechaIng"),
    @NamedQuery(name = "Mascota.findBySexo", query = "SELECT m FROM Mascota m WHERE m.sexo = :sexo"),
    @NamedQuery(name = "Mascota.findByCastrado", query = "SELECT m FROM Mascota m WHERE m.castrado = :castrado"),
    @NamedQuery(name = "Mascota.findByDeceso", query = "SELECT m FROM Mascota m WHERE m.deceso = :deceso"),
    @NamedQuery(name = "Mascota.findByEstadoMas", query = "SELECT m FROM Mascota m WHERE m.estadoMas = :estadoMas")})
public class Mascota implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMascota")
    private Integer idMascota;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "ruta")
    private String ruta;
    @Column(name = "fecha_nac")
    @Temporal(TemporalType.DATE)
    private Date fechaNac;
    @Column(name = "fecha_ing")
    @Temporal(TemporalType.DATE)
    private Date fechaIng;
    @Column(name = "sexo")
    private Integer sexo;
    @Column(name = "castrado")
    private Integer castrado;
    @Column(name = "deceso")
    private Integer deceso;
    @Column(name = "estado_mas")
    private Integer estadoMas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMascota")
    private List<CitaMedica> citaMedicaList;
    @JoinColumn(name = "idPelaje", referencedColumnName = "idPelaje")
    @ManyToOne(optional = false)
    private Pelaje idPelaje;
    @JoinColumn(name = "idRaza", referencedColumnName = "idRaza")
    @ManyToOne(optional = true)
    private Raza idRaza;
    @JoinColumn(name = "idAsociado", referencedColumnName = "idAsociado")
    @ManyToOne(optional = false)
    private Asociado idAsociado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMascota")
    private List<HistoriaClinica> historiaClinicaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMascota")
    private List<CitaServicio> citaServicioList;

    public Mascota() {
    }

    public Mascota(Integer idMascota) {
        this.idMascota = idMascota;
    }

    public Integer getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Integer idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Date getFechaIng() {
        return fechaIng;
    }

    public void setFechaIng(Date fechaIng) {
        this.fechaIng = fechaIng;
    }

    public Integer getSexo() {
        return sexo;
    }

    public void setSexo(Integer sexo) {
        this.sexo = sexo;
    }

    public Integer getCastrado() {
        return castrado;
    }

    public void setCastrado(Integer castrado) {
        this.castrado = castrado;
    }

    public Integer getDeceso() {
        return deceso;
    }

    public void setDeceso(Integer deceso) {
        this.deceso = deceso;
    }

    public Integer getEstadoMas() {
        return estadoMas;
    }

    public void setEstadoMas(Integer estadoMas) {
        this.estadoMas = estadoMas;
    }

    @XmlTransient
    public List<CitaMedica> getCitaMedicaList() {
        return citaMedicaList;
    }

    public void setCitaMedicaList(List<CitaMedica> citaMedicaList) {
        this.citaMedicaList = citaMedicaList;
    }

    public Pelaje getIdPelaje() {
        return idPelaje;
    }

    public void setIdPelaje(Pelaje idPelaje) {
        this.idPelaje = idPelaje;
    }

    public Raza getIdRaza() {
        return idRaza;
    }

    public void setIdRaza(Raza idRaza) {
        this.idRaza = idRaza;
    }

    public Asociado getIdAsociado() {
        return idAsociado;
    }

    public void setIdAsociado(Asociado idAsociado) {
        this.idAsociado = idAsociado;
    }

    @XmlTransient
    public List<HistoriaClinica> getHistoriaClinicaList() {
        return historiaClinicaList;
    }

    public void setHistoriaClinicaList(List<HistoriaClinica> historiaClinicaList) {
        this.historiaClinicaList = historiaClinicaList;
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
        hash += (idMascota != null ? idMascota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mascota)) {
            return false;
        }
        Mascota other = (Mascota) object;
        if ((this.idMascota == null && other.idMascota != null) || (this.idMascota != null && !this.idMascota.equals(other.idMascota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.Mascota[ idMascota=" + idMascota + " ]";
    }
    
}
