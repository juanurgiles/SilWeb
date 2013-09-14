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
public class SilaboReferencia implements Serializable {
    private static final long serialVersionUID = 1L;
    private String idSilaboReferencia;
    private short tipoJer;
    private Referencia referenciaId;
    private Silabo silaboId;

    public SilaboReferencia() {
    }

    public SilaboReferencia(String idSilaboReferencia) {
        this.idSilaboReferencia = idSilaboReferencia;
    }

    public SilaboReferencia(String idSilaboReferencia, short tipoJer) {
        this.idSilaboReferencia = idSilaboReferencia;
        this.tipoJer = tipoJer;
    }

    public String getIdSilaboReferencia() {
        return idSilaboReferencia;
    }

    public void setIdSilaboReferencia(String idSilaboReferencia) {
        this.idSilaboReferencia = idSilaboReferencia;
    }

    public short getTipoJer() {
        return tipoJer;
    }

    public void setTipoJer(short tipoJer) {
        this.tipoJer = tipoJer;
    }

    public Referencia getReferenciaId() {
        return referenciaId;
    }

    public void setReferenciaId(Referencia referenciaId) {
        this.referenciaId = referenciaId;
    }

    public Silabo getSilaboId() {
        return silaboId;
    }

    public void setSilaboId(Silabo silaboId) {
        this.silaboId = silaboId;
    }

    public int hashCode() {
        int hash = 0;
        hash += (idSilaboReferencia != null ? idSilaboReferencia.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SilaboReferencia)) {
            return false;
        }
        SilaboReferencia other = (SilaboReferencia) object;
        if ((this.idSilaboReferencia == null && other.idSilaboReferencia != null) || (this.idSilaboReferencia != null && !this.idSilaboReferencia.equals(other.idSilaboReferencia))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "com.utpl.javasilabopersist.entidad.SilaboReferencia[ idSilaboReferencia=" + idSilaboReferencia + " ]";
    }
    
}
