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
public class Ciclo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer idCiclo;
    private Integer numero;
    
    private Collection<MateriaMalla> materiaMallaCollection;

    public Ciclo() {
    }

    public Ciclo(Integer idCiclo) {
        this.idCiclo = idCiclo;
    }

    public Integer getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(Integer idCiclo) {
        this.idCiclo = idCiclo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    
    public Collection<MateriaMalla> getMateriaMallaCollection() {
        return materiaMallaCollection;
    }

    public void setMateriaMallaCollection(Collection<MateriaMalla> materiaMallaCollection) {
        this.materiaMallaCollection = materiaMallaCollection;
    }

    
    public int hashCode() {
        int hash = 0;
        hash += (idCiclo != null ? idCiclo.hashCode() : 0);
        return hash;
    }

    
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciclo)) {
            return false;
        }
        Ciclo other = (Ciclo) object;
        if ((this.idCiclo == null && other.idCiclo != null) || (this.idCiclo != null && !this.idCiclo.equals(other.idCiclo))) {
            return false;
        }
        return true;
    }

    
    public String toString() {
        return "com.utpl.javasilabopersist.entidad.Ciclo[ idCiclo=" + idCiclo + " ]";
    }
    
}
