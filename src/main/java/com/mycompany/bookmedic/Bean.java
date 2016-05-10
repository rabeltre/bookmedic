/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bookmedic;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
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
public class Bean implements Serializable {

    /**
     * Creates a new instance of NewJSFManagedBean
     */
    public Bean() {
        this.setSelectedItem("foo");
    }

    private String selectedItem; // +getter +setter
    private List<SelectItem> availableItems;
    private List<SelectItem> starRatingList;
    private List<SelectItem> availableItems2;
    private Map<String, String> availableItemMap;


    public void submit() {
        System.out.println("Selected item: " + selectedItem);
    }

    @PostConstruct
    public void init() {

        availableItems = new ArrayList<SelectItem>();
        starRatingList = new ArrayList<SelectItem>();
        starRatingList.add(new SelectItem(new Integer(1), "One Star"));
        starRatingList.add(new SelectItem(new Integer(2), "Two Stars"));
        starRatingList.add(new SelectItem(new Integer(3), "Three Stars"));
        starRatingList.add(new SelectItem(new Integer(4), "Four Stars"));


//    Esta es una opcion para llenar el combobox
        availableItems.add(new SelectItem("foo", "Foo label"));
        availableItems.add(new SelectItem("bar", "Bar label"));
        availableItems.add(new SelectItem("baz", "Baz label"));


//        Este ejemplo es utilizando grupos
        availableItems2 = new ArrayList<SelectItem>();
        SelectItemGroup group1 = new SelectItemGroup("gropo 1");
        group1.setSelectItems(new SelectItem[]{
                new SelectItem("Group 1 Value 1", "Group 1 Label 1"),
                new SelectItem("Group 1 Value 2", "Group 1 Label 2"),
                new SelectItem("Group 1 Value 3", "Group 1 Label 3")

        });
        SelectItemGroup group2 = new SelectItemGroup("Group 2");
        group2.setSelectItems(new SelectItem[]{
                new SelectItem("Group 2 Value 1", "Group 2 Label 1"),
                new SelectItem("Group 2 Value 2", "Group 2 Label 2"),
                new SelectItem("Group 2 Value 3", "Group 2 Label 3")
        });
        availableItems2.add(group1);
        availableItems2.add(group2);


//        Ejemplo utilizando availableItemMap
        availableItemMap = new LinkedHashMap<String, String>();
        availableItemMap.put("Foo label", "foo");
        availableItemMap.put("Bar label", "bar");
        availableItemMap.put("Baz label", "baz");

    }


    public Map<String, String> getAvailableItemMap() {
        return availableItemMap;
    }

    public void setAvailableItemMap(Map<String, String> availableItemMap) {
        this.availableItemMap = availableItemMap;
    }

    public List<SelectItem> getAvailableItems() {

        return availableItems;
    }

    public void setAvailableItems(List<SelectItem> availableItems) {
        this.availableItems = availableItems;
    }

    public String getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }

    public List<SelectItem> getAvailableItems2() {
        return availableItems2;
    }

    public void setAvailableItems2(List<SelectItem> availableItems2) {
        this.availableItems2 = availableItems2;
    }
    private Integer stars = new Integer(1);

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public Integer getStars() {
        return this.stars;
    }

    public List<SelectItem> getStarRatingList() {
        return starRatingList;
    }

    public void setStarRatingList(List<SelectItem> starRatingList) {
        this.starRatingList = starRatingList;
    }
}
