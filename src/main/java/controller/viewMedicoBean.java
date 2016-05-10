package controller;

import model.Medic;
import service.MedicoService;

import javax.enterprise.event.ObserverException;
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
public class viewMedicoBean implements Serializable{
    @ManagedProperty(value="#{medicoService}")
    private MedicoService medicoService;
    private List<Object>especialidadMedica;
    private List<Medic>medicos;
public void init (){
//    medicos = medicoService.findAll();
    especialidadMedica = medicoService.findWithSpecialty();
}

    public List<Medic> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medic> medicos) {
        this.medicos = medicos;
    }

    public List<Object> getEspecialidadMedica() {
        return especialidadMedica;
    }

    public void setEspecialidadMedica(List<Object> especialidadMedica) {
        this.especialidadMedica = especialidadMedica;
    }

    public void setMedicoService(MedicoService medicoService) {
        this.medicoService = medicoService;
    }
}
