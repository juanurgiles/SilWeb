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
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import org.primefaces.context.RequestContext;

/**
 *
 * @author root
 */
@ManagedBean (name = "ReferenciaBean")
@ApplicationScoped
public class ReferenciaBean implements Serializable{
    @XmlElement
    private Referencia selReferencia;
    @XmlElement
    private List<Referencia> referencias;
    GenericRest gr = new GenericRest("com.utpl.javasilabopersist.entidad.referencia");
    private boolean show;
    private final DefaultClientConfig clientConfig;
    
    /**
     * Creates a new instance of Persistencia
     */
    public ReferenciaBean() {
        
           GenericRest gr = new GenericRest("com.utpl.javasilabopersist.entidad.referencia");
        GenericType<List<Referencia>> gType1 = new GenericType<List<Referencia>>() {};
        clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        
        referencias =  gr.findAll_XML(gType1);
        if (Integer.parseInt(gr.countREST())>0){
        selReferencia= referencias.get(0);}
        System.out.println("test");
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
   
    public void editar(){
//        RequestContext context = RequestContext.getCurrentInstance();  
//        context.addCallbackParam("saved", true);    //basic parameter  
//        context.addCallbackParam("user", selReferencia);     //pojo as json  
//          
//        //execute javascript oncomplete  
//        context.execute("PrimeFaces.info('Hello from the Backing Bean');");  
//          
//        //update panel  
//        context.update("form:panel");  
//  
//        //scroll to panel  
//       
//        //add facesmessage  
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Success", "Success"));  
//    
       gr.edit_JSON(this.getSelReferencia());
//       //System.out.println("test");
       System.out.println("test");
        RequestContext context = RequestContext.getCurrentInstance();

context.execute("RefDialog.hide();"); // To close the dialog
    }
    public void guardar(){
       //return "About?faces-redirect=true";
        Referencia r = new Referencia();
        r.setTituloReferencia("alsdjfñls");
        r.setIdReferencia(null);
    gr.create_JSON(r);
    RequestContext context = RequestContext.getCurrentInstance();

context.execute("RefDialog.hide();"); // To close the dialog
    }
}
