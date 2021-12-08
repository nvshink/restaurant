package com.company;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Restaurant {
    private static List<Employee> employees;

    public static void setEmployees() {

    }

    public static List<Employee> getEmployees() {
        return employees;
    }

    private static List<MenuItem> menuItems;

    public static void setMenuItems() {

    }

    public static List<MenuItem> getMenuItems() {
        return menuItems;
    }

    private static List<Reservation> reservations;

    public static void setReservations() {

    }

    public static List<Reservation> getReservations() {
        return reservations;
    }

    private static List<Table> tables;

    public static void setTables() {

    }

    public static List<Table> getTables() {
        return tables;
    }
    public static void serializationRestaurant () {
        menuItems = new ArrayList<>();
        MenuItem water = new MenuItem("water", BigDecimal.valueOf(50), "water", "0.5 litres");
        menuItems.add(water);
        MenuItem falafel = new MenuItem("falafel", BigDecimal.valueOf(180), "falafel, fresh vegetables, gherkins, hummus, sesame sauce thin", "300 gram");
        menuItems.add(falafel);
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
        int tablesValue = 10; //избавиться от инта?
        tables = new ArrayList<>();
        for (int i = 0; i < tablesValue; i++) {
            List<Reservation> tableReservations = new ArrayList<>();
            for (Reservation reservation : reservations) {
                if (reservation.getTableID() == i) {
                    tableReservations.add(reservation);
                }
            }
            Table table = new Table(i, tableReservations);
            tables.add(table);
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./src/com/company/restaurant.ser"))){
            oos.writeObject(menuItems);
            oos.writeObject(reservations);
            oos.writeObject(tables);
        }
            catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void deserializationEmployee() {
        employees = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./src/com/company/employees.ser"))){
            while (ois.readObject() != null) {
                Employee employee = (Employee) ois.readObject();
                employees.add(employee);
            }
        }
        catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void deserializationRestaurant() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./src/com/company/restaurant.ser"))){
            menuItems = (ArrayList) ois.readObject();
            reservations = (ArrayList) ois.readObject();
            tables = (ArrayList) ois.readObject();
            ois.close();
        }
        catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
