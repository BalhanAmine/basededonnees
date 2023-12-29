package com.example.tp_poo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetAllEtudiant extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Liste des Étudiants");

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.setAlignment(Pos.CENTER);

        // Récupérer tous les étudiants de la base de données
        Label etudiantLabel = new Label(getAllEtudiants());
        vbox.getChildren().addAll(etudiantLabel);

        Button retourAccueilButton = new Button("Retour à l'accueil");
        retourAccueilButton.setOnAction(e -> retourALaccueil(primaryStage));
        vbox.getChildren().add(retourAccueilButton);

        Scene scene = new Scene(vbox, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private String getAllEtudiants() {
        StringBuilder result = new StringBuilder();

        String jdbcUrl = "jdbc:mysql://localhost:3306/poo_projet";
        String username = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            String query = "SELECT idEtudiant, nom, prenom, apogee, email, motdepasse FROM etudiant";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int idEtudiant = resultSet.getInt("idEtudiant");
                    String nom = resultSet.getString("nom");
                    String prenom = resultSet.getString("prenom");
                    String apogee = resultSet.getString("apogee");
                    String email = resultSet.getString("email");
                    String motdepasse = resultSet.getString("motdepasse");

                    result.append("ID: ").append(idEtudiant)
                            .append(", Nom: ").append(nom)
                            .append(", Prénom: ").append(prenom)
                            .append(", apogee: ").append(apogee)
                            .append(", Email: ").append(email)
                            .append(", Mot de passe: ").append(motdepasse)
                            .append("\n");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result.append("Erreur lors de la récupération des étudiants.");
        }

        return result.toString();
    }

    private void retourALaccueil(Stage primaryStage) {
        // Retourner à la fenêtre principale
        MainInterface mainInterface = new MainInterface();
        mainInterface.start(primaryStage);
    }
}
