/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utpl.silaboweb.entidad;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author root
 */
@XmlType
public class MateriaMalla implements Serializable {
    private static final long serialVersionUID = 1L;
    private String idMATERIAMALLA;
    private Ciclo cicloIdCiclo;
    private Malla mallaId;
    private Materia materiaId;

    public MateriaMalla() {
    }

    public MateriaMalla(String idMATERIAMALLA) {
        this.idMATERIAMALLA = idMATERIAMALLA;
    }

    public String getIdMATERIAMALLA() {
        return idMATERIAMALLA;
    }

    public void setIdMATERIAMALLA(String idMATERIAMALLA) {
        this.idMATERIAMALLA = idMATERIAMALLA;
    }

    public Ciclo getCicloIdCiclo() {
        return cicloIdCiclo;
    }

    public void setCicloIdCiclo(Ciclo cicloIdCiclo) {
        this.cicloIdCiclo = cicloIdCiclo;
    }

    public Malla getMallaId() {
        return mallaId;
    }

    public void setMallaId(Malla mallaId) {
        this.mallaId = mallaId;
    }

    public Materia getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Materia materiaId) {
        this.materiaId = materiaId;
    }

    public int hashCode() {
        int hash = 0;
        hash += (idMATERIAMALLA != null ? idMATERIAMALLA.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MateriaMalla)) {
            return false;
        }
        MateriaMalla other = (MateriaMalla) object;
        if ((this.idMATERIAMALLA == null && other.idMATERIAMALLA != null) || (this.idMATERIAMALLA != null && !this.idMATERIAMALLA.equals(other.idMATERIAMALLA))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "com.utpl.javasilabopersist.entidad.MateriaMalla[ idMATERIAMALLA=" + idMATERIAMALLA + " ]";
    }
    
}
