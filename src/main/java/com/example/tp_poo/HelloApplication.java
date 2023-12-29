package com.example.tp_poo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {


        public static void main(String[] args) {
            Application.launch(args);

        }

        @Override
        public void start(Stage primaryStage) {
            //  Initialize the Stage, groups, and scene
            primaryStage.setTitle("Page Administration");

            Group group1 = new Group();
            Scene scene1 = new Scene(group1, 300, 500);

            Button btn = new Button();
            btn.setLayoutX(100);
            btn.setLayoutY(100);
            btn.setText("Departement ");

            group1.getChildren().add(btn);
            primaryStage.setScene(scene1);
            primaryStage.show();



            Button btn3 = new Button();
            btn3.setLayoutX(100);
            btn3.setLayoutY(140);
            btn3.setText(" Etudiant ");

            group1.getChildren().add(btn3);
            primaryStage.setScene(scene1);
            primaryStage.show();






            Button btn6 = new Button();
            btn6.setLayoutX(100);
            btn6.setLayoutY(180);
            btn6.setText(" Module ");

            group1.getChildren().add(btn6);

            primaryStage.setScene(scene1);
            primaryStage.show();

            Button btn7 = new Button();
            btn7.setLayoutX(100);
            btn7.setLayoutY(220);
            btn7.setText(" Enseignant ");


            group1.getChildren().add(btn7);

            primaryStage.setScene(scene1);
            primaryStage.show();


            Button btn10 = new Button();
            btn10.setLayoutX(100);
            btn10.setLayoutY(260);
            btn10.setText(" Filere ");

            group1.getChildren().add(btn10);

            primaryStage.setScene(scene1);
            primaryStage.show();

        }


    }
