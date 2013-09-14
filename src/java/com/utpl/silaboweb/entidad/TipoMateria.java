/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utpl.silaboweb.entidad;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author root
 */
@XmlType
public class TipoMateria implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idTipoMateria;
    private String nombreTIpomateria;
    private String descripcionTipomateria;
    private Collection<Materia> materiaCollection;

    public TipoMateria() {
    }

    public TipoMateria(Integer idTipoMateria) {
        this.idTipoMateria = idTipoMateria;
    }

    public Integer getIdTipoMateria() {
        return idTipoMateria;
    }

    public void setIdTipoMateria(Integer idTipoMateria) {
        this.idTipoMateria = idTipoMateria;
    }

    public String getNombreTIpomateria() {
        return nombreTIpomateria;
    }

    public void setNombreTIpomateria(String nombreTIpomateria) {
        this.nombreTIpomateria = nombreTIpomateria;
    }

    public String getDescripcionTipomateria() {
        return descripcionTipomateria;
    }

    public void setDescripcionTipomateria(String descripcionTipomateria) {
        this.descripcionTipomateria = descripcionTipomateria;
    }

    public Collection<Materia> getMateriaCollection() {
        return materiaCollection;
    }

    public void setMateriaCollection(Collection<Materia> materiaCollection) {
        this.materiaCollection = materiaCollection;
    }

    public int hashCode() {
        int hash = 0;
        hash += (idTipoMateria != null ? idTipoMateria.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMateria)) {
            return false;
        }
        TipoMateria other = (TipoMateria) object;
        if ((this.idTipoMateria == null && other.idTipoMateria != null) || (this.idTipoMateria != null && !this.idTipoMateria.equals(other.idTipoMateria))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "com.utpl.javasilabopersist.entidad.TipoMateria[ idTipoMateria=" + idTipoMateria + " ]";
    }
    
}
