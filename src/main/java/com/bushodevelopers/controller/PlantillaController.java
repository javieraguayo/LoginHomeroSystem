/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bushodevelopers.controller;

import com.bushodevelopers.model.Usuario;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author javie
 */
@Named
@ViewScoped
public class PlantillaController implements Serializable{
    
    public void verificarSesion() {
        
        try {
            //accedo a la session del usuario
            Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            if (us == null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("./../permisos.xhtml");
            }
        } catch (Exception e) {
            //log para guardar registro
        }
    }
    
}
