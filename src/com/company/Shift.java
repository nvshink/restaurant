package com.company;

import java.time.LocalDateTime;

public class Shift {
    private int id;
    private LocalDateTime startShiftDate;
    private LocalDateTime endShiftDate;
    private int employeeId;
    public Shift (int id, LocalDateTime startShiftDate, LocalDateTime endShiftDate, int employeeId) {
        this.id = id;
        this.startShiftDate = startShiftDate;
        this.endShiftDate = endShiftDate;
        this.employeeId = employeeId;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setStartShiftDate(LocalDateTime startShiftDate) {
        this.startShiftDate = startShiftDate;
    }
    public LocalDateTime getStartShiftDate() {
        return startShiftDate;
    }
    public void setEndShiftDate(LocalDateTime endShiftDate) {
        this.endShiftDate = endShiftDate;
    }
    public LocalDateTime getEndShiftDate() {
        return endShiftDate;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public int setEmployeeId() {
        return employeeId;
    }
}
