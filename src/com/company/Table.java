package com.company;
import java.util.*;

public class Table {
    private final int id;
    private final int reservationId;

    private List<Reservation> reservations;

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Table(int id, int reservationId) {
        this.id = id;
        this.reservationId = reservationId;
    }

    public int getId() {
        return id;
    }
    public int getReservationId() {
        return reservationId;
    }
    public boolean isReserved() {
        return reservationId != 0;
    }


}