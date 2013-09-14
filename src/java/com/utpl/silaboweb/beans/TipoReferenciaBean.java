/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utpl.silaboweb.beans;

import com.sun.jersey.api.client.GenericType;
import com.utpl.silaboweb.entidad.Referencia;
import com.utpl.silaboweb.entidad.TipoReferencia;
import com.utpl.silaboweb.rest.GenericRest;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author root
 */
@ManagedBean (name = "TipoReferenciaBean")
@ApplicationScoped
public class TipoReferenciaBean {
     private TipoReferencia selTipoReferencia;
    private List<TipoReferencia> tiporeferencias;
    
    /**
     * Creates a new instance of Persistencia
     */
    public TipoReferenciaBean() {
        GenericRest gr = new GenericRest("com.utpl.javasilabopersist.entidad.tiporeferencia");
        GenericType<List<TipoReferencia>> gType1 = new GenericType<List<TipoReferencia>>() {};
        tiporeferencias =  gr.findAll_XML(gType1);
        selTipoReferencia= tiporeferencias.get(1);
        
    }

    public TipoReferencia getSelTipoReferencia() {
        return selTipoReferencia;
    }

    public void setSelTipoReferencia(TipoReferencia selTipoReferencia) {
        this.selTipoReferencia = selTipoReferencia;
    }

    public List<TipoReferencia> getTiporeferencias() {
        return tiporeferencias;
    }

    public void setTiporeferencias(List<TipoReferencia> tiporeferencias) {
        this.tiporeferencias = tiporeferencias;
    }

   
    
}
