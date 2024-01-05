package com.example.demo2;

import com.example.demo2.model.Movie;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

/**
 * search controller for searching for a movie or cast or director
 */
public class SearchController implements Initializable {

    /**
     * list for displaying all data
     */
    @FXML
    private ListView<String> listview;

    @FXML
    private TextField search;

    private List<String> movie = new ArrayList<>();
    /**
     * reading data into lists
     */
    private List<Movie> movies = Movie.Read("OOP_Movies.txt");
    private List<cast> casts = cast.Read("cast.txt");
    private List<director> directors = director.Read("director.txt");

    private ObservableList<String> selectedItems = FXCollections.observableArrayList();


    private Stage stage;

    public SearchController() throws IOException {
    }

    /**
     * getting titles that are in list view
     */
    void GetTitles(){
        for(Movie m : movies){
            movie.add(m.getMovieTitle());
        }
        for(cast m : casts){
            movie.add(m.getF_name() + " " + m.getL_name());
        }
        for(director m : directors){
            movie.add(m.getF_name() + " " + m.getL_name());
        }
    }
    @FXML
    void Search(ActionEvent event){
        listview.getItems().clear();
        listview.getItems().addAll(searchList(search.getText(), movie));
    }

    /**
     * setting titles into list view
     * @param searchword the searched value
     * @param movies array that has all values
     * @return
     */
    private List<String> searchList(String searchword, List<String> movies){
        List<String> searchwordsarray = Arrays.asList(searchword.trim().split("\\s+"));
        return movies.stream().filter(input -> {
            return searchwordsarray.stream().allMatch(word ->
                    input.toLowerCase().contains(word.toLowerCase()));
        }).collect(Collectors.toList());
    }
    /**
     * overriding Initializable interface
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GetTitles();
        listview.getItems().addAll(movie);

        listview.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        selectedItems.add(newValue);
                        System.out.println("Selected: " + newValue);
                    }
                });
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

    /**
     * switching stage
     * @param stage
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
