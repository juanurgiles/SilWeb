/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utpl.silaboweb.entidad;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author root
 */
@XmlType
public class Malla implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idMalla;
    private String nombreMalla;
    private Integer anio;
    private Integer anios;
    private Integer periodos;
    private Collection<MateriaMalla> materiaMallaCollection;
    private VersionMalla idVersionMalla;
    private Carrera idCarrera;

    public Malla() {
    }

    public Malla(Integer idMalla) {
        this.idMalla = idMalla;
    }

    public Integer getIdMalla() {
        return idMalla;
    }

    public void setIdMalla(Integer idMalla) {
        this.idMalla = idMalla;
    }

    public String getNombreMalla() {
        return nombreMalla;
    }

    public void setNombreMalla(String nombreMalla) {
        this.nombreMalla = nombreMalla;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getAnios() {
        return anios;
    }

    public void setAnios(Integer anios) {
        this.anios = anios;
    }

    public Integer getPeriodos() {
        return periodos;
    }

    public void setPeriodos(Integer periodos) {
        this.periodos = periodos;
    }

    public Collection<MateriaMalla> getMateriaMallaCollection() {
        return materiaMallaCollection;
    }

    public void setMateriaMallaCollection(Collection<MateriaMalla> materiaMallaCollection) {
        this.materiaMallaCollection = materiaMallaCollection;
    }

    public VersionMalla getIdVersionMalla() {
        return idVersionMalla;
    }

    public void setIdVersionMalla(VersionMalla idVersionMalla) {
        this.idVersionMalla = idVersionMalla;
    }

    public Carrera getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Carrera idCarrera) {
        this.idCarrera = idCarrera;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMalla != null ? idMalla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Malla)) {
            return false;
        }
        Malla other = (Malla) object;
        if ((this.idMalla == null && other.idMalla != null) || (this.idMalla != null && !this.idMalla.equals(other.idMalla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.utpl.javasilabopersist.entidad.Malla[ idMalla=" + idMalla + " ]";
    }
    
}
