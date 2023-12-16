package person_based_movies;

import nureen.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.SplittableRandom;

public class cast extends movie_person implements ReadFiles {

  public static ArrayList<cast> cast_list = new ArrayList<cast>();


    cast(int age, String Gender, String nationality, String f_name, String l_name) {
        super(age, Gender, nationality, f_name, l_name);

    }



    public static ArrayList<cast> Read(String Path) throws IOException {
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
        this.F_name =name;
    }

    public void setCast_Lastname(String lastname) {
        this.L_name=lastname;
    }

    public String displaycast(){
        //int age, String Gender, String nationality, String f_name, String l_name
        return Age+","+Gender+","+Nationality+","+F_name+","+L_name;


    }


    public static void WriteFile(String Path,ArrayList<cast> castwite) {
        try {
            if (Path.equals("movie_persion_ca.txt")) {
                String filePath = "movie_persion_ca.txt";

                Files.write(Paths.get(filePath), "".getBytes(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);


                Files.write(Paths.get(filePath), "".getBytes(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);

                for (cast c : castwite) {
                    String userData = c.displaycast();
                    Files.write(Paths.get(filePath), (userData + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
                    System.out.println("Data appended to the file successfully.");
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
