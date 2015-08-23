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
@Table(name = "igv")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Igv.findAll", query = "SELECT i FROM Igv i"),
    @NamedQuery(name = "Igv.findByIdIGV", query = "SELECT i FROM Igv i WHERE i.idIGV = :idIGV"),
    @NamedQuery(name = "Igv.findByPorcentaje", query = "SELECT i FROM Igv i WHERE i.porcentaje = :porcentaje"),
    @NamedQuery(name = "Igv.findByFecha", query = "SELECT i FROM Igv i WHERE i.fecha = :fecha"),
    @NamedQuery(name = "Igv.findByEstadoIgv", query = "SELECT i FROM Igv i WHERE i.estadoIgv = :estadoIgv")})
public class Igv implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idIGV")
    private Integer idIGV;
    @Size(max = 45)
    @Column(name = "porcentaje")
    private String porcentaje;
    @Size(max = 45)
    @Column(name = "fecha")
    private String fecha;
    @Column(name = "estado_igv")
    private Integer estadoIgv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idIGV")
    private List<ComprobantePago> comprobantePagoList;

    public Igv() {
    }

    public Igv(Integer idIGV) {
        this.idIGV = idIGV;
    }

    public Integer getIdIGV() {
        return idIGV;
    }

    public void setIdIGV(Integer idIGV) {
        this.idIGV = idIGV;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getEstadoIgv() {
        return estadoIgv;
    }

    public void setEstadoIgv(Integer estadoIgv) {
        this.estadoIgv = estadoIgv;
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
        hash += (idIGV != null ? idIGV.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Igv)) {
            return false;
        }
        Igv other = (Igv) object;
        if ((this.idIGV == null && other.idIGV != null) || (this.idIGV != null && !this.idIGV.equals(other.idIGV))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.Igv[ idIGV=" + idIGV + " ]";
    }
    
}
