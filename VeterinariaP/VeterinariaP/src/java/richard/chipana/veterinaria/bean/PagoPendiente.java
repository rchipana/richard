/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richard.chipana.veterinaria.bean;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RICHARD
 */
@Entity
@Table(name = "pago_pendiente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PagoPendiente.findAll", query = "SELECT p FROM PagoPendiente p"),
    @NamedQuery(name = "PagoPendiente.findByIdPagopendiente", query = "SELECT p FROM PagoPendiente p WHERE p.idPagopendiente = :idPagopendiente"),
    @NamedQuery(name = "PagoPendiente.findByFechaPago", query = "SELECT p FROM PagoPendiente p WHERE p.fechaPago = :fechaPago"),
    @NamedQuery(name = "PagoPendiente.findByFechaNueva", query = "SELECT p FROM PagoPendiente p WHERE p.fechaNueva = :fechaNueva"),
    @NamedQuery(name = "PagoPendiente.findByMontoTotalPagar", query = "SELECT p FROM PagoPendiente p WHERE p.montoTotalPagar = :montoTotalPagar"),
    @NamedQuery(name = "PagoPendiente.findByEstadoPap", query = "SELECT p FROM PagoPendiente p WHERE p.estadoPap = :estadoPap")})
public class PagoPendiente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPago_pendiente")
    private Integer idPagopendiente;
    @Column(name = "fecha_pago")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPago;
    @Column(name = "fecha_nueva")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNueva;
    @Column(name = "monto_total_pagar")
    private Long montoTotalPagar;
    @Column(name = "estado_pap")
    private Integer estadoPap;
    @JoinColumn(name = "idComprobante_pago", referencedColumnName = "idComprobante_pago")
    @ManyToOne(optional = false)
    private ComprobantePago idComprobantepago;

    public PagoPendiente() {
    }

    public PagoPendiente(Integer idPagopendiente) {
        this.idPagopendiente = idPagopendiente;
    }

    public Integer getIdPagopendiente() {
        return idPagopendiente;
    }

    public void setIdPagopendiente(Integer idPagopendiente) {
        this.idPagopendiente = idPagopendiente;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Date getFechaNueva() {
        return fechaNueva;
    }

    public void setFechaNueva(Date fechaNueva) {
        this.fechaNueva = fechaNueva;
    }

    public Long getMontoTotalPagar() {
        return montoTotalPagar;
    }

    public void setMontoTotalPagar(Long montoTotalPagar) {
        this.montoTotalPagar = montoTotalPagar;
    }

    public Integer getEstadoPap() {
        return estadoPap;
    }

    public void setEstadoPap(Integer estadoPap) {
        this.estadoPap = estadoPap;
    }

    public ComprobantePago getIdComprobantepago() {
        return idComprobantepago;
    }

    public void setIdComprobantepago(ComprobantePago idComprobantepago) {
        this.idComprobantepago = idComprobantepago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPagopendiente != null ? idPagopendiente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagoPendiente)) {
            return false;
        }
        PagoPendiente other = (PagoPendiente) object;
        if ((this.idPagopendiente == null && other.idPagopendiente != null) || (this.idPagopendiente != null && !this.idPagopendiente.equals(other.idPagopendiente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.PagoPendiente[ idPagopendiente=" + idPagopendiente + " ]";
    }
    
}
