package mitsho;

import nureen.User;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
/**
 * watched class that inherit from movies parent  class
 */
public class Watched extends Movie{
    static ArrayList<Movie> watchedlist =new ArrayList<>();

    public Watched(boolean is_watched, String which){
        super(is_watched, "watched");
    }
    /***
     * display the watched list of the user
     * @param usr the user that will display they list
     */
    public static void DisplayWatched(User usr){
        //watchedlist= User.getAlreadyWatched();
        for (Movie movies:usr.getAlreadyWatched() ){
            System.out.println(movies.displaymovie());
        }
    }
}
