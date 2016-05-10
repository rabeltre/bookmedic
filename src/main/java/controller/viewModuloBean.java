package controller;

import model.Category;
import service.ModuloService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

/**
 * Created by estudiantes on 27/03/16.
 */
@ManagedBean
@ViewScoped
public class viewModuloBean implements Serializable {
    @ManagedProperty(value= "#{moduloService}")
    private ModuloService moduloService;
private List<Category> modulos;
    public void setModuloService(ModuloService moduloService) {
        this.moduloService = moduloService;
    }

    public void init (){
       modulos= moduloService.findAll();
    }

    public List<Category> getModulos() {
        return modulos;
    }

    public void setModulos(List<Category> modulos) {
        this.modulos = modulos;
    }
}
