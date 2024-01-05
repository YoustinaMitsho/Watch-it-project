package com.example.demo2;

import com.example.demo2.model.Movie;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * movie card template
 */
public class CardController {
    @FXML
    private ImageView Poster;

    @FXML
    private Label Title;

    @FXML
    private HBox box;

    private String colour = "3f3b5c";

    /**
     * setting data to their initial valuess
     * @param movie
     */
    public void setData(Movie movie){
        Image image = new Image(getClass().getResourceAsStream(movie.getImage_source()));
        Poster.setImage(image);

        Title.setText(movie.getMovieTitle());
        box.setStyle("-fx-background-color: #3f3b5c;" +
                " -fx-background-radius: 15;" +
                "-fx-effect: dropShadow(three-pass-box, rgba(0,0,0,0.1),10,0,0,10);");
    }

}
