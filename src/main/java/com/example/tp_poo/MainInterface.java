package com.example.tp_poo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainInterface extends Application {

    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Interface Principale");

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.setAlignment(Pos.CENTER);

        Button departementButton = new Button("Gérer les Départements");
        Button etudiantButton = new Button("Gérer les Étudiants");
        Button filiereButton = new Button("Gérer les Filères");
        Button enseignantButton = new Button("Gérer les Enseignants");

        vbox.getChildren().addAll(departementButton, etudiantButton, filiereButton, enseignantButton);

        departementButton.setOnAction(e -> ouvrirDepartementActions());
        etudiantButton.setOnAction(e -> ouvrirEtudiantActions());
        filiereButton.setOnAction(e -> showFiliereActions());
        enseignantButton.setOnAction(e -> showEnseignantActions());

        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void ouvrirDepartementActions() {
        DepartementActions departementActions = new DepartementActions();
        departementActions.start(new Stage());

        // Masquer la fenêtre actuelle
        primaryStage.hide();
    }

    private void ouvrirEtudiantActions() {
        EtudiantActions etudiantActions = new EtudiantActions();
        etudiantActions.start(new Stage());

        // Masquer la fenêtre actuelle
        primaryStage.hide();
    }

    private void showFiliereActions() {
        // Implémentez la logique pour montrer la scène des Filières
    }

    private void showEnseignantActions() {
        // Implémentez la logique pour montrer la scène des Enseignants
    }

    public void retourALaccueil() {
        // Afficher à nouveau la fenêtre principale
        primaryStage.show();
    }
}
