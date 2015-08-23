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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RICHARD
 */
@Entity
@Table(name = "auditoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auditoria.findAll", query = "SELECT a FROM Auditoria a"),
    @NamedQuery(name = "Auditoria.findByIdAuditoria", query = "SELECT a FROM Auditoria a WHERE a.idAuditoria = :idAuditoria"),
    @NamedQuery(name = "Auditoria.findByFechaLogin", query = "SELECT a FROM Auditoria a WHERE a.fechaLogin = :fechaLogin"),
    @NamedQuery(name = "Auditoria.findByFechaLogout", query = "SELECT a FROM Auditoria a WHERE a.fechaLogout = :fechaLogout"),
    @NamedQuery(name = "Auditoria.findByUser", query = "SELECT a FROM Auditoria a WHERE a.user = :user"),
    @NamedQuery(name = "Auditoria.findByTiempo", query = "SELECT a FROM Auditoria a WHERE a.tiempo = :tiempo"),
    @NamedQuery(name = "Auditoria.findByEstadoAud", query = "SELECT a FROM Auditoria a WHERE a.estadoAud = :estadoAud")})
public class Auditoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAuditoria")
    private Integer idAuditoria;
    @Column(name = "fechaLogin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaLogin;
    @Column(name = "fechaLogout")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaLogout;
    @Size(max = 45)
    @Column(name = "user")
    private String user;
    @Size(max = 45)
    @Column(name = "tiempo")
    private String tiempo;
    @Column(name = "estado_aud")
    private Integer estadoAud;
    @JoinColumn(name = "idSede", referencedColumnName = "idSede")
    @ManyToOne(optional = false)
    private Sede idSede;

    public Auditoria() {
    }

    public Auditoria(Integer idAuditoria) {
        this.idAuditoria = idAuditoria;
    }

    public Integer getIdAuditoria() {
        return idAuditoria;
    }

    public void setIdAuditoria(Integer idAuditoria) {
        this.idAuditoria = idAuditoria;
    }

    public Date getFechaLogin() {
        return fechaLogin;
    }

    public void setFechaLogin(Date fechaLogin) {
        this.fechaLogin = fechaLogin;
    }

    public Date getFechaLogout() {
        return fechaLogout;
    }

    public void setFechaLogout(Date fechaLogout) {
        this.fechaLogout = fechaLogout;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public Integer getEstadoAud() {
        return estadoAud;
    }

    public void setEstadoAud(Integer estadoAud) {
        this.estadoAud = estadoAud;
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
        hash += (idAuditoria != null ? idAuditoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auditoria)) {
            return false;
        }
        Auditoria other = (Auditoria) object;
        if ((this.idAuditoria == null && other.idAuditoria != null) || (this.idAuditoria != null && !this.idAuditoria.equals(other.idAuditoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.Auditoria[ idAuditoria=" + idAuditoria + " ]";
    }
    
}
