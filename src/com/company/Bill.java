package com.company;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Bill {
    private int id;
    private boolean payed;
    private List<MenuItem> menuItems;
    private BigDecimal amount;
    private String employeeName;
    private int employeeId;
    private LocalDateTime payTime;

    public Bill(int id, boolean payed, List<MenuItem> menuItems, BigDecimal amount,
                String employeeName, int employeeId, LocalDateTime payTime) {
        this.id = id;
        this.payed = payed;
        this.menuItems = menuItems;
        this.amount = amount;
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.payTime = payTime;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setPayed(boolean payed) {
        this.payed = payed;
    }
    public boolean getPayed() {
        return payed;
    }
    public List<MenuItem> getMenuItems() {
       return menuItems;
   }
    public void setMenuItems(List menuItems) {
       this.menuItems = menuItems;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String  employeeName) {
        this.employeeName = employeeName;
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int id) {
        this.employeeId = employeeId;
    }
    public LocalDateTime getPayTime() {
        return payTime;
    }
    public void setPayTime(LocalDateTime payTime) {
        this.payTime = payTime;
    }
}
