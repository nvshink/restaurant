package com.company;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Bill implements Serializable {
    private final List<MenuItem> menuItems;
    private BigDecimal amount;
    private final String employeeName;

    private LocalDateTime payTime;

    public Bill(List<MenuItem> menuItems, BigDecimal amount,
                String employeeName, LocalDateTime payTime) {
        this.menuItems = menuItems;
        this.amount = amount;
        this.employeeName = employeeName;
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
