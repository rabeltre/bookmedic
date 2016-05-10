package controller;

import model.Pacient;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by estudiantes on 25/03/16.*/

@ManagedBean
@ViewScoped
public class actionPacienteBean implements Serializable{

    @ManagedProperty(value="#{pacienteService}")
    private service.pacienteService pacienteService;
    private Pacient paciente;
    private boolean desicion;
    private String id;
    public void init (){
        if(this.getId()!=null){
            this.paciente= pacienteService.findById(this.getId());
           this.setDesicion(true);
        }
        else{
            paciente = new Pacient();
this.setDesicion(false);
        }

    }

    public String onPersist() throws IOException {
        this.pacienteService.makePersistent(this.paciente);
//        FacesContext.getCurrentInstance().getExternalContext().redirect("vistaPaciente.xhtml?faces-redirect=true");
   return "vistaPaciente.xhtml?faces-redirect=true";
    }


    public Pacient getPaciente() {
        return paciente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isDesicion() {
        return desicion;
    }

    public void setDesicion(boolean desicion) {
        this.desicion = desicion;
    }

    public void setPaciente(Pacient paciente) {
        this.paciente = paciente;
    }

    public void setPacienteService(service.pacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

}
