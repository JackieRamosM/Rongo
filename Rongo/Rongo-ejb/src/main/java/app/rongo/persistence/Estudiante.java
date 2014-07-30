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
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Liliana
 */
@Entity
@Table(name = "estudiante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e"),
    @NamedQuery(name = "Estudiante.findByUsuario", query = "SELECT e FROM Estudiante e WHERE e.usuario = :usuario"),
    @NamedQuery(name = "Estudiante.findBySkype", query = "SELECT e FROM Estudiante e WHERE e.skype = :skype"),
    @NamedQuery(name = "Estudiante.findByTwitter", query = "SELECT e FROM Estudiante e WHERE e.twitter = :twitter"),
    @NamedQuery(name = "Estudiante.findByIntereses", query = "SELECT e FROM Estudiante e WHERE e.intereses = :intereses"),
    @NamedQuery(name = "Estudiante.findByAdmin", query = "SELECT e FROM Estudiante e WHERE e.admin = :admin")})
public class Estudiante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Usuario")
    private String usuario;
    @Size(max = 30)
    @Column(name = "skype")
    private String skype;
    @Size(max = 30)
    @Column(name = "twitter")
    private String twitter;
    @Size(max = 255)
    @Column(name = "Intereses")
    private String intereses;
    @Column(name = "admin")
    private Boolean admin;
    @JoinColumn(name = "idcuestionario", referencedColumnName = "idcuestionario")
    @ManyToOne(optional = false)
    private Cuestionario idcuestionario;
    @JoinColumn(name = "idcurriculum", referencedColumnName = "idcurriculum")
    @ManyToOne(optional = false)
    private Curriculum idcurriculum;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudianteusuario")
    private List<Ayudante> ayudanteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudianteusuario")
    private List<Asistencia> asistenciaList;

    public Estudiante() {
    }

    public Estudiante(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getIntereses() {
        return intereses;
    }

    public void setIntereses(String intereses) {
        this.intereses = intereses;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Cuestionario getIdcuestionario() {
        return idcuestionario;
    }

    public void setIdcuestionario(Cuestionario idcuestionario) {
        this.idcuestionario = idcuestionario;
    }

    public Curriculum getIdcurriculum() {
        return idcurriculum;
    }

    public void setIdcurriculum(Curriculum idcurriculum) {
        this.idcurriculum = idcurriculum;
    }

    @XmlTransient
    @JsonIgnore
    public List<Ayudante> getAyudanteList() {
        return ayudanteList;
    }

    public void setAyudanteList(List<Ayudante> ayudanteList) {
        this.ayudanteList = ayudanteList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Asistencia> getAsistenciaList() {
        return asistenciaList;
    }

    public void setAsistenciaList(List<Asistencia> asistenciaList) {
        this.asistenciaList = asistenciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuario != null ? usuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.rongo.persistence.Estudiante[ usuario=" + usuario + " ]";
    }
    
}
