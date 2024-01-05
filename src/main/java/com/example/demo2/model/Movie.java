package com.example.demo2.model;

import com.example.demo2.MainScreenController;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.List;

/**
 * Movie Class that has all attributes
 */
public class Movie{
    /**
     * arraylist that saves all the data of movies
     */
    static ArrayList<Movie> MoviesList = new ArrayList<Movie>();
    public int MovieId;
    private String MovieTitle;
    public int MovieDate;
    public int MovieTime;
    public String MovieLanguage;
    public int IMDB_Score;
    public int UserRating;
    public String MovieCountry;
    public String  MovieBudget;
    public String  MovieRevenue;
    /**
     * these booleans is for adding a movie to watch later or favourites or history
     */
    public static boolean is_watched;
    public static boolean is_favourite;
    public static boolean is_WatchLater;
    // public Image MoviePoster;
    public String genera;
    public String discription;

    private String Image_source;

    private String Actor1;
    private String Actor2;
    private String Actor3;
    private String dir;
    private String background;

    /**
     * adding all values of casts and directors to their lists in their classes
     */
    public String F1_cast;
    public String s1_cast;
    public String f2_cast;
    public String c2_cast;
    public String f3_cast;
    public String c3_cast;
    public String snameDirector;
    public String FnameDirector;

    private static MouseEvent event;

    /**
     * empty constructor for creating temporary instances in gui
     */
    public Movie(){
    }

    /**
     * constructor that takes data from file
     * @param movieId
     * @param movieTitle
     * @param movieDate
     * @param movieTime
     * @param F1_cast
     * @param s1_cast
     * @param f2_cast
     * @param c2_cast
     * @param f3_cast
     * @param c3_cast
     * @param genera
     * @param FnameDirector
     * @param snameDirector
     * @param movieLanguage
     * @param IMDB_Score
     * @param movieCountry
     * @param movieBudget
     * @param movieRevenue
     * @param UserRating
     * @param Discription
     */
    public Movie(int movieId, String movieTitle, int movieDate, int movieTime, String F1_cast, String s1_cast, String f2_cast, String c2_cast, String f3_cast, String c3_cast, String genera, String FnameDirector, String snameDirector, String movieLanguage, int IMDB_Score , String  movieCountry, String movieBudget, String movieRevenue, int UserRating, String Discription) {
        MovieId = movieId;
        MovieTitle = movieTitle;
        MovieDate = movieDate;
        MovieTime = movieTime;
        MovieLanguage = movieLanguage;
        this.IMDB_Score = IMDB_Score;
        MovieCountry = movieCountry;
        MovieBudget = movieBudget;
        MovieRevenue = movieRevenue;
        this.UserRating=UserRating;
        this.discription=Discription;
        this.genera=genera;

        this.F1_cast=F1_cast;
        this.s1_cast=s1_cast;

        this.f2_cast=f2_cast;
        this.c2_cast=c2_cast;
        this.f3_cast=f3_cast;
        this.c3_cast=c3_cast;

        this.FnameDirector=FnameDirector;
        this.snameDirector=snameDirector;


    }

    /**
     * constructor for checking on lists
     * @param Is_it value
     * @param which which lists
     */
    public Movie(boolean Is_it, String which){
        if(which.equals("fav")){
            this.is_favourite = Is_it;
        } else if (which.equals("watched")) {
            this.is_watched = Is_it;
        }
        else if (which.equals("watchlater")){
            this.is_WatchLater = Is_it;
        }
    }

    public String getImage_source() {
        return Image_source;
    }

    public void setImage_source(String image_source) {
        Image_source = image_source;
    }

    public void setActor1(String actor1) {
        Actor1 = actor1;
    }

    public void setActor2(String actor2) {
        Actor2 = actor2;
    }

    public void setActor3(String actor3) {
        Actor3 = actor3;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getActor1() {
        return Actor1;
    }

    public String getActor2() {
        return Actor2;
    }

    public String getActor3() {
        return Actor3;
    }

    public String getDir() {
        return dir;
    }

    public String getBackground() {
        return background;
    }

    public void setMovieTitle(String movieTitle) {
        MovieTitle = movieTitle;
    }

    /**
     * function that reads from files and put these values into Movieslist
     * @param Path
     * @return
     * @throws IOException
     */
    public static ArrayList<Movie> Read(String Path) throws IOException {

        // Create a FileReader object to read the file
        FileReader fileReader = new FileReader(Path);


        try {
            // Wrap the FileReader with BufferedReader for efficient reading
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            // Read each line from the file
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
                String[] values = line.split(",");
                // Process each valuezz
                //System.out.println(value + " ");

                // Parse the string to obtain a Date object

                // int movieId0, String movieTitle1, Date movieDate2, int movieTime3,String F_cast4,String s_cast5,String L_cast6,String genera7,String FnameDirector8, String movieLanguage9, int IMDB_Score10 ,String  movieCountry11, String movieBudget12, String movieRevenue13,double UserRating14,String Discription15
                //public Movie(int movieId, String movieTitle, Date movieDate, int movieTime,String F1_cast,String s1_cast,String f2_cast,String c2_cast,String f3_cast,String c3_cast,String genera,String FnameDirector,String snameDirector,  String movieLanguage, int IMDB_Score ,String  movieCountry, String movieBudget, String movieRevenue,double UserRating,String Discription)
                MoviesList.add(new Movie(Integer.parseInt(values[0]), values[1], Integer.parseInt(values[2]), Integer.parseInt(values[3]), values[4], values[5], values[6], values[7], values[8], values[9], values[10], values[11], values[12], values[13], Integer.parseInt(values[14]), values[15], values[16], values[17], Integer.parseInt(values[18]), values[19]));

                // Now 'date' contains the parsed date
                // System.out.println("Parsed Date: " + date);

            }
        } catch (IOException e) {
            System.out.println("file not found");
            // Handle any potential IO exceptions (e.g., file not found)
            e.printStackTrace();
        } finally {
            fileReader.close();
        }
        return MoviesList;
    }
    public String getMovieTitle() {
        return MovieTitle;
    }

    public int getIMDB_Score() {
        return IMDB_Score;
    }

    /**
     * show movies that has imdb score higher than 8
     * @param Movies
     * @return
     */
    public ArrayList<Movie> Top(List<Movie> Movies){
        ArrayList<Movie> top = new ArrayList<>();
        for (Movie m: Movies) {
            if(m.IMDB_Score >= 8){
                top.add(m);
            }
        }
        return top;
    }

    /**
     * check if this movie belong to a specific genre or not
     * @param Movies
     * @param genre
     * @return
     */
    public ArrayList<Movie> GenreDecider(List<Movie> Movies, String genre){
        ArrayList<Movie> genres = new ArrayList<>();
        for (Movie m: Movies) {
            if(m.genera.toLowerCase().contains(genre.toLowerCase())){
                genres.add(m);
            }
        }
        return genres;
    }

    public static void WriteFile(String Path,ArrayList<Movie> Movieswite) {
        try {
            if (Path.equals("hager.txt")) {
                String filePath = "hager.txt";

                Files.write(Paths.get(filePath), "".getBytes(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);


                Files.write(Paths.get(filePath), "".getBytes(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);

                for (Movie m : Movieswite) {
                    String userData = m.displaymovie();
                    Files.write(Paths.get(filePath), (userData + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
                    System.out.println("Data appended to the file successfully.");
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * displaying movie data
     * @return
     */
    public String displaymovie(){

        // int movieId, String movieTitle, Date movieDate, int movieTime,String F_cast,String s_cast,String L_cast,String genera,String FnameDirector, String movieLanguage, int IMDB_Score ,String  movieCountry, String movieBudget, String movieRevenue,double UserRating,String Discription)
        //public Movie(int movieId, String movieTitle, Date movieDate, int movieTime,String F1_cast,String s1_cast,String f2_cast,String c2_cast,String f3_cast,String c3_cast,String genera,String FnameDirector,String snameDirector,  String movieLanguage, int IMDB_Score ,String  movieCountry, String movieBudget, String movieRevenue,double UserRating,String Discription)
        return MovieId+","+getMovieTitle()+","+MovieDate+","+MovieTime+","+F1_cast+","+s1_cast+","+f2_cast+","+ c2_cast+","+f3_cast+","+ c3_cast+"," +genera+","+FnameDirector+","+snameDirector+","+MovieLanguage+","+IMDB_Score+","+MovieCountry+","+MovieBudget+","+MovieRevenue+","+UserRating+","+discription;
    }
    public static void DisplayAllMovies(){
        for (Movie movie:MoviesList) {
            System.out.println(movie.displaymovie());
        }
    }
}
