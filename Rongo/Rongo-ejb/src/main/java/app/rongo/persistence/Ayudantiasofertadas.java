/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.rongo.persistence;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Liliana
 */
@Entity
@Table(name = "ayudantiasofertadas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ayudantiasofertadas.findAll", query = "SELECT a FROM Ayudantiasofertadas a"),
    @NamedQuery(name = "Ayudantiasofertadas.findByIdayudantiasofertadas", query = "SELECT a FROM Ayudantiasofertadas a WHERE a.idayudantiasofertadas = :idayudantiasofertadas"),
    @NamedQuery(name = "Ayudantiasofertadas.findByCargasemanal", query = "SELECT a FROM Ayudantiasofertadas a WHERE a.cargasemanal = :cargasemanal"),
    @NamedQuery(name = "Ayudantiasofertadas.findByRequisitos", query = "SELECT a FROM Ayudantiasofertadas a WHERE a.requisitos = :requisitos"),
    @NamedQuery(name = "Ayudantiasofertadas.findByDescripcion", query = "SELECT a FROM Ayudantiasofertadas a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "Ayudantiasofertadas.findByVigentedesde", query = "SELECT a FROM Ayudantiasofertadas a WHERE a.vigentedesde = :vigentedesde"),
    @NamedQuery(name = "Ayudantiasofertadas.findByVigentehasta", query = "SELECT a FROM Ayudantiasofertadas a WHERE a.vigentehasta = :vigentehasta"),
    @NamedQuery(name = "Ayudantiasofertadas.findByTipodeayudantia", query = "SELECT a FROM Ayudantiasofertadas a WHERE a.tipodeayudantia = :tipodeayudantia")})
public class Ayudantiasofertadas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idayudantiasofertadas")
    private Integer idayudantiasofertadas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cargasemanal")
    private int cargasemanal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "requisitos")
    private String requisitos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vigentedesde")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vigentedesde;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vigentehasta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vigentehasta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "tipodeayudantia")
    private String tipodeayudantia;
    @JoinColumn(name = "idsupervisor", referencedColumnName = "idsupervisor")
    @ManyToOne(optional = false)
    private Supervisor idsupervisor;

    public Ayudantiasofertadas() {
    }

    public Ayudantiasofertadas(Integer idayudantiasofertadas) {
        this.idayudantiasofertadas = idayudantiasofertadas;
    }

    public Ayudantiasofertadas(Integer idayudantiasofertadas, int cargasemanal, String requisitos, String descripcion, Date vigentedesde, Date vigentehasta, String tipodeayudantia) {
        this.idayudantiasofertadas = idayudantiasofertadas;
        this.cargasemanal = cargasemanal;
        this.requisitos = requisitos;
        this.descripcion = descripcion;
        this.vigentedesde = vigentedesde;
        this.vigentehasta = vigentehasta;
        this.tipodeayudantia = tipodeayudantia;
    }

    public Integer getIdayudantiasofertadas() {
        return idayudantiasofertadas;
    }

    public void setIdayudantiasofertadas(Integer idayudantiasofertadas) {
        this.idayudantiasofertadas = idayudantiasofertadas;
    }

    public int getCargasemanal() {
        return cargasemanal;
    }

    public void setCargasemanal(int cargasemanal) {
        this.cargasemanal = cargasemanal;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getVigentedesde() {
        return vigentedesde;
    }

    public void setVigentedesde(Date vigentedesde) {
        this.vigentedesde = vigentedesde;
    }

    public Date getVigentehasta() {
        return vigentehasta;
    }

    public void setVigentehasta(Date vigentehasta) {
        this.vigentehasta = vigentehasta;
    }

    public String getTipodeayudantia() {
        return tipodeayudantia;
    }

    public void setTipodeayudantia(String tipodeayudantia) {
        this.tipodeayudantia = tipodeayudantia;
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
        hash += (idayudantiasofertadas != null ? idayudantiasofertadas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ayudantiasofertadas)) {
            return false;
        }
        Ayudantiasofertadas other = (Ayudantiasofertadas) object;
        if ((this.idayudantiasofertadas == null && other.idayudantiasofertadas != null) || (this.idayudantiasofertadas != null && !this.idayudantiasofertadas.equals(other.idayudantiasofertadas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.rongo.persistence.Ayudantiasofertadas[ idayudantiasofertadas=" + idayudantiasofertadas + " ]";
    }
    
}
