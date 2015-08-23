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
@Table(name = "pelaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pelaje.findAll", query = "SELECT p FROM Pelaje p"),
    @NamedQuery(name = "Pelaje.findByIdPelaje", query = "SELECT p FROM Pelaje p WHERE p.idPelaje = :idPelaje"),
    @NamedQuery(name = "Pelaje.findByDescripcion", query = "SELECT p FROM Pelaje p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Pelaje.findByEstadoPel", query = "SELECT p FROM Pelaje p WHERE p.estadoPel = :estadoPel")})
public class Pelaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPelaje")
    private Integer idPelaje;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estado_pel")
    private Integer estadoPel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPelaje")
    private List<Mascota> mascotaList;

    public Pelaje() {
    }

    public Pelaje(Integer idPelaje) {
        this.idPelaje = idPelaje;
    }

    public Integer getIdPelaje() {
        return idPelaje;
    }

    public void setIdPelaje(Integer idPelaje) {
        this.idPelaje = idPelaje;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getEstadoPel() {
        return estadoPel;
    }

    public void setEstadoPel(Integer estadoPel) {
        this.estadoPel = estadoPel;
    }

    @XmlTransient
    public List<Mascota> getMascotaList() {
        return mascotaList;
    }

    public void setMascotaList(List<Mascota> mascotaList) {
        this.mascotaList = mascotaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPelaje != null ? idPelaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pelaje)) {
            return false;
        }
        Pelaje other = (Pelaje) object;
        if ((this.idPelaje == null && other.idPelaje != null) || (this.idPelaje != null && !this.idPelaje.equals(other.idPelaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.Pelaje[ idPelaje=" + idPelaje + " ]";
    }
    
}
