package com.company;

import java.math.BigDecimal;

public class MenuItem {
    private int id;
    private String itemName;
    private BigDecimal cost;
    private String structure;
    private String size;

    public int getId() {
        return id;
    }

    public MenuItem (int id, String itemName, BigDecimal cost, String structure, String size)
    {
        this.id = id;
        this.itemName = itemName;
        this.cost = cost;
        this.structure = structure;
        this.size = size;
    }

    public String getItemName() {
        return itemName;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public void setSize(String size) {
        this.size = size;
    }

}