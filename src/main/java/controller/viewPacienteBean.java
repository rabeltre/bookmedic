package controller;

import model.Pacient;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;



@ManagedBean
@ViewScoped
public class viewPacienteBean implements Serializable {

    @ManagedProperty(value="#{pacienteService}")
    private service.pacienteService pacienteService;

    private List<Pacient>pacientes;

public void init(){
    pacientes = pacienteService.findAll();

}

    public void setPacienteService(service.pacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    public List<Pacient> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Pacient> pacientes) {
        this.pacientes = pacientes;
    }
}

