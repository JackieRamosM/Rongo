/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.rongo.persistence;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SEHORE
 */
@Entity
@Table(name = "valoracion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Valoracion.findAll", query = "SELECT v FROM Valoracion v"),
    @NamedQuery(name = "Valoracion.findByIdvaloracion", query = "SELECT v FROM Valoracion v WHERE v.idvaloracion = :idvaloracion"),
    @NamedQuery(name = "Valoracion.findByCriterio", query = "SELECT v FROM Valoracion v WHERE v.criterio = :criterio"),
    @NamedQuery(name = "Valoracion.findByCalificacion", query = "SELECT v FROM Valoracion v WHERE v.calificacion = :calificacion"),
    @NamedQuery(name = "Valoracion.findByObservaciones", query = "SELECT v FROM Valoracion v WHERE v.observaciones = :observaciones")})
public class Valoracion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idvaloracion")
    private Integer idvaloracion;
    @Column(name = "criterio")
    private Integer criterio;
    @Column(name = "calificacion")
    private Integer calificacion;
    @Size(max = 45)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "idevaluacion", referencedColumnName = "idevaluacion_desempeno")
    @ManyToOne
    private Cuestionario idevaluacion;

    public Valoracion() {
    }

    public Valoracion(Integer idvaloracion) {
        this.idvaloracion = idvaloracion;
    }

    public Integer getIdvaloracion() {
        return idvaloracion;
    }

    public void setIdvaloracion(Integer idvaloracion) {
        this.idvaloracion = idvaloracion;
    }

    public Integer getCriterio() {
        return criterio;
    }

    public void setCriterio(Integer criterio) {
        this.criterio = criterio;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Cuestionario getIdevaluacion() {
        return idevaluacion;
    }

    public void setIdevaluacion(Cuestionario idevaluacion) {
        this.idevaluacion = idevaluacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvaloracion != null ? idvaloracion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valoracion)) {
            return false;
        }
        Valoracion other = (Valoracion) object;
        if ((this.idvaloracion == null && other.idvaloracion != null) || (this.idvaloracion != null && !this.idvaloracion.equals(other.idvaloracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.rongo.persistence.Valoracion[ idvaloracion=" + idvaloracion + " ]";
    }
    
}
