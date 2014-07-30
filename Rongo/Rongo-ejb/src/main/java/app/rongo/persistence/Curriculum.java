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
@Table(name = "curriculum")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curriculum.findAll", query = "SELECT c FROM Curriculum c"),
    @NamedQuery(name = "Curriculum.findByIdcurriculum", query = "SELECT c FROM Curriculum c WHERE c.idcurriculum = :idcurriculum"),
    @NamedQuery(name = "Curriculum.findByNombre", query = "SELECT c FROM Curriculum c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Curriculum.findByArchivo", query = "SELECT c FROM Curriculum c WHERE c.archivo = :archivo")})
public class Curriculum implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcurriculum")
    private Integer idcurriculum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "archivo")
    private String archivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcurriculum")
    private List<Estudiante> estudianteList;

    public Curriculum() {
    }

    public Curriculum(Integer idcurriculum) {
        this.idcurriculum = idcurriculum;
    }

    public Curriculum(Integer idcurriculum, String nombre, String archivo) {
        this.idcurriculum = idcurriculum;
        this.nombre = nombre;
        this.archivo = archivo;
    }

    public Integer getIdcurriculum() {
        return idcurriculum;
    }

    public void setIdcurriculum(Integer idcurriculum) {
        this.idcurriculum = idcurriculum;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    @XmlTransient
    @JsonIgnore
    public List<Estudiante> getEstudianteList() {
        return estudianteList;
    }

    public void setEstudianteList(List<Estudiante> estudianteList) {
        this.estudianteList = estudianteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcurriculum != null ? idcurriculum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curriculum)) {
            return false;
        }
        Curriculum other = (Curriculum) object;
        if ((this.idcurriculum == null && other.idcurriculum != null) || (this.idcurriculum != null && !this.idcurriculum.equals(other.idcurriculum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.rongo.persistence.Curriculum[ idcurriculum=" + idcurriculum + " ]";
    }
    
}
