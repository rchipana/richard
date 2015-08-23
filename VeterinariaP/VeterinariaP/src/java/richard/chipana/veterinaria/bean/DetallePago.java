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
@Table(name = "detalle_pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetallePago.findAll", query = "SELECT d FROM DetallePago d"),
    @NamedQuery(name = "DetallePago.findByIdDetallePago", query = "SELECT d FROM DetallePago d WHERE d.idDetallePago = :idDetallePago"),
    @NamedQuery(name = "DetallePago.findByTipoPago", query = "SELECT d FROM DetallePago d WHERE d.tipoPago = :tipoPago"),
    @NamedQuery(name = "DetallePago.findByNumeroDocl", query = "SELECT d FROM DetallePago d WHERE d.numeroDocl = :numeroDocl"),
    @NamedQuery(name = "DetallePago.findByFechaPago", query = "SELECT d FROM DetallePago d WHERE d.fechaPago = :fechaPago"),
    @NamedQuery(name = "DetallePago.findByMontoPagado", query = "SELECT d FROM DetallePago d WHERE d.montoPagado = :montoPagado"),
    @NamedQuery(name = "DetallePago.findByDetallePagocol", query = "SELECT d FROM DetallePago d WHERE d.detallePagocol = :detallePagocol"),
    @NamedQuery(name = "DetallePago.findByEstadoDetp", query = "SELECT d FROM DetallePago d WHERE d.estadoDetp = :estadoDetp")})
public class DetallePago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDetalle_Pago")
    private Integer idDetallePago;
    @Size(max = 45)
    @Column(name = "tipo_pago")
    private String tipoPago;
    @Size(max = 45)
    @Column(name = "numero_docl")
    private String numeroDocl;
    @Size(max = 45)
    @Column(name = "fecha_pago")
    private String fechaPago;
    @Size(max = 45)
    @Column(name = "monto_pagado")
    private String montoPagado;
    @Size(max = 45)
    @Column(name = "Detalle_Pagocol")
    private String detallePagocol;
    @Column(name = "estado_detp")
    private Integer estadoDetp;
    @JoinColumn(name = "idFactura_prov", referencedColumnName = "idFactura_prov")
    @ManyToOne(optional = false)
    private PagoProveedor idFacturaprov;

    public DetallePago() {
    }

    public DetallePago(Integer idDetallePago) {
        this.idDetallePago = idDetallePago;
    }

    public Integer getIdDetallePago() {
        return idDetallePago;
    }

    public void setIdDetallePago(Integer idDetallePago) {
        this.idDetallePago = idDetallePago;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getNumeroDocl() {
        return numeroDocl;
    }

    public void setNumeroDocl(String numeroDocl) {
        this.numeroDocl = numeroDocl;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(String montoPagado) {
        this.montoPagado = montoPagado;
    }

    public String getDetallePagocol() {
        return detallePagocol;
    }

    public void setDetallePagocol(String detallePagocol) {
        this.detallePagocol = detallePagocol;
    }

    public Integer getEstadoDetp() {
        return estadoDetp;
    }

    public void setEstadoDetp(Integer estadoDetp) {
        this.estadoDetp = estadoDetp;
    }

    public PagoProveedor getIdFacturaprov() {
        return idFacturaprov;
    }

    public void setIdFacturaprov(PagoProveedor idFacturaprov) {
        this.idFacturaprov = idFacturaprov;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetallePago != null ? idDetallePago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePago)) {
            return false;
        }
        DetallePago other = (DetallePago) object;
        if ((this.idDetallePago == null && other.idDetallePago != null) || (this.idDetallePago != null && !this.idDetallePago.equals(other.idDetallePago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.DetallePago[ idDetallePago=" + idDetallePago + " ]";
    }
    
}
