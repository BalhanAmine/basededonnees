package com.example.tp_poo;

import javafx.application.Application;
import javafx.geometry.Insets;
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

public class GetAllDepartement extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Liste des Départements");

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));

        // Récupérer tous les départements de la base de données
        Label departementLabel = new Label(getAllDepartements());
        vbox.getChildren().addAll(departementLabel);

        Button retourAccueilButton = new Button("Retour à l'accueil");
        retourAccueilButton.setOnAction(e -> retourALaccueil(primaryStage));
        vbox.getChildren().add(retourAccueilButton);

        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private String getAllDepartements() {
        StringBuilder result = new StringBuilder();

        String jdbcUrl = "jdbc:mysql://localhost:3306/poo_projet";
        String username = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            String query = "SELECT idDepartement, intitule, responsable FROM departement";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int idDepartement = resultSet.getInt("idDepartement");
                    String intitule = resultSet.getString("intitule");
                    String responsable = resultSet.getString("responsable");

                    result.append("ID: ").append(idDepartement)
                            .append(", Intitulé: ").append(intitule)
                            .append(", Responsable: ").append(responsable)
                            .append("\n");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result.append("Erreur lors de la récupération des départements.");
        }

        return result.toString();
    }

    private void retourALaccueil(Stage primaryStage) {
        // Retourner à la fenêtre principale
        MainInterface mainInterface = new MainInterface();
        mainInterface.start(primaryStage);
    }
}
