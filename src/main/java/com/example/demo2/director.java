package com.example.demo2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
/**
 * cast class that extends from an abstract class called movie person
 */
public class director extends movie_person {
    /**
     * arraylist that saves all the data of casts
     */
    public static ArrayList<director> director_list = new ArrayList<director>();

    /**
     * constructor that takes data from file
     * @param age
     * @param Gender
     * @param nationality
     * @param f_name
     * @param l_name
     */
    director(int age, String Gender, String nationality, String f_name, String l_name) {
        super(age, Gender, nationality, f_name, l_name);

    }

    /**
     * function that reads from files and put these values into director
     * @param Path
     * @return
     * @throws IOException
     */
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

    /**
     * displaying director data
     * @return
     */
    public String displaydiretor(){
        //int age, String Gender, String nationality, String f_name, String l_name
        return Age+","+Gender+","+Nationality+","+F_name+","+L_name;


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
