package com.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
/**
 * profile class the edit page
 */
public class ProfileEditController implements Initializable {

    @FXML
    private Label username;

    @FXML
    private PasswordField new_pass;

    @FXML
    private TextField tf_age;

    @FXML
    private TextField tf_fname;

    @FXML
    private TextField tf_lname;

    @FXML
    private TextField tf_mail;

    @FXML
    private TextField tf_nat;

    @FXML
    private TextField tf_old_pass;

    @FXML
    private TextField tf_username;

    User user;
    /**
     * reading data and saving them into arraylist
     */
    List<User> users = User.Read("oop_prpject_user_data.txt");
    private Stage stage;
    Parent root;

    boolean flg = false;

    public ProfileEditController() throws IOException {
    }
    /**
     * changing stage
     * @param stage
     * @throws Exception
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
        SetUser();
        SetDataInEditProfile(user);
    }
    /**
     * setting username
     */
    @FXML
    public void SetUsername(){
        username.setText(LogInController.username);
    }
    /**
     * setting user
     */
    private void SetUser(){
        for (User u: users){
            if(u.username.equals(LogInController.username)){
                user = u;
            }
        }
    }

    /**
     * setting data in prompt text fields
     * @param u
     */
    private void SetDataInEditProfile(User u){
        tf_fname.setPromptText(u.firstname);
        tf_lname.setPromptText(u.secondname);
        tf_username.setPromptText(u.username);
        tf_age.setPromptText(Integer.toString(u.age));
        tf_mail.setPromptText(u.email);
        tf_nat.setPromptText(u.nationality);
        tf_old_pass.setPromptText(Integer.toString(u.password));
    }

    /**
     * saving changes and checking for data validation
     */
    @FXML
    protected void onSaveButtonClick(){
        if (!tf_fname.getText().isBlank()) {
            user.firstname = tf_fname.getText();
            flg = true;
        } else if (!tf_lname.getText().isBlank()) {
            user.secondname = tf_lname.getText();
            flg = true;
        }else if (!tf_username.getText().isBlank()) {
            user.username = tf_username.getText();
            flg = true;
        }else if (!tf_age.getText().isBlank()) {
            user.age = Integer.parseInt(tf_age.getText());
            flg = true;
        }else if (!tf_mail.getText().isBlank()) {
            user.email = tf_mail.getText();
            flg = true;
        }else if (!tf_nat.getText().isBlank()) {
            user.nationality = tf_nat.getText();
            flg = true;
        }
        if(!tf_old_pass.getText().isBlank() && !new_pass.getText().isBlank()) {
            if (!tf_old_pass.getText().isBlank() && user.getPassword() == Integer.parseInt(tf_old_pass.getText())) {
                if (!new_pass.getText().isBlank()) {
                    user.password = Integer.parseInt(new_pass.getText());
                    flg = true;
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Password");
                    alert.setContentText("New Password isn't provided");
                    alert.showAndWait();
                }
            } else if (tf_old_pass.getText().isBlank() && !new_pass.getText().isBlank()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Password");
                alert.setContentText("Please provide the old password");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Password");
                alert.setContentText("Password provided doesn't match the old one");
                alert.showAndWait();
            }
        }

        if(flg) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Update");
            alert.setContentText("Data updated successfully");
            alert.showAndWait();
            System.out.println(user.password);
        }
    }

    /**
     * switching to subscription
     * @param event
     * @throws IOException
     */
    @FXML
    public void SwitchToSub(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("sub.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        ProfileSubController profileSubController = loader.getController();
        profileSubController.setStage(stage);
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
     * switching to main
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
