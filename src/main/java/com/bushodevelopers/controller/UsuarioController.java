/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bushodevelopers.controller;

import com.bushodevelopers.ejb.UsuarioFacadeLocal;
import com.bushodevelopers.model.Persona;
import com.bushodevelopers.model.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author javie
 */
@Named
@ViewScoped
public class UsuarioController implements Serializable{
    
    @EJB
    private UsuarioFacadeLocal UsuarioEJB;
    
    private Usuario usuario;
    private Persona persona;
    
    
    @PostConstruct
    public void init(){
        
        usuario = new Usuario();
        persona = new Persona();
    
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public void registrar(){
        try {
            this.usuario.setCodigo(persona);
            UsuarioEJB.create(usuario);
        } catch (Exception e) {
        }
    
    }
    
}
