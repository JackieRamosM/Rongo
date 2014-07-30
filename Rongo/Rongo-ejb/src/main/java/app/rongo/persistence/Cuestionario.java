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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Liliana
 */
@Entity
@Table(name = "cuestionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuestionario.findAll", query = "SELECT c FROM Cuestionario c"),
    @NamedQuery(name = "Cuestionario.findByIdcuestionario", query = "SELECT c FROM Cuestionario c WHERE c.idcuestionario = :idcuestionario"),
    @NamedQuery(name = "Cuestionario.findByTipocuestionario", query = "SELECT c FROM Cuestionario c WHERE c.tipocuestionario = :tipocuestionario"),
    @NamedQuery(name = "Cuestionario.findByDescripcion", query = "SELECT c FROM Cuestionario c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Cuestionario.findByRuta", query = "SELECT c FROM Cuestionario c WHERE c.ruta = :ruta")})
public class Cuestionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcuestionario")
    private Integer idcuestionario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "tipocuestionario")
    private String tipocuestionario;
    @Size(max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ruta")
    private String ruta;
    @JoinColumn(name = "idcamposcuestionario", referencedColumnName = "idcamposcuestionario")
    @ManyToOne(optional = false)
    private Camposcuestionario idcamposcuestionario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcuestionario")
    private List<Estudiante> estudianteList;
    @OneToMany(mappedBy = "idcuestionario")
    private List<Supervisor> supervisorList;

    public Cuestionario() {
    }

    public Cuestionario(Integer idcuestionario) {
        this.idcuestionario = idcuestionario;
    }

    public Cuestionario(Integer idcuestionario, String tipocuestionario, String ruta) {
        this.idcuestionario = idcuestionario;
        this.tipocuestionario = tipocuestionario;
        this.ruta = ruta;
    }

    public Integer getIdcuestionario() {
        return idcuestionario;
    }

    public void setIdcuestionario(Integer idcuestionario) {
        this.idcuestionario = idcuestionario;
    }

    public String getTipocuestionario() {
        return tipocuestionario;
    }

    public void setTipocuestionario(String tipocuestionario) {
        this.tipocuestionario = tipocuestionario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Camposcuestionario getIdcamposcuestionario() {
        return idcamposcuestionario;
    }

    public void setIdcamposcuestionario(Camposcuestionario idcamposcuestionario) {
        this.idcamposcuestionario = idcamposcuestionario;
    }

    @XmlTransient
    public List<Estudiante> getEstudianteList() {
        return estudianteList;
    }

    public void setEstudianteList(List<Estudiante> estudianteList) {
        this.estudianteList = estudianteList;
    }

    @XmlTransient
    public List<Supervisor> getSupervisorList() {
        return supervisorList;
    }

    public void setSupervisorList(List<Supervisor> supervisorList) {
        this.supervisorList = supervisorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcuestionario != null ? idcuestionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuestionario)) {
            return false;
        }
        Cuestionario other = (Cuestionario) object;
        if ((this.idcuestionario == null && other.idcuestionario != null) || (this.idcuestionario != null && !this.idcuestionario.equals(other.idcuestionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.rongo.persistence.Cuestionario[ idcuestionario=" + idcuestionario + " ]";
    }
    
}
