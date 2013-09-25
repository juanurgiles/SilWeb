/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utpl.silaboweb.beans;

import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.utpl.silaboweb.entidad.Materia;
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
@ManagedBean(name = "CarreraBean")
@ViewScoped
public final class MateriaBean implements Serializable {

    @XmlElement
    private Materia selCarrera;
    @XmlElement
    private Materia nCarrera;
    @XmlElement
    private List<Materia> carreras;
    GenericRest gr = new GenericRest("com.utpl.javasilabopersist.entidad.materia");
    private boolean show;
    private final DefaultClientConfig clientConfig;
    private Integer idTr;

    public Materia getSelCarrera() {
        return selCarrera;
    }

    public void setSelCarrera(Materia selCarrera) {
        this.selCarrera = selCarrera;
    }

    public List<Materia> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<Materia> carreras) {
        this.carreras = carreras;
    }

    public MateriaBean() {

        clientConfig = new DefaultClientConfig();
        this.popular();
        if (Integer.parseInt(gr.countREST()) > 0) {
            selCarrera = carreras.get(0);
        } else {
            selCarrera = new Materia();

        }
        //System.out.println("test");
        nCarrera = new Materia();
        nCarrera.setIdMateria(null);
    }

    public void popular() {
        // GenericRest gr = new GenericRest("com.utpl.javasilabopersist.entidad.profesor");
        GenericType<List<Materia>> gType1 = new GenericType<List<Materia>>() {
        };

        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

        carreras = gr.findAll_XML(gType1);
    }

    public void nuevo() {
        selCarrera = new Materia();


        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("RefDialog.show();"); // To close the dialog
    }

    public void editar() {
        if (selCarrera.getIdMateria()== null) {
            System.out.println("nuevo");
            gr.create_JSON(selCarrera);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Persistencia", "Nueva materia correctamente guardada"));
            this.popular();
        } else {
            System.out.println("editar");
            gr.edit_JSON(selCarrera);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Persistencia", "Edición de materia correctamente guardada"));

        }
        //System.out.println("test:"+selReferencia.getIdReferencia()+"-"+selReferencia.getTituloReferencia()+"-"+selReferencia.getIdTipoReferencia());
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("RefDialog.hide();"); // To close the dialog

    }

    public void borrar(Materia r) {

        //System.out.println("Borrar:"+selReferencia.getIdReferencia()+"-"+selReferencia.getTituloReferencia()+"-"+selReferencia.getIdTipoReferencia());
        gr.remove(r.getIdMateria().toString());
        this.popular();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Persistencia", "Facultad eliminado correctamenet"));
    }
}
