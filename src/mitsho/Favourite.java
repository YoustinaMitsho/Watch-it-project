package mitsho;

import nureen.User;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

/***
 * class Favourite which inherit from movie parent class
 */
public class Favourite extends Movie {

    /***
     * function that add to user favourite list a movie
     * @param mov object from movie class that will add in the list
     * @param u object from user class who will add movie to his list
     */
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

    /**
     * function that remove a movie from user favourite list
     * @param id the id of the movie that will be removed from favourite
     * @param u object from user class who will remove movie from his list
     */
    protected static void RemoveMovieFromFavourite(int id,User u){
        for (Movie movie: u.getFavouriteMovies()) {
            if (movie.getMovieId()==id){
                u.getFavouriteMovies().remove(movie);
                System.out.println("deleted "+ movie.getMovieTitle() +" successfly");
                break;
            }
            else {
                System.out.println("movie not found");
                break;
            }
            //break;
        }
    }

    /****
     * display the favourite list of the user
     * @param us the user that will display they list
     */
    public static void DisplayFavourite(User us){
        int i=1;
        for (Movie movies: us.getFavouriteMovies()) {
            System.out.println(movies.getMovieId()+" "+movies.getMovieTitle()+" and "+movies.discription);
            i++;
        }
    }
}
