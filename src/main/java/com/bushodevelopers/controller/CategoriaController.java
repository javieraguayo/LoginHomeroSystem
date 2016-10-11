/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bushodevelopers.controller;

import com.bushodevelopers.ejb.CategoriaFacadeLocal;
import com.bushodevelopers.model.Categoria;
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
public class CategoriaController {
    @EJB
    private CategoriaFacadeLocal categoriaEJB;
    private Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    @PostConstruct
    public void init(){
        categoria = new  Categoria();
    }
    
    public void registrar(){
        try {
            this.
            categoriaEJB.create(categoria);
        } catch (Exception e) {
        }
    
    }
    
}
