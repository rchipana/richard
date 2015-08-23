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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RICHARD
 */
@Entity
@Table(name = "detalle_sede_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleSedeProducto.findAll", query = "SELECT d FROM DetalleSedeProducto d"),
    @NamedQuery(name = "DetalleSedeProducto.findByIdDetalleSedeProducto", query = "SELECT d FROM DetalleSedeProducto d WHERE d.idDetalleSedeProducto = :idDetalleSedeProducto"),
    @NamedQuery(name = "DetalleSedeProducto.findByStock", query = "SELECT d FROM DetalleSedeProducto d WHERE d.stock = :stock"),
    @NamedQuery(name = "DetalleSedeProducto.findByEstadoDsp", query = "SELECT d FROM DetalleSedeProducto d WHERE d.estadoDsp = :estadoDsp")})
public class DetalleSedeProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDetalle_Sede_Producto")
    private Integer idDetalleSedeProducto;
    @Size(max = 45)
    @Column(name = "stock")
    private String stock;
    @Column(name = "estado_dsp")
    private Integer estadoDsp;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
    @ManyToOne(optional = false)
    private Producto idProducto;
    @JoinColumn(name = "idSede", referencedColumnName = "idSede")
    @ManyToOne(optional = false)
    private Sede idSede;

    public DetalleSedeProducto() {
    }

    public DetalleSedeProducto(Integer idDetalleSedeProducto) {
        this.idDetalleSedeProducto = idDetalleSedeProducto;
    }

    public Integer getIdDetalleSedeProducto() {
        return idDetalleSedeProducto;
    }

    public void setIdDetalleSedeProducto(Integer idDetalleSedeProducto) {
        this.idDetalleSedeProducto = idDetalleSedeProducto;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public Integer getEstadoDsp() {
        return estadoDsp;
    }

    public void setEstadoDsp(Integer estadoDsp) {
        this.estadoDsp = estadoDsp;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Sede getIdSede() {
        return idSede;
    }

    public void setIdSede(Sede idSede) {
        this.idSede = idSede;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleSedeProducto != null ? idDetalleSedeProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleSedeProducto)) {
            return false;
        }
        DetalleSedeProducto other = (DetalleSedeProducto) object;
        if ((this.idDetalleSedeProducto == null && other.idDetalleSedeProducto != null) || (this.idDetalleSedeProducto != null && !this.idDetalleSedeProducto.equals(other.idDetalleSedeProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.DetalleSedeProducto[ idDetalleSedeProducto=" + idDetalleSedeProducto + " ]";
    }
    
}
