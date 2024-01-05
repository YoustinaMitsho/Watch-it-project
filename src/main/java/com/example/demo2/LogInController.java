package com.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * controller that controls the log in page
 */
public class LogInController{

    @FXML
    private TextField tf_mail;

    @FXML
    private PasswordField tf_pass;

    Stage stage;
    Parent root;
    boolean flg = false;

    public static String username;

    /**
     * this function checks if email and password are correct
     * @param event
     * @throws IOException
     */
    @FXML
    protected void onLoginButtonClick(ActionEvent event) throws IOException {
        if (tf_mail.getText().isBlank() || tf_pass.getText().isBlank()) {
            System.out.println("The Login fields are required!");

            if (tf_mail.getText().isBlank()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("e-mail");
                alert.setContentText("E-mail is missing");
                alert.showAndWait();
            } else if (tf_pass.getText().isBlank()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("password");
                alert.setContentText("password is missing");
                alert.showAndWait();
            }
        } else {
            for(User u: User.Userslist){
                if(tf_mail.getText().equals(u.email) && tf_pass.getText().equals(Integer.toString(u.password))) {
                    flg = true;
                    username = u.username;
                }
            }
            if(flg){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("log in");
                alert.setContentText("log in successfully");
                alert.showAndWait();
                SwitchToMain(event);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("log in");
                alert.setContentText("log in failed");
                alert.showAndWait();
            }
        }
    }

    /**
     * switching scenes to sign in
     * @param event
     * @throws IOException
     */
    @FXML
    public void UserSignIn(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("SignUp.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        SignUpController signup = loader.getController();
        signup.setStage(stage);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * switching scenes to main page
     * @param event
     * @throws IOException
     */
    @FXML
    public void SwitchToMain(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Main.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        MainScreenController mainScreenController = loader.getController();
        mainScreenController.setStage(stage);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * changing stages
     * @param stage
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
