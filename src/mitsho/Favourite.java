package mitsho;

import nureen.User;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class Favourite extends Movie {


    static ArrayList<Movie>FavouriteList= new ArrayList<>();

    public static ArrayList<Movie> getFavouriteList() {
        return FavouriteList;
    }
// public Favourite(int movieId, String movieTitle, Date movieDate, int movieTime, String movieLanguage, int IMDB_Score, String movieCountry, int movieBudget, int movieRevenue, Image moviePoster, double UserRating, String Discription, ArrayList<Movie> favouriteList) {
        // p(int movieId, String movieTitle, Date movieDate, int movieTime, String F1_cast, String s1_cast, String f2_cast, String c2_cast, String f3_cast, String c3_cast, String genera, String FnameDirector, String snameDirector, String movieLanguage, int IMDB_Score , String  movieCountry, String movieBudget, String movieRevenue, double UserRating, String Discription)

        //super(movieId, movieTitle, movieDate, movieTime, movieLanguage, IMDB_Score, movieCountry, movieBudget, movieRevenue, moviePoster, UserRating, Discription);
       // FavouriteList = favouriteList;
    //}

    public Favourite(boolean fav, String which){

        super(fav, "fav");
    }
    public Favourite(String name){

    }
    /*public Favourite(String name){
        super();
        this.MovieTitle=name;
    }*/
    protected static void AddFavouritemovie(Movie mov,User u){
        boolean flag=false;
        for (Movie FAv:u.getFavouriteMovies()) {
            if(FAv.getMovieId()==mov.getMovieId()){
                flag=true;
                break;
            }
        }
        if (flag==true){
            System.out.println("already exist ");

        } else if (flag==false) {
            u.getFavouriteMovies().add(mov);
            System.out.println("added done");

        }
    }

    protected static void RemoveMovieFromFavourite(int id,User u){
        for (Movie movie: u.getFavouriteMovies()) {
            if (movie.getMovieId()==id){
                u.getFavouriteMovies().remove(movie);
                System.out.println("deleted "+ movie.getMovieTitle() +" successfly");
                break;
            }
            //break;
        }
    }

    public static void DisplayFavourite(User us){
        int i=1;
        for (Movie movies: us.getFavouriteMovies()) {
            System.out.println(movies.getMovieId()+" "+movies.getMovieTitle()+" and "+movies.discription);
            i++;
        }
    }
}
