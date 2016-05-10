package controller;

import model.Category;
import service.ModuloService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

/**
 * Created by estudiantes on 27/03/16.
 */
@ManagedBean
@ViewScoped
public class actionModuloBean implements Serializable {
    @ManagedProperty(value = "#{moduloService}")
    private ModuloService moduloService;
    private Category modulo;
    private String id;
    private String accion;
public void init (){
    if (this.getId()!=null){
        this.modulo = moduloService.findById(this.getId());
        this.accion ="Editar Categoria";
    }else{
        this.modulo = new Category();
        this.accion ="Nuevo Categoria";

    }
}
public String onPersist(){
    moduloService.makePersistent(this.modulo);
    return "vistaModulo.xhtml?faces-redirect=true";
}
    public Category getModulo() {
        return modulo;
    }

    public void setModulo(Category modulo) {
        this.modulo = modulo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public void setModuloService(ModuloService moduloService) {
        this.moduloService = moduloService;
    }
}
