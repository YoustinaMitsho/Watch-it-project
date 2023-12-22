package mitsho;
import nureen.User;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * watchlater that inherit from movie parent class
 */
public class WatchLater extends Movie {

public WatchLater(boolean watchlater, String which)
    {
        super(watchlater, "watchlater");
    }

    /**
     * add to list of watch later of the user
     * @param mov the movie that will be added to tha list
     * @param u the user that will add to they list
     */
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
    /**
     * remove from watch later list of tha user
     * @param id the id of the spacific movie that will be removed
     * @param u the user that wii remove from his list
     */
protected static void RemoveMovieFromWatchLater(int id,User u){


        for (Movie movie:u.getWatchLaterList() ) {
            if (movie.getMovieId()==id){
                u.getWatchLaterList().remove(movie);
            System.out.println("deleted "+ movie.getMovieTitle() +" successfly");
                break;
            }

        }


    }

    /***
     * display the array of watch later list
     * @param userlist the user that will display his list
     */
public static void DisplayWatchLater(User userlist){
        for (Movie m:userlist.getWatchLaterList()){
            System.out.println(m.getMovieId() +" "+m.getMovieTitle()+" and discription : "+m.discription);

        }
    }
}
