/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
 * @author Liliana
 */
@Entity
@Table(name = "asistencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asistencia.findAll", query = "SELECT a FROM Asistencia a"),
    @NamedQuery(name = "Asistencia.findByIdasistencia", query = "SELECT a FROM Asistencia a WHERE a.idasistencia = :idasistencia"),
    @NamedQuery(name = "Asistencia.findByAsistenciacol", query = "SELECT a FROM Asistencia a WHERE a.asistenciacol = :asistenciacol")})
public class Asistencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idasistencia")
    private Integer idasistencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "asistenciacol")
    private String asistenciacol;
    @JoinColumn(name = "estudianteusuario", referencedColumnName = "Usuario")
    @ManyToOne(optional = false)
    private Estudiante estudianteusuario;
    @JoinColumn(name = "idclase", referencedColumnName = "idclase")
    @ManyToOne(optional = false)
    private Clase idclase;

    public Asistencia() {
    }

    public Asistencia(Integer idasistencia) {
        this.idasistencia = idasistencia;
    }

    public Asistencia(Integer idasistencia, String asistenciacol) {
        this.idasistencia = idasistencia;
        this.asistenciacol = asistenciacol;
    }

    public Integer getIdasistencia() {
        return idasistencia;
    }

    public void setIdasistencia(Integer idasistencia) {
        this.idasistencia = idasistencia;
    }

    public String getAsistenciacol() {
        return asistenciacol;
    }

    public void setAsistenciacol(String asistenciacol) {
        this.asistenciacol = asistenciacol;
    }

    public Estudiante getEstudianteusuario() {
        return estudianteusuario;
    }

    public void setEstudianteusuario(Estudiante estudianteusuario) {
        this.estudianteusuario = estudianteusuario;
    }

    public Clase getIdclase() {
        return idclase;
    }

    public void setIdclase(Clase idclase) {
        this.idclase = idclase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idasistencia != null ? idasistencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asistencia)) {
            return false;
        }
        Asistencia other = (Asistencia) object;
        if ((this.idasistencia == null && other.idasistencia != null) || (this.idasistencia != null && !this.idasistencia.equals(other.idasistencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.rongo.persistence.Asistencia[ idasistencia=" + idasistencia + " ]";
    }
    
}
