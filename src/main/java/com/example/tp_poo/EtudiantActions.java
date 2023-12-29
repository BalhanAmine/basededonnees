package com.example.tp_poo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EtudiantActions extends Application {
    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Actions Étudiant");

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.setAlignment(Pos.CENTER);

        Button ajouterButton = new Button("Ajouter Étudiant");
        Button supprimerButton = new Button("Supprimer Étudiant");
        Button editerButton = new Button("Éditer Étudiant");
        Button listeButton = new Button("Afficher la liste des Étudiants");
        Button retourButton = new Button("Retour à l'accueil");

        vbox.getChildren().addAll(ajouterButton, supprimerButton, editerButton, listeButton, retourButton);

        ajouterButton.setOnAction(e -> ajouterEtudiant());
        supprimerButton.setOnAction(e -> supprimerEtudiant());
        editerButton.setOnAction(e -> editerEtudiant());
        listeButton.setOnAction(e -> afficherListeEtudiants());
        retourButton.setOnAction(e -> retourALaccueil());

        Scene scene = new Scene(vbox, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void ajouterEtudiant() {
        primaryStage.close();
        AjouterEtudiant ajouterEtudiant = new AjouterEtudiant();
        ajouterEtudiant.start(new Stage());
    }

    private void supprimerEtudiant() {
        primaryStage.close();
        SupprimerEtudiant supprimerEtudiant = new SupprimerEtudiant();
        supprimerEtudiant.start(new Stage());
    }

    private void editerEtudiant() {
        primaryStage.close();
        EditEtudiant editEtudiant = new EditEtudiant();
        editEtudiant.start(new Stage());
    }

    private void afficherListeEtudiants() {
        primaryStage.close();
        GetAllEtudiant getAllEtudiant = new GetAllEtudiant();
        getAllEtudiant.start(new Stage());
    }

    private void retourALaccueil() {
        primaryStage.close();
        MainInterface mainInterface = new MainInterface();
        mainInterface.start(new Stage());
    }
}
