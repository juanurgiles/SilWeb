/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utpl.silaboweb.beans;

import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.utpl.silaboweb.entidad.Profesor;
import com.utpl.silaboweb.entidad.Referencia;
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
@ManagedBean (name = "UsuarioBean")
@ViewScoped
public final class UsuarioBean implements Serializable{
    @XmlElement
    private Profesor selProfesor;
    @XmlElement
    private Profesor  nProfesor;
    @XmlElement
    private List<Profesor> profesores;
    GenericRest gr = new GenericRest("com.utpl.javasilabopersist.entidad.profesor");
    private boolean show;
    private final DefaultClientConfig clientConfig;
    private Integer idTr;

    public Profesor getSelProfesor() {
        return selProfesor;
    }

    public void setSelProfesor(Profesor selProfesor) {
        this.selProfesor = selProfesor;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }
    
    

    /**
     * Creates a new instance of Persistencia
     */
    
   

    /**
     * Creates a new instance of Persistencia
     */
    
    /**
     * Creates a new instance of Persistencia
     */
    
    public Profesor getSelUsuario() {
        return selProfesor;
    }

    public void setSelUsuario(Profesor selProfesor) {
        this.selProfesor = selProfesor;
    }

    public Profesor getnProfesor() {
        return nProfesor;
    }

    public void setnProfesor(Profesor nProfesor) {
        this.nProfesor = nProfesor;
    }


    public Integer getIdTr() {
        return idTr;
    }

    public void setIdTr(Integer idTr) {
        this.idTr = idTr;
    }

    
    public UsuarioBean() {
        
        clientConfig = new DefaultClientConfig();
        this.popular();
        if (Integer.parseInt(gr.countREST())>0){
        selProfesor= profesores.get(0);}else{
        selProfesor = new Profesor();
        
        }
        //System.out.println("test");
        nProfesor = new Profesor();
        nProfesor.setIdProfesor(null);
    }
    public void popular(){
     // GenericRest gr = new GenericRest("com.utpl.javasilabopersist.entidad.profesor");
        GenericType<List<Profesor>> gType1 = new GenericType<List<Profesor>>() {};
        
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        
        profesores =  gr.findAll_XML(gType1);
    }
    
    public void nuevo(){
          selProfesor= new Profesor();
          
          
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("RefDialog.show();"); // To close the dialog
    }
    public void editar(){
        if(selProfesor.getIdProfesor()==null){
             System.out.println("nuevo");
          gr.create_JSON(selProfesor);
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Persistencia", "Nuevo docente correctamente guardada"));  
          this.popular();
        }else{
            System.out.println("editar");
        gr.edit_JSON(selProfesor);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Persistencia", "Edición de docente correctamente guardada"));  
        
        }
        //System.out.println("test:"+selReferencia.getIdReferencia()+"-"+selReferencia.getTituloReferencia()+"-"+selReferencia.getIdTipoReferencia());
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("RefDialog.hide();"); // To close the dialog
  
    }
    public void borrar(Profesor r){

       //System.out.println("Borrar:"+selReferencia.getIdReferencia()+"-"+selReferencia.getTituloReferencia()+"-"+selReferencia.getIdTipoReferencia());
       gr.remove(r.getIdProfesor().toString());
       this.popular();
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Persistencia", "Docente eliminado correctamenet"));  
    }
    
}
