package com.company;


import java.io.*;
import java.util.*;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        Restaurant.deserializationEmployee();
        Restaurant.deserializationRestaurant();
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
