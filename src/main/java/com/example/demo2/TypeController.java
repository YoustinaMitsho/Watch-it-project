package com.example.demo2;

import com.example.demo2.model.Movie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

import java.io.IOException;
import java.util.List;

public class TypeController {
    @FXML
    private Label count;

    @FXML
    private Label end;

    @FXML
    private Button renew;

    @FXML
    private Label start;

    @FXML
    private Button upgrade;

    User user;

    List<User> users = User.Read("oop_prpject_user_data.txt");

    public TypeController() throws IOException {
    }
    private void SetUser(){
        for (User u: users){
            if(u.username.equals(LogInController.username)){
                user = u;
            }
        }
    }
    public void setData(Movie movie){

    }

    @FXML
    void SwitchToIntro(ActionEvent event) {}
}
