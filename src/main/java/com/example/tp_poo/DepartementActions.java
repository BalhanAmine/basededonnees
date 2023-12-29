package com.example.tp_poo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DepartementActions extends Application {
    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Actions Département");

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));

        // Centrer les boutons verticalement dans la VBox
        vbox.setAlignment(Pos.CENTER);

        Button ajouterButton = new Button("Ajouter");
        Button supprimerButton = new Button("Supprimer");
        Button editerButton = new Button("Éditer");
        Button listeButton = new Button("Afficher la liste");

        // Bouton de retour à l'accueil
        Button retourButton = new Button("Retour à l'accueil");
        retourButton.setOnAction(e -> retourALaccueil());

        // Ajouter les boutons et le bouton de retour à l'accueil à la VBox
        vbox.getChildren().addAll(ajouterButton, supprimerButton, editerButton, listeButton, retourButton);

        // Événements de clic pour chaque bouton
        ajouterButton.setOnAction(e -> ajouterDepartement());
        supprimerButton.setOnAction(e -> supprimerDepartement());
        editerButton.setOnAction(e -> editerDepartement());
        listeButton.setOnAction(e -> afficherListeDepartements());

        Scene scene = new Scene(vbox, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void ajouterDepartement() {
        // Fermez la scène actuelle (page des actions département)
        primaryStage.close();

        // Lancez une nouvelle instance de AjouterDepartement
        AjouterDepartement ajouterDepartement = new AjouterDepartement();
        ajouterDepartement.start(new Stage());
    }

    private void supprimerDepartement() {
        // Fermez la scène actuelle (page des actions département)
        primaryStage.close();

        // Lancez une nouvelle instance de SupprimerDepartement
        SupprimerDepartement supprimerDepartement = new SupprimerDepartement();
        supprimerDepartement.start(new Stage());
    }

    private void editerDepartement() {
        // Fermez la scène actuelle (page des actions département)
        primaryStage.close();

        // Lancez une nouvelle instance de EditDepartement
        EditDepartement editDepartement = new EditDepartement();
        editDepartement.start(new Stage());
    }

    private void afficherListeDepartements() {
        // Fermez la scène actuelle (page des actions département)
        primaryStage.close();

        // Lancez une nouvelle instance de GetAllDepartement
        GetAllDepartement getAllDepartement = new GetAllDepartement();
        getAllDepartement.start(new Stage());
    }

    private void retourALaccueil() {
        // Fermez la scène actuelle (page des actions département)
        primaryStage.close();

        // Lancez une nouvelle instance de MainInterface
        MainInterface mainInterface = new MainInterface();
        mainInterface.start(new Stage());
    }
}
