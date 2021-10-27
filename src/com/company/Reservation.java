package com.company;

import java.time.LocalDateTime;
import java.util.List;

public class Reservation {
    private int id;
    private int tableID;
    private LocalDateTime reservationTime;
    private String nameReservation;


    public Reservation(int id, int tableID, LocalDateTime reservationTime, String nameReservation) {
        this.id = id;
        this.tableID = tableID;
        this.reservationTime = reservationTime;
        this.nameReservation = nameReservation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTableID() {
        return tableID;
    }

    public void setTableID(int tableID) {
        this.tableID = tableID;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalDateTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    public String getNameReservation() {
        return nameReservation;
    }

    public void setNameReservation(String nameReservation) {
        this.nameReservation = nameReservation;
    }


}
