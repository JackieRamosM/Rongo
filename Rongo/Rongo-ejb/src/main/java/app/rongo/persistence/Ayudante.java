/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.rongo.persistence;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Liliana
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "idayudante")
    private Integer idayudante;
    @Column(name = "fechaayudante")
    @Temporal(TemporalType.DATE)
    private Date fechaayudante;
    @Size(max = 500)
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "estudianteusuario", referencedColumnName = "Usuario")
    @ManyToOne(optional = false)
    private Estudiante estudianteusuario;
    @JoinColumn(name = "idayudantia", referencedColumnName = "idayudantia")
    @ManyToOne(optional = false)
    private Ayudantia idayudantia;

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

    public Estudiante getEstudianteusuario() {
        return estudianteusuario;
    }

    public void setEstudianteusuario(Estudiante estudianteusuario) {
        this.estudianteusuario = estudianteusuario;
    }

    public Ayudantia getIdayudantia() {
        return idayudantia;
    }

    public void setIdayudantia(Ayudantia idayudantia) {
        this.idayudantia = idayudantia;
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
