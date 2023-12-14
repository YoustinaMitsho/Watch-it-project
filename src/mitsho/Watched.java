package mitsho;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class Watched extends Movie{

    static ArrayList<Movie> watchedlist =new ArrayList<Movie>();

    public Watched(int movieId, String movieTitle, int movieDate, int movieTime, String movieLanguage, int IMDB_Score, String movieCountry, String movieBudget, String movieRevenue, int UserRating, String Discription, ArrayList<Movie> watchedlist) {
        super(movieId, movieTitle, movieDate, movieTime, movieLanguage, IMDB_Score, movieCountry, movieBudget, movieRevenue, UserRating, Discription);
        this.watchedlist = watchedlist;
    }

    public Watched(boolean is_watched, String which){
        super(is_watched, "watched");
    }

    protected void AddWatched() {
        for (Movie watchedMovie : MoviesList)
            if (is_watched) {
                watchedlist.add(watchedMovie);
            }
    }

    public static void DisplayWatched(){
        for (Movie movies:watchedlist ){
            System.out.println(movies.displaymovie());
        }
    }
    protected static void RemoveMovieFromWatched(String MovieName){
        for (Movie movie: watchedlist) {
            if(movie.equals(MovieName)){
                watchedlist.remove(movie);
            }
        }
    }
}
