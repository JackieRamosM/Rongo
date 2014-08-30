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
@Table(name = "item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.findByIditem", query = "SELECT i FROM Item i WHERE i.iditem = :iditem"),
    @NamedQuery(name = "Item.findByTipo", query = "SELECT i FROM Item i WHERE i.tipo = :tipo"),
    @NamedQuery(name = "Item.findByContenido", query = "SELECT i FROM Item i WHERE i.contenido = :contenido")})
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iditem")
    private Integer iditem;
    @Column(name = "tipo")
    private Integer tipo;
    @Size(max = 45)
    @Column(name = "contenido")
    private String contenido;
    @JoinColumn(name = "idevaluacion5", referencedColumnName = "idevaluacion_desempeno")
    @ManyToOne
    private Cuestionario idevaluacion5;

    public Item() {
    }

    public Item(Integer iditem) {
        this.iditem = iditem;
    }

    public Integer getIditem() {
        return iditem;
    }

    public void setIditem(Integer iditem) {
        this.iditem = iditem;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Cuestionario getIdevaluacion5() {
        return idevaluacion5;
    }

    public void setIdevaluacion5(Cuestionario idevaluacion5) {
        this.idevaluacion5 = idevaluacion5;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iditem != null ? iditem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.iditem == null && other.iditem != null) || (this.iditem != null && !this.iditem.equals(other.iditem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.rongo.persistence.Item[ iditem=" + iditem + " ]";
    }
    
}
