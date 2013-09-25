/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utpl.silaboweb.beans;

import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.utpl.silaboweb.entidad.Referencia;
import com.utpl.silaboweb.entidad.TipoReferencia;
import com.utpl.silaboweb.rest.GenericRest;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author root
 */
@ManagedBean (name = "TipoReferenciaBean")
@ViewScoped
public class TipoReferenciaBean {
     private TipoReferencia selTipoReferencia;
    private List<TipoReferencia> tiporeferencias;
    GenericRest gr = new GenericRest("com.utpl.javasilabopersist.entidad.tiporeferencia");
    private final DefaultClientConfig clientConfig;
    private TipoReferencia nTipoReferencia ;
    public TipoReferenciaBean() {
        
        GenericType<List<TipoReferencia>> gType1 = new GenericType<List<TipoReferencia>>() {};
        tiporeferencias =  gr.findAll_XML(gType1);
        selTipoReferencia= tiporeferencias.get(1);
        clientConfig = new DefaultClientConfig();
        
        this.popular();
        if (Integer.parseInt(gr.countREST())>0){
        selTipoReferencia= tiporeferencias.get(0);}else{
        selTipoReferencia = new TipoReferencia();
        
        }
        //System.out.println("test");
        nTipoReferencia = new TipoReferencia();
        nTipoReferencia.setIdTipoReferencia(null);
        
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

   public void nuevo(){
          selTipoReferencia= new TipoReferencia();
          
          
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("RefDialog.show();"); // To close the dialog
    }
   public void popular(){
     
        GenericType<List<TipoReferencia>> gType1 = new GenericType<List<TipoReferencia>>() {};
        
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        
        tiporeferencias =  gr.findAll_XML(gType1);
    }
    public void editar(){
        if(selTipoReferencia.getIdTipoReferencia()==null){
          gr.create_JSON(selTipoReferencia);
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Persistencia", "Nuevo tipo de referencia correctamente guardada"));  
          this.popular();
        }else{
        gr.edit_JSON(selTipoReferencia);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Persistencia", "Edición de tipo de referencia correctamente guardada"));  
        
        }
        System.out.println("test:"+selTipoReferencia.getIdTipoReferencia()+"-"+selTipoReferencia.getNombreTipoReferencia()+"-");
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("RefDialog.hide();"); // To close the dialog
  
    }
    public void borrar(TipoReferencia r){
        System.out.println("Borrar:"+r.getIdTipoReferencia()+"-"+r.getNombreTipoReferencia());
        int b=0;
        try {
             gr.remove(r.getIdTipoReferencia().toString());
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Persistencia", "No se puede borrar porque contiene referencias"));  
            b=1;
        }
       
      if (b==1){
       this.popular();
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Persistencia", "Tipo de Referencia Borrada"));  
      }
    }
    
}
