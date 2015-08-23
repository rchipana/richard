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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author RICHARD
 */
@Entity
@Table(name = "asociado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asociado.findAll", query = "SELECT a FROM Asociado a"),
    @NamedQuery(name = "Asociado.findByIdAsociado", query = "SELECT a FROM Asociado a WHERE a.idAsociado = :idAsociado"),
    @NamedQuery(name = "Asociado.findByNombres", query = "SELECT a FROM Asociado a WHERE a.nombres = :nombres"),
    @NamedQuery(name = "Asociado.findByApePat", query = "SELECT a FROM Asociado a WHERE a.apePat = :apePat"),
    @NamedQuery(name = "Asociado.findByApeMat", query = "SELECT a FROM Asociado a WHERE a.apeMat = :apeMat"),
    @NamedQuery(name = "Asociado.findBySexo", query = "SELECT a FROM Asociado a WHERE a.sexo = :sexo"),
    @NamedQuery(name = "Asociado.findByFechaNac", query = "SELECT a FROM Asociado a WHERE a.fechaNac = :fechaNac"),
    @NamedQuery(name = "Asociado.findByTelef", query = "SELECT a FROM Asociado a WHERE a.telef = :telef"),
    @NamedQuery(name = "Asociado.findByCelular", query = "SELECT a FROM Asociado a WHERE a.celular = :celular"),
    @NamedQuery(name = "Asociado.findByDirecc", query = "SELECT a FROM Asociado a WHERE a.direcc = :direcc"),
    @NamedQuery(name = "Asociado.findByEmail", query = "SELECT a FROM Asociado a WHERE a.email = :email"),
    @NamedQuery(name = "Asociado.findByRuc", query = "SELECT a FROM Asociado a WHERE a.ruc = :ruc"),
    @NamedQuery(name = "Asociado.findByDni", query = "SELECT a FROM Asociado a WHERE a.dni = :dni"),
    @NamedQuery(name = "Asociado.findByEstado", query = "SELECT a FROM Asociado a WHERE a.estado = :estado"),
    @NamedQuery(name = "Asociado.findByLineaAsccredito", query = "SELECT a FROM Asociado a WHERE a.lineaAsccredito = :lineaAsccredito"),
    @NamedQuery(name = "Asociado.findByEstadoAsc", query = "SELECT a FROM Asociado a WHERE a.estadoAsc = :estadoAsc")})
public class Asociado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAsociado")
    private Integer idAsociado;
    @Size(max = 45)
    @Column(name = "nombres")
    private String nombres;
    @Size(max = 45)
    @Column(name = "ape_pat")
    private String apePat;
    @Size(max = 45)
    @Column(name = "ape_mat")
    private String apeMat;
    @Size(max = 45)
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "fecha_nac")
    @Temporal(TemporalType.DATE)
    private Date fechaNac;
    @Size(max = 45)
    @Column(name = "telef")
    private String telef;
    @Size(max = 45)
    @Column(name = "celular")
    private String celular;
    @Size(max = 150)
    @Column(name = "direcc")
    private String direcc;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Size(max = 11)
    @Column(name = "ruc")
    private String ruc;
    @Size(max = 8)
    @Column(name = "dni")
    private String dni;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @Column(name = "linea_asccredito")
    private Integer lineaAsccredito;
    @Column(name = "estado_asc")
    private Integer estadoAsc;
    @JoinColumn(name = "idDistrito", referencedColumnName = "idDistrito")
    @ManyToOne(optional = false)
    private Distrito idDistrito;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAsociado")
    private List<Mascota> mascotaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAsociado")
    private List<ComprobantePago> comprobantePagoList;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAsociado")
    private List<CitaMedica> citaMedicaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAsociado")
    private List<HistoriaClinica> historiaClinicaList;

    public Asociado() {
    }

    public String getNombreCompleto() {
        return nombres + "  " + apePat + "  " + apeMat + "→Ruc: " + ruc + "→Dni: " + dni;
    }

    public String getNombreCompletoS() {
        return nombres + "  " + apePat + "  " + apeMat;
    }

    public List<CitaMedica> getCitaMedicaList() {
        return citaMedicaList;
    }

    public void setCitaMedicaList(List<CitaMedica> citaMedicaList) {
        this.citaMedicaList = citaMedicaList;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Asociado(Integer idAsociado) {
        this.idAsociado = idAsociado;
    }

    public Integer getIdAsociado() {
        return idAsociado;
    }

    public void setIdAsociado(Integer idAsociado) {
        this.idAsociado = idAsociado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApePat() {
        return apePat;
    }

    public void setApePat(String apePat) {
        this.apePat = apePat;
    }

    public String getApeMat() {
        return apeMat;
    }

    public void setApeMat(String apeMat) {
        this.apeMat = apeMat;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getTelef() {
        return telef;
    }

    public void setTelef(String telef) {
        this.telef = telef;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDirecc() {
        return direcc;
    }

    public void setDirecc(String direcc) {
        this.direcc = direcc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getLineaAsccredito() {
        return lineaAsccredito;
    }

    public void setLineaAsccredito(Integer lineaAsccredito) {
        this.lineaAsccredito = lineaAsccredito;
    }

    public Integer getEstadoAsc() {
        return estadoAsc;
    }

    public void setEstadoAsc(Integer estadoAsc) {
        this.estadoAsc = estadoAsc;
    }

    public Distrito getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(Distrito idDistrito) {
        this.idDistrito = idDistrito;
    }

    @XmlTransient

    public List<HistoriaClinica> getHistoriaClinicaList() {
        return historiaClinicaList;
    }

    public void setHistoriaClinicaList(List<HistoriaClinica> historiaClinicaList) {
        this.historiaClinicaList = historiaClinicaList;
    }

    @XmlTransient
    public List<Mascota> getMascotaList() {
        return mascotaList;
    }

    public void setMascotaList(List<Mascota> mascotaList) {
        this.mascotaList = mascotaList;
    }

    @XmlTransient
    public List<ComprobantePago> getComprobantePagoList() {
        return comprobantePagoList;
    }

    public void setComprobantePagoList(List<ComprobantePago> comprobantePagoList) {
        this.comprobantePagoList = comprobantePagoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsociado != null ? idAsociado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asociado)) {
            return false;
        }
        Asociado other = (Asociado) object;
        if ((this.idAsociado == null && other.idAsociado != null) || (this.idAsociado != null && !this.idAsociado.equals(other.idAsociado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.Asociado[ idAsociado=" + idAsociado + " ]";
    }

}
