package nureen;
import mitsho.*;
import person_based_movies.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.SplittableRandom;

public class User extends personx {
    int age;
   String subscrebtion_type;
    String nationality;
     ArrayList<Movie> alreadyWatched = new ArrayList<>();
    ArrayList<Integer>IDforalreadyWatched=new ArrayList<Integer>();
     ArrayList<Movie> FavouriteMovies = new ArrayList<>();
    ArrayList<Integer>IDforFAV=new ArrayList<Integer>() ;
     ArrayList<Movie> WatchLaterList = new ArrayList<Movie>();
    ArrayList<Integer>IDforLAter=new ArrayList<Integer>();
   ArrayList<Movie> MoviesList = Movie.getMoviesList();
     int BNoOfMovies=0;//basic 5 movies
     int SNoOfMovies=0;//standerd 10 movies
     int PNoOfMovies=0;//premium 30 movies
     private int mounth;
    public User() {
        super();
    }
    public User(int id, String username, int pass, String Fname, String Lname, String email, int age, String nationality, String subscrebtiontype, int mounth){
        super( id, username,  pass,  Fname,  Lname,  email);
        this.age=age;
        this.nationality=nationality;
        this.subscrebtion_type=subscrebtiontype;
        this.mounth=mounth;

        if (subscrebtion_type.toLowerCase().equals("basic")) {
            //Basic b=new Basic()
            Basic.PlanACounter++;

        } else if (subscrebtion_type.toLowerCase().equals("standard")) {
            Standard.PlanBCounter++;

        } else if (subscrebtion_type.toLowerCase().equals("premium")) {
            Premium.PlanCCounter++;

        }


    }
    public User(int id, String username, int pass, String Fname, String Lname, String email, int age, String nationality, String subscrebtiontype, int mounth,ArrayList<Integer>fav,ArrayList<Integer>Later,ArrayList<Integer>WAtcheedaleardy){
        super( id, username,  pass,  Fname,  Lname,  email);
        this.age=age;
        this.nationality=nationality;
        this.subscrebtion_type=subscrebtiontype;
        this.mounth=mounth;

        if (subscrebtion_type.toLowerCase().equals("basic")) {
            //Basic b=new Basic()
            Basic.PlanACounter++;

        } else if (subscrebtion_type.toLowerCase().equals("standard")) {
            Standard.PlanBCounter++;

        } else if (subscrebtion_type.toLowerCase().equals("premium")) {
            Premium.PlanCCounter++;

        }
        this.IDforFAV=fav;
        this.IDforLAter=Later;
        this.IDforalreadyWatched=WAtcheedaleardy;


                for (Integer inte:Later) {
                    for (Movie m:MoviesList) {
                        if (m.getMovieId() == inte) {

                            WatchLaterList.add(m);
                            break;
                        }
                    }
                }

            for (Integer i:fav) {
                for (Movie m:MoviesList) {
                if (m.getMovieId()==i){
                    FavouriteMovies.add(m);
                    break;
                }
                }
            }

            for (Integer i:WAtcheedaleardy) {
                for (Movie m:MoviesList) {
                if (m.getMovieId()==i){

                    alreadyWatched.add(m);
                    break;
                }
                }
            }

      // this.WatchLaterList=WatchLater.getWatchedLater();
       // this.FavouriteMovies=Favourite.getFavouriteList();
        //this.alreadyWatched=Watched.getWatchedlist();
    }
    public int getMounth() {
        return mounth;
    }
    public ArrayList<Integer> getIDforFAV()
    {
        return IDforFAV;
    }
    public ArrayList<Integer> getIDforLAter() {
        return IDforLAter;
    }
    public ArrayList<Integer> getIDforalreadyWatched() {
        return IDforalreadyWatched;
    }
  /* public int paln(){
        return Basic.PlanACounter();
   }*/
    public void setSubscrebtion_type(String subscrebtion_type) {
        this.subscrebtion_type = subscrebtion_type;
    }

    public String getSubscrebtion_type() {
        return subscrebtion_type;
    }
    static ArrayList<User> Userslist = new ArrayList<User>();

    /***
     * read the file of tha data  of all users
     * @param Path the path to the file
     * @return array list of users that contain the data
     * @throws IOException
     */
public static ArrayList Read(String Path) throws IOException {
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
                /* ArrayList<Integer> watcheddata=new ArrayList<>();
                 */
                ArrayList<Integer> favdataid = new ArrayList<Integer>();
                ArrayList<Integer> LATER = new ArrayList<Integer>();
                ArrayList<Integer> WATCHEDIDS = new ArrayList<Integer>();

                int i = 10;//array of data in files
                // int jforFAV=0;//for array od id of fav movies
                //int jforLATER=0;
                //int jforWATCHEDIDS=0;

                while (!(values[i].equals("&"))) {

                    //favdataid[jforFAV] = Integer.parseInt(values[i]);
                    favdataid.add(Integer.parseInt(values[i]));
                    i++;

                }
                if (values[i].equals("&")) {
                    i++;

                }
                while (!(values[i].equals("$"))) {

                    LATER.add(Integer.parseInt(values[i]));

                    i++;
                }
                if (values[i].equals("$")) {
                    i++;
                }
                while (!(values[i].equals("#"))) {

                    WATCHEDIDS.add(Integer.parseInt(values[i]));

                    i++;
                }
                Userslist.add(new User(Integer.parseInt(values[0]), values[1], Integer.parseInt(values[2]), values[3], values[4], values[5], Integer.parseInt(values[6]), values[7], values[8], Integer.parseInt(values[9]), favdataid, LATER, WATCHEDIDS));

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

    /***
     *  collect all data of this user
     * @return all data ot one user
     */
 public String  displayfile(){

     String data=null;
    for (int i=0;i<getIDforFAV().size();++i) {

        // String = (id+","username, pass,String Fname,String Lname,String email,int age,String nationality,String subscrebtiontype
         data= id + "," + getUsername() + "," + getPassword() + "," + firstname + "," + secondname + "," + getEmail() + "," + age + "," + nationality + "," + subscrebtion_type + "," + mounth + "," +getIDforFAV().get(i);

    }
    return data;
    // return id + "," + getUsername() + "," + getPassword() + "," + firstname + "," + secondname + "," + getEmail() + "," + age + "," + nationality + "," + subscrebtion_type + "," + mounth + ",";
 }

    /***
     * write on the file
     * @param Path the path to the file
     * @param witeuser the array of all users that contain all data and all changes
     */
public static void WriteFile(String Path,ArrayList<User> witeuser) {
        try {
            if (Path.equals("hager.txt")) {
                String filePath = "hager.txt";

                //Files.write(Paths.get(filePath), "".getBytes(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);

               /* for (User u: witeuser) {
                    String userData = u.toString();
                    Files.write(Paths.get(filePath),userData.getBytes(), StandardOpenOption.APPEND);
                    Files.write(Paths.get(filePath), System.lineSeparator().getBytes(), StandardOpenOption.APPEND);
                    System.out.println("Data appended to the file successfully.");
                }*/

                Files.write(Paths.get(filePath), "".getBytes(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);

                for (User u : witeuser) {
                    String userData = u.displayfile();
                    Files.write(Paths.get(filePath), (userData + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);

                }
                System.out.println("Data appended to the file successfully.");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * check the limit of movies by user subscription plan and each plan has a limit of movies
     * @param m the movie that will watched by the user
     * @param wa array list of all movies
     * @param u the user that will watch the movie
     */
public  void checknofmovies(Movie m,ArrayList<Movie> wa,User u) {
    for (Movie data : wa) {

        if (data.getMovieId() == m.getMovieId()) {
            System.out.println("movie already found");
            break;
        } else {
            if (u.getSubscrebtion_type().toLowerCase().equals("basic")) {
                if (wa.size() < 5) {
                    wa.add(m);
                    BNoOfMovies++;
                    System.out.println("added done");
                } else {
                    System.out.println("your limit of movie finished ");
                }

            } else if (u.getSubscrebtion_type().toLowerCase().equals("standard")) {
                if (wa.size() < 10) {
                    wa.add(m);
                    SNoOfMovies++;
                    System.out.println("added done");
                } else {
                    System.out.println("your limit of movie finished ");
                }

            } else if (u.getSubscrebtion_type().toLowerCase().equals("premium")) {
                if (wa.size() < 30) {
                    PNoOfMovies++;
                    wa.add(m);
                    System.out.println("added done");
                } else {
                    System.out.println("your limit of movie finished ");
                }

            }
        }
    }
}


    public  ArrayList<Movie> getFavouriteMovies()
    {
        return this.FavouriteMovies;
    }

    public  ArrayList<Movie> getWatchLaterList() {
        return this.WatchLaterList;
    }

    public  ArrayList<Movie> getAlreadyWatched() {
        return this.alreadyWatched;
    }

}
