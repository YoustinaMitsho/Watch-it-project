package nureen;
import mitsho.*;
import person_based_movies.ReadFiles;
import person_based_movies.cast;
import person_based_movies.director;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class User extends personx implements ReadFiles {
    int age; //3shan offer films related

   String subscrebtion_type;

    public User(int id, String username, int pass, String Fname, String Lname, String email, int age, String nationality, String subscrebtiontype){
        super( id, username,  pass,  Fname,  Lname,  email);
        this.age=age;
        this.nationality=nationality;
        this.subscrebtion_type=subscrebtiontype;
    }
    Subscription subscriptionPlan = new Subscription();
    String nationality;//3shan offer films related
    ArrayList<Watched> alreadyWatched = new ArrayList<>();
    ArrayList<Favourite> FavouriteMovies = new ArrayList<>();
    ArrayList<WatchLater> WatchLaterList = new ArrayList<>();
    ArrayList<Movie> MoviesList = new ArrayList<>();
    ArrayList<cast> MovieCast = new ArrayList<>();

    ArrayList<director> MovieDirector = new ArrayList<>();
    static ArrayList<User> Userslist = new ArrayList<User>();
    public static ArrayList<User> Read(String Path) throws IOException {
        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
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

                Userslist.add(new User(Integer.parseInt(values[0]), values[1], Integer.parseInt(values[2]), values[3], values[4], values[5], Integer.parseInt(values[6]), values[7], values[8]));
                //return obj;
            }
        } catch (IOException e) {
            System.out.println("file not found");
            // Handle any potential IO exceptions (e.g., file not found)
            e.printStackTrace();
        } finally {
            fileReader.close();
        }
        return Userslist;
    }
    public ArrayList<Movie> MovieSearch(String MovieName) {
        ArrayList<Movie> result = new ArrayList<Movie>();
        for (Movie movie : MoviesList) {
            if (MovieName.equals(movie.getMovieTitle())) {
                result.add(movie);
            }
        }
        return result;
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
    void Add_rate(){


    }
 public String  display(){
       // String = (id+","username, pass,String Fname,String Lname,String email,int age,String nationality,String subscrebtiontype
 return id+","+username+","+password+","+firstname+","+secondname+","+email+","+age+","+nationality+","+subscrebtion_type;

 }






     public static void WriteFile(String Path,ArrayList<User> witeuser) {
        try {
            if (Path.equals("hager.txt")) {
                String filePath = "hager.txt";

                Files.write(Paths.get(filePath), "".getBytes(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);

               /* for (User u: witeuser) {
                    String userData = u.toString();
                    Files.write(Paths.get(filePath),userData.getBytes(), StandardOpenOption.APPEND);
                    Files.write(Paths.get(filePath), System.lineSeparator().getBytes(), StandardOpenOption.APPEND);
                    System.out.println("Data appended to the file successfully.");
                }*/

                Files.write(Paths.get(filePath), "".getBytes(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);

                for (User u : witeuser) {
                    String userData = u.display();
                    Files.write(Paths.get(filePath), (userData + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
                    System.out.println("Data appended to the file successfully.");
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
