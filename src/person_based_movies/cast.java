package person_based_movies;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class cast extends movie_person {

  public static ArrayList<cast> cast_list = new ArrayList<cast>();


public cast(int age, String Gender, String nationality, String f_name, String l_name) {
        super(age, Gender, nationality, f_name, l_name);

    }
    /***
     * read the file of actors data
     * @param Path the path to the file
     * @return array list of actors that contain all data
     * @throws IOException
     */
    public  static ArrayList Read(String Path) throws IOException {
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
                cast_list.add(new cast(Integer.parseInt(values[0]), values[1], values[2], values[3], values[4]));
                //return obj;
            }
        } catch (IOException e) {
            System.out.println("file not found");
            // Handle any potential IO exceptions (e.g., file not found)
            e.printStackTrace();
        } finally {
            fileReader.close();
        }
        return cast_list;
    }
    public void setCast_name(String  name) {
        this.F_name=name;
    }

    public void setCast_Lastname(String lastname) {
        this.L_name=lastname;
    }

    /**
     * override from parent class (movie preson) and collect all data
     * @return all data of each actor
     */
    public String display(){
        //int age, String Gender, String nationality, String f_name, String l_name
        return Age+","+Gender+","+getNationality()+","+getF_name()+","+getL_name();


    }

    /**
     * write in the file
     * @param Path to file
     * @param castwite array of all actors with all changes
     */
    public static void WriteFile(String Path,ArrayList<cast> castwite) {
        try {
            if (Path.equals("cast.txt")) {
                String filePath = "cast.txt";

                Files.write(Paths.get(filePath), "".getBytes(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);


                Files.write(Paths.get(filePath), "".getBytes(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);

                for (cast c : castwite) {
                    String userData = c.display();
                    Files.write(Paths.get(filePath), (userData + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);

                }
                System.out.println("Data appended to the file successfully.");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
