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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * the main screen with the upcomming and recommended movies
 */
public class MainScreenController implements Initializable {


    @FXML
    private HBox upcoming;

    private List<Movie> UpComming;
    private List<Movie> Rec;
    private List<Movie> allmovies;

    @FXML
    private GridPane MovieContainer;


    @FXML
    private Label username;

    Parent root;
    /**
     * reading data into array list
     */
    private List<Movie> movies = Movie.Read("OOP_Movies.txt");
    static Stage stage;

    public MainScreenController() throws IOException {
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
        SetUsername();
        UpComming = new ArrayList<>(UpComming());
        Rec = new ArrayList<>(Recommended());
        allmovies = new ArrayList<>(AllMovies());
        int column = 0;
        int row = 1;
        try{
            /**
             * creating box layout for upcomming movies
             */
           for(Movie movie : UpComming){
               FXMLLoader fxmlLoader = new FXMLLoader();
               fxmlLoader.setLocation(getClass().getResource("card.fxml"));
               HBox cardbox = fxmlLoader.load();
               CardController cardController = fxmlLoader.getController();
               cardController.setData(movie);
               upcoming.getChildren().add(cardbox);
           }
/**
 * creating grid for recommended movies
 */
            for(Movie value : Rec){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Movie.fxml"));
                VBox MovieBox = fxmlLoader.load();
                MovieController movieController = fxmlLoader.getController();
                movieController.setData(value);
                if(column == 8){
                    column = 0;
                    ++row;
                }

                MovieContainer.add(MovieBox, column++, row);
                GridPane.setMargin(MovieBox, new Insets(10));
                MovieBox.setOnMouseClicked(event -> {
                    try {
                        SwitchToMovie(value, event);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * switching scenes to movies
     * @param event
     * @throws IOException
     */
    public static void SwitchToMovie(Movie movie, MouseEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(MainScreenController.class.getResource("MovieLayout.fxml"));
        Parent root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        MovieLayoutController controller=loader.getController();
        controller.setData(movie);
        controller.setStage(stage);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * get username of each user
     */
    @FXML
    public void SetUsername(){
        username.setText(LogInController.username);
    }

    /**
     * adding movies to upcamming movies array
     * @return
     */
    private List<Movie> UpComming(){
        List<Movie> ls = new ArrayList<>();
        Adder(ls, "Barbie");
        Adder(ls, "oppenheimer");
        Adder(ls, "Yolun Açik Olsun");
        Adder(ls, "Kira & el gin");
        Adder(ls, "For zeko");
        Adder(ls, "Beit el roby");
        Adder(ls, "Smile");
        Adder(ls, "Elemental");
        return ls;
    }
    /**
     * adding movies to Recommended movies array
     * @return
     */
    private List<Movie> Recommended() {
        List<Movie> ls = new ArrayList<>();
        for(Movie movie: movies){
            Adder(ls, movie.getMovieTitle());
        }
        return ls;
    }
    /**
     * adding movies to all movies array
     * @return
     */
    private List<Movie> AllMovies() {
        ArrayList<Movie> ls = new ArrayList<>();
        for(Movie movie: movies) {
            Adder(ls, movie.getMovieTitle());
        }
        return ls;
    }
    /**
     * function assign each value in the movie
     * @return
     */
    private List<Movie> Adder(List<Movie> listmovies, String Title){
        Movie movie = new Movie();
        movie.setMovieTitle(Title);
        movie.setImage_source("Posters/" + Title.toLowerCase() + ".jpg");
        movie.setBackground("Background/Barbie.jpg");
        movie.setActor1("Actors/margot robbie.jpg");
        movie.setActor2("Actors/Rayen Renolds.jpg");
        movie.setActor3("Actors/Issa Rae.jpg");
        movie.setDir("Directors/Greta gerwig.jpg");
        for(Movie m : movies){
            if(m.getMovieTitle().equals(Title)){
                movie.discription = m.discription;
                movie.IMDB_Score = m.IMDB_Score;
                movie.MovieTime = m.MovieTime;
            }
        }
        listmovies.add(movie);
        return listmovies;
    }
    /**
     * switching scenes to top movies
     * @param event
     * @throws IOException
     */
    @FXML
    public void SwitchToTop(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Top.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        TopScreenController topScreenController = loader.getController();
        topScreenController.setStage(stage);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * switching scenes to genre movies
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
     * switching scenes to profile
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
    /**
     * switching scenes to search
     * @param event
     * @throws IOException
     */
    @FXML
    public void SwitchToSearch(MouseEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("search.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        SearchController searchController = loader.getController();
        searchController.setStage(stage);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
