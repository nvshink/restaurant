package com.company;

import java.awt.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Tab;
import javafx.stage.Stage;

public class Main extends Application{

    private static List<Employee> employees;
    public static List<Employee> getEmployees() {
        return employees;
    }

    private static List<MenuItem> menuItems;
    public static List<MenuItem> getMenuItems () {
        return menuItems;
    }

    private static List<Table> tables;
    public static List<Table> getTables() {
        return tables;
    }

    private static List<Reservation> reservations;
    public static List<Reservation> getReservations() {
        return reservations;
    }

    public static void main(String[] args) throws InterruptedException {
        employees = new ArrayList<>();
        Employee employee1 = new Employee(1, "McQueen", "Lightning", null, "waiter", "kchau", "0000");
        Employee employee2 = new Employee(1, "McQueen", "Lightning", null, "waiter", "1", "1");
        employees.add(employee1);
        employees.add(employee2);

        menuItems = new ArrayList<>();
        MenuItem water = new MenuItem(1, "water", BigDecimal.valueOf(50), "water", "0.5 litres");
        menuItems.add(water);
        MenuItem falafel = new MenuItem(2, "falafel", BigDecimal.valueOf(180), "falafel, fresh vegetables, gherkins, hummus, sesame sauce thin", "300 gram");
        menuItems.add(falafel);

        reservations = new ArrayList<>();
        Reservation reservation1 = new Reservation(1, 2, LocalDateTime.of(2021, 12, 8, 11, 30), "Zubenko");
        Reservation reservation2 = new Reservation(2, 6, LocalDateTime.of(2021, 12, 7, 12, 30), "Zubenko");
        Reservation reservation3 = new Reservation(3, 3, LocalDateTime.of(2021, 12, 7, 11, 30), "Zubenko");
        reservations.add(reservation1);
        reservations.add(reservation2);
        reservations.add(reservation3);

        for (int left = 0; left < reservations.size(); left++) {
            int minInd = left;
            for (int i = left; i < reservations.size(); i++) {
                if (reservations.get(i).getReservationTime().isBefore(reservations.get(minInd).getReservationTime())) {
                    minInd = i;
                }
            }
            Collections.swap(reservations, left, minInd);
        }
        int tablesValue = 10;
        tables = new ArrayList<>();
        for (int i = 1; i <= tablesValue; i++) {
            Table table = null;
            List<Reservation> tableReservations = new ArrayList<>();
            for (int j = 0; j < reservations.size(); j++) {
                Reservation reservation = reservations.get(j);
                if (reservation.getTableID() == i) {
                    tableReservations.add(reservation);
                    table = new Table(i, reservations.get(j).getId());
                    break;
                } else {
                    table = new Table(i, 0);
                }
                System.out.println(table.getId() + " " + table.getReservationId());
            }
            table.setReservations(tableReservations);
            tables.add(table);
        }
        Application.launch();
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loginScene.fxml")));
        primaryStage.setTitle("Restaurant helper");
        primaryStage.setMinHeight(500);
        primaryStage.setMinWidth(500);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
