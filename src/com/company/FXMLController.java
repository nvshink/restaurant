package com.company;


import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FXMLController {
    private Stage stage;
    private String employeeName;
    private int employeeId;
    @FXML
    private TextField loginField;
    @FXML
    private TextField passwordField;
    @FXML
    private Button loginButton;
    @FXML
    private void loginButtonClicked(ActionEvent event) throws Exception {
        List<Employee> employees = Main.getEmployees();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getLogin().equals(loginField.getText()) && employees.get(i).getPassword().equals(passwordField.getText())) {
                employeeName = employees.get(i).getLastName() + employees.get(i).getFirstName();
                employeeId = employees.get(i).getId();
                Parent root = FXMLLoader.load(getClass().getResource("mainScene.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.getScene().setRoot(root);
                break;
            }
        }
    }
//    @FXML
//    private void logInFieldsChanged() {
//        if (passwordField.getText().isEmpty() && loginField.getText().isEmpty()) {
//            loginButton.setDisable(true);
//        } else {
//            loginButton.setDisable(false);
//        }
//    }

    @FXML
    private Pane itemBox;
    @FXML
    private HBox itemBoxHbox;
    private int billsNumber = 0;
    private int billId = 0;
    private List<Bill> bills = new ArrayList<>();
    private List<MenuItem> billItems = new ArrayList<>();
    private List<VBox> billVBoxes = new ArrayList<>();
    private List<MenuItem> menuItems = Main.getMenuItems();
    private List<Table> tables = Main.getTables();
    private List<Reservation> reservations = Main.getReservations();
    @FXML
    private void itemBoxMouseClicked() {
        Bill bill = new Bill(billId, false, billItems, BigDecimal.valueOf(50), employeeName, employeeId, null);
        VBox billVBox = new VBox();
        billVBox.setPrefHeight(itemBox.getPrefHeight());
        billVBox.setPrefWidth(itemBox.getPrefWidth());
        billVBox.setMinHeight(billVBox.getPrefHeight());
        billVBox.setMinWidth(billVBox.getPrefWidth());
        billVBox.setPadding(new Insets(20, 20, 20, 20));
        billVBox.setSpacing(20);
        Label label = new Label("Чек №" + billId);
        label.getStyleClass().add("labelHBox");

        TableView<MenuItem> billTableView = new TableView<MenuItem>();
        billTableView.getStyleClass().add("item-table");
        TableColumn<MenuItem, String> itemName = new TableColumn<MenuItem, String>("Name");
        itemName.setCellValueFactory(new PropertyValueFactory<MenuItem, String>("itemName"));
        itemName.setPrefWidth(196);
        itemName.setResizable(false);
        billTableView.getColumns().add(itemName);
        TableColumn<MenuItem, String> itemValue = new TableColumn<MenuItem, String>("Cost");
        itemValue.setCellValueFactory(new PropertyValueFactory<MenuItem, String>("cost"));
        itemValue.setMinWidth(20);
        itemValue.setResizable(false);
        billTableView.getColumns().add(itemValue);

        ContextMenu billContextMenu = new ContextMenu();
        List<javafx.scene.control.MenuItem> contextMenuItem = new ArrayList<>();
        for (int i = 0; i < menuItems.size(); i++) {
            javafx.scene.control.MenuItem item = new javafx.scene.control.MenuItem(menuItems.get(i).getItemName() + " " + menuItems.get(i).getSize() + " "
                    + menuItems.get(i).getCost() + "r. ("
                    + menuItems.get(i).getStructure() + ")");
            billContextMenu.getItems().add(item);
            int j = i;
            item.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    billTableView.getItems().add(menuItems.get(j));
                }
            });
            contextMenuItem.add(item);
        }

        HBox listButtonsHBox = new HBox();
        Button deleteListView = new Button("-");
        deleteListView.getStyleClass().add("delete-button");
        deleteListView.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                billTableView.getItems().remove(billTableView.getSelectionModel().getSelectedItem());
            }
        });
        deleteListView.setPrefWidth(25);
        Button addListView = new Button("+");
        addListView.getStyleClass().add("primary-button");
        addListView.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                billContextMenu.show(addListView, event.getScreenX(), event.getScreenY());
            }
        });
        deleteListView.setPrefWidth(25);
        listButtonsHBox.setSpacing(10);
        listButtonsHBox.setAlignment(Pos.TOP_RIGHT);
        listButtonsHBox.getChildren().addAll(deleteListView, addListView);

        HBox boxButtonsHBox = new HBox();
        Button deleteBox = new Button("Удалить");
        deleteBox.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                itemBoxHbox.getChildren().remove(billVBox);
            }
        });
        deleteBox.getStyleClass().add("delete-button");
        Button payBox = new Button("Оплатить");
        payBox.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (!billTableView.getItems().isEmpty()) {
                    bill.setPayed(true);
                    payBox.setText("Оплачено");
                    payBox.getStyleClass().add("green-button");
                    bill.setPayTime(LocalDateTime.now());
                    //itemBoxHbox.getChildren().remove(billVBox);
                }
            }
        });
        payBox.getStyleClass().add("primary-button");
        boxButtonsHBox.setSpacing(10);
        boxButtonsHBox.setAlignment(Pos.TOP_RIGHT);
        boxButtonsHBox.getChildren().addAll(deleteBox, payBox);
        billVBox.getChildren().addAll(label, billTableView, listButtonsHBox, boxButtonsHBox);
        billVBox.getStyleClass().add("item-box");
        billVBoxes.add(billVBox);
        itemBoxHbox.getChildren().add(billVBox);
        bills.add(bill);
        billId++;
    }

    @FXML
    private AnchorPane billsAnchorPane;
    @FXML
    private AnchorPane tablesAnchorPane;
    @FXML
    private AnchorPane shiftsAnchorPane;

    @FXML
    private Button billsButton;
    @FXML
    private Button tablesButton;
    @FXML
    private Button shiftsButton;
    @FXML
    private FlowPane tablesFlow;
    private boolean isTablesGenerated = false;

    @FXML
    void billsButtonClicked() {
        billsAnchorPane.setVisible(true);;
        tablesAnchorPane.setVisible(false);
        shiftsAnchorPane.setVisible(false);
        billsButton.getStyleClass().remove("sections-button");
        billsButton.getStyleClass().add("sections-button-selected");
        tablesButton.getStyleClass().remove("sections-button-selected");
        tablesButton.getStyleClass().add("sections-button");
        shiftsButton.getStyleClass().remove("sections-button-selected");
        shiftsButton.getStyleClass().add("sections-button");
    }

    @FXML
    void tablesButtonClicked() {
        tablesGenerate();
        billsAnchorPane.setVisible(false);
        tablesAnchorPane.setVisible(true);;
        shiftsAnchorPane.setVisible(false);
        billsButton.getStyleClass().remove("sections-button-selected");
        billsButton.getStyleClass().add("sections-button");
        tablesButton.getStyleClass().remove("sections-button");
        tablesButton.getStyleClass().add("sections-button-selected");
        shiftsButton.getStyleClass().remove("sections-button-selected");
        shiftsButton.getStyleClass().add("sections-button");
    }
    private void tablesGenerate() {
        if (!isTablesGenerated){
            for (Table table : tables) {
                HBox tableHBox;
                if (table.getReservationId() == 0) {
                    tableHBox = table.addNotReservedTable(table.getId());
                } else {
                    tableHBox = table.addReservedTable(table.getId(), table.getReservations(), table.getReservationId());
                }
                tablesFlow.getChildren().add(tableHBox);
            }
        isTablesGenerated = true;
        }
    }


    @FXML
    void shiftsButtonClicked() {
        billsAnchorPane.setVisible(false);
        tablesAnchorPane.setVisible(false);
        shiftsAnchorPane.setVisible(true);;
        billsButton.getStyleClass().remove("sections-button-selected");
        billsButton.getStyleClass().add("sections-button");
        tablesButton.getStyleClass().remove("sections-button-selected");
        tablesButton.getStyleClass().add("sections-button");
        shiftsButton.getStyleClass().remove("sections-button-selected");
        shiftsButton.getStyleClass().add("sections-button-selected");
    }
}