package com.company;

import java.io.Serializable;
import java.util.*;

public class Table implements Serializable {
    private final int id;
    private final List<Reservation> reservations;

    public Table(int id, List<Reservation> reservations) {
        this.id = id;
        this.reservations = reservations;
    }

    public int getId() {
        return id;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
}