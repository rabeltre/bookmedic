/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bookmedic;

import model.Medic;
import service.MedicoService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author estudiantes
 */
@ManagedBean
@ViewScoped
public class BeannPrueba implements Serializable {
private Integer selectedItem;
    @ManagedProperty(value = "#{medicoService}")
    private MedicoService medicoService;
    public List<Medic> medicos;
    private List<SelectItem>medicosLista;


    /**
     * Creates a new instance of NewJSFManagedBean
     */
    public BeannPrueba() {
        selectedItem =3;

    }


    public void submit() {
        System.out.println("Selected item: " + selectedItem);
    }

    @PostConstruct
    public void init() {
        medicos = medicoService.findAll();
        System.out.printf("No dio error");
        medicosLista = new ArrayList<SelectItem>();
        for (Medic medic: medicos){
medicosLista.add(new SelectItem(medic.getId(), medic.getName()));

        }
        medicos.clear();


    }

    public Integer getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(Integer selectedItem) {
        this.selectedItem = selectedItem;
    }

    public MedicoService getMedicoService() {
        return medicoService;
    }

    public void setMedicoService(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    public List<Medic> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medic> medicos) {
        this.medicos = medicos;
    }

    public List<SelectItem> getMedicosLista() {
        return medicosLista;
    }

    public void setMedicosLista(List<SelectItem> medicosLista) {
        this.medicosLista = medicosLista;
    }
}
