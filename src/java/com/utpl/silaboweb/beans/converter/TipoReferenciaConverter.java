/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utpl.silaboweb.beans.converter;

import com.utpl.silaboweb.entidad.TipoReferencia;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import org.omnifaces.converter.SelectItemsConverter;

/**
 *
 * @author root
 */
@FacesConverter("TipoReferenciaConverter")
public class TipoReferenciaConverter extends SelectItemsConverter {

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Integer id = (value instanceof TipoReferencia) ? ((TipoReferencia) value).getIdTipoReferencia() : null;
        return (id != null) ? String.valueOf(id) : null;
    }

}