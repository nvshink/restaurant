package com.company;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Reservation implements Serializable {

    private final int tableID;
    private final LocalDateTime startTime;
    private final String comment;


    public Reservation(int tableID, LocalDateTime startTime, String comment) {
        this.tableID = tableID;
        this.startTime = startTime;
        this.comment = comment;
    }

    public int getTableID() {
        return tableID;
    }

    public LocalDateTime getstartTime() {
        return startTime;
    }

    public String getcomment() {
        return comment;
    }
}
