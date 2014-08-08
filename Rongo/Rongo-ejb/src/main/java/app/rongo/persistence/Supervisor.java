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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "supervisor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Supervisor.findAll", query = "SELECT s FROM Supervisor s"),
    @NamedQuery(name = "Supervisor.findByIdsupervisor", query = "SELECT s FROM Supervisor s WHERE s.idsupervisor = :idsupervisor"),
    @NamedQuery(name = "Supervisor.findByNombre", query = "SELECT s FROM Supervisor s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "Supervisor.findByApellido", query = "SELECT s FROM Supervisor s WHERE s.apellido = :apellido"),
    @NamedQuery(name = "Supervisor.findByCedula", query = "SELECT s FROM Supervisor s WHERE s.cedula = :cedula"),
    @NamedQuery(name = "Supervisor.findByCorreo", query = "SELECT s FROM Supervisor s WHERE s.correo = :correo"),
    @NamedQuery(name = "Supervisor.findByActivo", query = "SELECT s FROM Supervisor s WHERE s.activo = :activo")})
public class Supervisor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsupervisor")
    private Integer idsupervisor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cedula")
    private String cedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @JoinColumn(name = "idcuestionario", referencedColumnName = "idcuestionario")
    @ManyToOne
    private Cuestionario idcuestionario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsupervisor")
    private List<Ayudantiasofertadas> ayudantiasofertadasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsupervisor")
    private List<Ayudantia> ayudantiaList;

    public Supervisor() {
    }

    public Supervisor(Integer idsupervisor) {
        this.idsupervisor = idsupervisor;
    }

    public Supervisor(Integer idsupervisor, String nombre, String apellido, String cedula, String correo, boolean activo) {
        this.idsupervisor = idsupervisor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.correo = correo;
        this.activo = activo;
    }

    public Integer getIdsupervisor() {
        return idsupervisor;
    }

    public void setIdsupervisor(Integer idsupervisor) {
        this.idsupervisor = idsupervisor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Cuestionario getIdcuestionario() {
        return idcuestionario;
    }

    public void setIdcuestionario(Cuestionario idcuestionario) {
        this.idcuestionario = idcuestionario;
    }

    @XmlTransient
    public List<Ayudantiasofertadas> getAyudantiasofertadasList() {
        return ayudantiasofertadasList;
    }

    public void setAyudantiasofertadasList(List<Ayudantiasofertadas> ayudantiasofertadasList) {
        this.ayudantiasofertadasList = ayudantiasofertadasList;
    }

    @XmlTransient
    public List<Ayudantia> getAyudantiaList() {
        return ayudantiaList;
    }

    public void setAyudantiaList(List<Ayudantia> ayudantiaList) {
        this.ayudantiaList = ayudantiaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsupervisor != null ? idsupervisor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Supervisor)) {
            return false;
        }
        Supervisor other = (Supervisor) object;
        if ((this.idsupervisor == null && other.idsupervisor != null) || (this.idsupervisor != null && !this.idsupervisor.equals(other.idsupervisor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.rongo.persistence.Supervisor[ idsupervisor=" + idsupervisor + " ]";
    }
    
}
