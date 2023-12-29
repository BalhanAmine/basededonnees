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

public class EditEtudiant extends Application {
    private TextField idEtudiantField = new TextField();
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
        primaryStage.setTitle("PAGE EDITER ÉTUDIANT");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        // Add UI elements to the grid
        grid.add(new Label("ID Étudiant:"), 0, 0);
        grid.add(idEtudiantField, 1, 0);
        grid.add(new Label("Nom:"), 0, 1);
        grid.add(nomField, 1, 1);
        grid.add(new Label("Prénom:"), 0, 2);
        grid.add(prenomField, 1, 2);
        grid.add(new Label("apogee:"), 0, 3);
        grid.add(apogeeField, 1, 3);
        grid.add(new Label("Email:"), 0, 4);
        grid.add(emailField, 1, 4);
        grid.add(new Label("Mot de passe:"), 0, 5);
        grid.add(motdepasseField, 1, 5);

        Button retourAccueilButton = new Button("Retour à l'accueil");
        retourAccueilButton.setOnAction(e -> retourALaccueil(primaryStage));
        grid.add(retourAccueilButton, 0, 6);

        Button editButton = new Button("EDITER");
        editButton.setOnAction(e -> editEtudiant());
        grid.add(editButton, 1, 6);

        Scene scene = new Scene(grid, 400, 280);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void editEtudiant() {
        int idEtudiant;
        try {
            idEtudiant = Integer.parseInt(idEtudiantField.getText());
        } catch (NumberFormatException e) {
            System.out.println("Veuillez saisir un ID d'étudiant valide.");
            return;
        }

        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String apogee = apogeeField.getText();
        String email = emailField.getText();
        String motdepasse = motdepasseField.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/poo_projet";
        String username = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            String query = "UPDATE etudiant SET nom = ?, prenom = ?, apogee = ?, email = ?, motdepasse = ? WHERE idEtudiant = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, nom);
                preparedStatement.setString(2, prenom);
                preparedStatement.setString(3, apogee);
                preparedStatement.setString(4, email);
                preparedStatement.setString(5, motdepasse);
                preparedStatement.setInt(6, idEtudiant);
                int affectedRows = preparedStatement.executeUpdate();

                if (affectedRows > 0) {
                    System.out.println("Étudiant édité avec succès.");
                } else {
                    System.out.println("Aucun étudiant trouvé avec l'ID spécifié.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de l'édition de l'étudiant.");
        }
    }

    private void retourALaccueil(Stage primaryStage) {
        // Retourner à la fenêtre principale
        MainInterface mainInterface = new MainInterface();
        mainInterface.start(primaryStage);
    }
}
