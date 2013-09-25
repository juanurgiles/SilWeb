/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utpl.silaboweb.beans.converter;


import com.utpl.silaboweb.entidad.Carrera;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import org.omnifaces.converter.SelectItemsConverter;

/**
 *
 * @author root
 */
@FacesConverter("CarreraConverter")
public class CarreraConverter extends SelectItemsConverter {

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Integer id = (value instanceof Carrera) ? ((Carrera) value).getIdCarrera(): null;
        return (id != null) ? String.valueOf(id) : null;
    }

}