package com.company;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import java.time.LocalDateTime;
import java.util.*;

public class Table {
    private int id;
    private int reservationId;

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

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getReservationId() {
        return reservationId;
    }

    public HBox addNotReservedTable(int tableNumber) {
        HBox tableHBox = new HBox();
        tableHBox.setAlignment(Pos.CENTER);
        tableHBox.getStyleClass().add("item-box");
        tableHBox.setPrefHeight(100);
        tableHBox.setPrefWidth(200);
        tableHBox.setMinHeight(Region.USE_PREF_SIZE);
        tableHBox.setMinWidth(Region.USE_PREF_SIZE);
        tableHBox.getChildren().addAll(addNotReservedTableVBox(tableNumber), addNotReservedTableButton());
        return tableHBox;
    }

    private VBox addNotReservedTableVBox(int tableNumber) {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(5));
        vBox.setPrefWidth(100);
        vBox.setPrefHeight(100);
        vBox.getChildren().add(addNotReservedTableNumber(tableNumber));
        return vBox;
    }

    private Label addNotReservedTableNumber(int tableNumber) {
        Label label = new Label();
        label.setText("№" + tableNumber);
        label.getStyleClass().add("tables-label");
        label.setAlignment(Pos.CENTER);
        return label;
    }

    private Button addNotReservedTableButton() {
        Button button = new Button();
        button.setText("Reserve");
        button.getStyleClass().addAll("tables-reserve-button", "tables-reserve-button-primary");
        button.setTextAlignment(TextAlignment.CENTER);
        return button;
    }

    public HBox addReservedTable(int tableNumber, List<Reservation> reservations, int reservationId) {
        HBox tableHBox = new HBox();
        tableHBox.setAlignment(Pos.CENTER);
        tableHBox.getStyleClass().add("item-box");
        tableHBox.setPrefHeight(100);
        tableHBox.setPrefWidth(200);
        tableHBox.setMinHeight(Region.USE_PREF_SIZE);
        tableHBox.setMinWidth(Region.USE_PREF_SIZE);
        tableHBox.getChildren().addAll(addReservedTableVBox(tableNumber, reservations, reservationId), addReservedTableButton());
        return tableHBox;
    }

    private VBox addReservedTableVBox(int tableNumber, List<Reservation> reservations, int reservationId) {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(5));
        vBox.setPrefWidth(100);
        vBox.setPrefHeight(100);
        vBox.getChildren().addAll(addReservedTableNumber(tableNumber), addReservedTableDescription(reservations, reservationId));
        return vBox;
    }

    private Label addReservedTableNumber(int tableNumber) {
        Label label = new Label();
        label.setText("№" + tableNumber);
        label.getStyleClass().add("tables-label-small-number");
        label.setAlignment(Pos.TOP_LEFT);
        return label;
    }

    private Label addReservedTableDescription(List<Reservation> reservations, int reservationId) {
        Label label = new Label();
        Reservation reservation = reservations.get(0);
        LocalDateTime reservationTime = reservation.getReservationTime();
        label.setText(reservation.getNameReservation() + "\n" + reservationTime.getHour() + ":"
                + reservationTime.getMinute() + "\n" + reservationTime.getDayOfMonth() + "." + reservationTime.getMonthValue());
        label.getStyleClass().add("tables-label-small-description");
        label.setAlignment(Pos.TOP_LEFT);
        return label;
    }

    private Button addReservedTableButton() {
        Button button = new Button();
        button.setText("Other");
        button.getStyleClass().addAll("tables-reserve-button", "tables-reserve-button-green");
        button.setTextAlignment(TextAlignment.CENTER);
        return button;
    }
}