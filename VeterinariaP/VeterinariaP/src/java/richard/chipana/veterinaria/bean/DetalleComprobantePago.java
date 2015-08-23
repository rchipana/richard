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
@Table(name = "detalle_comprobante_pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleComprobantePago.findAll", query = "SELECT d FROM DetalleComprobantePago d"),
    @NamedQuery(name = "DetalleComprobantePago.findByIdDetalleComprobante", query = "SELECT d FROM DetalleComprobantePago d WHERE d.idDetalleComprobante = :idDetalleComprobante"),
    @NamedQuery(name = "DetalleComprobantePago.findByCantidad", query = "SELECT d FROM DetalleComprobantePago d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalleComprobantePago.findByDescripcion", query = "SELECT d FROM DetalleComprobantePago d WHERE d.descripcion = :descripcion"),
    @NamedQuery(name = "DetalleComprobantePago.findByPrecio", query = "SELECT d FROM DetalleComprobantePago d WHERE d.precio = :precio"),
    @NamedQuery(name = "DetalleComprobantePago.findByEstadoDep", query = "SELECT d FROM DetalleComprobantePago d WHERE d.estadoDep = :estadoDep")})
public class DetalleComprobantePago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDetalle_Comprobante")
    private Integer idDetalleComprobante;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "precio")
    private Long precio;
    @Column(name = "estado_dep")
    private Integer estadoDep;
    @JoinColumn(name = "idComprobante_pago", referencedColumnName = "idComprobante_pago")
    @ManyToOne(optional = false)
    private ComprobantePago idComprobantepago;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
    @ManyToOne
    private Producto idProducto;

    public DetalleComprobantePago() {
    }

    public DetalleComprobantePago(Integer idDetalleComprobante) {
        this.idDetalleComprobante = idDetalleComprobante;
    }

    public Integer getIdDetalleComprobante() {
        return idDetalleComprobante;
    }

    public void setIdDetalleComprobante(Integer idDetalleComprobante) {
        this.idDetalleComprobante = idDetalleComprobante;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public Integer getEstadoDep() {
        return estadoDep;
    }

    public void setEstadoDep(Integer estadoDep) {
        this.estadoDep = estadoDep;
    }

    public ComprobantePago getIdComprobantepago() {
        return idComprobantepago;
    }

    public void setIdComprobantepago(ComprobantePago idComprobantepago) {
        this.idComprobantepago = idComprobantepago;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleComprobante != null ? idDetalleComprobante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleComprobantePago)) {
            return false;
        }
        DetalleComprobantePago other = (DetalleComprobantePago) object;
        if ((this.idDetalleComprobante == null && other.idDetalleComprobante != null) || (this.idDetalleComprobante != null && !this.idDetalleComprobante.equals(other.idDetalleComprobante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.DetalleComprobantePago[ idDetalleComprobante=" + idDetalleComprobante + " ]";
    }
    
}
