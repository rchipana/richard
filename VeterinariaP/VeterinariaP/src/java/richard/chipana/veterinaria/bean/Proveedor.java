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
@Table(name = "proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p"),
    @NamedQuery(name = "Proveedor.findByIdProveedor", query = "SELECT p FROM Proveedor p WHERE p.idProveedor = :idProveedor"),
    @NamedQuery(name = "Proveedor.findByRucProv", query = "SELECT p FROM Proveedor p WHERE p.rucProv = :rucProv"),
    @NamedQuery(name = "Proveedor.findByNombreProv", query = "SELECT p FROM Proveedor p WHERE p.nombreProv = :nombreProv"),
    @NamedQuery(name = "Proveedor.findByTelefProv", query = "SELECT p FROM Proveedor p WHERE p.telefProv = :telefProv"),
    @NamedQuery(name = "Proveedor.findByDireccProv", query = "SELECT p FROM Proveedor p WHERE p.direccProv = :direccProv"),
    @NamedQuery(name = "Proveedor.findByCorreoProv", query = "SELECT p FROM Proveedor p WHERE p.correoProv = :correoProv"),
    @NamedQuery(name = "Proveedor.findByNumCuenta", query = "SELECT p FROM Proveedor p WHERE p.numCuenta = :numCuenta"),
    @NamedQuery(name = "Proveedor.findByEstado", query = "SELECT p FROM Proveedor p WHERE p.estado = :estado"),
    @NamedQuery(name = "Proveedor.findByEstadoPro", query = "SELECT p FROM Proveedor p WHERE p.estadoPro = :estadoPro")})
public class Proveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProveedor")
    private Integer idProveedor;
    @Size(max = 45)
    @Column(name = "ruc_prov")
    private String rucProv;
    @Size(max = 45)
    @Column(name = "nombre_prov")
    private String nombreProv;
    @Size(max = 45)
    @Column(name = "telef_prov")
    private String telefProv;
    @Size(max = 45)
    @Column(name = "direcc_prov")
    private String direccProv;
    @Size(max = 45)
    @Column(name = "correo_prov")
    private String correoProv;
    @Size(max = 45)
    @Column(name = "num_cuenta")
    private String numCuenta;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @Column(name = "estado_pro")
    private Integer estadoPro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProveedor")
    private List<FacturaProveedor> facturaProveedorList;
    @JoinColumn(name = "Distrito_idDistrito", referencedColumnName = "idDistrito")
    @ManyToOne(optional = false)
    private Distrito distritoidDistrito;

    public Proveedor() {
    }

    public Proveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getRucProv() {
        return rucProv;
    }

    public void setRucProv(String rucProv) {
        this.rucProv = rucProv;
    }

    public String getNombreProv() {
        return nombreProv;
    }

    public void setNombreProv(String nombreProv) {
        this.nombreProv = nombreProv;
    }

    public String getTelefProv() {
        return telefProv;
    }

    public void setTelefProv(String telefProv) {
        this.telefProv = telefProv;
    }

    public String getDireccProv() {
        return direccProv;
    }

    public void setDireccProv(String direccProv) {
        this.direccProv = direccProv;
    }

    public String getCorreoProv() {
        return correoProv;
    }

    public void setCorreoProv(String correoProv) {
        this.correoProv = correoProv;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getEstadoPro() {
        return estadoPro;
    }

    public void setEstadoPro(Integer estadoPro) {
        this.estadoPro = estadoPro;
    }

    @XmlTransient
    public List<FacturaProveedor> getFacturaProveedorList() {
        return facturaProveedorList;
    }

    public void setFacturaProveedorList(List<FacturaProveedor> facturaProveedorList) {
        this.facturaProveedorList = facturaProveedorList;
    }

    public Distrito getDistritoidDistrito() {
        return distritoidDistrito;
    }

    public void setDistritoidDistrito(Distrito distritoidDistrito) {
        this.distritoidDistrito = distritoidDistrito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProveedor != null ? idProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.idProveedor == null && other.idProveedor != null) || (this.idProveedor != null && !this.idProveedor.equals(other.idProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.Proveedor[ idProveedor=" + idProveedor + " ]";
    }
    
}
