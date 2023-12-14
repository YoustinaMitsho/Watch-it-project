package mitsho;

import nureen.User;
import person_based_movies.ReadFiles;
import person_based_movies.cast;
import person_based_movies.director;

import java.awt.*;
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

public class Movie implements ReadFiles {
    static ArrayList<Movie> MoviesList = new ArrayList<Movie>();
    public int MovieId;
    public String MovieTitle;
    public int MovieDate;
    public int MovieTime;
    ArrayList<cast> MovieCast = new ArrayList<cast>();   // Cast class to be done later
    ArrayList<Genre> MovieGenre = new ArrayList<Genre>(); // Genre class to be done later
    ArrayList<director> MovieDirector = new ArrayList<director>();  // Director class to be done later
    public String MovieLanguage; // Is it a class like director?
    public int IMDB_Score;
    public int UserRating;
    public String MovieCountry;
    public String  MovieBudget;
    public String  MovieRevenue;
    public static boolean is_watched;
    public static boolean is_favourite;
    public static boolean is_WatchLater;
   // public Image MoviePoster;
    String genera;
    public String discription;

    String F1_cast;
    String s1_cast;
    String f2_cast;
    String c2_cast;
    String f3_cast;
    String c3_cast;
    String snameDirector;
    String FnameDirector;
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

        for (cast c:MovieCast) {
            c.setCast_name(F1_cast);
            //System.out.println(d.F_name);
        }
        for (cast c:MovieCast) {
            c.setCast_Lastname(s1_cast);
            //System.out.println(d.F_name);
        }
        for (cast c:MovieCast) {
            c.setCast_name(f2_cast);
            //System.out.println(d.F_name);
        }
        for (cast c:MovieCast) {
            c.setCast_Lastname(c2_cast);
            //System.out.println(d.F_name);
        }
        for (cast c:MovieCast) {
            c.setCast_name(f3_cast);
            //System.out.println(d.F_name);
        }
        for (cast c:MovieCast) {
            c.setCast_Lastname(c3_cast);
            //System.out.println(d.F_name);
        }
        for (cast c:MovieCast) {
            c.setCast_name(FnameDirector);
            //System.out.println(d.F_name);
        }

        this.FnameDirector=FnameDirector;
        this.snameDirector=snameDirector;
        for (director d:MovieDirector) {
            d.setDirector_name(FnameDirector);
            //System.out.println(d.F_name);
        }
        for (director d:MovieDirector) {
            d.setDirector_lname(snameDirector);
        }


    }

    public Movie(int movieId, String movieTitle, int movieDate, int movieTime, String movieLanguage, int imdbScore, String movieCountry, String movieBudget, String movieRevenue, int userRating, String discription) {
        MovieId = movieId;
        MovieTitle = movieTitle;
        MovieDate = movieDate;
        MovieTime = movieTime;
        MovieLanguage = movieLanguage;
        this.IMDB_Score = imdbScore;
        MovieCountry = movieCountry;
        MovieBudget = movieBudget;
        MovieRevenue = movieRevenue;
        this.UserRating=userRating;
        this.discription=discription;
    }

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

    public String getMovieTitle() {
        return MovieTitle;
    }

    public int getIMDB_Score() {
        return IMDB_Score;
    }

    //public boolean isIs_watched() {
        //return is_watched;
    //}

    public static void MovieSearch(String MovieName) {
        for (Movie movie : MoviesList) {
            if (MovieName.equals(movie.getMovieTitle())) {
                System.out.println(movie.displaymovie());
            }else {
                System.out.println("Sorry, This movie isn't found!");
            }
        }
    }

    // need adjustment
    protected void AddGenre(String MovieName, Genre genre) {
        for (Movie movie : MoviesList) {
            if (MovieName.equals(movie.getMovieTitle())) {
                this.MovieGenre.add(genre);
            }
        }
    }

    public ArrayList<Genre> ShowMovieGenre(String MovieName) {
        for (Movie movie : MoviesList) {
            if (MovieName.equals(movie.getMovieTitle())) {
                return movie.MovieGenre;
            }
        }
        return null;
    }

    // need adjustments
    public void AddCast(cast c) {
        MovieCast.add(c);
    }

    public void AddDirector(director d) {
        MovieDirector.add(d);
    }

    public ArrayList<cast> SearchCastByName(String name) {
        ArrayList<cast> result = new ArrayList<cast>();
        for (cast castData : MovieCast) {
            if (name.equals(castData.F_name)) {
                result.add(castData);
            }
        }
        return result;
    }
   public ArrayList<director> SearchDirectorByName(String name) {
        ArrayList<director> result = new ArrayList<director>();
        for (director DirectorData : MovieDirector) {
            if (name.equals(DirectorData.F_name)) {
                result.add(DirectorData);
            }
        }
        return result;

    }

    public ArrayList<Movie> UpCommingMovies(){
        ArrayList<Movie> UpCommingMovie = new ArrayList<>();
        for (Movie m: MoviesList) {
            if(m.MovieDate > 2023){
                UpCommingMovie.add(m);
            }
        }
        return UpCommingMovie;
    }

    public static List<Movie> TopMovies(){
        Collections.sort(MoviesList, Comparator.comparingDouble(Movie::getIMDB_Score).reversed());
        List<Movie> top10Movies = MoviesList.subList(0, Math.min(MoviesList.size(), 10));
        return top10Movies;
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
