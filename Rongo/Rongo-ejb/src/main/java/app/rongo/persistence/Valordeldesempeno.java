/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.rongo.persistence;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Liliana
 */
@Entity
@Table(name = "valordeldesempeno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Valordeldesempeno.findAll", query = "SELECT v FROM Valordeldesempeno v"),
    @NamedQuery(name = "Valordeldesempeno.findByIdvalordeldesempeno", query = "SELECT v FROM Valordeldesempeno v WHERE v.idvalordeldesempeno = :idvalordeldesempeno"),
    @NamedQuery(name = "Valordeldesempeno.findByCriterio", query = "SELECT v FROM Valordeldesempeno v WHERE v.criterio = :criterio"),
    @NamedQuery(name = "Valordeldesempeno.findByCalificacion", query = "SELECT v FROM Valordeldesempeno v WHERE v.calificacion = :calificacion"),
    @NamedQuery(name = "Valordeldesempeno.findByObservacion", query = "SELECT v FROM Valordeldesempeno v WHERE v.observacion = :observacion")})
public class Valordeldesempeno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idvalordeldesempeno")
    private Integer idvalordeldesempeno;
    @Size(max = 20)
    @Column(name = "criterio")
    private String criterio;
    @Column(name = "calificacion")
    private Integer calificacion;
    @Size(max = 500)
    @Column(name = "observacion")
    private String observacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idvalordesempeno")
    private List<Camposcuestionario> camposcuestionarioList;

    public Valordeldesempeno() {
    }

    public Valordeldesempeno(Integer idvalordeldesempeno) {
        this.idvalordeldesempeno = idvalordeldesempeno;
    }

    public Integer getIdvalordeldesempeno() {
        return idvalordeldesempeno;
    }

    public void setIdvalordeldesempeno(Integer idvalordeldesempeno) {
        this.idvalordeldesempeno = idvalordeldesempeno;
    }

    public String getCriterio() {
        return criterio;
    }

    public void setCriterio(String criterio) {
        this.criterio = criterio;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @XmlTransient
    @JsonIgnore
    public List<Camposcuestionario> getCamposcuestionarioList() {
        return camposcuestionarioList;
    }

    public void setCamposcuestionarioList(List<Camposcuestionario> camposcuestionarioList) {
        this.camposcuestionarioList = camposcuestionarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvalordeldesempeno != null ? idvalordeldesempeno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valordeldesempeno)) {
            return false;
        }
        Valordeldesempeno other = (Valordeldesempeno) object;
        if ((this.idvalordeldesempeno == null && other.idvalordeldesempeno != null) || (this.idvalordeldesempeno != null && !this.idvalordeldesempeno.equals(other.idvalordeldesempeno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.rongo.persistence.Valordeldesempeno[ idvalordeldesempeno=" + idvalordeldesempeno + " ]";
    }
    
}
