/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utpl.silaboweb.beans;

import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.utpl.silaboweb.entidad.Escuela;
import com.utpl.silaboweb.rest.GenericRest;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.xml.bind.annotation.XmlElement;
import org.primefaces.context.RequestContext;

/**
 *
 * @author root
 */
@ManagedBean (name = "EscuelaBean")
@ViewScoped
public final class EscuelaBean implements Serializable{
    @XmlElement
    private Escuela selEscuela;
    @XmlElement
    private Escuela  nEscuela;
    @XmlElement
    private List<Escuela> escuelas;
    GenericRest gr = new GenericRest("com.utpl.javasilabopersist.entidad.escuela");
    private boolean show;
    private final DefaultClientConfig clientConfig;
    private Integer idTr;

    public Escuela getSelEscuela() {
        return selEscuela;
    }

    public void setSelEscuela(Escuela selEscuela) {
        this.selEscuela = selEscuela;
    }

    public List<Escuela> getEscuelas() {
        return escuelas;
    }

    public void setEscuelas(List<Escuela> escuelas) {
        this.escuelas = escuelas;
    }

   
    
    public EscuelaBean() {
        
        clientConfig = new DefaultClientConfig();
        this.popular();
        if (Integer.parseInt(gr.countREST())>0){
        selEscuela= escuelas.get(0);}else{
        selEscuela = new Escuela();
        
        }
        //System.out.println("test");
        nEscuela = new Escuela();
        nEscuela.setIdEscuela(null);
    }
    public void popular(){
     // GenericRest gr = new GenericRest("com.utpl.javasilabopersist.entidad.profesor");
        GenericType<List<Escuela>> gType1 = new GenericType<List<Escuela>>() {};
        
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        
        escuelas =  gr.findAll_XML(gType1);
    }
    
    public void nuevo(){
          selEscuela= new Escuela();
          
          
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("RefDialog.show();"); // To close the dialog
    }
    public void editar(){
        if(selEscuela.getIdEscuela()==null){
             System.out.println("nuevo");
          gr.create_JSON(selEscuela);
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Persistencia", "Nueva escuela correctamente guardada"));  
          this.popular();
        }else{
            System.out.println("editar");
        gr.edit_JSON(selEscuela);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Persistencia", "Edición de escuela correctamente guardada"));  
        
        }
        //System.out.println("test:"+selReferencia.getIdReferencia()+"-"+selReferencia.getTituloReferencia()+"-"+selReferencia.getIdTipoReferencia());
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("RefDialog.hide();"); // To close the dialog
  
    }
    public void borrar(Escuela r){

       //System.out.println("Borrar:"+selReferencia.getIdReferencia()+"-"+selReferencia.getTituloReferencia()+"-"+selReferencia.getIdTipoReferencia());
       gr.remove(r.getIdEscuela().toString());
       this.popular();
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Persistencia", "Facultad eliminado correctamenet"));  
    }
    
}
