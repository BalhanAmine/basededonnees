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

public class SupprimerEtudiant extends Application {
    private TextField idEtudiantField = new TextField();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("PAGE SUPPRIMER ÉTUDIANT");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        // Add UI elements to the grid
        grid.add(new Label("ID Étudiant:"), 0, 0);
        grid.add(idEtudiantField, 1, 0);

        Button deleteButton = new Button("SUPPRIMER");
        deleteButton.setOnAction(e -> deleteEtudiant());

        Button retourAccueilButton = new Button("Retour à l'accueil");
        retourAccueilButton.setOnAction(e -> retourALaccueil(primaryStage));

        grid.add(deleteButton, 1, 1);
        grid.add(retourAccueilButton, 1, 2);

        Scene scene = new Scene(grid, 370, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void deleteEtudiant() {
        int idEtudiant;
        try {
            idEtudiant = Integer.parseInt(idEtudiantField.getText());
        } catch (NumberFormatException e) {
            System.out.println("Veuillez saisir un ID d'étudiant valide.");
            return;
        }

        String jdbcUrl = "jdbc:mysql://localhost:3306/poo_projet";
        String username = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            String query = "DELETE FROM etudiant WHERE idEtudiant = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, idEtudiant);
                int affectedRows = preparedStatement.executeUpdate();

                if (affectedRows > 0) {
                    System.out.println("Étudiant supprimé avec succès.");
                } else {
                    System.out.println("Aucun étudiant trouvé avec l'ID spécifié.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la suppression de l'étudiant.");
        }
    }

    private void retourALaccueil(Stage primaryStage) {
        // Retourner à la fenêtre principale
        MainInterface mainInterface = new MainInterface();
        mainInterface.start(primaryStage);
    }
}
