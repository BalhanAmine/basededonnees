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

public class AjouterEtudiant extends Application {
    private TextField nomField = new TextField();
    private TextField prenomField = new TextField();
    private TextField apogeeField = new TextField();
    private TextField emailField = new TextField();
    private TextField motdepasseField = new TextField();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("PAGE AJOUTER ÉTUDIANT");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        // Add UI elements to the grid
        grid.add(new Label("Nom:"), 0, 0);
        grid.add(nomField, 1, 0);
        grid.add(new Label("Prénom:"), 0, 1);
        grid.add(prenomField, 1, 1);
        grid.add(new Label("apogee:"), 0, 2);
        grid.add(apogeeField, 1, 2);
        grid.add(new Label("Email:"), 0, 3);
        grid.add(emailField, 1, 3);
        grid.add(new Label("Mot de passe:"), 0, 4);
        grid.add(motdepasseField, 1, 4);

        Button retourAccueilButton = new Button("Retour à l'accueil");
        retourAccueilButton.setOnAction(e -> retourALaccueil(primaryStage));
        grid.add(retourAccueilButton, 0, 5);

        Button saveButton = new Button("AJOUTER");
        saveButton.setOnAction(e -> saveEtudiant());
        grid.add(saveButton, 1, 5);

        Scene scene = new Scene(grid, 370, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void saveEtudiant() {
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String apogee = apogeeField.getText();
        String email = emailField.getText();
        String motdepasse = motdepasseField.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/poo_projet";
        String username = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            String query = "INSERT INTO etudiant (nom, prenom, apogee, email, motdepasse) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, nom);
                preparedStatement.setString(2, prenom);
                preparedStatement.setString(3, apogee);
                preparedStatement.setString(4, email);
                preparedStatement.setString(5, motdepasse);
                preparedStatement.executeUpdate();
                System.out.println("Étudiant ajouté avec succès.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Erreur lors de l'ajout de l'étudiant.");
        }
    }

    private void retourALaccueil(Stage primaryStage) {
        // Retourner à la fenêtre principale
        MainInterface mainInterface = new MainInterface();
        mainInterface.start(primaryStage);
    }
}
