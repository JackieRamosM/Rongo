/*
 * To change this template, choose Tools | Templates
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
 * @author SEHORE
 */
@Entity
@Table(name = "ayudante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ayudante.findAll", query = "SELECT a FROM Ayudante a"),
    @NamedQuery(name = "Ayudante.findByIdayudante", query = "SELECT a FROM Ayudante a WHERE a.idayudante = :idayudante"),
    @NamedQuery(name = "Ayudante.findByFechaayudante", query = "SELECT a FROM Ayudante a WHERE a.fechaayudante = :fechaayudante"),
    @NamedQuery(name = "Ayudante.findByObservacion", query = "SELECT a FROM Ayudante a WHERE a.observacion = :observacion")})
public class Ayudante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idayudante")
    private Integer idayudante;
    @Column(name = "fechaayudante")
    @Temporal(TemporalType.DATE)
    private Date fechaayudante;
    @Size(max = 500)
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "idEstudiante", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Estudiante idEstudiante;
    @JoinColumn(name = "idayudantia", referencedColumnName = "idayudantia")
    @ManyToOne(optional = false)
    private Ayudantia idayudantia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idayudante")
    private List<Clase> claseList;

    public Ayudante() {
    }

    public Ayudante(Integer idayudante) {
        this.idayudante = idayudante;
    }

    public Integer getIdayudante() {
        return idayudante;
    }

    public void setIdayudante(Integer idayudante) {
        this.idayudante = idayudante;
    }

    public Date getFechaayudante() {
        return fechaayudante;
    }

    public void setFechaayudante(Date fechaayudante) {
        this.fechaayudante = fechaayudante;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Estudiante getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Estudiante idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Ayudantia getIdayudantia() {
        return idayudantia;
    }

    public void setIdayudantia(Ayudantia idayudantia) {
        this.idayudantia = idayudantia;
    }

    @XmlTransient
    public List<Clase> getClaseList() {
        return claseList;
    }

    public void setClaseList(List<Clase> claseList) {
        this.claseList = claseList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idayudante != null ? idayudante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ayudante)) {
            return false;
        }
        Ayudante other = (Ayudante) object;
        if ((this.idayudante == null && other.idayudante != null) || (this.idayudante != null && !this.idayudante.equals(other.idayudante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.rongo.persistence.Ayudante[ idayudante=" + idayudante + " ]";
    }
    
}
