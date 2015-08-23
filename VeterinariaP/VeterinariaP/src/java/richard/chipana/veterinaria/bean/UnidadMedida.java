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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RICHARD
 */
@Entity
@Table(name = "unidad_medida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadMedida.findAll", query = "SELECT u FROM UnidadMedida u"),
    @NamedQuery(name = "UnidadMedida.findByIdUnidadmedida", query = "SELECT u FROM UnidadMedida u WHERE u.idUnidadmedida = :idUnidadmedida"),
    @NamedQuery(name = "UnidadMedida.findByDescripcion", query = "SELECT u FROM UnidadMedida u WHERE u.descripcion = :descripcion"),
    @NamedQuery(name = "UnidadMedida.findByEstadoUni", query = "SELECT u FROM UnidadMedida u WHERE u.estadoUni = :estadoUni")})
public class UnidadMedida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUnidad_medida")
    private Integer idUnidadmedida;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estado_uni")
    private Integer estadoUni;

    public UnidadMedida() {
    }

    public UnidadMedida(Integer idUnidadmedida) {
        this.idUnidadmedida = idUnidadmedida;
    }

    public Integer getIdUnidadmedida() {
        return idUnidadmedida;
    }

    public void setIdUnidadmedida(Integer idUnidadmedida) {
        this.idUnidadmedida = idUnidadmedida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getEstadoUni() {
        return estadoUni;
    }

    public void setEstadoUni(Integer estadoUni) {
        this.estadoUni = estadoUni;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidadmedida != null ? idUnidadmedida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadMedida)) {
            return false;
        }
        UnidadMedida other = (UnidadMedida) object;
        if ((this.idUnidadmedida == null && other.idUnidadmedida != null) || (this.idUnidadmedida != null && !this.idUnidadmedida.equals(other.idUnidadmedida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.UnidadMedida[ idUnidadmedida=" + idUnidadmedida + " ]";
    }
    
}
