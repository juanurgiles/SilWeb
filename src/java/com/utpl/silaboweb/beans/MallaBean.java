/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utpl.silaboweb.beans;

import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.utpl.silaboweb.entidad.Malla;
import com.utpl.silaboweb.entidad.VersionMalla;
import com.utpl.silaboweb.rest.GenericRest;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.xml.bind.annotation.XmlElement;
import org.primefaces.context.RequestContext;

/**
 *
 * @author root
 */
@ManagedBean(name = "MallaBean")
@ViewScoped
public final class MallaBean implements Serializable {

    @XmlElement
    private Malla selMalla;
    @XmlElement
    private Malla nMalla;
    @XmlElement
    private List<Malla> mallas;
    GenericRest gr = new GenericRest("com.utpl.javasilabopersist.entidad.malla");
    private boolean show;
    private final DefaultClientConfig clientConfig;
    private Integer idTr;
    VersionMallaBean vmb = new VersionMallaBean();
    @XmlElement
    private VersionMalla vmactivo;
    private List<Malla> malladrop;
    

    public VersionMalla getVmactivo() {
        return vmactivo;
    }

    public void setVmactivo(VersionMalla vmactivo) {
        this.vmactivo = vmactivo;
    }
    

    public Malla getSelMalla() {
        return selMalla;
    }

    public void setSelMalla(Malla selMalla) {
        this.selMalla = selMalla;
    }

    public List<Malla> getMallas() {
        return mallas;
    }

    public void setMallas(List<Malla> mallas) {
        this.mallas = mallas;
    }

    public MallaBean() {

        clientConfig = new DefaultClientConfig();
        
        vmactivo = vmb.getActivoVersionMalla();
        System.out.println(vmactivo.getIdVersionMalla());
        this.popular();
        if (mallas.isEmpty()) {
            selMalla = new Malla();
           
            //selMalla= null;
        } else {
            selMalla = mallas.get(0);

        }
        //System.out.println("test");
        nMalla = new Malla();
        nMalla.setIdMalla(null);
    }
    
    public void popular() {
        // GenericRest gr = new GenericRest("com.utpl.javasilabopersist.entidad.profesor");
        GenericType<List<Malla>> gType1 = new GenericType<List<Malla>>() {
        };

        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        String idVm= vmactivo.getIdVersionMalla().toString();
        System.out.println(idVm); 
        
        mallas =   gr.buscarMientras_XML(gType1,  "idVersionMalla.idVersionMalla", idVm );
       
    }

    public void nuevo() {
        selMalla = new Malla();
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("RefDialog.show();"); // To close the dialog
    }

    public void editar() {
        if (selMalla.getIdMalla() == null) {
            System.out.println("nuevo");
            gr.create_JSON(selMalla);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Persistencia", "Nueva malla correctamente guardada"));
            this.popular();
        } else {
            System.out.println("editar"+selMalla.getIdVersionMalla());
            gr.edit_JSON(selMalla);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Persistencia", "Edición de malla correctamente guardada"));

        }
        //System.out.println("test:"+selReferencia.getIdReferencia()+"-"+selReferencia.getTituloReferencia()+"-"+selReferencia.getIdTipoReferencia());
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("RefDialog.hide();"); // To close the dialog

    }

    public void borrar(Malla r) {

        //System.out.println("Borrar:"+selReferencia.getIdReferencia()+"-"+selReferencia.getTituloReferencia()+"-"+selReferencia.getIdTipoReferencia());
        gr.remove(r.getIdMalla().toString());
        this.popular();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Persistencia", "Facultad eliminado correctamenet"));
    }
}
