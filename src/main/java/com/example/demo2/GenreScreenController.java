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
 * controller to control genre screen showing genres and each movies they have
 */
public class GenreScreenController implements Initializable {

    @FXML
    private GridPane animation;

    @FXML
    private GridPane comedy;

    @FXML
    private GridPane drama;

    @FXML
    private GridPane fantasy;

    @FXML
    private GridPane horror;
    @FXML
    private GridPane mystery;

    @FXML
    private GridPane romance;
    private List<Movie> Comedy;
    private List<Movie> Fantasy;
    private List<Movie> Romance;
    private List<Movie> Drama;
    private List<Movie> Horror;
    private List<Movie> Mystery;
    private List<Movie> Animation;
    /**
     * reading data into array list
     */
    private List<Movie> genre = Movie.Read("OOP_Movies.txt");
    Stage stage;
    Parent root;

    public GenreScreenController() throws IOException {
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
        Comedy = new ArrayList<>(getComedy());
        Fantasy = new ArrayList<>(getFantasy());
        Romance = new ArrayList<>(getRomance());
        Drama = new ArrayList<>(getDrama());
        Horror = new ArrayList<>(getHorror());
        Mystery = new ArrayList<>(getMystery());
        Animation = new ArrayList<>(getAnimation());
        int column = 0;
        int row = 1;
        try{
            /**
             * creating card layout for fantasy genre
             */
            for(Movie value : Fantasy){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Movie.fxml"));
                VBox MovieBox = fxmlLoader.load();
                MovieController movieController = fxmlLoader.getController();
                movieController.setData(value);

                if(column == 8){
                    column = 0;
                    ++row;
                }

                fantasy.add(MovieBox, column++, row);
                GridPane.setMargin(MovieBox, new Insets(10));
            }
            column = 0;
            row = 1;
            /**
             * creating card layout for comedy genre
             */
            for(Movie value : Comedy){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Movie.fxml"));
                VBox MovieBox = fxmlLoader.load();
                MovieController movieController = fxmlLoader.getController();
                movieController.setData(value);

                if(column == 8){
                    column = 0;
                    ++row;
                }

                comedy.add(MovieBox, column++, row);
                GridPane.setMargin(MovieBox, new Insets(10));
            }
            column = 0;
            row = 1;
            /**
             * creating card layout for animation genre
             */
            for(Movie value : Animation){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Movie.fxml"));
                VBox MovieBox = fxmlLoader.load();
                MovieController movieController = fxmlLoader.getController();
                movieController.setData(value);

                if(column == 8){
                    column = 0;
                    ++row;
                }

                animation.add(MovieBox, column++, row);
                GridPane.setMargin(MovieBox, new Insets(10));
            }
            column = 0;
            row = 1;
            /**
             * creating card layout for horror genre
             */
            for(Movie value : Horror){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Movie.fxml"));
                VBox MovieBox = fxmlLoader.load();
                MovieController movieController = fxmlLoader.getController();
                movieController.setData(value);

                if(column == 8){
                    column = 0;
                    ++row;
                }

                horror.add(MovieBox, column++, row);
                GridPane.setMargin(MovieBox, new Insets(10));
            }
            column = 0;
            row = 1;
            /**
             * creating card layout for darama genre
             */
            for(Movie value : Drama){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Movie.fxml"));
                VBox MovieBox = fxmlLoader.load();
                MovieController movieController = fxmlLoader.getController();
                movieController.setData(value);

                if(column == 8){
                    column = 0;
                    ++row;
                }


                drama.add(MovieBox, column++, row);
                GridPane.setMargin(MovieBox, new Insets(10));
            }
            column = 0;
            row = 1;
            /**
             * creating card layout for mystery genre
             */
            for(Movie value : Mystery){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Movie.fxml"));
                VBox MovieBox = fxmlLoader.load();
                MovieController movieController = fxmlLoader.getController();
                movieController.setData(value);

                if(column == 8){
                    column = 0;
                    ++row;
                }

                mystery.add(MovieBox, column++, row);
                GridPane.setMargin(MovieBox, new Insets(10));
            }
            column = 0;
            row = 1;
            /**
             * creating card layout for romance genre
             */
            for(Movie value : Romance){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Movie.fxml"));
                VBox MovieBox = fxmlLoader.load();
                MovieController movieController = fxmlLoader.getController();
                movieController.setData(value);

                if(column == 8){
                    column = 0;
                    ++row;
                }

                romance.add(MovieBox, column++, row);
                GridPane.setMargin(MovieBox, new Insets(10));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * function gets the movie that has this genre
     * @return
     */
    private List<Movie> getFantasy(){
        List<Movie> gen = new ArrayList<>();
        Movie movie = new Movie();
        List<Movie> ls = movie.GenreDecider(genre, "fantasy");
        for (Movie m : ls){
            Adder(gen , m.getMovieTitle());
        }
        return gen;
    }
    /**
     * function gets the movie that has this genre
     * @return
     */
    private List<Movie> getComedy(){
        List<Movie> gen = new ArrayList<>();
        Movie movie = new Movie();
        List<Movie> ls = movie.GenreDecider(genre, "comedy");
        for (Movie m : ls){
            Adder(gen , m.getMovieTitle());
        }
        return gen;
    }
    /**
     * function gets the movie that has this genre
     * @return
     */
    private List<Movie> getDrama(){
        List<Movie> gen = new ArrayList<>();
        Movie movie = new Movie();
        List<Movie> ls = movie.GenreDecider(genre, "drama");
        for (Movie m : ls){
            Adder(gen , m.getMovieTitle());
        }
        return gen;
    }
    /**
     * function gets the movie that has this genre
     * @return
     */
    private List<Movie> getHorror(){
        List<Movie> gen = new ArrayList<>();
        Movie movie = new Movie();
        List<Movie> ls = movie.GenreDecider(genre, "horror");
        for (Movie m : ls){
            Adder(gen , m.getMovieTitle());
        }
        return gen;
    }
    /**
     * function gets the movie that has this genre
     * @return
     */
    private List<Movie> getMystery(){
        List<Movie> gen = new ArrayList<>();
        Movie movie = new Movie();
        List<Movie> ls = movie.GenreDecider(genre, "mystery");
        for (Movie m : ls){
            Adder(gen , m.getMovieTitle());
        }
        return gen;
    }
    /**
     * function gets the movie that has this genre
     * @return
     */
    private List<Movie> getAnimation(){
        List<Movie> gen = new ArrayList<>();
        Movie movie = new Movie();
        List<Movie> ls = movie.GenreDecider(genre, "romance");
        for (Movie m : ls){
            Adder(gen , m.getMovieTitle());
        }
        return gen;
    }
    /**
     * function gets the movie that has this genre
     * @return
     */
    private List<Movie> getRomance(){
        List<Movie> gen = new ArrayList<>();
        Movie movie = new Movie();
        List<Movie> ls = movie.GenreDecider(genre, "romance");
        for (Movie m : ls){
            Adder(gen , m.getMovieTitle());
        }
        return gen;
    }
    /**
     * function assign each value in the movie
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
     * switching scenes to top rated movies
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
     * switching scenes to discover movies
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
     * switching scenes to user profile movies
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
