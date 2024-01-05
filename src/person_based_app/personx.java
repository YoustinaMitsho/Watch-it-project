package person_based_app;

public abstract class personx {

     int id;
     //must be public 34an user w m4 rady
    private String username;
   private   int password;
    String firstname;



    String secondname;
    private String email;
   // static int basic_counter,standard_counter,premium_counter;
    public personx(int id, String username, int pass, String Fname, String Lname, String email) {
        this.id=id;
        this.username = username;
        this.password = pass;
        this.firstname = Fname;
        this.secondname = Lname;
        this.email = email;

    }
 public personx(){

 }
    public int getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

    public int getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}