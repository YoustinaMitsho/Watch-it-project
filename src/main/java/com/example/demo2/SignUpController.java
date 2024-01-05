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

/**
 * controller for sign up page
 */
public class SignUpController {
    @FXML
    private Button Login;

    @FXML
    private Button SignUpBtn;

    @FXML
    private TextField tf_Sign_usrname;

    @FXML
    private TextField tf_age;

    @FXML
    private TextField tf_fname;

    @FXML
    private TextField tf_lname;

    @FXML
    private TextField tf_nationality;

    @FXML
    private TextField tf_sign_mail;

    @FXML
    private PasswordField tf_sign_pass;

    @FXML
    private TextField tf_sub;

    Stage stage;
    Parent root;

    /**
     * adding all data to user file after checking on some validations
     */
    @FXML
    protected void onSignUpButtonClick() {

        if (tf_Sign_usrname.getText().isBlank() || tf_sign_mail.getText().isBlank() || tf_sign_pass.getText().isBlank() || tf_sub.getText().isBlank() || tf_age.getText().isBlank() || tf_fname.getText().isBlank() ||tf_lname.getText().isBlank() || tf_nationality.getText().isBlank()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("password");
            alert.setContentText("Please fill in all fields!");
            alert.showAndWait();

            if (tf_Sign_usrname.getText().isBlank()) {
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("password");
                alert1.setContentText("password is missing");
                alert1.showAndWait();
            } else if (tf_sign_mail.getText().isBlank()) {
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("password");
                alert1.setContentText("password is missing");
                alert1.showAndWait();
            } else if (tf_sign_pass.getText().isBlank()) {
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("password");
                alert1.setContentText("password is missing");
                alert1.showAndWait();
            } else if (tf_sub.getText().isBlank()) {
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("password");
                alert1.setContentText("password is missing");
                alert1.showAndWait();
            }else if (tf_age.getText().isBlank()) {
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("password");
                alert1.setContentText("password is missing");
                alert1.showAndWait();
            }else if (tf_fname.getText().isBlank()) {
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("password");
                alert1.setContentText("password is missing");
                alert1.showAndWait();
            }
            else if (tf_lname.getText().isBlank()) {
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("password");
                alert1.setContentText("password is missing");
                alert1.showAndWait();
            }
            else if (tf_nationality.getText().isBlank()) {
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("password");
                alert1.setContentText("password is missing");
                alert1.showAndWait();
            }
        } else {
            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("password");
            alert1.setContentText("valid");
            alert1.showAndWait();
            User u = (User) User.Userslist.get(User.Userslist.size() - 1);
            int idnew = u.id + 1;
            User.Userslist.add(new User(idnew, tf_Sign_usrname.getText(),Integer.parseInt(tf_sign_pass.getText()), tf_fname.getText(), tf_lname.getText(), tf_sign_mail.getText(), Integer.parseInt(tf_age.getText()), tf_nationality.getText(), tf_sub.getText()));
        }
    }

    /**
     * switching scene to log in page
     * @param event
     * @throws IOException
     */
    @FXML
    protected void onLogInBtnClicked(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("LogIn.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        LogInController login = loader.getController();
        login.setStage(stage);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
