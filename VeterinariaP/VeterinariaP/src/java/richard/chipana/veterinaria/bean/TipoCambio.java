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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RICHARD
 */
@Entity
@Table(name = "tipo_cambio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCambio.findAll", query = "SELECT t FROM TipoCambio t"),
    @NamedQuery(name = "TipoCambio.findByIdTipoCambio", query = "SELECT t FROM TipoCambio t WHERE t.idTipoCambio = :idTipoCambio"),
    @NamedQuery(name = "TipoCambio.findByValorCompra", query = "SELECT t FROM TipoCambio t WHERE t.valorCompra = :valorCompra"),
    @NamedQuery(name = "TipoCambio.findByValorVenta", query = "SELECT t FROM TipoCambio t WHERE t.valorVenta = :valorVenta"),
    @NamedQuery(name = "TipoCambio.findByFecha", query = "SELECT t FROM TipoCambio t WHERE t.fecha = :fecha"),
    @NamedQuery(name = "TipoCambio.findByEstadoTip", query = "SELECT t FROM TipoCambio t WHERE t.estadoTip = :estadoTip")})
public class TipoCambio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipo_Cambio")
    private Integer idTipoCambio;
    @Size(max = 45)
    @Column(name = "valor_compra")
    private String valorCompra;
    @Size(max = 45)
    @Column(name = "valor_venta")
    private String valorVenta;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "estado_tip")
    private Integer estadoTip;

    public TipoCambio() {
    }

    public TipoCambio(Integer idTipoCambio) {
        this.idTipoCambio = idTipoCambio;
    }

    public Integer getIdTipoCambio() {
        return idTipoCambio;
    }

    public void setIdTipoCambio(Integer idTipoCambio) {
        this.idTipoCambio = idTipoCambio;
    }

    public String getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(String valorCompra) {
        this.valorCompra = valorCompra;
    }

    public String getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(String valorVenta) {
        this.valorVenta = valorVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getEstadoTip() {
        return estadoTip;
    }

    public void setEstadoTip(Integer estadoTip) {
        this.estadoTip = estadoTip;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoCambio != null ? idTipoCambio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCambio)) {
            return false;
        }
        TipoCambio other = (TipoCambio) object;
        if ((this.idTipoCambio == null && other.idTipoCambio != null) || (this.idTipoCambio != null && !this.idTipoCambio.equals(other.idTipoCambio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.TipoCambio[ idTipoCambio=" + idTipoCambio + " ]";
    }
    
}
