package com.example.demo2;

import com.example.demo2.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * controller for intro page
 */
public class StartWatchingController {
    @FXML

    private Stage stage;
    private Scene scene;
    private Parent root;

    /**
     * switching scene to intro page
     * @param event
     * @throws IOException
     */
    @FXML
    public void SwitchToLogInPage(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LogIn.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        root = fxmlLoader.load();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
