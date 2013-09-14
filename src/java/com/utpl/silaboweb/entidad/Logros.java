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
import javax.persistence.Lob;
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
public class Logros implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idLogros;
    private String resultados;
    private String indicadores;
    private String situaciones;
    private Short a1;
    private Short a2;
    private Short a3;
    private Short a4;
    private Short a5;
    private Short a6;
    private Short a7;
    private Short a8;
    private Short a9;
    private Short a10;
    private Short a11;
    private Short a12;
    private Short a13;
    private Short a14;
    private Short a15;
    private String archivo;
    private String link;
    private short nivel;
    private String link1;
    private String link2;
    private String link3;
    private String archivo1;
    private String archivo2;
    private String archivo3;
    private Silabo idSilabo;

    public Logros() {
    }

    public Logros(Integer idLogros) {
        this.idLogros = idLogros;
    }

    public Logros(Integer idLogros, short nivel, String link1, String link2, String link3, String archivo1, String archivo2, String archivo3) {
        this.idLogros = idLogros;
        this.nivel = nivel;
        this.link1 = link1;
        this.link2 = link2;
        this.link3 = link3;
        this.archivo1 = archivo1;
        this.archivo2 = archivo2;
        this.archivo3 = archivo3;
    }

    public Integer getIdLogros() {
        return idLogros;
    }

    public void setIdLogros(Integer idLogros) {
        this.idLogros = idLogros;
    }

    public String getResultados() {
        return resultados;
    }

    public void setResultados(String resultados) {
        this.resultados = resultados;
    }

    public String getIndicadores() {
        return indicadores;
    }

    public void setIndicadores(String indicadores) {
        this.indicadores = indicadores;
    }

    public String getSituaciones() {
        return situaciones;
    }

    public void setSituaciones(String situaciones) {
        this.situaciones = situaciones;
    }

    public Short getA1() {
        return a1;
    }

    public void setA1(Short a1) {
        this.a1 = a1;
    }

    public Short getA2() {
        return a2;
    }

    public void setA2(Short a2) {
        this.a2 = a2;
    }

    public Short getA3() {
        return a3;
    }

    public void setA3(Short a3) {
        this.a3 = a3;
    }

    public Short getA4() {
        return a4;
    }

    public void setA4(Short a4) {
        this.a4 = a4;
    }

    public Short getA5() {
        return a5;
    }

    public void setA5(Short a5) {
        this.a5 = a5;
    }

    public Short getA6() {
        return a6;
    }

    public void setA6(Short a6) {
        this.a6 = a6;
    }

    public Short getA7() {
        return a7;
    }

    public void setA7(Short a7) {
        this.a7 = a7;
    }

    public Short getA8() {
        return a8;
    }

    public void setA8(Short a8) {
        this.a8 = a8;
    }

    public Short getA9() {
        return a9;
    }

    public void setA9(Short a9) {
        this.a9 = a9;
    }

    public Short getA10() {
        return a10;
    }

    public void setA10(Short a10) {
        this.a10 = a10;
    }

    public Short getA11() {
        return a11;
    }

    public void setA11(Short a11) {
        this.a11 = a11;
    }

    public Short getA12() {
        return a12;
    }

    public void setA12(Short a12) {
        this.a12 = a12;
    }

    public Short getA13() {
        return a13;
    }

    public void setA13(Short a13) {
        this.a13 = a13;
    }

    public Short getA14() {
        return a14;
    }

    public void setA14(Short a14) {
        this.a14 = a14;
    }

    public Short getA15() {
        return a15;
    }

    public void setA15(Short a15) {
        this.a15 = a15;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public short getNivel() {
        return nivel;
    }

    public void setNivel(short nivel) {
        this.nivel = nivel;
    }

    public String getLink1() {
        return link1;
    }

    public void setLink1(String link1) {
        this.link1 = link1;
    }

    public String getLink2() {
        return link2;
    }

    public void setLink2(String link2) {
        this.link2 = link2;
    }

    public String getLink3() {
        return link3;
    }

    public void setLink3(String link3) {
        this.link3 = link3;
    }

    public String getArchivo1() {
        return archivo1;
    }

    public void setArchivo1(String archivo1) {
        this.archivo1 = archivo1;
    }

    public String getArchivo2() {
        return archivo2;
    }

    public void setArchivo2(String archivo2) {
        this.archivo2 = archivo2;
    }

    public String getArchivo3() {
        return archivo3;
    }

    public void setArchivo3(String archivo3) {
        this.archivo3 = archivo3;
    }

    public Silabo getIdSilabo() {
        return idSilabo;
    }

    public void setIdSilabo(Silabo idSilabo) {
        this.idSilabo = idSilabo;
    }

    public int hashCode() {
        int hash = 0;
        hash += (idLogros != null ? idLogros.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logros)) {
            return false;
        }
        Logros other = (Logros) object;
        if ((this.idLogros == null && other.idLogros != null) || (this.idLogros != null && !this.idLogros.equals(other.idLogros))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "com.utpl.javasilabopersist.entidad.Logros[ idLogros=" + idLogros + " ]";
    }
    
}
