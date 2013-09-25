/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utpl.silaboweb.beans;

import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.utpl.silaboweb.entidad.Referencia;
import com.utpl.silaboweb.rest.GenericRest;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.xml.bind.annotation.XmlElement;
import org.primefaces.context.RequestContext;

/**
 *
 * @author root
 */
@ManagedBean (name = "ReferenciaBean")
@ViewScoped
public final class ReferenciaBean implements Serializable{
    @XmlElement
    private Referencia selReferencia;
    @XmlElement
    private Referencia  nReferencia;
    @XmlElement
    private List<Referencia> referencias;
    GenericRest gr = new GenericRest("com.utpl.javasilabopersist.entidad.referencia");
    private boolean show;
    private final DefaultClientConfig clientConfig;
    private Integer idTr;
    

    /**
     * Creates a new instance of Persistencia
     */
    
    public Referencia getnReferencia() {
        return nReferencia;
    }

    public void setnReferencia(Referencia nReferencia) {
        this.nReferencia = nReferencia;
    }

    
    public Integer getIdTr() {
        return idTr;
    }

    public void setIdTr(Integer idTr) {
        this.idTr = idTr;
    }

    /**
     * Creates a new instance of Persistencia
     */
    public ReferenciaBean() {
        
        clientConfig = new DefaultClientConfig();
        this.recReferencias();
        if (Integer.parseInt(gr.countREST())>0){
        selReferencia= referencias.get(0);}else{
        selReferencia = new Referencia();
        
        }
        //System.out.println("test");
        nReferencia = new Referencia();
        nReferencia.setIdReferencia(null);
    }
    public void recReferencias(){
      GenericRest gr = new GenericRest("com.utpl.javasilabopersist.entidad.referencia");
        GenericType<List<Referencia>> gType1 = new GenericType<List<Referencia>>() {};
        
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        
        referencias =  gr.findAll_XML(gType1);
    }
    public Referencia getSelReferencia() {
        return selReferencia;
    }

    public void setSelReferencia(Referencia selReferencia) {
        this.selReferencia = selReferencia;
    }

    public List<Referencia> getReferencias() {
        return referencias;
    }

    public void setReferencias(List<Referencia> referencias) {
        this.referencias = referencias;
    }
    public void nuevaReferencia(){
          selReferencia= new Referencia();
          
          
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("RefDialog.show();"); // To close the dialog
    }
    public void editar(){
        if(selReferencia.getIdReferencia()==null){
          gr.create_JSON(selReferencia);
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Persistencia", "Nueva referencia correctamente guardada"));  
          this.recReferencias();
        }else{
        gr.edit_JSON(selReferencia);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Persistencia", "Edición de referencia correctamente guardada"));  
        
        }
        //System.out.println("test:"+selReferencia.getIdReferencia()+"-"+selReferencia.getTituloReferencia()+"-"+selReferencia.getIdTipoReferencia());
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("RefDialog.hide();"); // To close the dialog
  
    }
    public void borrar(Referencia r){

       //System.out.println("Borrar:"+selReferencia.getIdReferencia()+"-"+selReferencia.getTituloReferencia()+"-"+selReferencia.getIdTipoReferencia());
       gr.remove(r.getIdReferencia().toString());
       this.recReferencias();
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Persistencia", "Referencia Borrada"));  
    }
    
}
