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
@Table(name = "ayudantia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ayudantia.findAll", query = "SELECT a FROM Ayudantia a"),
    @NamedQuery(name = "Ayudantia.findByIdayudantia", query = "SELECT a FROM Ayudantia a WHERE a.idayudantia = :idayudantia"),
    @NamedQuery(name = "Ayudantia.findByNombre", query = "SELECT a FROM Ayudantia a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Ayudantia.findByTipodeayudantia", query = "SELECT a FROM Ayudantia a WHERE a.tipodeayudantia = :tipodeayudantia")})
public class Ayudantia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idayudantia")
    private Integer idayudantia;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "tipodeayudantia")
    private String tipodeayudantia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idayudantia")
    private List<Ayudante> ayudanteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idayudantia")
    private List<Clase> claseList;
    @JoinColumn(name = "idsupervisor", referencedColumnName = "idsupervisor")
    @ManyToOne(optional = false)
    private Supervisor idsupervisor;

    public Ayudantia() {
    }

    public Ayudantia(Integer idayudantia) {
        this.idayudantia = idayudantia;
    }

    public Ayudantia(Integer idayudantia, String tipodeayudantia) {
        this.idayudantia = idayudantia;
        this.tipodeayudantia = tipodeayudantia;
    }

    public Integer getIdayudantia() {
        return idayudantia;
    }

    public void setIdayudantia(Integer idayudantia) {
        this.idayudantia = idayudantia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipodeayudantia() {
        return tipodeayudantia;
    }

    public void setTipodeayudantia(String tipodeayudantia) {
        this.tipodeayudantia = tipodeayudantia;
    }

    @XmlTransient
    public List<Ayudante> getAyudanteList() {
        return ayudanteList;
    }

    public void setAyudanteList(List<Ayudante> ayudanteList) {
        this.ayudanteList = ayudanteList;
    }

    @XmlTransient
    public List<Clase> getClaseList() {
        return claseList;
    }

    public void setClaseList(List<Clase> claseList) {
        this.claseList = claseList;
    }

    public Supervisor getIdsupervisor() {
        return idsupervisor;
    }

    public void setIdsupervisor(Supervisor idsupervisor) {
        this.idsupervisor = idsupervisor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idayudantia != null ? idayudantia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ayudantia)) {
            return false;
        }
        Ayudantia other = (Ayudantia) object;
        if ((this.idayudantia == null && other.idayudantia != null) || (this.idayudantia != null && !this.idayudantia.equals(other.idayudantia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.rongo.persistence.Ayudantia[ idayudantia=" + idayudantia + " ]";
    }
    
}
