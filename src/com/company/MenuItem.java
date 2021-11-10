package com.company;

import java.math.BigDecimal;

public class MenuItem {
    //private int id;
    private String name;
    private BigDecimal cost;
    private String structure;
    private String size;

//    public int getId() {
//        return id;
//    }

    public MenuItem (/*int id,*/ String name, BigDecimal cost, String structure, String size)
    {
        //this.id = id;
        this.name = name;
        this.cost = cost;
        this.structure = structure;
        this.size = size;
    }

    public String getItemName() {
        return name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public String getStructure() {
        return structure;
    }

    public String getSize() {
        return size;
    }

}