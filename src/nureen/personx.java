package nureen;

public class personx {
    public int id;
    public String username;
    public int password;
    String firstname;
    String secondname;
    String email;
    static int basic_counter,standard_counter,premium_counter;
    public personx(int id, String username, int pass, String Fname, String Lname, String email) {
        this.id=id;
        this.username = username;
        this.password = pass;
        this.firstname = Fname;
        this.secondname = Lname;
        this.email = email;

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
}