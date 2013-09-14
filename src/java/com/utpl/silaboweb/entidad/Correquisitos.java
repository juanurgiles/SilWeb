/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utpl.silaboweb.entidad;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author root
 */
@XmlType
public class Correquisitos implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idRequisito;
    private Materia materiaidMateria;
    private Materia idMateriaMateria;

    public Correquisitos() {
    }

    public Correquisitos(Integer idRequisito) {
        this.idRequisito = idRequisito;
    }

    public Integer getIdRequisito() {
        return idRequisito;
    }

    public void setIdRequisito(Integer idRequisito) {
        this.idRequisito = idRequisito;
    }

    public Materia getMateriaidMateria() {
        return materiaidMateria;
    }

    public void setMateriaidMateria(Materia materiaidMateria) {
        this.materiaidMateria = materiaidMateria;
    }

    public Materia getIdMateriaMateria() {
        return idMateriaMateria;
    }

    public void setIdMateriaMateria(Materia idMateriaMateria) {
        this.idMateriaMateria = idMateriaMateria;
    }

    public int hashCode() {
        int hash = 0;
        hash += (idRequisito != null ? idRequisito.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Correquisitos)) {
            return false;
        }
        Correquisitos other = (Correquisitos) object;
        if ((this.idRequisito == null && other.idRequisito != null) || (this.idRequisito != null && !this.idRequisito.equals(other.idRequisito))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "com.utpl.javasilabopersist.entidad.Correquisitos[ idRequisito=" + idRequisito + " ]";
    }
    
}
