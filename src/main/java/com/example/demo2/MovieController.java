package com.example.demo2;

import com.example.demo2.model.Movie;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * movie template
 */
public class MovieController {
    @FXML
    private ImageView poster;

    @FXML
    private Label title;
    /**
     * setting data to their initial valuess
     * @param movie
     */
    public void setData(Movie movie){
        Image image = new Image(getClass().getResourceAsStream(movie.getImage_source()));
        poster.setImage(image);

        title.setText(movie.getMovieTitle());

    }

}
