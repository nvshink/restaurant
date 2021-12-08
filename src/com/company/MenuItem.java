package com.company;

import java.io.Serializable;
import java.math.BigDecimal;

public class MenuItem implements Serializable {
    private final String name;
    private final BigDecimal cost;
    private final String structure;
    private final String size;


    public MenuItem(String name, BigDecimal cost, String structure, String size) {
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