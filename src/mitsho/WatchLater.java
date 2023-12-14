package mitsho;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class WatchLater extends Movie {

    static ArrayList<Movie> WatchedLater=new ArrayList<Movie>();

    public WatchLater(int movieId, String movieTitle, int movieDate, int movieTime, String movieLanguage, int IMDB_Score, String movieCountry, String movieBudget, String movieRevenue, int UserRating, String Discription) {
        super(movieId, movieTitle, movieDate, movieTime, movieLanguage, IMDB_Score, movieCountry, movieBudget, movieRevenue, UserRating, Discription);
    }

    public WatchLater(boolean watchlater, String which) {
        super(watchlater, "watchlater");
    }
    protected static void Addwatchlater(){
        for (Movie WatchLaterMovie:MoviesList) {
            if(is_WatchLater){
                WatchedLater.add(WatchLaterMovie);
            }
        }
    }

    protected static void RemoveMovieFromWatchLater(String MovieName){
        for (Movie movie: WatchedLater) {
            if(movie.equals(MovieName)){
                WatchedLater.remove(movie);
            }
        }
    }

    public static void DisplayWatchLater(){
        for (Movie movies:WatchedLater){
            System.out.println(movies.displaymovie());
        }
    }
}
