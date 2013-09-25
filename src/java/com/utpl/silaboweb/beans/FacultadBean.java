/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utpl.silaboweb.beans;

import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.utpl.silaboweb.entidad.Facultad;
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
@ManagedBean (name = "FacultadBean")
@ViewScoped
public final class FacultadBean implements Serializable{
    @XmlElement
    private Facultad selFacultad;
    @XmlElement
    private Facultad  nFacultad;
    @XmlElement
    private List<Facultad> facultades;
    GenericRest gr = new GenericRest("com.utpl.javasilabopersist.entidad.facultad");
    private boolean show;
    private final DefaultClientConfig clientConfig;
    private Integer idTr;

    public Facultad getSelFacultad() {
        return selFacultad;
    }

    public void setSelFacultad(Facultad selFacultad) {
        this.selFacultad = selFacultad;
    }

    public Facultad getnFacultad() {
        return nFacultad;
    }

    public void setnFacultad(Facultad nFacultad) {
        this.nFacultad = nFacultad;
    }

    public List<Facultad> getFacultades() {
        return facultades;
    }

    public void setFacultades(List<Facultad> facultades) {
        this.facultades = facultades;
    }

    
    
    public FacultadBean() {
        
        clientConfig = new DefaultClientConfig();
        this.popular();
        if (Integer.parseInt(gr.countREST())>0){
        selFacultad= facultades.get(0);}else{
        selFacultad = new Facultad();
        
        }
        //System.out.println("test");
        nFacultad = new Facultad();
        nFacultad.setIdFacultad(null);
    }
    public void popular(){
     // GenericRest gr = new GenericRest("com.utpl.javasilabopersist.entidad.profesor");
        GenericType<List<Facultad>> gType1 = new GenericType<List<Facultad>>() {};
        
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        
        facultades =  gr.findAll_XML(gType1);
    }
    
    public void nuevo(){
          selFacultad= new Facultad();
          
          
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("RefDialog.show();"); // To close the dialog
    }
    public void editar(){
        if(selFacultad.getIdFacultad()==null){
             System.out.println("nuevo");
          gr.create_JSON(selFacultad);
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Persistencia", "Nueva facutlad correctamente guardada"));  
          this.popular();
        }else{
            System.out.println("editar");
        gr.edit_JSON(selFacultad);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Persistencia", "Edición de facultad correctamente guardada"));  
        
        }
        //System.out.println("test:"+selReferencia.getIdReferencia()+"-"+selReferencia.getTituloReferencia()+"-"+selReferencia.getIdTipoReferencia());
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("RefDialog.hide();"); // To close the dialog
  
    }
    public void borrar(Facultad r){

       //System.out.println("Borrar:"+selReferencia.getIdReferencia()+"-"+selReferencia.getTituloReferencia()+"-"+selReferencia.getIdTipoReferencia());
       gr.remove(r.getIdFacultad().toString());
       this.popular();
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Persistencia", "Facultad eliminado correctamenet"));  
    }
    
}
