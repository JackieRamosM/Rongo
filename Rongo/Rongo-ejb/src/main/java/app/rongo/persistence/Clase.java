/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.rongo.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Liliana
 */
@Entity
@Table(name = "clase")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clase.findAll", query = "SELECT c FROM Clase c"),
    @NamedQuery(name = "Clase.findByIdclase", query = "SELECT c FROM Clase c WHERE c.idclase = :idclase"),
    @NamedQuery(name = "Clase.findByHoraini", query = "SELECT c FROM Clase c WHERE c.horaini = :horaini"),
    @NamedQuery(name = "Clase.findByHorafin", query = "SELECT c FROM Clase c WHERE c.horafin = :horafin"),
    @NamedQuery(name = "Clase.findByDescripcion", query = "SELECT c FROM Clase c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Clase.findByFecha", query = "SELECT c FROM Clase c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Clase.findByDioclase", query = "SELECT c FROM Clase c WHERE c.dioclase = :dioclase")})
public class Clase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idclase")
    private Integer idclase;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horaini")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaini;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horafin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horafin;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "dioclase")
    private Boolean dioclase;
    @JoinColumn(name = "idayudantia", referencedColumnName = "idayudantia")
    @ManyToOne(optional = false)
    private Ayudantia idayudantia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idclase")
    private List<Asistencia> asistenciaList;

    public Clase() {
    }

    public Clase(Integer idclase) {
        this.idclase = idclase;
    }

    public Clase(Integer idclase, Date horaini, Date horafin) {
        this.idclase = idclase;
        this.horaini = horaini;
        this.horafin = horafin;
    }

    public Integer getIdclase() {
        return idclase;
    }

    public void setIdclase(Integer idclase) {
        this.idclase = idclase;
    }

    public Date getHoraini() {
        return horaini;
    }

    public void setHoraini(Date horaini) {
        this.horaini = horaini;
    }

    public Date getHorafin() {
        return horafin;
    }

    public void setHorafin(Date horafin) {
        this.horafin = horafin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getDioclase() {
        return dioclase;
    }

    public void setDioclase(Boolean dioclase) {
        this.dioclase = dioclase;
    }

    public Ayudantia getIdayudantia() {
        return idayudantia;
    }

    public void setIdayudantia(Ayudantia idayudantia) {
        this.idayudantia = idayudantia;
    }

    @XmlTransient
    public List<Asistencia> getAsistenciaList() {
        return asistenciaList;
    }

    public void setAsistenciaList(List<Asistencia> asistenciaList) {
        this.asistenciaList = asistenciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclase != null ? idclase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clase)) {
            return false;
        }
        Clase other = (Clase) object;
        if ((this.idclase == null && other.idclase != null) || (this.idclase != null && !this.idclase.equals(other.idclase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.rongo.persistence.Clase[ idclase=" + idclase + " ]";
    }
    
}
