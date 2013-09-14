/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utpl.silaboweb.entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author root
 */
@XmlType
public class Requisitos implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idRequisito;
    private Materia materiaidMateria;
    private Materia idMateriaMateria;

    public Requisitos() {
    }

    public Requisitos(Integer idRequisito) {
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
        if (!(object instanceof Requisitos)) {
            return false;
        }
        Requisitos other = (Requisitos) object;
        if ((this.idRequisito == null && other.idRequisito != null) || (this.idRequisito != null && !this.idRequisito.equals(other.idRequisito))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "com.utpl.javasilabopersist.entidad.Requisitos[ idRequisito=" + idRequisito + " ]";
    }
    
}
