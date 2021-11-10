package com.company;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Bill {
    //private int id;
    private final List<MenuItem> menuItems;
    private BigDecimal amount;
    private final String employeeName;
//    private final int employeeId;

    private LocalDateTime payTime;

    public Bill(/*int id,*/ /*boolean payed,*/ List<MenuItem> menuItems, BigDecimal amount,
                String employeeName, /*int employeeId,*/ LocalDateTime payTime) {
        //this.id = id;
        //this.payed = payed;
        this.menuItems = menuItems;
        this.amount = amount;
        this.employeeName = employeeName;
       // this.employeeId = employeeId;
        this.payTime = payTime;
    }
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public LocalDateTime getPayTime() {
        return payTime;
    }
    public void setPayTime(LocalDateTime payTime) {
        this.payTime = payTime;
    }
    public boolean isPayed () {
        return getPayTime() != null;
    }
}
