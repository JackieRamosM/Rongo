/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.rongo.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SEHORE
 */
@Entity
@Table(name = "cuestionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuestionario.findAll", query = "SELECT c FROM Cuestionario c"),
    @NamedQuery(name = "Cuestionario.findByIdevaluacionDesempeno", query = "SELECT c FROM Cuestionario c WHERE c.idevaluacionDesempeno = :idevaluacionDesempeno"),
    @NamedQuery(name = "Cuestionario.findByArea", query = "SELECT c FROM Cuestionario c WHERE c.area = :area"),
    @NamedQuery(name = "Cuestionario.findByIdayudante", query = "SELECT c FROM Cuestionario c WHERE c.idayudante = :idayudante"),
    @NamedQuery(name = "Cuestionario.findByDesde", query = "SELECT c FROM Cuestionario c WHERE c.desde = :desde"),
    @NamedQuery(name = "Cuestionario.findByHasta", query = "SELECT c FROM Cuestionario c WHERE c.hasta = :hasta"),
    @NamedQuery(name = "Cuestionario.findByAnioacademicodesde", query = "SELECT c FROM Cuestionario c WHERE c.anioacademicodesde = :anioacademicodesde"),
    @NamedQuery(name = "Cuestionario.findByAnioacademicohasta", query = "SELECT c FROM Cuestionario c WHERE c.anioacademicohasta = :anioacademicohasta"),
    @NamedQuery(name = "Cuestionario.findByFecha", query = "SELECT c FROM Cuestionario c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Cuestionario.findByTipo", query = "SELECT c FROM Cuestionario c WHERE c.tipo = :tipo")})
public class Cuestionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idevaluacion_desempeno")
    private Integer idevaluacionDesempeno;
    @Size(max = 45)
    @Column(name = "area")
    private String area;
    @Column(name = "idayudante")
    private Integer idayudante;
    @Column(name = "desde")
    @Temporal(TemporalType.DATE)
    private Date desde;
    @Column(name = "hasta")
    @Temporal(TemporalType.DATE)
    private Date hasta;
    @Column(name = "anioacademicodesde")
    private Integer anioacademicodesde;
    @Column(name = "anioacademicohasta")
    private Integer anioacademicohasta;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "tipo")
    private Integer tipo;
    @JoinColumn(name = "idsupervisor", referencedColumnName = "idsupervisor")
    @ManyToOne
    private Supervisor idsupervisor;
    @OneToMany(mappedBy = "idevaluacion1")
    private List<HoraAsignada> horaAsignadaList;
    @OneToMany(mappedBy = "idevaluacion")
    private List<Valoracion> valoracionList;
    @OneToMany(mappedBy = "idevaluacion5")
    private List<Item> itemList;
    @OneToMany(mappedBy = "idevaluacion2")
    private List<Valordeldesempeno> valordeldesempenoList;

    public Cuestionario() {
    }

    public Cuestionario(Integer idevaluacionDesempeno) {
        this.idevaluacionDesempeno = idevaluacionDesempeno;
    }

    public Integer getIdevaluacionDesempeno() {
        return idevaluacionDesempeno;
    }

    public void setIdevaluacionDesempeno(Integer idevaluacionDesempeno) {
        this.idevaluacionDesempeno = idevaluacionDesempeno;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getIdayudante() {
        return idayudante;
    }

    public void setIdayudante(Integer idayudante) {
        this.idayudante = idayudante;
    }

    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public Date getHasta() {
        return hasta;
    }

    public void setHasta(Date hasta) {
        this.hasta = hasta;
    }

    public Integer getAnioacademicodesde() {
        return anioacademicodesde;
    }

    public void setAnioacademicodesde(Integer anioacademicodesde) {
        this.anioacademicodesde = anioacademicodesde;
    }

    public Integer getAnioacademicohasta() {
        return anioacademicohasta;
    }

    public void setAnioacademicohasta(Integer anioacademicohasta) {
        this.anioacademicohasta = anioacademicohasta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Supervisor getIdsupervisor() {
        return idsupervisor;
    }

    public void setIdsupervisor(Supervisor idsupervisor) {
        this.idsupervisor = idsupervisor;
    }

    @XmlTransient
    public List<HoraAsignada> getHoraAsignadaList() {
        return horaAsignadaList;
    }

    public void setHoraAsignadaList(List<HoraAsignada> horaAsignadaList) {
        this.horaAsignadaList = horaAsignadaList;
    }

    @XmlTransient
    public List<Valoracion> getValoracionList() {
        return valoracionList;
    }

    public void setValoracionList(List<Valoracion> valoracionList) {
        this.valoracionList = valoracionList;
    }

    @XmlTransient
    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @XmlTransient
    public List<Valordeldesempeno> getValordeldesempenoList() {
        return valordeldesempenoList;
    }

    public void setValordeldesempenoList(List<Valordeldesempeno> valordeldesempenoList) {
        this.valordeldesempenoList = valordeldesempenoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idevaluacionDesempeno != null ? idevaluacionDesempeno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuestionario)) {
            return false;
        }
        Cuestionario other = (Cuestionario) object;
        if ((this.idevaluacionDesempeno == null && other.idevaluacionDesempeno != null) || (this.idevaluacionDesempeno != null && !this.idevaluacionDesempeno.equals(other.idevaluacionDesempeno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.rongo.persistence.Cuestionario[ idevaluacionDesempeno=" + idevaluacionDesempeno + " ]";
    }
    
}
