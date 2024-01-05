package com.example.demo2;

import com.example.demo2.model.Movie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * the top screen with movies rated 8 or higher based on imdb score
 */
public class TopScreenController implements Initializable {


    @FXML
    private HBox top;
    /**
     * reading movie data and saving them to arraylist
     */
    private List<Movie> Top = Movie.Read("OOP_Movies.txt");

    Stage stage;
    Parent root;

    public TopScreenController() throws IOException {
    }
    /**
     * changing stages
     * @param stage
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    /**
     * overriding an interface
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Top = new ArrayList<>(Top());
        try{
            /**
             * showing top movies as movie box layout
             */
           for(Movie movie : Top){
               FXMLLoader fxmlLoader = new FXMLLoader();
               fxmlLoader.setLocation(getClass().getResource("card.fxml"));
               HBox cardbox = fxmlLoader.load();
               CardController cardController = fxmlLoader.getController();
               cardController.setData(movie);
               top.getChildren().add(cardbox);
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * getting which movies to show
     * @return
     */
    private List<Movie> Top(){
        List<Movie> toper = new ArrayList<>();
        Movie movie = new Movie();
        List<Movie> ls = movie.Top(Top);
        for (Movie m : ls){
            Adder(toper , m.getMovieTitle());
        }
        return toper;
    }

    /**
     * adding data for each movie in top movies
     * @param movies
     * @param Title
     * @return
     */
    private List<Movie> Adder(List<Movie> movies, String Title){
        Movie movie = new Movie();
        movie.setMovieTitle(Title);
        movie.setImage_source("Posters/" + Title + ".jpg");
        movies.add(movie);
        return movies;
    }

    /**
     * switching scene to genre page
     * @param event
     * @throws IOException
     */
    @FXML
    public void SwitchToGenre(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Genre.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        GenreScreenController genreScreenController = loader.getController();
        genreScreenController.setStage(stage);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * switching scene to main page
     * @param event
     * @throws IOException
     */
    @FXML
    public void SwitchToDescover(ActionEvent event) throws IOException {
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
     * switching scene to user profile
     * @param event
     * @throws IOException
     */
    @FXML
    public void SwitchToProfile(MouseEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("user.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        ProfileEditController profileEditController = loader.getController();
        profileEditController.setStage(stage);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
