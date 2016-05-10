package controller;

import model.Category;
import model.Medic;
import service.MedicoService;
import service.ModuloService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by estudiantes on 27/03/16.
 */
@ManagedBean
@ViewScoped
public class actionMedicoBean implements Serializable {
    @ManagedProperty(value = "#{medicoService}")
    private MedicoService medicoService;
    @ManagedProperty(value = "#{moduloService}")
    private ModuloService moduloService;
 private Integer selectedItem;
    private List<SelectItem>moduloLista;
    private Category modulo;
    private List<Category> modulos;
    private Medic medico;
    private String id;
    private String accion;
    private boolean desicion;


    public void init() {
        this.moduloLista = new ArrayList<SelectItem>();
        this.modulos = moduloService.findAll();
        for (Category category: modulos){
            moduloLista.add(new SelectItem(category.getId(), category.getName()));

        }

        this.modulos.clear();
        this.modulo = new Category();


        if (this.getId() != null) {
            this.medico = medicoService.findById(this.getId());
this.selectedItem = medico.getCategory().getId();
            this.accion = "Editar Medico";

        } else {
            this.accion = "Crear Medico";

            this.medico = new Medic();


        }
    }


    public String onPersist() {

        this.modulo.setId(this.selectedItem);
        this.medico.setCategory(this.modulo);
        medicoService.makePersistent(this.medico);
        return "vistaMedico.xhtml?faces-redirect=true";
    }

    public Medic getMedico() {
        return medico;
    }

    public void setMedico(Medic medico) {
        this.medico = medico;
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

    public List<Category> getModulos() {
        return modulos;
    }

    public void setModulos(List<Category> modulos) {
        this.modulos = modulos;
    }


    public Category getModulo() {
        return modulo;
    }

    public void setModulo(Category modulo) {
        this.modulo = modulo;
    }

    public boolean isDesicion() {
        return desicion;
    }

    public void setDesicion(boolean desicion) {
        this.desicion = desicion;
    }

    public Integer getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(Integer selectedItem) {
        this.selectedItem = selectedItem;
    }

    public void setMedicoService(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    public List<SelectItem> getModuloLista() {
        return moduloLista;
    }

    public void setModuloLista(List<SelectItem> moduloLista) {
        this.moduloLista = moduloLista;
    }
}
