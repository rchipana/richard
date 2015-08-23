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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author RICHARD
 */
@Entity
@Table(name = "comprobante_pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComprobantePago.findAll", query = "SELECT c FROM ComprobantePago c"),
    @NamedQuery(name = "ComprobantePago.findByIdComprobantepago", query = "SELECT c FROM ComprobantePago c WHERE c.idComprobantepago = :idComprobantepago"),
    @NamedQuery(name = "ComprobantePago.findByFechaComp", query = "SELECT c FROM ComprobantePago c WHERE c.fechaComp = :fechaComp"),
    @NamedQuery(name = "ComprobantePago.findByEstadoCom", query = "SELECT c FROM ComprobantePago c WHERE c.estadoCom = :estadoCom")})
public class ComprobantePago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idComprobante_pago")
    private Integer idComprobantepago;
    @Column(name = "fecha_comp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaComp;
    @Column(name = "estado_com")
    private Integer estadoCom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idComprobantepago")
    private List<DetalleComprobantePago> detalleComprobantePagoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idComprobantepago")
    private List<PagoPendiente> pagoPendienteList;
    @JoinColumn(name = "idIGV", referencedColumnName = "idIGV")
    @ManyToOne(optional = false)
    private Igv idIGV;
    @JoinColumn(name = "idAsociado", referencedColumnName = "idAsociado")
    @ManyToOne(optional = false)
    private Asociado idAsociado;

    public ComprobantePago() {
    }

    public ComprobantePago(Integer idComprobantepago) {
        this.idComprobantepago = idComprobantepago;
    }

    public Integer getIdComprobantepago() {
        return idComprobantepago;
    }

    public void setIdComprobantepago(Integer idComprobantepago) {
        this.idComprobantepago = idComprobantepago;
    }

    public Date getFechaComp() {
        return fechaComp;
    }

    public void setFechaComp(Date fechaComp) {
        this.fechaComp = fechaComp;
    }

    public Integer getEstadoCom() {
        return estadoCom;
    }

    public void setEstadoCom(Integer estadoCom) {
        this.estadoCom = estadoCom;
    }

    @XmlTransient
    public List<DetalleComprobantePago> getDetalleComprobantePagoList() {
        return detalleComprobantePagoList;
    }

    public void setDetalleComprobantePagoList(List<DetalleComprobantePago> detalleComprobantePagoList) {
        this.detalleComprobantePagoList = detalleComprobantePagoList;
    }

    @XmlTransient
    public List<PagoPendiente> getPagoPendienteList() {
        return pagoPendienteList;
    }

    public void setPagoPendienteList(List<PagoPendiente> pagoPendienteList) {
        this.pagoPendienteList = pagoPendienteList;
    }

    public Igv getIdIGV() {
        return idIGV;
    }

    public void setIdIGV(Igv idIGV) {
        this.idIGV = idIGV;
    }

    public Asociado getIdAsociado() {
        return idAsociado;
    }

    public void setIdAsociado(Asociado idAsociado) {
        this.idAsociado = idAsociado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComprobantepago != null ? idComprobantepago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComprobantePago)) {
            return false;
        }
        ComprobantePago other = (ComprobantePago) object;
        if ((this.idComprobantepago == null && other.idComprobantepago != null) || (this.idComprobantepago != null && !this.idComprobantepago.equals(other.idComprobantepago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.ComprobantePago[ idComprobantepago=" + idComprobantepago + " ]";
    }
    
}
