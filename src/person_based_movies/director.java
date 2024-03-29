package person_based_movies;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class director extends movie_person {

    public static ArrayList<director> director_list = new ArrayList<director>();

    public director(int age, String Gender, String nationality, String f_name, String l_name) {
        super(age, Gender, nationality, f_name, l_name);

    }
    /***
     * read the file of directors data
     * @param Path the path to the file
     * @return array list of directors that contain all data
     * @throws IOException
     */
public static ArrayList Read(String Path) throws IOException {

        FileReader fileReader = new FileReader(Path);


        try {

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {

                String[] values = line.split(",");

                director_list.add(new director(Integer.parseInt(values[0]), values[1], values[2], values[3], values[4]));

            }
        } catch (IOException e) {
            System.out.println("file not found");

            e.printStackTrace();
        } finally {
            fileReader.close();
        }
        return director_list;
    }
    public void setDirector_name(String namedi) {
        this.F_name=namedi;
    }
    public void setDirector_lname(String namedi) {
        this.L_name=namedi;
    }
    /**
     * override from parent class (movie preson) and collect all data
     * @return all data of each actor
     */
    public String display(){

        return Age+","+Gender+","+getNationality()+","+getF_name()+","+getL_name();


    }

    /**
     * write in the file
     * @param Path to file
     * @param Directorwite array of all directors with all changes
     */
    public static void WriteFile(String Path,ArrayList<director> Directorwite) {
        try {
            if (Path.equals("director.txt")) {
                String filePath = "director.txt";

                Files.write(Paths.get(filePath), "".getBytes(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);


                Files.write(Paths.get(filePath), "".getBytes(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);

                for (director d : Directorwite) {
                    String userData = d.display();
                    Files.write(Paths.get(filePath), (userData + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);

                }
                System.out.println("Data appended to the file successfully.");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
