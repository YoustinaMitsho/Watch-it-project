package person_based_movies;

import mitsho.Movie;
import nureen.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class director extends movie_person {

    public static ArrayList<director> director_list = new ArrayList<director>();

    public director(int age, String Gender, String nationality, String f_name, String l_name) {
        super(age, Gender, nationality, f_name, l_name);

    }

    public static ArrayList<director> Read(String Path) throws IOException {
       // SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
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
                //int age, String Gender, String nationality, String f_name, String l_name
                director_list.add(new director(Integer.parseInt(values[0]), values[1], values[2], values[3], values[4]));
                //return obj;
            }
        } catch (IOException e) {
            System.out.println("file not found");
            // Handle any potential IO exceptions (e.g., file not found)
            e.printStackTrace();
        } finally {
            fileReader.close();
        }
        return director_list;
    }

    // file


    public void setDirector_name(String namedi) {
        this.F_name=namedi;
    }
    public void setDirector_lname(String namedi) {
        this.L_name=namedi;
    }


    public String displaydiretor(){
        //int age, String Gender, String nationality, String f_name, String l_name
        return Age+","+Gender+","+getNationality()+","+getF_name()+","+getL_name();


    }
    public static void WriteFile(String Path,ArrayList<director> Directorwite) {
        try {
            if (Path.equals("movie_persion_di.txt")) {
                String filePath = "movie_persion_di.txt";

                Files.write(Paths.get(filePath), "".getBytes(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);


                Files.write(Paths.get(filePath), "".getBytes(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);

                for (director d : Directorwite) {
                    String userData = d.displaydiretor();
                    Files.write(Paths.get(filePath), (userData + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
                    System.out.println("Data appended to the file successfully.");
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
