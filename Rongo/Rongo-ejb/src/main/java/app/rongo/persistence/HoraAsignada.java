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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SEHORE
 */
@Entity
@Table(name = "hora_asignada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HoraAsignada.findAll", query = "SELECT h FROM HoraAsignada h"),
    @NamedQuery(name = "HoraAsignada.findByIdhoraAsignada", query = "SELECT h FROM HoraAsignada h WHERE h.idhoraAsignada = :idhoraAsignada"),
    @NamedQuery(name = "HoraAsignada.findByDia", query = "SELECT h FROM HoraAsignada h WHERE h.dia = :dia"),
    @NamedQuery(name = "HoraAsignada.findByHoras", query = "SELECT h FROM HoraAsignada h WHERE h.horas = :horas")})
public class HoraAsignada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idhora_asignada")
    private Integer idhoraAsignada;
    @Column(name = "Dia")
    private Integer dia;
    @Column(name = "horas")
    private Integer horas;
    @JoinColumn(name = "idevaluacion1", referencedColumnName = "idevaluacion_desempeno")
    @ManyToOne
    private Cuestionario idevaluacion1;

    public HoraAsignada() {
    }

    public HoraAsignada(Integer idhoraAsignada) {
        this.idhoraAsignada = idhoraAsignada;
    }

    public Integer getIdhoraAsignada() {
        return idhoraAsignada;
    }

    public void setIdhoraAsignada(Integer idhoraAsignada) {
        this.idhoraAsignada = idhoraAsignada;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    public Cuestionario getIdevaluacion1() {
        return idevaluacion1;
    }

    public void setIdevaluacion1(Cuestionario idevaluacion1) {
        this.idevaluacion1 = idevaluacion1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhoraAsignada != null ? idhoraAsignada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HoraAsignada)) {
            return false;
        }
        HoraAsignada other = (HoraAsignada) object;
        if ((this.idhoraAsignada == null && other.idhoraAsignada != null) || (this.idhoraAsignada != null && !this.idhoraAsignada.equals(other.idhoraAsignada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.rongo.persistence.HoraAsignada[ idhoraAsignada=" + idhoraAsignada + " ]";
    }
    
}
