package controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by 1494778 on 2016-01-20.
 */
public class Controller extends Application {

    @FXML
    private GridPane root;

    @FXML
    private Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        String path = "/vue/Vue_exercice.fxml";
        System.out.print(getClass().getResource(path));
       root = FXMLLoader.load(getClass().getResource(
                path));
        scene = new Scene(root);


        primaryStage.setTitle("Cours multimédia 7- Fabienne Marquis");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
