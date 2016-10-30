/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bushodevelopers.controller;

import com.bushodevelopers.ejb.MenuFacadeLocal;
import com.bushodevelopers.model.Menu;
import com.bushodevelopers.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author javie
 */
@Named
@ViewScoped
public class MenuController implements Serializable{

    @EJB
    //acceso a EJB
    private MenuFacadeLocal EJBMenu;
    private List<Menu> lista;//traemos una lista de menus
    private MenuModel model;

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    
    
    
    @PostConstruct
    public void init() {
        this.listarMenus();
        model = new DefaultMenuModel();
        this.establecerPermisos();
    }

    public void listarMenus() {

        try {
            lista = EJBMenu.findAll();
        } catch (Exception e) {
            //mensaje jsf
        }

    }

    public void establecerPermisos() {
        
         Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
         
        for (Menu m : lista) {
            if (m.getTipo().equals("S")&& m.getTipoUsuario().equals(us.getTipo())) {
                DefaultSubMenu firstSubmenu = new DefaultSubMenu(m.getNombre());
                for (Menu i : lista) {
                    Menu submenu = i.getSubmenu();
                    if (submenu != null) {
                        if (submenu.getCodigo() == m.getCodigo()){
                            DefaultMenuItem item = new DefaultMenuItem(i.getNombre());
                            firstSubmenu.addElement(item);
                        }
                    }
                }
                model.addElement(firstSubmenu);
            }else{
                if (m.getSubmenu() == null && m.getTipoUsuario().equals(us.getTipo())) {
                    DefaultMenuItem item = new DefaultMenuItem(m.getNombre());
                 model.addElement(item);
                }
                 
            }
        }

    }

}
