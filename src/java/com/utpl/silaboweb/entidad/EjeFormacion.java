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
public class EjeFormacion implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idEjeFormacion;
    private String nombreEjeFormacion;
    private String descripcionEjeFormacion;
    private Collection<Materia> materiaCollection;

    public EjeFormacion() {
    }

    public EjeFormacion(Integer idEjeFormacion) {
        this.idEjeFormacion = idEjeFormacion;
    }

    public Integer getIdEjeFormacion() {
        return idEjeFormacion;
    }

    public void setIdEjeFormacion(Integer idEjeFormacion) {
        this.idEjeFormacion = idEjeFormacion;
    }

    public String getNombreEjeFormacion() {
        return nombreEjeFormacion;
    }

    public void setNombreEjeFormacion(String nombreEjeFormacion) {
        this.nombreEjeFormacion = nombreEjeFormacion;
    }

    public String getDescripcionEjeFormacion() {
        return descripcionEjeFormacion;
    }

    public void setDescripcionEjeFormacion(String descripcionEjeFormacion) {
        this.descripcionEjeFormacion = descripcionEjeFormacion;
    }

    public Collection<Materia> getMateriaCollection() {
        return materiaCollection;
    }

    public void setMateriaCollection(Collection<Materia> materiaCollection) {
        this.materiaCollection = materiaCollection;
    }

   public int hashCode() {
        int hash = 0;
        hash += (idEjeFormacion != null ? idEjeFormacion.hashCode() : 0);
        return hash;
    }

     public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EjeFormacion)) {
            return false;
        }
        EjeFormacion other = (EjeFormacion) object;
        if ((this.idEjeFormacion == null && other.idEjeFormacion != null) || (this.idEjeFormacion != null && !this.idEjeFormacion.equals(other.idEjeFormacion))) {
            return false;
        }
        return true;
    }

   public String toString() {
        return "com.utpl.javasilabopersist.entidad.EjeFormacion[ idEjeFormacion=" + idEjeFormacion + " ]";
    }
    
}
