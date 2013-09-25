/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utpl.silaboweb.beans;

import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.utpl.silaboweb.entidad.Referencia;
import com.utpl.silaboweb.entidad.TipoU;
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
@ManagedBean (name = "TipoUsuarioBean")
@ViewScoped
public class TipoUsuarioBean {
     private TipoU selTipoU;
    private List<TipoU> tipousuarios;
    GenericRest gr = new GenericRest("com.utpl.javasilabopersist.entidad.tipou");
    private final DefaultClientConfig clientConfig;
    private TipoU nTipoU ;
    public TipoUsuarioBean() {
        
        GenericType<List<TipoU>> gType1 = new GenericType<List<TipoU>>() {};
         clientConfig = new DefaultClientConfig();
        if(Integer.parseInt(gr.countREST())>0){
        tipousuarios =  gr.findAll_XML(gType1);
        
        selTipoU= tipousuarios.get(0);
       
        
        this.popular();
        }
        
        if (Integer.parseInt(gr.countREST())>0){
        selTipoU= tipousuarios.get(0);}else{
        selTipoU = new TipoU();
        
        }
        //System.out.println("test");
        nTipoU = new TipoU();
        nTipoU.setId(null);
        
    }

    public TipoU getSelTipoU() {
        return selTipoU;
    }

    public void setSelTipoU(TipoU selTipoU) {
        this.selTipoU = selTipoU;
    }

    public List<TipoU> getTipousuarios() {
        return tipousuarios;
    }

    public void setTipousuarios(List<TipoU> tipousuarios) {
        this.tipousuarios = tipousuarios;
    }

   public void nuevo(){
          selTipoU= new TipoU();
          
          
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("RefDialog.show();"); // To close the dialog
    }
   public void popular(){
     
        GenericType<List<TipoU>> gType1 = new GenericType<List<TipoU>>() {};
        
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        
        tipousuarios =  gr.findAll_XML(gType1);
    }
    public void editar(){
        if(selTipoU.getId()==null){
          gr.create_JSON(selTipoU);
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Persistencia", "Nuevo tipo de tipo de usuario correctamente guardada"));  
          this.popular();
        }else{
        gr.edit_JSON(selTipoU);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Persistencia", "Edición de tipo de referencia correctamente guardada"));  
        
        }
        System.out.println("test:"+selTipoU.getId()+"-"+selTipoU.getNombre()+"-");
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("RefDialog.hide();"); // To close the dialog
  
    }
    public void borrar(TipoU r){
        System.out.println("Borrar:"+r.getId()+"-"+r.getNombre());
        int b=0;
        try {
             gr.remove(r.getId().toString());
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Persistencia", "Problema al borrar la categorìa de usuario"));  
            b=1;
        }
       
      if (b==1){
       this.popular();
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Persistencia", "Categorìa de usuario Borrada"));  
      }
    }
    
}
