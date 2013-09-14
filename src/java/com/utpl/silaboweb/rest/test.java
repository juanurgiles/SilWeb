/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utpl.silaboweb.rest;

import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.utpl.silaboweb.entidad.Referencia;
import com.utpl.silaboweb.entidad.TipoReferencia;
import java.util.Collection;
import java.util.List;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author root
 */
public class test {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        ReferenciaRest r = new ReferenciaRest();
//        
//        List<Referencia> f ;
//        GenericType<List<Referencia>> gType = new GenericType<List<Referencia>>() {};
//        List<Referencia> refs = (List<Referencia>) r.findAll_XML(gType);
//        for (Referencia referencia : refs) {
//            System.out.println(referencia.getTituloReferencia()+referencia.getIdTipoReferencia());
//        }
        
        test t = new test();
        
        t.dtest();
        
    }
    private DefaultClientConfig clientConfig;
    public void dtest(){
    GenericRest gr = new GenericRest("com.utpl.javasilabopersist.entidad.referencia");
        GenericType<List<Referencia>> gType1 = new GenericType<List<Referencia>>() {};
        clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        //gr.accept(MediaType.APPLICATION_JSON).get(Referencia[].class);
        
        List<Referencia> refs1 = (List<Referencia>) gr.findAll_XML(gType1);


        
        for (Referencia referencia : refs1) {
            System.out.println(referencia.getTituloReferencia()+referencia.getIdReferencia());
        }
        Referencia r = refs1.get(1);
        r.setEdicion("654640");
        r.setIdReferencia(null);
        gr.create_JSON(r);
    }
    
}
