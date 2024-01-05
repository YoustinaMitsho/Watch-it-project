package com.example.demo2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("intro.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Watch It");
        User.Userslist = User.Read("oop_prpject_user_data.txt");
/*       Image image =new Image("Images/theater.png");
        stage.getIcons().add(image);*/
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}