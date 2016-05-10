package controller;

import model.Category;
import model.Medic;
import service.MedicoService;
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
public class actionMedicoBean_backup implements Serializable {
    @ManagedProperty(value = "#{medicoService}")
    private MedicoService medicoService;
    @ManagedProperty(value = "#{moduloService}")
    private ModuloService moduloService;
    private Integer idModulo;
    private Category modulo;
    private List<Category> modulos;
    private Medic medico;
    private String id;
    private String accion;
    private boolean desicion;

    public void init() {
        if (this.getId() != null) {
            this.medico = medicoService.findById(this.getId());
            this.idModulo =4;
            this.accion = "Editar Medico";
            this.setDesicion(false);
        } else {
            this.accion = "Crear Medico";
            this.modulos = moduloService.findAll();
            this.medico = new Medic();
            this.modulo = new Category();
            this.setDesicion(true);
        }
    }


    public String onPersist() {
        if(this.idModulo!=0){
            this.modulo.setId(this.idModulo);
            this.medico.setCategory(this.modulo);
        }

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

    public Integer getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(Integer idModulo) {
        this.idModulo = idModulo;
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

    public void setMedicoService(MedicoService medicoService) {
        this.medicoService = medicoService;
    }
}
