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
@Table(name = "observaciones_actividad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ObservacionesActividad.findAll", query = "SELECT o FROM ObservacionesActividad o"),
    @NamedQuery(name = "ObservacionesActividad.findByIdobservacionesActividad", query = "SELECT o FROM ObservacionesActividad o WHERE o.idobservacionesActividad = :idobservacionesActividad"),
    @NamedQuery(name = "ObservacionesActividad.findByActividadesRealizadas", query = "SELECT o FROM ObservacionesActividad o WHERE o.actividadesRealizadas = :actividadesRealizadas"),
    @NamedQuery(name = "ObservacionesActividad.findByNumero", query = "SELECT o FROM ObservacionesActividad o WHERE o.numero = :numero"),
    @NamedQuery(name = "ObservacionesActividad.findByHoras", query = "SELECT o FROM ObservacionesActividad o WHERE o.horas = :horas"),
    @NamedQuery(name = "ObservacionesActividad.findByObservaciones", query = "SELECT o FROM ObservacionesActividad o WHERE o.observaciones = :observaciones")})
public class ObservacionesActividad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idobservaciones_actividad")
    private Integer idobservacionesActividad;
    @Size(max = 45)
    @Column(name = "actividades_realizadas")
    private String actividadesRealizadas;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "horas")
    private Integer horas;
    @Size(max = 60)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "idcuestionario", referencedColumnName = "idevaluacion_desempeno")
    @ManyToOne
    private Cuestionario idcuestionario;

    public ObservacionesActividad() {
    }

    public ObservacionesActividad(Integer idobservacionesActividad) {
        this.idobservacionesActividad = idobservacionesActividad;
    }

    public Integer getIdobservacionesActividad() {
        return idobservacionesActividad;
    }

    public void setIdobservacionesActividad(Integer idobservacionesActividad) {
        this.idobservacionesActividad = idobservacionesActividad;
    }

    public String getActividadesRealizadas() {
        return actividadesRealizadas;
    }

    public void setActividadesRealizadas(String actividadesRealizadas) {
        this.actividadesRealizadas = actividadesRealizadas;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Cuestionario getIdcuestionario() {
        return idcuestionario;
    }

    public void setIdcuestionario(Cuestionario idcuestionario) {
        this.idcuestionario = idcuestionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idobservacionesActividad != null ? idobservacionesActividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObservacionesActividad)) {
            return false;
        }
        ObservacionesActividad other = (ObservacionesActividad) object;
        if ((this.idobservacionesActividad == null && other.idobservacionesActividad != null) || (this.idobservacionesActividad != null && !this.idobservacionesActividad.equals(other.idobservacionesActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.rongo.persistence.ObservacionesActividad[ idobservacionesActividad=" + idobservacionesActividad + " ]";
    }
    
}
