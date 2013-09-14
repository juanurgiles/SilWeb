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
import javax.persistence.Lob;
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
public class Silabo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idSilabo;
    private String codigoSilabo;
    private String nombreSilabo;
    private String objetivosMateria;
    private String resultadosLogros;
    private String indicadores;
    private String situacionesEvaluacion;
    private String criteriosEvaluacionAprendizaje;
    private String criteriosEvaluacionCurso;
    private String recursos;
    private String ref1;
    private String ref2;
    private String ref3;
    private String ref4;
    private String ref5;
    private String ref6;
    private Collection<Materia> materiaCollection;
    private Periodo idPeriodo;
    private Modalidad idModalidad;
    private Collection<Logros> logrosCollection;
    private Collection<SilaboReferencia> silaboReferenciaCollection;

    public Silabo() {
    }

    public Silabo(Integer idSilabo) {
        this.idSilabo = idSilabo;
    }

    public Silabo(Integer idSilabo, String recursos, String ref1, String ref2, String ref3, String ref4, String ref5, String ref6) {
        this.idSilabo = idSilabo;
        this.recursos = recursos;
        this.ref1 = ref1;
        this.ref2 = ref2;
        this.ref3 = ref3;
        this.ref4 = ref4;
        this.ref5 = ref5;
        this.ref6 = ref6;
    }

    public Integer getIdSilabo() {
        return idSilabo;
    }

    public void setIdSilabo(Integer idSilabo) {
        this.idSilabo = idSilabo;
    }

    public String getCodigoSilabo() {
        return codigoSilabo;
    }

    public void setCodigoSilabo(String codigoSilabo) {
        this.codigoSilabo = codigoSilabo;
    }

    public String getNombreSilabo() {
        return nombreSilabo;
    }

    public void setNombreSilabo(String nombreSilabo) {
        this.nombreSilabo = nombreSilabo;
    }

    public String getObjetivosMateria() {
        return objetivosMateria;
    }

    public void setObjetivosMateria(String objetivosMateria) {
        this.objetivosMateria = objetivosMateria;
    }

    public String getResultadosLogros() {
        return resultadosLogros;
    }

    public void setResultadosLogros(String resultadosLogros) {
        this.resultadosLogros = resultadosLogros;
    }

    public String getIndicadores() {
        return indicadores;
    }

    public void setIndicadores(String indicadores) {
        this.indicadores = indicadores;
    }

    public String getSituacionesEvaluacion() {
        return situacionesEvaluacion;
    }

    public void setSituacionesEvaluacion(String situacionesEvaluacion) {
        this.situacionesEvaluacion = situacionesEvaluacion;
    }

    public String getCriteriosEvaluacionAprendizaje() {
        return criteriosEvaluacionAprendizaje;
    }

    public void setCriteriosEvaluacionAprendizaje(String criteriosEvaluacionAprendizaje) {
        this.criteriosEvaluacionAprendizaje = criteriosEvaluacionAprendizaje;
    }

    public String getCriteriosEvaluacionCurso() {
        return criteriosEvaluacionCurso;
    }

    public void setCriteriosEvaluacionCurso(String criteriosEvaluacionCurso) {
        this.criteriosEvaluacionCurso = criteriosEvaluacionCurso;
    }

    public String getRecursos() {
        return recursos;
    }

    public void setRecursos(String recursos) {
        this.recursos = recursos;
    }

    public String getRef1() {
        return ref1;
    }

    public void setRef1(String ref1) {
        this.ref1 = ref1;
    }

    public String getRef2() {
        return ref2;
    }

    public void setRef2(String ref2) {
        this.ref2 = ref2;
    }

    public String getRef3() {
        return ref3;
    }

    public void setRef3(String ref3) {
        this.ref3 = ref3;
    }

    public String getRef4() {
        return ref4;
    }

    public void setRef4(String ref4) {
        this.ref4 = ref4;
    }

    public String getRef5() {
        return ref5;
    }

    public void setRef5(String ref5) {
        this.ref5 = ref5;
    }

    public String getRef6() {
        return ref6;
    }

    public void setRef6(String ref6) {
        this.ref6 = ref6;
    }

    public Collection<Materia> getMateriaCollection() {
        return materiaCollection;
    }

    public void setMateriaCollection(Collection<Materia> materiaCollection) {
        this.materiaCollection = materiaCollection;
    }

    public Periodo getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Periodo idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public Modalidad getIdModalidad() {
        return idModalidad;
    }

    public void setIdModalidad(Modalidad idModalidad) {
        this.idModalidad = idModalidad;
    }

    public Collection<Logros> getLogrosCollection() {
        return logrosCollection;
    }

    public void setLogrosCollection(Collection<Logros> logrosCollection) {
        this.logrosCollection = logrosCollection;
    }

    public Collection<SilaboReferencia> getSilaboReferenciaCollection() {
        return silaboReferenciaCollection;
    }

    public void setSilaboReferenciaCollection(Collection<SilaboReferencia> silaboReferenciaCollection) {
        this.silaboReferenciaCollection = silaboReferenciaCollection;
    }

    public int hashCode() {
        int hash = 0;
        hash += (idSilabo != null ? idSilabo.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Silabo)) {
            return false;
        }
        Silabo other = (Silabo) object;
        if ((this.idSilabo == null && other.idSilabo != null) || (this.idSilabo != null && !this.idSilabo.equals(other.idSilabo))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "com.utpl.javasilabopersist.entidad.Silabo[ idSilabo=" + idSilabo + " ]";
    }
    
}
