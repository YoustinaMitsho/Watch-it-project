package person_based_movies;

public abstract class movie_person {
    public int Age ;
    public String Gender;
    private String Nationality;
     String F_name;

    public String getNationality() {
        return Nationality;
    }

    String L_name;

movie_person(int age, String Gender, String nationality, String f_name, String l_name){
    this.Age=age;
    this.Gender=Gender;
    this.Nationality=nationality;
    this.L_name=l_name;
    this.F_name=f_name;

}

    /**
     * collect data of the movie person
     * @return all data
     */
public String display(){
        return Age+","+Gender+","+getNationality()+","+getF_name()+","+getL_name();


    }
public String getF_name() {
        return F_name;
    }

public String getL_name() {
        return L_name;
    }

}


