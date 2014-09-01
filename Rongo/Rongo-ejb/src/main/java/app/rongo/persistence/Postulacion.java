/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.rongo.persistence;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SEHORE
 */
@Entity
@Table(name = "postulacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Postulacion.findAll", query = "SELECT p FROM Postulacion p"),
    @NamedQuery(name = "Postulacion.findByIdpostulacion", query = "SELECT p FROM Postulacion p WHERE p.idpostulacion = :idpostulacion"),
    @NamedQuery(name = "Postulacion.findByArchivo", query = "SELECT p FROM Postulacion p WHERE p.archivo = :archivo")})
public class Postulacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpostulacion")
    private Integer idpostulacion;
    @Size(max = 50)
    @Column(name = "archivo")
    private String archivo;
    @JoinColumn(name = "idestudiante", referencedColumnName = "idUsuario")
    @ManyToOne
    private Estudiante idestudiante;
    @JoinColumn(name = "idayudantiaofertada", referencedColumnName = "idayudantiasofertadas")
    @ManyToOne
    private Ayudantiasofertadas idayudantiaofertada;

    public Postulacion() {
    }

    public Postulacion(Integer idpostulacion) {
        this.idpostulacion = idpostulacion;
    }

    public Integer getIdpostulacion() {
        return idpostulacion;
    }

    public void setIdpostulacion(Integer idpostulacion) {
        this.idpostulacion = idpostulacion;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public Estudiante getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(Estudiante idestudiante) {
        this.idestudiante = idestudiante;
    }

    public Ayudantiasofertadas getIdayudantiaofertada() {
        return idayudantiaofertada;
    }

    public void setIdayudantiaofertada(Ayudantiasofertadas idayudantiaofertada) {
        this.idayudantiaofertada = idayudantiaofertada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpostulacion != null ? idpostulacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Postulacion)) {
            return false;
        }
        Postulacion other = (Postulacion) object;
        if ((this.idpostulacion == null && other.idpostulacion != null) || (this.idpostulacion != null && !this.idpostulacion.equals(other.idpostulacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.rongo.persistence.Postulacion[ idpostulacion=" + idpostulacion + " ]";
    }
    
}
