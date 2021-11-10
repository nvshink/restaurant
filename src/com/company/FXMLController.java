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
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FXMLController {
    private Stage stage;
    private int employeeNumber;
    @FXML
    private TextField loginField;
    @FXML
    private TextField passwordField;

    @FXML
    private void loginButtonClicked(ActionEvent event) throws Exception {
        List<Employee> employees = Restaurant.getEmployees();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getLogin().equals(loginField.getText()) && employees.get(i).getPassword().equals(passwordField.getText())) {
                employeeNumber = i;
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
    private AnchorPane contentAnchorPane;
    @FXML
    private Pane itemBox;
    @FXML
    private FlowPane itemBoxFlowPane;
    private List<Bill> bills = new ArrayList<>();
    private List<MenuItem> billItems = new ArrayList<>();
    private List<VBox> billVBoxes = new ArrayList<>();
    private List<MenuItem> menuItems = Restaurant.getMenuItems();
    private List<Table> tables = Restaurant.getTables();
    private List<Reservation> reservations = Restaurant.getReservations();

    @FXML
    private void itemBoxMouseClicked() {
        addBill();

//        ContextMenu billContextMenu = new ContextMenu();
//        List<javafx.scene.control.MenuItem> contextMenuItem = new ArrayList<>();
//        for (int i = 0; i < menuItems.size(); i++) {
//            javafx.scene.control.MenuItem item = new javafx.scene.control.MenuItem(menuItems.get(i).getItemName() + " " + menuItems.get(i).getSize() + " "
//                    + menuItems.get(i).getCost() + "r. ("
//                    + menuItems.get(i).getStructure() + ")");
//            billContextMenu.getItems().add(item);
//            int j = i;
//            item.setOnAction(new EventHandler<ActionEvent>() {
//                public void handle(ActionEvent event) {
//                    billTableView.getItems().add(menuItems.get(j));
//                }
//            });
//            contextMenuItem.add(item);
//        }




    }

    private VBox addBill() {
        Bill bill = new Bill(billItems, BigDecimal.valueOf(50),
                (Restaurant.getEmployees().get(employeeNumber).getLastName()
                        + " " + Restaurant.getEmployees().get(employeeNumber).getShortFirstName()), null);
        bills.add(bill);
        VBox billVBox = new VBox();
        billVBox.getStyleClass().add("item-box");
        billVBox.setPrefHeight(itemBox.getPrefHeight());
        billVBox.setPrefWidth(itemBox.getPrefWidth());
        billVBox.setMinHeight(billVBox.getPrefHeight());
        billVBox.setMinWidth(billVBox.getPrefWidth());
        billVBox.setPadding(new Insets(20, 20, 20, 20));
        billVBox.setSpacing(20);
        TableView tableView = addBillTable();
        billVBox.getChildren().addAll(addBillNumber(bills.size()), tableView, addTableButtons(tableView), addBoxButtons(tableView));
        billVBoxes.add(billVBox);
        itemBoxFlowPane.getChildren().add(billVBox);
        return billVBox;
    }

    private Label addBillNumber(int billNumber) {
        Label label = new Label("Чек №" + billNumber);
        label.getStyleClass().add("labelHBox");
        return label;
    }

    private TableView addBillTable() {
        TableView<MenuItem> tableView = new TableView<MenuItem>();
        tableView.getStyleClass().add("item-table");
        TableColumn<MenuItem, String> itemName = new TableColumn<MenuItem, String>("Name");
        itemName.setCellValueFactory(new PropertyValueFactory<MenuItem, String>("name"));
        itemName.setPrefWidth(196);
        itemName.setResizable(false);
        TableColumn<MenuItem, String> itemValue = new TableColumn<MenuItem, String>("Cost");
        itemValue.setCellValueFactory(new PropertyValueFactory<MenuItem, String>("cost"));
        itemValue.setMinWidth(20);
        itemValue.setResizable(false);
        tableView.getColumns().addAll(itemName, itemValue);
        return tableView;
    }
    private HBox addTableButtons (TableView tableView) {
        HBox tableButtonsHBox = new HBox();
        Button deleteListView = new Button("-");
        deleteListView.getStyleClass().add("delete-button");
        deleteListView.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                tableView.getItems().remove(tableView.getSelectionModel().getSelectedItem());
            }
        });
        deleteListView.setPrefWidth(25);
        Button addListView = new Button("+");
        addListView.getStyleClass().add("primary-button");
        addListView.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                openPopup();
//                contentAnchorPane.getChildren().add();
                //billContextMenu.show(addListView, event.getScreenX(), event.getScreenY());
            }
        });
        deleteListView.setPrefWidth(25);
        tableButtonsHBox.setSpacing(10);
        tableButtonsHBox.setAlignment(Pos.TOP_RIGHT);
        tableButtonsHBox.getChildren().addAll(deleteListView, addListView);
        return tableButtonsHBox;
    }
    @FXML
    private AnchorPane popupAnchorPane;

    private HBox addBoxButtons (TableView tableView) {

        HBox boxButtonsHBox = new HBox();
        Button deleteBox = new Button("Удалить");
        deleteBox.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                //   itemBoxHbox.getChildren().remove(billVBox);
            }
        });
        deleteBox.getStyleClass().add("delete-button");
        Button payBox = new Button("Оплатить");
        payBox.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (!tableView.getItems().isEmpty()) {
                   // bill.setPayTime(LocalDateTime.now());
                    payBox.setText("Оплачено");
                    payBox.getStyleClass().add("green-button");
                    //itemBoxHbox.getChildren().remove(billVBox);
                }
            }
        });
        payBox.getStyleClass().add("primary-button");
        boxButtonsHBox.setSpacing(10);
        boxButtonsHBox.setAlignment(Pos.TOP_RIGHT);
        boxButtonsHBox.getChildren().addAll(deleteBox, payBox);
        return boxButtonsHBox;
    }
    @FXML BorderPane popupBorderPane;
    @FXML Button popupButtonClose;
    //TODO: доделать вывод таблицы, кнопки и адаптацию титульника и кнопки
    private void openPopup() {
        popupBorderPane.setVisible(true);
        BoxBlur bb = new BoxBlur();
        bb.setWidth(5);
        bb.setHeight(5);
        bb.setIterations(1);
        contentAnchorPane.setEffect(bb);
        popupButtonClose.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                    popupBorderPane.setVisible(false);
                    contentAnchorPane.setEffect(null);
                    //itemBoxHbox.getChildren().remove(billVBox);
            }
        });
//        popupButtonClose.getStyleClass().add("popup-button-close");
//        popupButtonClose.setText("");
//        SVGPath path1 = new SVGPath();
//        int size = 10;
//        path1.setContent("M0,0L20,20z");
////        path1.setContent("M0," + size + "L" + size / 2 + ",0 "
////                + size + "," + size + " " + size / 2 + "," + 2 * size / 3 + "z");
//        path1.getStyleClass().add("svg1");
//        SVGPath path2 = new SVGPath();
//        path2.setContent("M0," + size + "L" + size / 2 + ",0 "
//                + size + "," + size + " " + size / 2 + "," + 2 * size / 3 + "z");
//        path2.getStyleClass().add("close-button");
//        SVGPath path3 = new SVGPath();
//        path3.setContent("M6 6H54V54H6V6Z");
//        path3.getStyleClass().add("svg2");
//        Group group = new Group(path1/*, path2, path3*/);
//        popupButtonClose.setGraphic(group);
//        Bounds bounds = group.getBoundsInParent();
//        double scale = Math.min(150/bounds.getWidth(), 150 / bounds.getHeight());
//        group.setScaleX(scale);
//        group.setScaleY(scale);
//        popupButtonClose.setMaxSize(150, 150);
//        popupButtonClose.setMinSize(150, 150);
//        popupButtonClose.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
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
        billsAnchorPane.setVisible(true);
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
        tablesAnchorPane.setVisible(true);
        ;
        shiftsAnchorPane.setVisible(false);
        billsButton.getStyleClass().remove("sections-button-selected");
        billsButton.getStyleClass().add("sections-button");
        tablesButton.getStyleClass().remove("sections-button");
        tablesButton.getStyleClass().add("sections-button-selected");
        shiftsButton.getStyleClass().remove("sections-button-selected");
        shiftsButton.getStyleClass().add("sections-button");
    }

    private void tablesGenerate() {
        if (!isTablesGenerated) {
            for (Table table : tables) {
                HBox tableHBox = table.isReserved()
                        ? addNotReservedTable(table.getId())
                        : addReservedTable(table.getId(), table.getReservations(), table.getReservationId());
                tablesFlow.getChildren().add(tableHBox);
            }
            isTablesGenerated = true;
        }
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
        LocalDateTime startTime = reservation.getstartTime();
        label.setText(reservation.getcomment() + "\n" + startTime.getHour() + ":"
                + startTime.getMinute() + "\n" + startTime.getDayOfMonth() + "." + startTime.getMonthValue());
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

    @FXML
    void shiftsButtonClicked() {
        billsAnchorPane.setVisible(false);
        tablesAnchorPane.setVisible(false);
        shiftsAnchorPane.setVisible(true);
        ;
        billsButton.getStyleClass().remove("sections-button-selected");
        billsButton.getStyleClass().add("sections-button");
        tablesButton.getStyleClass().remove("sections-button-selected");
        tablesButton.getStyleClass().add("sections-button");
        shiftsButton.getStyleClass().remove("sections-button-selected");
        shiftsButton.getStyleClass().add("sections-button-selected");
    }
}