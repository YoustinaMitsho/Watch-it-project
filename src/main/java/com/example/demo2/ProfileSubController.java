package com.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
/**
 * profile class the about page
 */
public class ProfileSubController implements Initializable {


    @FXML
    private Button about;

    @FXML
    private Button edit;

    @FXML
    private Button sub;

    @FXML
    private Label username;


    private Stage stage;
    Parent root;

    /**
     * changing stage
     * @param stage
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    /**
     * overriding Initializable interface
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SetUsername();
    }

    @FXML
    public void SetUsername() {
        username.setText(LogInController.username);
    }

    /**
     * switching to edit page in user
     * @param event
     * @throws IOException
     */
    @FXML
    public void SwitchToEdit(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("user.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        ProfileEditController profileEditController = loader.getController();
        profileEditController.setStage(stage);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * switching to about page
     * @param event
     * @throws IOException
     */
    @FXML
    public void SwitchToAbout(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("about.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        ProfileAboutController profileAboutController = loader.getController();
        profileAboutController.setStage(stage);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * logging out
     * @param event
     * @throws IOException
     */
    @FXML
    public void SwitchToIntro(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("LogIn.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        LogInController login = loader.getController();
        login.setStage(stage);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * switching to main screen
     * @param event
     * @throws IOException
     */
    @FXML
    public void SwitchToMain(MouseEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Main.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        MainScreenController mainScreenController = loader.getController();
        mainScreenController.setStage(stage);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
