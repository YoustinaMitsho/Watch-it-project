package mitsho;

import person_based_movies.*;
import person_based_movies.cast;
import person_based_movies.director;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

/**
 * class movies
 */
public class Movie  {
    static ArrayList<Movie> MoviesList = new ArrayList<Movie>();
    private int MovieId;
    private String MovieTitle;
    int MovieDate;
    int MovieTime;
    ArrayList<cast> MovieCast = new ArrayList<cast>();
    ArrayList<director> MovieDirector = new ArrayList<director>();
    String MovieLanguage;
    int IMDB_Score;
    int UserRating;
    String MovieCountry;
    String MovieBudget;
    String MovieRevenue;
    public static boolean is_watched = false;
    public static boolean is_favourite;
    public static boolean is_WatchLater;
    String genera;
    String discription;
    String F1_cast;
    String s1_cast;
    String f2_cast;
    String c2_cast;
    String f3_cast;
    String c3_cast;
    String snameDirector;
    String FnameDirector;

    public Movie(int movieId, String movieTitle, int movieDate, int movieTime, String F1_cast, String s1_cast, String f2_cast, String c2_cast, String f3_cast, String c3_cast, String genera, String FnameDirector, String snameDirector, String movieLanguage, int IMDB_Score, String movieCountry, String movieBudget, String movieRevenue, int UserRating, String Discription) {
        MovieId = movieId;
        this.MovieTitle = movieTitle;
        MovieDate = movieDate;
        MovieTime = movieTime;
        MovieLanguage = movieLanguage;
        this.IMDB_Score = IMDB_Score;
        MovieCountry = movieCountry;
        MovieBudget = movieBudget;
        MovieRevenue = movieRevenue;
        this.UserRating = UserRating;
        this.discription = Discription;
        this.genera = genera;

        this.F1_cast = F1_cast;
        this.s1_cast = s1_cast;

        this.f2_cast = f2_cast;
        this.c2_cast = c2_cast;
        this.f3_cast = f3_cast;
        this.c3_cast = c3_cast;

        for (cast c : MovieCast) {
            c.setCast_name(F1_cast);
            //System.out.println(d.F_name);
        }
        for (cast c : MovieCast) {
            c.setCast_Lastname(s1_cast);
            //System.out.println(d.F_name);
        }
        for (cast c : MovieCast) {
            c.setCast_name(f2_cast);
            //System.out.println(d.F_name);
        }
        for (cast c : MovieCast) {
            c.setCast_Lastname(c2_cast);
            //System.out.println(d.F_name);
        }
        for (cast c : MovieCast) {
            c.setCast_name(f3_cast);
            //System.out.println(d.F_name);
        }
        for (cast c : MovieCast) {
            c.setCast_Lastname(c3_cast);
            //System.out.println(d.F_name);
        }
        for (cast c : MovieCast) {
            c.setCast_name(FnameDirector);
            //System.out.println(d.F_name);
        }

        this.FnameDirector = FnameDirector;
        this.snameDirector = snameDirector;
        for (director d : MovieDirector) {
            d.setDirector_name(FnameDirector);
            //System.out.println(d.F_name);
        }
        for (director d : MovieDirector) {
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
        this.UserRating = userRating;
        this.discription = discription;
    }

    public Movie() {
    }

    /**
     * read file of movies
     *
     * @param Path the path of the file
     * @return array list of movies that contain all data
     * @throws IOException
     */
    public static ArrayList Read(String Path) throws IOException {
        FileReader fileReader = new FileReader(Path);


        try {

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");
                MoviesList.add(new Movie(Integer.parseInt(values[0]), values[1], Integer.parseInt(values[2]), Integer.parseInt(values[3]), values[4], values[5], values[6], values[7], values[8], values[9], values[10], values[11], values[12], values[13], Integer.parseInt(values[14]), values[15], values[16], values[17], Integer.parseInt(values[18]), values[19]));
            }
        } catch (IOException e) {
            System.out.println("file not found");
            e.printStackTrace();
        } finally {
            fileReader.close();
        }
        return MoviesList;
    }

    public int getMovieId() {
        return MovieId;
    }

    public String getGenera() {
        return genera;
    }

    public String getMovieTitle() {
        return MovieTitle;
    }

    public int getIMDB_Score() {
        return IMDB_Score;
    }

    /**
     * @return array of list that contain the data
     */
    public static ArrayList<Movie> getMoviesList() {
        return MoviesList;
    }

    /**
     * @param Is_it boolean set with each array of movies
     * @param which the type of the movies
     */
    public Movie(boolean Is_it, String which) {
        if (which.equals("fav")) {
            this.is_favourite = Is_it;
        } else if (which.equals("watched")) {
            this.is_watched = Is_it;
        } else if (which.equals("watchlater")) {
            this.is_WatchLater = Is_it;
        }
    }

    /***
     * search by movie name in the array of all movies
     * @param MovieName the name of the movie that we search about
     */
    public static void MovieSearch(String MovieName) {
        boolean flagOfSearch = false;
        for (Movie movie : MoviesList) {
            if (MovieName.equals(movie.getMovieTitle())) {
                System.out.println(movie.getMovieTitle() + " " + movie.discription);
                flagOfSearch = true;
            }
        }

        if (flagOfSearch == false) {
            System.out.println("Sorry, This movie isn't found!");
        }
    }

    /***
     * search by genera
     * @param MovieName the genera of the movie
     * @return array list contain movies with specific genera
     */
    public static ArrayList<Movie> ShowMovieGenre(String MovieName) {
        ArrayList<Movie> g = new ArrayList<>();
        for (Movie movie : MoviesList) {
            if (MovieName.equals(movie.genera)) {
                g.add(movie);
            }
        }
        return g;
    }

    /**
     * search by director name  and display its information
     *
     * @param directorFname director first name that we look for
     * @param directorLname director last name that we look for
     */
    public static void MovieSearch_bydirector(String directorFname, String directorLname) {
        boolean flagOfSearch = false;
        for (director director : director.director_list) {
            if (directorFname.equals(director.getF_name()) && directorLname.equals(director.getL_name())) {
                System.out.println("his firstname:" + director.getF_name());
                System.out.println("his lastname:" + director.getL_name());
                System.out.println(" his nationality:" + director.getNationality());
                System.out.println("his director Age" + director.Age);
                for (Movie movie : MoviesList) {
                    if ((directorFname.equals(movie.FnameDirector)) && (directorLname.equals(movie.snameDirector))) {

                        System.out.println("his movie he/she directed: " + movie.getMovieTitle());
                        flagOfSearch = true;

                    }

                }
                if (flagOfSearch == false) {
                    System.out.println(" this director has no movies");
                }
            }

        }
    }

    /***
     * search by actor name and display its information
     * @param ActorFname actor first name that we look for
     * @param ActorLname  actor last name that we look for
     */
    public static void MovieSearch_byActor(String ActorFname, String ActorLname) {
        boolean flag = false;
        for (cast cast : cast.cast_list) {

            if (ActorFname.equals(cast.getF_name()) && ActorLname.equals(cast.getL_name())) {

                System.out.println("his firstname is :" + cast.getF_name());
                System.out.println("his lastname is :" + cast.getL_name());
                System.out.println(" his nationality is :" + cast.getNationality());
                System.out.println("his actor Age is " + cast.Age);
                for (Movie movie : MoviesList) {
                    if (((ActorFname.equals(movie.F1_cast)) && (ActorLname.equals(movie.s1_cast))) || ((ActorFname.equals(movie.f2_cast)) && (ActorLname.equals(movie.c2_cast))) || ((ActorFname.equals(movie.f3_cast)) && (ActorLname.equals(movie.c3_cast)))) {
                        System.out.println("his movie he/she work in  : " + movie.getMovieTitle());
                        flag = true;
                    }

                }
                if (flag == false) {
                    System.out.println("  no movies");
                }
            }

        }
    }

    /***
     * look for the upcoming movies and save them in array
     * @return array that contain the upcoming movies
     */
    public static ArrayList<Movie> UpCommingMovies() {
        ArrayList<Movie> UpCommingMovie = new ArrayList<>();
        for (Movie m : MoviesList) {
            if (m.MovieDate >= 2023) {
                UpCommingMovie.add(m);
            }
        }
        return UpCommingMovie;
    }

    /**
     * write in the file all the updates thah changed
     *
     * @param Path       the path to the file
     * @param Movieswite array list of all movies that contaii all data
     */
    public static void WriteFile(String Path, ArrayList<Movie> Movieswite) {
        try {
            if (Path.equals("OOP_Movies.txt")) {
                String filePath = "OOP_Movies.txt";

                Files.write(Paths.get(filePath), "".getBytes(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);


                Files.write(Paths.get(filePath), "".getBytes(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);

                for (Movie m : Movieswite) {
                    String userData = m.displaymovie();
                    Files.write(Paths.get(filePath), (userData + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);

                }
                System.out.println("Data appended to the file successfully.");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @return all data of all movies
     */
    public String displaymovie() {

        return MovieId + "," + MovieTitle + "," + MovieDate + "," + MovieTime + "," + F1_cast + "," + s1_cast + "," + f2_cast + "," + c2_cast + "," + f3_cast + "," + c3_cast + "," + genera + "," + FnameDirector + "," + snameDirector + "," + MovieLanguage + "," + IMDB_Score + "," + MovieCountry + "," + MovieBudget + "," + MovieRevenue + "," + UserRating + "," + discription;
    }

    /***
     * display id and movie title for all movies
     */
    public static void DisplayAllMovies() {
        for (Movie movie : MoviesList) {

            System.out.println(movie.MovieId + " : " + movie.getMovieTitle());
        }
    }

    /**
     * call the non static function (displaymovie) and display it
     */
    public static void DisplayAllMoviesInfo() {
        for (Movie movie : MoviesList) {

            System.out.println(movie.displaymovie());
        }
    }
    /**
     * write in the file all the updates thah changed
     * @param Path the path to the file
     * @param Movieswite array list of all movies that contaii all data
     */
   /* public void Write(String Path, ArrayList<Movie> Movieswite) throws IOException {
        try {
            if (Path.equals("OOP_Movies.txt")) {
                String filePath = "OOP_Movies.txt";

                Files.write(Paths.get(filePath), "".getBytes(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);


                Files.write(Paths.get(filePath), "".getBytes(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);

                for (Movie m : Movieswite) {
                    String userData = m.displaymovie();
                    Files.write(Paths.get(filePath), (userData + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);

                }
                System.out.println("Data appended to the file successfully.");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    }*/
}
