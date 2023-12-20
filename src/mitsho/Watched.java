package mitsho;

import nureen.User;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class Watched extends Movie{

    static ArrayList<Movie> watchedlist =new ArrayList<>();

    public static ArrayList<Movie> getWatchedlist() {
        return watchedlist;
    }
/* public Watched(int movieId, String movieTitle, int movieDate, int movieTime, String movieLanguage, int IMDB_Score, String movieCountry, String movieBudget, String movieRevenue, int UserRating, String Discription, ArrayList<Movie> watchedlist) {
        super(movieId, movieTitle, movieDate, movieTime, movieLanguage, IMDB_Score, movieCountry, movieBudget, movieRevenue, UserRating, Discription);
        this.watchedlist = watchedlist;
    }*/


    /*public ArrayList<Movie> getarray() {
        return watchedlist;
    }*/

    public Watched(boolean is_watched, String which){
        super(is_watched, "watched");
    }

   /* protected void AddWatched() {
        for (Movie watchedMovie : MoviesList)
            if (is_watched) {
                watchedlist.add(watchedMovie);
            }
    }*/

    public static void DisplayWatched(User usr){
        //watchedlist= User.getAlreadyWatched();
        for (Movie movies:usr.getAlreadyWatched() ){
            System.out.println(movies.displaymovie());
        }
    }
    /*protected static void RemoveMovieFromWatched(String MovieName){
        for (Movie movie: watchedlist) {
            if(movie.equals(MovieName)){
                watchedlist.remove(movie);
            }
        }
    }*/
}
