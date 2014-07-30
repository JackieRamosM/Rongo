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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Liliana
 */
@Entity
@Table(name = "camposcuestionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Camposcuestionario.findAll", query = "SELECT c FROM Camposcuestionario c"),
    @NamedQuery(name = "Camposcuestionario.findByIdcamposcuestionario", query = "SELECT c FROM Camposcuestionario c WHERE c.idcamposcuestionario = :idcamposcuestionario")})
public class Camposcuestionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcamposcuestionario")
    private Integer idcamposcuestionario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcamposcuestionario")
    private List<Cuestionario> cuestionarioList;
    @JoinColumn(name = "idvalordesempeno", referencedColumnName = "idvalordeldesempeno")
    @ManyToOne(optional = false)
    private Valordeldesempeno idvalordesempeno;

    public Camposcuestionario() {
    }

    public Camposcuestionario(Integer idcamposcuestionario) {
        this.idcamposcuestionario = idcamposcuestionario;
    }

    public Integer getIdcamposcuestionario() {
        return idcamposcuestionario;
    }

    public void setIdcamposcuestionario(Integer idcamposcuestionario) {
        this.idcamposcuestionario = idcamposcuestionario;
    }

    @XmlTransient
    public List<Cuestionario> getCuestionarioList() {
        return cuestionarioList;
    }

    public void setCuestionarioList(List<Cuestionario> cuestionarioList) {
        this.cuestionarioList = cuestionarioList;
    }

    public Valordeldesempeno getIdvalordesempeno() {
        return idvalordesempeno;
    }

    public void setIdvalordesempeno(Valordeldesempeno idvalordesempeno) {
        this.idvalordesempeno = idvalordesempeno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcamposcuestionario != null ? idcamposcuestionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Camposcuestionario)) {
            return false;
        }
        Camposcuestionario other = (Camposcuestionario) object;
        if ((this.idcamposcuestionario == null && other.idcamposcuestionario != null) || (this.idcamposcuestionario != null && !this.idcamposcuestionario.equals(other.idcamposcuestionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.rongo.persistence.Camposcuestionario[ idcamposcuestionario=" + idcamposcuestionario + " ]";
    }
    
}
