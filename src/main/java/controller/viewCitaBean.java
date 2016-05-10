package controller;

import service.CitaService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

/**
 * Created by root on 05/04/16.
 */
@ManagedBean
@ViewScoped
public class viewCitaBean implements Serializable {

    @ManagedProperty(value="#{citaService}")
    private CitaService citaService;

    private List<Object> citas;
    private String id;
    private String opcion;
    public void init(){
//        if (this.opcion.equals("medico")){
//        citas = citaService.findByMedic(this.id);}
//        else if(this.opcion.equals("paciente")){
//            citas = citaService.findByPacient(this.id);
//        }

        if (this.opcion.equals("medic")){
            citas = citaService.findByPacientOrMedic(this.id, this.opcion);}
        else if(this.opcion.equals("pacient")){
            citas = citaService.findByPacientOrMedic(this.id, this.opcion);
        }

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Object> getCitas() {
        return citas;
    }

    public void setCitas(List<Object> citas) {
        this.citas = citas;
    }

    public String getOpcion() {

        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public void setCitaService(CitaService citaService) {
        this.citaService = citaService;
    }
}
