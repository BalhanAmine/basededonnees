package com.example.tp_poo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AjouterDepartement extends Application {
    private TextField intituleField = new TextField();
    private TextField responsableField = new TextField();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(" PAGE AJOUTER DEPARTEMENT ");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        // Add UI elements to the grid
        grid.add(new Label("Intitule:"), 0, 0);
        grid.add(intituleField, 1, 0);
        grid.add(new Label("Responsable:"), 0, 1);
        grid.add(responsableField, 1, 1);

        Button retourAccueilButton = new Button("Retour à l'accueil");
        retourAccueilButton.setOnAction(e -> retourALaccueil(primaryStage));
        grid.add(retourAccueilButton, 0, 2);

        Button saveButton = new Button("AJOUTER");
        saveButton.setOnAction(e -> saveUserInfo());
        grid.add(saveButton, 1, 2);

        Scene scene = new Scene(grid, 370, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void saveUserInfo() {
        // Get user input
        String intitule = intituleField.getText();
        String responsable = responsableField.getText();

        // Perform database operations (insert into MySQL, for example)
        String jdbcUrl = "jdbc:mysql://localhost:3306/poo_projet";
        String username = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            String query = " INSERT INTO departement  (intitule, responsable) values (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, intitule);
                preparedStatement.setString(2, responsable);
                preparedStatement.executeUpdate();
                System.out.println("tbarklah");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("mdeb3");
        }

        // For simplicity, we'll just print the user input in this example
        System.out.println("User Info Saved: " + intitule + " " + responsable);
    }

    private void retourALaccueil(Stage primaryStage) {
        // Retourner à la fenêtre principale
        MainInterface mainInterface = new MainInterface();
        mainInterface.start(primaryStage);
    }
}
