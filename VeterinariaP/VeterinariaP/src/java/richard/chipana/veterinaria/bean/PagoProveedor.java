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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "pago_proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PagoProveedor.findAll", query = "SELECT p FROM PagoProveedor p"),
    @NamedQuery(name = "PagoProveedor.findByIdPagoProveedor", query = "SELECT p FROM PagoProveedor p WHERE p.idPagoProveedor = :idPagoProveedor"),
    @NamedQuery(name = "PagoProveedor.findByMontoActualPago", query = "SELECT p FROM PagoProveedor p WHERE p.montoActualPago = :montoActualPago"),
    @NamedQuery(name = "PagoProveedor.findByEstadoPagp", query = "SELECT p FROM PagoProveedor p WHERE p.estadoPagp = :estadoPagp")})
public class PagoProveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPago_Proveedor")
    private Integer idPagoProveedor;
    @Size(max = 45)
    @Column(name = "monto_actual_pago")
    private String montoActualPago;
    @Column(name = "estado_pagp")
    private Integer estadoPagp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFacturaprov")
    private List<DetallePago> detallePagoList;
    @JoinColumn(name = "idFactura_prov", referencedColumnName = "idFactura_prov")
    @ManyToOne(optional = false)
    private FacturaProveedor idFacturaprov;

    public PagoProveedor() {
    }

    public PagoProveedor(Integer idPagoProveedor) {
        this.idPagoProveedor = idPagoProveedor;
    }

    public Integer getIdPagoProveedor() {
        return idPagoProveedor;
    }

    public void setIdPagoProveedor(Integer idPagoProveedor) {
        this.idPagoProveedor = idPagoProveedor;
    }

    public String getMontoActualPago() {
        return montoActualPago;
    }

    public void setMontoActualPago(String montoActualPago) {
        this.montoActualPago = montoActualPago;
    }

    public Integer getEstadoPagp() {
        return estadoPagp;
    }

    public void setEstadoPagp(Integer estadoPagp) {
        this.estadoPagp = estadoPagp;
    }

    @XmlTransient
    public List<DetallePago> getDetallePagoList() {
        return detallePagoList;
    }

    public void setDetallePagoList(List<DetallePago> detallePagoList) {
        this.detallePagoList = detallePagoList;
    }

    public FacturaProveedor getIdFacturaprov() {
        return idFacturaprov;
    }

    public void setIdFacturaprov(FacturaProveedor idFacturaprov) {
        this.idFacturaprov = idFacturaprov;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPagoProveedor != null ? idPagoProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagoProveedor)) {
            return false;
        }
        PagoProveedor other = (PagoProveedor) object;
        if ((this.idPagoProveedor == null && other.idPagoProveedor != null) || (this.idPagoProveedor != null && !this.idPagoProveedor.equals(other.idPagoProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.PagoProveedor[ idPagoProveedor=" + idPagoProveedor + " ]";
    }
    
}
