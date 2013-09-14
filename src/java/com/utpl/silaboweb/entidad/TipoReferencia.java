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
public class TipoReferencia implements Serializable {
    private static final long serialVersionUID = 1L;
   
    private Integer idTipoReferencia;
    
    private String nombreTipoReferencia;
    
    private String descripcionReferencia;
    
    private Collection<Referencia> referenciaCollection;

    public TipoReferencia() {
    }

    public TipoReferencia(Integer idTipoReferencia) {
        this.idTipoReferencia = idTipoReferencia;
    }

    public Integer getIdTipoReferencia() {
        return idTipoReferencia;
    }

    public void setIdTipoReferencia(Integer idTipoReferencia) {
        this.idTipoReferencia = idTipoReferencia;
    }

    public String getNombreTipoReferencia() {
        return nombreTipoReferencia;
    }

    public void setNombreTipoReferencia(String nombreTipoReferencia) {
        this.nombreTipoReferencia = nombreTipoReferencia;
    }

    public String getDescripcionReferencia() {
        return descripcionReferencia;
    }

    public void setDescripcionReferencia(String descripcionReferencia) {
        this.descripcionReferencia = descripcionReferencia;
    }

   
    public Collection<Referencia> getReferenciaCollection() {
        return referenciaCollection;
    }

    public void setReferenciaCollection(Collection<Referencia> referenciaCollection) {
        this.referenciaCollection = referenciaCollection;
    }

   
    
}
