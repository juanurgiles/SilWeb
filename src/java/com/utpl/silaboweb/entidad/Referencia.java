/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utpl.silaboweb.entidad;


import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author root
 */
@XmlType
public class Referencia implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer idReferencia;
    
    private String clasificacion;
   
    private String tituloReferencia;
   
    private String autorPersonal;
    
    private String autorCorporativo;
    
    private String edicion;
    private Integer anio;
   
    private String paginas;
   
    private String url;
   
    private String publicacion;
    
    private TipoReferencia idTipoReferencia;

    public Referencia() {
    }

    public Referencia(Integer idReferencia) {
        this.idReferencia = idReferencia;
    }

    public Integer getIdReferencia() {
        return idReferencia;
    }

    public void setIdReferencia(Integer idReferencia) {
        this.idReferencia = idReferencia;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getTituloReferencia() {
        return tituloReferencia;
    }

    public void setTituloReferencia(String tituloReferencia) {
        this.tituloReferencia = tituloReferencia;
    }

    public String getAutorPersonal() {
        return autorPersonal;
    }

    public void setAutorPersonal(String autorPersonal) {
        this.autorPersonal = autorPersonal;
    }

    public String getAutorCorporativo() {
        return autorCorporativo;
    }

    public void setAutorCorporativo(String autorCorporativo) {
        this.autorCorporativo = autorCorporativo;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getPaginas() {
        return paginas;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(String publicacion) {
        this.publicacion = publicacion;
    }

   

    public TipoReferencia getIdTipoReferencia() {
        return idTipoReferencia;
    }

    public void setIdTipoReferencia(TipoReferencia idTipoReferencia) {
        this.idTipoReferencia = idTipoReferencia;
    }

   

    
}
