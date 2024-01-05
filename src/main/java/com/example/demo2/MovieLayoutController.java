package com.example.demo2;

import com.example.demo2.model.Movie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * movie box template
 */
public class MovieLayoutController {

    @FXML
    private Button watch;

    @FXML
    private ImageView a1;

    @FXML
    private ImageView a2;

    @FXML
    private ImageView a3;

    @FXML
    private ImageView back;

    @FXML
    private ImageView background;

    @FXML
    private Label desc;

    @FXML
    private ImageView dir;

    @FXML
    private ImageView fav;

    @FXML
    private Label name;

    @FXML
    private ImageView poster;

    @FXML
    private ImageView save;

    @FXML
    private Label score;

    @FXML
    private Label time;

    private Stage stage;

    /**
     * setting data to their initial valuess
     * @param movie
     */
    public void setData(Movie movie){
        name.setText(movie.getMovieTitle());

        desc.setText(movie.discription);

        score.setText(Integer.toString(movie.getIMDB_Score()));

        time.setText(Integer.toString(movie.MovieTime) + "Min"); // genre

        Image p = new Image(getClass().getResourceAsStream(movie.getImage_source()));
        poster.setImage(p);

        Image b = new Image(getClass().getResourceAsStream(movie.getBackground()));
        background.setImage(b);

        Image act1 = new Image(getClass().getResourceAsStream(movie.getActor1()));
        a1.setImage(act1);

        Image act2 = new Image(getClass().getResourceAsStream(movie.getActor2()));
        a2.setImage(act2);

        Image act3 = new Image(getClass().getResourceAsStream(movie.getActor3()));
        a3.setImage(act3);

        Image d = new Image(getClass().getResourceAsStream(movie.getDir()));
        dir.setImage(d);
    }

    /**
     * setting stage
     * @param stage
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    /**
     * switching scenes to main
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
     * adding movie to fav
     * @param event
     * @throws IOException
     */
    @FXML
    public void AddToFav(MouseEvent event){
        Movie.is_favourite = true;
        Image f = new Image(getClass().getResourceAsStream("Images/heart (1).png"));
        fav.setImage(f);
    }
    /**
     * adding movie to watch later
     * @param event
     * @throws IOException
     */
    @FXML
    public void AddToWatchLater(MouseEvent event){
        Movie.is_WatchLater = true;
        Image s = new Image(getClass().getResourceAsStream("Images/bookmark (1).png"));
        save.setImage(s);
    }
    /**
     * adding movie to history
     * @param event
     * @throws IOException
     */
    @FXML
    public void Watch(ActionEvent event){
        Movie.is_watched = true;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Watch");
        alert.setContentText("Added to History");
        alert.showAndWait();
    }
}
