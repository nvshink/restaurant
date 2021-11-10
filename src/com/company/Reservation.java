package com.company;

import java.time.LocalDateTime;
import java.util.List;

public class Reservation {
    //private final int id;
    // private final Table table;
    private final int tableID;
    private final LocalDateTime startTime;  // startTime;
    private final String comment;         // comment


    public Reservation(/*int id,*/ int tableID, LocalDateTime startTime, String comment) {
        //this.id = id;
        this.tableID = tableID;
        this.startTime = startTime;
        this.comment = comment;
    }

//    public int getId() {
//        return id;
//    }

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
