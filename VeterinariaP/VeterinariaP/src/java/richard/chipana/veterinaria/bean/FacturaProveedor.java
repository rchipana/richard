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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author RICHARD
 */
@Entity
@Table(name = "factura_proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FacturaProveedor.findAll", query = "SELECT f FROM FacturaProveedor f"),
    @NamedQuery(name = "FacturaProveedor.findByIdFacturaprov", query = "SELECT f FROM FacturaProveedor f WHERE f.idFacturaprov = :idFacturaprov"),
    @NamedQuery(name = "FacturaProveedor.findByTipoPagoFact", query = "SELECT f FROM FacturaProveedor f WHERE f.tipoPagoFact = :tipoPagoFact"),
    @NamedQuery(name = "FacturaProveedor.findByFechaFact", query = "SELECT f FROM FacturaProveedor f WHERE f.fechaFact = :fechaFact"),
    @NamedQuery(name = "FacturaProveedor.findByFechaPago", query = "SELECT f FROM FacturaProveedor f WHERE f.fechaPago = :fechaPago"),
    @NamedQuery(name = "FacturaProveedor.findByTotalFact", query = "SELECT f FROM FacturaProveedor f WHERE f.totalFact = :totalFact"),
    @NamedQuery(name = "FacturaProveedor.findByEstadoFact", query = "SELECT f FROM FacturaProveedor f WHERE f.estadoFact = :estadoFact")})
public class FacturaProveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFactura_prov")
    private Integer idFacturaprov;
    @Size(max = 45)
    @Column(name = "tipo_pago_fact")
    private String tipoPagoFact;
    @Column(name = "fecha_fact")
    @Temporal(TemporalType.DATE)
    private Date fechaFact;
    @Column(name = "fecha_pago")
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    @Column(name = "total_fact")
    private Long totalFact;
    @Size(max = 45)
    @Column(name = "estado_fact")
    private String estadoFact;
    @JoinColumn(name = "idProveedor", referencedColumnName = "idProveedor")
    @ManyToOne(optional = false)
    private Proveedor idProveedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFacturaprov")
    private List<DetalleFactura> detalleFacturaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFacturaprov")
    private List<PagoProveedor> pagoProveedorList;

    public FacturaProveedor() {
    }

    public FacturaProveedor(Integer idFacturaprov) {
        this.idFacturaprov = idFacturaprov;
    }

    public Integer getIdFacturaprov() {
        return idFacturaprov;
    }

    public void setIdFacturaprov(Integer idFacturaprov) {
        this.idFacturaprov = idFacturaprov;
    }

    public String getTipoPagoFact() {
        return tipoPagoFact;
    }

    public void setTipoPagoFact(String tipoPagoFact) {
        this.tipoPagoFact = tipoPagoFact;
    }

    public Date getFechaFact() {
        return fechaFact;
    }

    public void setFechaFact(Date fechaFact) {
        this.fechaFact = fechaFact;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Long getTotalFact() {
        return totalFact;
    }

    public void setTotalFact(Long totalFact) {
        this.totalFact = totalFact;
    }

    public String getEstadoFact() {
        return estadoFact;
    }

    public void setEstadoFact(String estadoFact) {
        this.estadoFact = estadoFact;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
    }

    @XmlTransient
    public List<DetalleFactura> getDetalleFacturaList() {
        return detalleFacturaList;
    }

    public void setDetalleFacturaList(List<DetalleFactura> detalleFacturaList) {
        this.detalleFacturaList = detalleFacturaList;
    }

    @XmlTransient
    public List<PagoProveedor> getPagoProveedorList() {
        return pagoProveedorList;
    }

    public void setPagoProveedorList(List<PagoProveedor> pagoProveedorList) {
        this.pagoProveedorList = pagoProveedorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFacturaprov != null ? idFacturaprov.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaProveedor)) {
            return false;
        }
        FacturaProveedor other = (FacturaProveedor) object;
        if ((this.idFacturaprov == null && other.idFacturaprov != null) || (this.idFacturaprov != null && !this.idFacturaprov.equals(other.idFacturaprov))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.FacturaProveedor[ idFacturaprov=" + idFacturaprov + " ]";
    }
    
}
