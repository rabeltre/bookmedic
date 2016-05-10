package controller;

import model.*;
import service.CitaService;
import service.MedicoService;
import service.pacienteService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 3/30/16.
 */
@ManagedBean
@ViewScoped
public class actionCitaBean implements Serializable {
    @ManagedProperty(value = "#{citaService}")
    private CitaService citaService;


    private Reservation citas;
    private String id;


    private Integer selectedItemStatus;
    private Integer selectedItemPayment;
    private Integer selectedItemMedico;
    private Integer selectedItemPaciente;

    private List<SelectItem> listaDeStatus;
    private List<SelectItem> listaDePagos;
    private List<SelectItem> listaDeMedicos;
    private List<SelectItem> listaDePacientes;

    private List<Status> statuses;
    private List<Payment> payments;
    private List<Medic> medicos;
    private List<Pacient> pacientes;

    private Status status;
    private Payment payment;
    private Medic medic;
    private Pacient pacient;



    public void init() {
        this.listaDeStatus = new ArrayList<SelectItem>();
        this.listaDePagos = new ArrayList<SelectItem>();
        this.listaDeMedicos = new ArrayList<SelectItem>();
        this.listaDePacientes = new ArrayList<SelectItem>();

        this.statuses = citaService.findAllStatus();
        this.payments = citaService.findAllPayment();
        this.medicos = citaService.findAllMedic();
        this.pacientes = citaService.findAllPacient();

        for (Status status : statuses) {
            listaDeStatus.add(new SelectItem(status.getId(), status.getName()));
        }
        for (Payment payment : payments) {
            listaDePagos.add(new SelectItem(payment.getId(), payment.getName()));
        }
        for (Medic medic : medicos) {
            listaDeMedicos.add(new SelectItem(medic.getId(), medic.toString()));
        }
        for (Pacient pacient : pacientes) {
            listaDePacientes.add(new SelectItem(pacient.getId(), pacient.toString()));

        }


        this.payments.clear();
        this.statuses.clear();
        this.pacientes.clear();
        this.medicos.clear();

        this.citas = new Reservation();
    }

    public String onPersist(){
        status = new Status(this.selectedItemStatus);
        payment = new Payment(this.selectedItemPayment);
        medic = new Medic(this.selectedItemMedico);
        pacient = new Pacient(this.selectedItemPaciente);
        this.citas.ponerValores(medic, pacient, payment, status);
citaService.makePersist(this.citas);
        return "/View/index.xhtml?faces-redirect=true";
    }


    public Integer getSelectedItemStatus() {
        return selectedItemStatus;
    }

    public void setSelectedItemStatus(Integer selectedItemStatus) {
        this.selectedItemStatus = selectedItemStatus;
    }

    public Integer getSelectedItemPayment() {
        return selectedItemPayment;
    }

    public void setSelectedItemPayment(Integer selectedItemPayment) {
        this.selectedItemPayment = selectedItemPayment;
    }

    public List<SelectItem> getListaDeStatus() {
        return listaDeStatus;
    }

    public void setListaDeStatus(List<SelectItem> listaDeStatus) {
        this.listaDeStatus = listaDeStatus;
    }

    public List<Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<Status> statuses) {
        this.statuses = statuses;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public List<SelectItem> getListaDePagos() {
        return listaDePagos;
    }

    public void setListaDePagos(List<SelectItem> listaDePagos) {
        this.listaDePagos = listaDePagos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCitaService(CitaService citaService) {

        this.citaService = citaService;
    }

    public Integer getSelectedItemMedico() {
        return selectedItemMedico;
    }

    public void setSelectedItemMedico(Integer selectedItemMedico) {
        this.selectedItemMedico = selectedItemMedico;
    }

    public Integer getSelectedItemPaciente() {
        return selectedItemPaciente;
    }

    public void setSelectedItemPaciente(Integer selectedItemPaciente) {
        this.selectedItemPaciente = selectedItemPaciente;
    }

    public List<SelectItem> getListaDeMedicos() {
        return listaDeMedicos;
    }

    public void setListaDeMedicos(List<SelectItem> listaDeMedicos) {
        this.listaDeMedicos = listaDeMedicos;
    }

    public List<SelectItem> getListaDePacientes() {
        return listaDePacientes;
    }

    public void setListaDePacientes(List<SelectItem> listaDePacientes) {
        this.listaDePacientes = listaDePacientes;
    }

    public List<Medic> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medic> medicos) {
        this.medicos = medicos;
    }

    public List<Pacient> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Pacient> pacientes) {
        this.pacientes = pacientes;
    }

    public Reservation getCitas() {
        return citas;
    }

    public void setCitas(Reservation citas) {
        this.citas = citas;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }

    public Pacient getPacient() {
        return pacient;
    }

    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
    }
}
