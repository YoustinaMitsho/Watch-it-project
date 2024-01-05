package Movie_Related;

import java.util.*;

/**
 * class Top10 that inherit t=from movie parent class
 */
public class Top10movies extends Movie  {
    /***
     * look for the top 10 movies by IMDB_score and save them in array
     * @return array that contain the top 10 movies
     */
    public static List<Movie> TopMovies(){
        List<Movie>sorted = new ArrayList<>();
        for (Movie data:MoviesList) {
            sorted.add(data);
        }
        Collections.sort(sorted, Comparator.comparingDouble(Movie::getIMDB_Score).reversed());
        List<Movie> top10Movies = sorted.subList(0, Math.min(sorted.size(), 10));
        return top10Movies;
    }
}
