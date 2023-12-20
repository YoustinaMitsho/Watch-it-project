package mitsho;
import nureen.User;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class WatchLater extends Movie {

    static ArrayList<Movie> WatchedLater=new ArrayList<>();
           // WatchedLater= u.getWatchLaterList();

    /*public static ArrayList<Movie> getWatchedLater() {
        return WatchedLater;
    }*/
/*public WatchLater(int movieId, String movieTitle, int movieDate, int movieTime, String movieLanguage, int IMDB_Score, String movieCountry, String movieBudget, String movieRevenue, int UserRating, String Discription) {
        super(movieId, movieTitle, movieDate, movieTime, movieLanguage, IMDB_Score, movieCountry, movieBudget, movieRevenue, UserRating, Discription);
    }*/

    public WatchLater(boolean watchlater, String which)
    {
        super(watchlater, "watchlater");
    }
    protected static void Addwatchlater(Movie mov,User u){
        boolean flag=false;
        for (Movie WAtch:u.getWatchLaterList()) {
            if(WAtch.getMovieId()==mov.getMovieId()){
                flag=true;
                break;
            }
        }
        if (flag==true){
            System.out.println("already exist ");

        } else if (flag==false) {
            u.getWatchLaterList().add(mov);
            System.out.println("added done");

        }
    }

//we gonne see what wil choose
    /*protected static void AddwatchlaterByname(Movie mov){
        boolean flag=false;
        for (Movie WAtch:WatchedLater) {
            if(WAtch.getMovieId()==mov.getMovieId()){
                flag=true;
                break;
            }
        }
        if (flag==true){
            System.out.println("already exist ");

        } else if (flag==false) {
            WatchedLater.add(mov);
            System.out.println("added done");

        }
    }*/
    protected static void RemoveMovieFromWatchLater(int id,User u){


        for (Movie movie:u.getWatchLaterList() ) {
            if (movie.getMovieId()==id){
                u.getWatchLaterList().remove(movie);
            System.out.println("deleted "+ movie.getMovieTitle() +" successfly");
                break;
            }

        }


    }

    public static void DisplayWatchLater(User userlist){
        for (Movie m:userlist.getWatchLaterList()){
            System.out.println(m.getMovieId() +" "+m.getMovieTitle()+" and discription : "+m.discription);

        }
    }
}
