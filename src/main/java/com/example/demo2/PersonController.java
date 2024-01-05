package com.example.demo2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class PersonController {
    @FXML
    private Label age;

    @FXML
    private Label name;

    @FXML
    private Label nat;

    @FXML
    private HBox work;

    private Stage stage;

    /**
     * setting data
     * @param person
     */
    public void SetData(movie_person person){
        name.setText(person.F_name + " " + person.L_name);
        age.setText(String.valueOf(person.Age));
        nat.setText(person.Nationality);
    }

    /**
     * changing stage
     * @param stage
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * switching to main
     * @param event
     * @throws IOException
     */
    @FXML
    public void SwitchToMain(MouseEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Main.fxml"));
        Parent root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        MainScreenController mainScreenController = loader.getController();
        mainScreenController.setStage(stage);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
