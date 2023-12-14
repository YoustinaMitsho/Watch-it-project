package person_based_movies;


import mitsho.Movie;
import nureen.Admin;
import nureen.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public interface ReadFiles {
   /* public static ArrayList<Object> ReadFile(String Path) {


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


        try {

            // Create a FileReader object to read the file
            FileReader fileReader = new FileReader(Path);
            // Wrap the FileReader with BufferedReader for efficient reading
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            // Read each line from the file
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
                String[] values = line.split(",");
                // Process each valuezz
                //System.out.println(value + " ");
                if (Path.equals("oop_prpject_user_data.txt")) {
                    ArrayList<User> Users = new ArrayList<User>();
                    Users.add(new User(Integer.parseInt(values[0]), values[1], Integer.parseInt(values[2]), values[3], values[4], values[5], Integer.parseInt(values[6]), values[7], values[8]));
                    Object b=(Object) Users;

                   *//* for (User data: Users) {
                        System.out.println(data.display());
                    }*//*

                } else if (Path.equals("movie_persion_di.txt")) {
                    ArrayList<director> directorsdata = new ArrayList<director>();
                    directorsdata.add(new director(Integer.parseInt(values[0]), values[1], values[2], values[3], values[4]));
                } else if (Path.equals("movie_persion_ca.txt")) {
                    ArrayList<cast> castsdata = new ArrayList<cast>();
                    castsdata.add(new cast(Integer.parseInt(values[0]), values[1], values[2], values[3], values[4]));
                } else if (Path.equals("Admin.txt")) {
                    ArrayList<Admin> admindata = new ArrayList<Admin>();
                    admindata.add(new Admin(Integer.parseInt(values[0]), values[1], Integer.parseInt(values[2]), values[3], values[4], values[5]));
                } else if (Path.equals("OOP_Movies.txt")) {
                    ArrayList<Movie> moveidata = new ArrayList<Movie>();
                    try {
                        // Parse the string to obtain a Date object
                        Date date = dateFormat.parse(values[2]);

                        // int movieId0, String movieTitle1, Date movieDate2, int movieTime3,String F_cast4,String s_cast5,String L_cast6,String genera7,String FnameDirector8, String movieLanguage9, int IMDB_Score10 ,String  movieCountry11, String movieBudget12, String movieRevenue13,double UserRating14,String Discription15
                        //public Movie(int movieId, String movieTitle, Date movieDate, int movieTime,String F1_cast,String s1_cast,String f2_cast,String c2_cast,String f3_cast,String c3_cast,String genera,String FnameDirector,String snameDirector,  String movieLanguage, int IMDB_Score ,String  movieCountry, String movieBudget, String movieRevenue,double UserRating,String Discription)
                        moveidata.add(new Movie(Integer.parseInt(values[0]), values[1], date,Integer.parseInt(values[3]), values[4], values[5], values[6], values[7], values[8], values[9], values[10], values[11], values[12], values[13], Integer.parseInt(values[14]), values[15], values[16], values[17], Integer.parseInt(values[18]), values[19]));

                        // Now 'date' contains the parsed date
                        // System.out.println("Parsed Date: " + date);
                    } catch (ParseException e) {
                        e.printStackTrace(); // Handle the parsing exception
                    }
                }
            }

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("file not found");
            // Handle any potential IO exceptions (e.g., file not found)
            e.printStackTrace();
        }


        return null;
    }*/

    //ArrayList<Objects> Read(String Path) ;


}