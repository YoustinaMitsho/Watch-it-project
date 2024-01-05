package com.example.demo2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

/**
 * user class that inherits from an abstract class
 */
public class User extends personx {
    int age;

    String subscrebtion_type;

    /**
     * constructor for setting data that is read from files
     * @param id
     * @param username
     * @param pass
     * @param Fname
     * @param Lname
     * @param email
     * @param age
     * @param nationality
     * @param subscrebtiontype
     */
    public User(int id, String username, int pass, String Fname, String Lname, String email, int age, String nationality, String subscrebtiontype){
        super( id, username,  pass,  Fname,  Lname,  email);
        this.age=age;
        this.nationality=nationality;
        this.subscrebtion_type=subscrebtiontype;
    }
    String nationality;
    /**
     * reading data and saving them into an array list
     */
    static ArrayList<User> Userslist = new ArrayList<User>();
    public static ArrayList<User> Read(String Path) throws IOException {
        FileReader fileReader = new FileReader(Path);
        try {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");
                Userslist.add(new User(Integer.parseInt(values[0]), values[1], Integer.parseInt(values[2]), values[3], values[4], values[5], Integer.parseInt(values[6]), values[7], values[8]));
            }
        } catch (IOException e) {
            System.out.println("file not found");
            e.printStackTrace();
        } finally {
            fileReader.close();
        }
        return Userslist;
    }

    /**
     * displaying user data
     * @return
     */
    public String  display(){
        return id+","+username+","+password+","+firstname+","+secondname+","+email+","+age+","+nationality+","+subscrebtion_type;
    }

    public static void WriteFile(String Path,ArrayList<User> witeuser) {
        try {
            if (Path.equals("hager.txt")) {
                String filePath = "hager.txt";
                Files.write(Paths.get(filePath), "".getBytes(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
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