package com.company;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Shift implements Serializable {
    private final LocalDateTime startShiftDate;
    private final LocalDateTime endShiftDate;
    private final int employeeId;
    public Shift (LocalDateTime startShiftDate, LocalDateTime endShiftDate, int employeeId) {
        this.startShiftDate = startShiftDate;
        this.endShiftDate = endShiftDate;
        this.employeeId = employeeId;
    }

    public LocalDateTime getStartShiftDate() {
        return startShiftDate;
    }
    public LocalDateTime getEndShiftDate() {
        return endShiftDate;
    }
    public int setEmployeeId() {
        return employeeId;
    }
}
