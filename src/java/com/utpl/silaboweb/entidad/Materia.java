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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
public class Materia implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idMateria;
    private String codigoMateria;
    private String nombreMateria;
    private String descripcionMateria;
    private Integer ciclo;
    private Integer teorico;
    private Integer practicas;
    private Integer teoricoPracticas;
    private Integer total;
    private Collection<Profesor> profesorCollection;
    private Collection<MateriaMalla> materiaMallaCollection;
    private TipoMateria idTipoMateria;
    private EjeFormacion idEjeFormacion;
    private Silabo silaboidSilabo;
    private Collection<Contenido> contenidoCollection;
    private Collection<Correquisitos> correquisitosCollection;
    private Collection<Correquisitos> correquisitosCollection1;
    private Collection<Requisitos> requisitosCollection;
    private Collection<Requisitos> requisitosCollection1;

    public Materia() {
    }

    public Materia(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public String getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(String codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getDescripcionMateria() {
        return descripcionMateria;
    }

    public void setDescripcionMateria(String descripcionMateria) {
        this.descripcionMateria = descripcionMateria;
    }

    public Integer getCiclo() {
        return ciclo;
    }

    public void setCiclo(Integer ciclo) {
        this.ciclo = ciclo;
    }

    public Integer getTeorico() {
        return teorico;
    }

    public void setTeorico(Integer teorico) {
        this.teorico = teorico;
    }

    public Integer getPracticas() {
        return practicas;
    }

    public void setPracticas(Integer practicas) {
        this.practicas = practicas;
    }

    public Integer getTeoricoPracticas() {
        return teoricoPracticas;
    }

    public void setTeoricoPracticas(Integer teoricoPracticas) {
        this.teoricoPracticas = teoricoPracticas;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Collection<Profesor> getProfesorCollection() {
        return profesorCollection;
    }

    public void setProfesorCollection(Collection<Profesor> profesorCollection) {
        this.profesorCollection = profesorCollection;
    }

    public Collection<MateriaMalla> getMateriaMallaCollection() {
        return materiaMallaCollection;
    }

    public void setMateriaMallaCollection(Collection<MateriaMalla> materiaMallaCollection) {
        this.materiaMallaCollection = materiaMallaCollection;
    }

    public TipoMateria getIdTipoMateria() {
        return idTipoMateria;
    }

    public void setIdTipoMateria(TipoMateria idTipoMateria) {
        this.idTipoMateria = idTipoMateria;
    }

    public EjeFormacion getIdEjeFormacion() {
        return idEjeFormacion;
    }

    public void setIdEjeFormacion(EjeFormacion idEjeFormacion) {
        this.idEjeFormacion = idEjeFormacion;
    }

    public Silabo getSilaboidSilabo() {
        return silaboidSilabo;
    }

    public void setSilaboidSilabo(Silabo silaboidSilabo) {
        this.silaboidSilabo = silaboidSilabo;
    }

    public Collection<Contenido> getContenidoCollection() {
        return contenidoCollection;
    }

    public void setContenidoCollection(Collection<Contenido> contenidoCollection) {
        this.contenidoCollection = contenidoCollection;
    }

    public Collection<Correquisitos> getCorrequisitosCollection() {
        return correquisitosCollection;
    }

    public void setCorrequisitosCollection(Collection<Correquisitos> correquisitosCollection) {
        this.correquisitosCollection = correquisitosCollection;
    }

    public Collection<Correquisitos> getCorrequisitosCollection1() {
        return correquisitosCollection1;
    }

    public void setCorrequisitosCollection1(Collection<Correquisitos> correquisitosCollection1) {
        this.correquisitosCollection1 = correquisitosCollection1;
    }

    public Collection<Requisitos> getRequisitosCollection() {
        return requisitosCollection;
    }

    public void setRequisitosCollection(Collection<Requisitos> requisitosCollection) {
        this.requisitosCollection = requisitosCollection;
    }

    public Collection<Requisitos> getRequisitosCollection1() {
        return requisitosCollection1;
    }

    public void setRequisitosCollection1(Collection<Requisitos> requisitosCollection1) {
        this.requisitosCollection1 = requisitosCollection1;
    }

    public int hashCode() {
        int hash = 0;
        hash += (idMateria != null ? idMateria.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materia)) {
            return false;
        }
        Materia other = (Materia) object;
        if ((this.idMateria == null && other.idMateria != null) || (this.idMateria != null && !this.idMateria.equals(other.idMateria))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "com.utpl.javasilabopersist.entidad.Materia[ idMateria=" + idMateria + " ]";
    }
    
}
