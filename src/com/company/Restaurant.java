package com.company;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Restaurant
{
   private static List<Employee> employees;
    public static void setEmployees() {
        employees = new ArrayList<>();
        Employee employee1 = new Employee(1, "McQueen", "Lightning", null, "waiter", "kchau", "0000");
        Employee employee2 = new Employee(1, "McQueen", "Lightning", null, "waiter", "1", "1");
        employees.add(employee1);
        employees.add(employee2);
//        Restaurant.employees = employees;
    }
    public static List<Employee> getEmployees() {
        return employees;
    }

    private static List<MenuItem> menuItems;
    public static void setMenuItems() {
        menuItems = new ArrayList<>();
        MenuItem water = new MenuItem("water", BigDecimal.valueOf(50), "water", "0.5 litres");
        menuItems.add(water);
        MenuItem falafel = new MenuItem("falafel", BigDecimal.valueOf(180), "falafel, fresh vegetables, gherkins, hummus, sesame sauce thin", "300 gram");
        menuItems.add(falafel);
//        Restaurant.menuItems = menuItems;
    }
    public static List<MenuItem> getMenuItems () {
        return menuItems;
    }

    private static List<Reservation> reservations;
    public static  void setReservations() {
        reservations = new ArrayList<>();
        Reservation reservation1 = new Reservation(2, LocalDateTime.of(2021, 12, 8, 11, 30), "Zubenko");
        Reservation reservation2 = new Reservation(6, LocalDateTime.of(2021, 12, 7, 12, 30), "Zubenko");
        Reservation reservation3 = new Reservation(3, LocalDateTime.of(2021, 12, 7, 11, 30), "Zubenko");
        reservations.add(reservation1);
        reservations.add(reservation2);
        reservations.add(reservation3);

        for (int left = 0; left < reservations.size(); left++) {
            int minInd = left;
            for (int i = left; i < reservations.size(); i++) {
                if (reservations.get(i).getstartTime().isBefore(reservations.get(minInd).getstartTime())) {
                    minInd = i;
                }
            }
            Collections.swap(reservations, left, minInd);
        }
    }
    public static List<Reservation> getReservations() {
        return reservations;
    }

    private static List<Table> tables;
    public static void setTables() {
        int tablesValue = 10; //избавиться от инта?
        tables = new ArrayList<>();
        for (int i = 1; i <= tablesValue; i++) {
            Table table = null;
            List<Reservation> tableReservations = new ArrayList<>();
            for (int j = 0; j < reservations.size(); j++) {
                Reservation reservation = reservations.get(j);
                if (reservation.getTableID() == i) {
                    tableReservations.add(reservation);
                    table = new Table(i, 0/*reservations.get(j).getId()*/);
                    break;
                } else {
                    table = new Table(i, 0);
                }
            }
            table.setReservations(tableReservations);
            tables.add(table);
        }
    }
    public static List<Table> getTables() {
        return tables;
    }
}
