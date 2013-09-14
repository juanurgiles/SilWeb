/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utpl.silaboweb.entidad;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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

/**
 *
 * @author root
 */
public class VersionMalla implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idVersionMalla;
    private String nombre;
    private String anio;
    private Boolean activo;
    private Collection<Malla> mallaCollection;

    public VersionMalla() {
    }

    public VersionMalla(Integer idVersionMalla) {
        this.idVersionMalla = idVersionMalla;
    }

    public Integer getIdVersionMalla() {
        return idVersionMalla;
    }

    public void setIdVersionMalla(Integer idVersionMalla) {
        this.idVersionMalla = idVersionMalla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Collection<Malla> getMallaCollection() {
        return mallaCollection;
    }

    public void setMallaCollection(Collection<Malla> mallaCollection) {
        this.mallaCollection = mallaCollection;
    }

    public int hashCode() {
        int hash = 0;
        hash += (idVersionMalla != null ? idVersionMalla.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VersionMalla)) {
            return false;
        }
        VersionMalla other = (VersionMalla) object;
        if ((this.idVersionMalla == null && other.idVersionMalla != null) || (this.idVersionMalla != null && !this.idVersionMalla.equals(other.idVersionMalla))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "com.utpl.javasilabopersist.entidad.VersionMalla[ idVersionMalla=" + idVersionMalla + " ]";
    }
    
}
