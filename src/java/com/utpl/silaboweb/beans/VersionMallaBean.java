/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utpl.silaboweb.beans;

import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
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
@ManagedBean(name = "VersionMallaBean")
@ViewScoped
public final class VersionMallaBean implements Serializable {

    @XmlElement
    private VersionMalla selVersionMalla;
    @XmlElement
    private VersionMalla nVersionMalla;
    @XmlElement
    private VersionMalla activoVersionMalla;
    @XmlElement
    private List<VersionMalla> versionmallas;
    GenericRest gr = new GenericRest("com.utpl.javasilabopersist.entidad.versionmalla");
    private boolean show;
    private final DefaultClientConfig clientConfig;
    private Integer idTr;
    private Integer bn = 0;

    public VersionMalla getActivoVersionMalla() {
        return activoVersionMalla;
    }

    public void setActivoVersionMalla(VersionMalla activoVersionMalla) {
        this.activoVersionMalla = activoVersionMalla;
    }

    public VersionMalla getSelVersionMalla() {
        return selVersionMalla;
    }

    public void setSelVersionMalla(VersionMalla selVersionMalla) {
        this.selVersionMalla = selVersionMalla;
    }

    public List<VersionMalla> getVersionMallas() {
        return versionmallas;
    }

    public void setVersionMallas(List<VersionMalla> versionmallas) {
        this.versionmallas = versionmallas;
    }

    public VersionMallaBean() {

        clientConfig = new DefaultClientConfig();
        this.popular();
        if (Integer.parseInt(gr.countREST()) > 0) {
            selVersionMalla = versionmallas.get(0);
        } else {
            selVersionMalla = new VersionMalla();

        }
        //System.out.println("test");
        nVersionMalla = new VersionMalla();
        nVersionMalla.setIdVersionMalla(null);
    }

    public void popular() {
        // GenericRest gr = new GenericRest("com.utpl.javasilabopersist.entidad.profesor");
        GenericType<List<VersionMalla>> gType1 = new GenericType<List<VersionMalla>>() {
        };

        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

        versionmallas = gr.findAll_XML(gType1);
        for (VersionMalla vm : versionmallas) {
            if(vm.getActivo()==true){
               activoVersionMalla=vm;
            }
        }
        System.out.println(activoVersionMalla.getIdVersionMalla());
        
    }

    public void nuevo() {
        selVersionMalla = new VersionMalla();
        selVersionMalla.setActivo(false);
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("RefDialog.show();"); // To close the dialog
    }

    public void editar() {
           System.out.println(selVersionMalla.getActivo());
        if (selVersionMalla.getIdVersionMalla() == null) {
            System.out.println("nuevo");
            selVersionMalla.setActivo(null);
            gr.create_JSON(selVersionMalla);
            if (bn==0){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Persistencia", "Nuevo plan curricular correctamente guardada"));
            }
            this.popular();
        } else {
            System.out.println("editar");
            gr.edit_JSON(selVersionMalla);
            if (bn==0){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Persistencia", "Edición de Plan curricular correctamente guardada"));
            }
        }
        //System.out.println("test:"+selReferencia.getIdReferencia()+"-"+selReferencia.getTituloReferencia()+"-"+selReferencia.getIdTipoReferencia());
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("RefDialog.hide();"); // To close the dialog

    }

    public void borrar(VersionMalla r) {

        //System.out.println("Borrar:"+selReferencia.getIdReferencia()+"-"+selReferencia.getTituloReferencia()+"-"+selReferencia.getIdTipoReferencia());
        gr.remove(r.getIdVersionMalla().toString());
        this.popular();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Persistencia", "Plan curricular eliminado correctamenet"));
    }
    public void activar(VersionMalla v){
        bn=1;
        for (VersionMalla vs : versionmallas) {
            vs.setActivo(false);
            selVersionMalla = vs;
            
            editar();
        }
        selVersionMalla = v;
        selVersionMalla.setActivo(true);
        editar();
        popular();
        bn=0;
    }
}
