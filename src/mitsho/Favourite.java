package mitsho;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class Favourite extends Movie {

    static ArrayList<Movie>FavouriteList=new ArrayList<Movie>();

   // public Favourite(int movieId, String movieTitle, Date movieDate, int movieTime, String movieLanguage, int IMDB_Score, String movieCountry, int movieBudget, int movieRevenue, Image moviePoster, double UserRating, String Discription, ArrayList<Movie> favouriteList) {
        // p(int movieId, String movieTitle, Date movieDate, int movieTime, String F1_cast, String s1_cast, String f2_cast, String c2_cast, String f3_cast, String c3_cast, String genera, String FnameDirector, String snameDirector, String movieLanguage, int IMDB_Score , String  movieCountry, String movieBudget, String movieRevenue, double UserRating, String Discription)

        //super(movieId, movieTitle, movieDate, movieTime, movieLanguage, IMDB_Score, movieCountry, movieBudget, movieRevenue, moviePoster, UserRating, Discription);
       // FavouriteList = favouriteList;
    //}

    public Favourite(boolean fav, String which){
        super(fav, "fav");
    }
    protected static void AddFavouritemovie(){
        for (Movie FavouriteMovie: MoviesList) {
            if(is_favourite){
                FavouriteList.add(FavouriteMovie);
            }
        }
    }

    protected static void RemoveMovieFromFavourite(String MovieName){
        for (Movie movie: FavouriteList) {
            if(movie.equals(MovieName)){
                FavouriteList.remove(movie);
            }
        }
    }

    public static void DisplayFavourite(){
        for (Movie movies: FavouriteList) {
            System.out.println(movies.displaymovie());
        }
    }
}
