package nureen;

import mitsho.*;
import mitsho.Movie;
import mitsho.Subscription;
import person_based_movies.cast;
import person_based_movies.director;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * the admin that inherit from personx parent class
 */
public class Admin extends personx {

//upcasting
    /***
     * upcasting from sup class to suber class
     */
    //private static personx admin2=  new Admin();
    private static Admin admin;
    Subscription sub = new Subscription();

    //ArrayList<Movie> movies = new ArrayList<Movie>();
    ArrayList<Movie> moviesList = new ArrayList<Movie>();
    ArrayList<String> moviescategory = new ArrayList<String>();///arraylist of categories 3nd youstine
    ArrayList<Movie> MoviesList = new ArrayList<>();
    ArrayList<cast> MovieCast = new ArrayList<>();
   // ArrayList<Genre> MovieGenre = new ArrayList<>();

    ArrayList<director> MovieDirector = new ArrayList<>();

    private Admin(int id, String username, int pass, String Fname, String Lname, String email){
        super(id, username, pass,  Fname,  Lname,  email);

    }
    private Admin(){}

    /***
     * make an instant from admin
     * @return one instant from admin
     */
    public static Admin getInstance() {
        if (admin == null) {
            // If no instance exists, create one
            admin = new Admin(5,"admin",12341234,"admin","admin","admin@admin.com");
        }
        return (Admin) admin;
    }

    public static void DisplayAdminData(){
        System.out.println(admin.id+","+admin.getUsername()+","+admin.getEmail());
    }
   /* public void add_movie(Movie addmovie) {
        MoviesList.add(addmovie);
        System.out.println("movie is added successfully!!");
    }
*/

    /***
     *the admin who can add movies with actors and directors and check if the movie is exist or not
     * @param mov the array that contain all data of all movies
     * @param casts  the array that contain all data of all actors
     * @param directors  the array that contain all data of all directors
     */
   public void  add_movie(ArrayList<Movie> mov,ArrayList<cast>casts,ArrayList<director>directors) {
       Scanner dataofmovie = new Scanner(System.in);


           System.out.print("Movie name:");
       String movie_name = dataofmovie.next();
           for (Movie data:mov) {
               if (movie_name.equals(data.getMovieTitle())) {
                   System.out.println("movie already exists");
                add_movie(mov,casts,directors);

               }
           }

      // System.out.print("Movie name:");
       //movie_name = dataofmovie.nextLine();
       System.out.print("Movie duration: ");
       int movie_dur = dataofmovie.nextInt();
       System.out.print("Movie release date: ");
       int movie_year = dataofmovie.nextInt();
       System.out.print("First actor first name: ");
       String actor1_fn = dataofmovie.next();
       System.out.print("First actor last name: ");
       String actor1_ln = dataofmovie.next();
       boolean iscastfound=false;
       for (cast data:casts) {
           if(actor1_fn.equals(data.getF_name())&&actor1_ln.equals(data.getL_name())){
               System.out.println("actor exists , no need to add its data");
               iscastfound=true;
               break;
           }
       }
       if (iscastfound==false)
       {
           System.out.println("actor not found please enter the data of that actor");
           System.out.println("----------------------------------------------------------------------");
           System.out.print("Add data of the cast !");
           System.out.print("Age:");
           int AgeOfActor=dataofmovie.nextInt();
           System.out.print("gender:");
           String actor_gender=dataofmovie.next();
           System.out.print("Nationality: ");
           String actor_nationality=dataofmovie.next();
           casts.add(new cast(AgeOfActor,actor_gender,actor_nationality,actor1_fn,actor1_ln));
           System.out.println("----------------------------------------------------------------------");
       }

       System.out.println("Second actor first name: ");
       String actor2_fn = dataofmovie.next();
       System.out.println("Second actor last name: ");
       String actor2_ln = dataofmovie.next();
       boolean iscast2found=false;
       for (cast data2:casts) {
           if(actor2_fn.equals(data2.getF_name())&&actor2_ln.equals(data2.getL_name())){
               System.out.println("actor exists , no need to add its data");
               iscast2found=true;
               break;
           }
       }
       if (iscast2found==false)
       {
           System.out.println("----------------------------------------------------------------------");
           System.out.print("Add data of the cast !");
           System.out.print("Age:");
           int AgeOfActor2=dataofmovie.nextInt();
           System.out.print("gender:");
           String actor_gender2=dataofmovie.next();
           System.out.print("Nationality: ");
           String actor_nationality2=dataofmovie.next();
           casts.add(new cast(AgeOfActor2,actor_gender2,actor_nationality2,actor2_fn,actor2_ln));
           System.out.println("----------------------------------------------------------------------");
       }


       System.out.println("Third actor fname: ");
       String actor3_fn = dataofmovie.next();
       System.out.println("Third actor last name: ");
       String actor3_ln = dataofmovie.next();
       boolean iscast3found=false;
       for (cast data3:casts) {
           if(actor3_fn.equals(data3.getF_name())&&actor3_ln.equals(data3.getL_name())){
               System.out.println("actor exists , no need to add its data");
               iscast3found=true;
               break;
           }
       }
       if (iscast3found==false)
       {
           System.out.println("----------------------------------------------------------------------");
           System.out.print("Add data of the cast !");
           System.out.print("Age:");
           int AgeOfActor3=dataofmovie.nextInt();
           System.out.print("gender:");
           String actor_gender3=dataofmovie.next();
           System.out.print("Nationality: ");
           String actor_nationality3=dataofmovie.next();
           casts.add(new cast(AgeOfActor3,actor_gender3,actor_nationality3,actor1_fn,actor1_ln));
           System.out.println("----------------------------------------------------------------------");
       }

       System.out.print("Movie genre");
       String movie_genre = dataofmovie.next();
       System.out.print("Director First name: ");
       String director_fn = dataofmovie.next();
       System.out.print("Director Last name: ");
       String director_ln = dataofmovie.next();
       boolean isdirectorfound=false;
       for (director dataofdi:directors) {
           if(director_fn.equals(dataofdi.getF_name())&&director_ln.equals(dataofdi.getL_name())){
               System.out.println("actor exists , no need to add its data");
               isdirectorfound=true;
               break;
           }
       }
       if (isdirectorfound==false)
       {
           System.out.println("----------------------------------------------------------------------");
           System.out.print("Add data of the director !");
           System.out.print("Age:");
           int AgeOfDirector=dataofmovie.nextInt();
           System.out.print("gender:");
           String director_gender=dataofmovie.next();
           System.out.print("Nationality: ");
           String director_nationality=dataofmovie.next();
           directors.add(new director(AgeOfDirector,director_gender,director_nationality,director_fn,director_ln));
           System.out.println("----------------------------------------------------------------------");
       }

       System.out.print("Movie language: ");
       String movie_lang = dataofmovie.next();
       System.out.print("IMDB score of the movie: ");
       int imdb = dataofmovie.nextInt();
       System.out.print("Country of production: ");
       String country = dataofmovie.next();
       System.out.print("Movie budget:");
       String budget = dataofmovie.next();
       System.out.print("Revenue of the movie: ");
       String revenue = dataofmovie.next();
       System.out.print("Movie description:");
       //m4
       String description = dataofmovie.nextLine();
       Movie MOV = (Movie) mov.get(mov.size() - 1);
       int idnewmovie = mov.getLast().getMovieId() + 1;
       dataofmovie.close();
       int id=mov.size()+1;
       int rate=0;
       mov.add(new Movie(id, movie_name, movie_year, movie_dur, actor1_fn, actor1_ln, actor2_fn, actor2_ln, actor3_fn, actor3_ln, movie_genre, director_fn, director_ln, movie_lang, imdb, country, budget, revenue, rate, description));
       //MoviesList.add(addmovie);
       System.out.println("movie is added successfully!!");
       System.out.println("----------------------------------------------------------------------------------------------------------");

   }

   /* public void  add_movie2(ArrayList<Movie> mov,ArrayList<cast>casts,ArrayList<director>directors) {
        Scanner dataofmovie = new Scanner(System.in);
        String movie_name;
        System.out.print("Movie name:");
        movie_name = dataofmovie.nextLine();
        for (Movie addmovie:mov) {
            if (movie_name.equals(addmovie.getMovieTitle())) {
                System.out.println("movie already exists");
                add_movie2(mov,casts,directors);
            }
        }

        System.out.print("Movie duration: ");
        int movie_dur = dataofmovie.nextInt();
        System.out.print("Movie release date: ");
        int movie_year = dataofmovie.nextInt();
        System.out.print("First actor first name: ");
        String actor1_fn = dataofmovie.next();
        System.out.print("First actor last name: ");
        String actor1_ln = dataofmovie.next();
        for (cast castt:casts) {
            if (actor1_fn.equals(castt.getF_name()) && actor1_ln.equals(castt.getL_name())) {
                System.out.println("actor exists , no need to add its data");
            } else {
                System.out.println("----------------------------------------------------------------------");
                System.out.print("Add data of the cast !");
                System.out.print("Age:");
                int AgeOfActor = dataofmovie.nextInt();
                System.out.print("gender:");
                String actor_gender = dataofmovie.next();
                System.out.print("Nationality: ");
                String actor_nationality = dataofmovie.next();
                casts.add(new cast(AgeOfActor, actor_gender, actor_nationality, actor1_fn, actor1_ln));
                System.out.println("----------------------------------------------------------------------");
            }
        }
        System.out.println("Second actor first name: ");
        String actor2_fn = dataofmovie.next();
        System.out.println("Second actor last name: ");
        String actor2_ln = dataofmovie.next();
        for(cast castt:casts) {
            if (actor2_fn.equals(castt.getF_name()) && actor2_ln.equals(castt.getL_name())) {
                System.out.println("actor exists , no need to add its data");
            } else {
                System.out.println("----------------------------------------------------------------------");
                System.out.print("Add data of the cast !");
                System.out.print("Age:");
                int AgeOfActor2 = dataofmovie.nextInt();
                System.out.print("gender:");
                String actor_gender2 = dataofmovie.next();
                System.out.print("Nationality: ");
                String actor_nationality2 = dataofmovie.next();
                casts.add(new cast(AgeOfActor2, actor_gender2, actor_nationality2, actor2_fn, actor2_ln));
                System.out.println("----------------------------------------------------------------------");
            }
        }
        System.out.println("Third actor fname: ");
        String actor3_fn = dataofmovie.next();
        System.out.println("Third actor last name: ");
        String actor3_ln = dataofmovie.next();
        for(cast castt:casts) {
            if (actor3_fn.equals(castt.F_name) && actor3_ln.equals(castt.L_name)) {
                System.out.println("actor exists , no need to add its data");
            } else {
                System.out.println("----------------------------------------------------------------------");
                System.out.print("Add data of the cast !");
                System.out.print("Age:");
                int AgeOfActor3 = dataofmovie.nextInt();
                System.out.print("gender:");
                String actor_gender3 = dataofmovie.next();
                System.out.print("Nationality: ");
                String actor_nationality3 = dataofmovie.next();
                casts.add(new cast(AgeOfActor3, actor_gender3, actor_nationality3, actor3_fn, actor3_ln));
                System.out.println("----------------------------------------------------------------------");
            }
        }
        System.out.print("Movie genre");
        String movie_genre = dataofmovie.next();
        System.out.print("Director First name: ");
        String director_fn = dataofmovie.next();
        System.out.print("Director Last name: ");
        String director_ln = dataofmovie.next();
        for (director direct:directors) {
            if (director_fn.equals(direct.F_name) && director_ln.equals(direct.L_name)) {
                System.out.println("director exists , no need to add its data");
            } else {
                System.out.println("----------------------------------------------------------------------");
                System.out.print("Add data of the director !");
                System.out.print("Age:");
                int AgeOfDirector = dataofmovie.nextInt();
                System.out.print("gender:");
                String director_gender = dataofmovie.next();
                System.out.print("Nationality: ");
                String director_nationality = dataofmovie.next();
                directors.add(new director(AgeOfDirector, director_gender, director_nationality, director_fn, director_ln));
                System.out.println("----------------------------------------------------------------------");
            }
        }
        System.out.print("Movie language: ");
        String movie_lang = dataofmovie.next();
        System.out.print("IMDB score of the movie: ");
        int imdb = dataofmovie.nextInt();
        System.out.print("Country of production: ");
        String country = dataofmovie.next();
        System.out.print("Movie budget:");
        String budget = dataofmovie.next();
        System.out.print("Revenue of the movie: ");
        String revenue = dataofmovie.next();
        System.out.print("Movie description:");
        String description = dataofmovie.nextLine();
        Movie MOV= (Movie) mov.get(mov.size() - 1);
        int idnewmovie = mov.getLast().MovieId + 1;

        mov.add(new Movie(idnewmovie, movie_name, movie_year, movie_dur, actor1_fn, actor1_ln, actor2_fn, actor2_ln, actor3_fn, actor3_ln, movie_genre, director_fn, director_ln, movie_lang, imdb, country, budget, revenue, addmoviee.UserRating, description));
        //MoviesList.add(addmovie);
        System.out.println("movie is added successfully!!");
        System.out.println("----------------------------------------------------------------------------------------------------------");

    }*/

    /**
     * tha admin who can delete movies
     * @param removedmovie the id of the movie that will be deleted
     * @param movie2 the array that contain all  data of all movies
     */
    public void remove_movie(int removedmovie,ArrayList<Movie>movie2) {
        //ArrayList<String> movies = new ArrayList<String>();///arrayoflist of movies 3nd youstina
        String genera ;
        for (Movie mo:movie2) {
          if (mo.getMovieId()==removedmovie){
              genera=mo.getGenera();
              movie2.remove(mo);
              System.out.println("deleted done ");
              break;
          }
        }
//list of category m4 msta8dm fe ay 4ta
       /* for (Movie mo:movie2) {
            if (mo.genera.equals(genera)){
                moviescategory.remove(mo);
                //movie2.remove(mo);
                System.out.println("deleted done ");
            }
        }*/
        /*for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).equals(removedmovie)) {
                movies.remove(i);
            }
        }*/

        /*ArrayList<String> moviescategory = new ArrayList<String>();///arrayoflist of movies 3nd youstina
        for (int i = 0; i < moviescategory.size(); i++) {
            if (moviescategory.get(i).equals(category)) {
                moviescategory.remove(i);
            }
        }*/
    }

   /* public void AddDirector(director d) {
        MovieDirector.add(d);
    }
    public void AddCast(cast c) {
        MovieCast.add(c);
    }
    public void AddGenre(Genre G) {
        MovieGenre.add(G);
    }*/

    /***
     * display the most subscription plan from three plans we have
     */
    public void displayplannumbers() {
        if (Subscription.PlanACounter > Subscription.PlanBCounter) {
            if (Subscription.PlanACounter > Subscription.PlanCCounter && Subscription.PlanCCounter > Subscription.PlanBCounter) {
                System.out.println("basic    " + Subscription.PlanACounter + " \n" + "  premium     " + Subscription.PlanCCounter + "/n" + "standard     " + Subscription.PlanBCounter);

            } else if (Subscription.PlanACounter > Subscription.PlanCCounter && Subscription.PlanCCounter < Subscription.PlanBCounter) {
                System.out.println("basic    " + Subscription.PlanACounter + " \n" + "standard     " + Subscription.PlanBCounter + "\n" + "  premium     " + Subscription.PlanCCounter);
            }
        }  if (Subscription.PlanBCounter > Subscription.PlanACounter) {
            if (Subscription.PlanBCounter > Subscription.PlanCCounter && Subscription.PlanCCounter > Subscription.PlanACounter) {
                System.out.println("standard" + Subscription.PlanBCounter + "\n" + "premium " + Subscription.PlanCCounter + "\n" + " basic " + Subscription.PlanACounter);
            } else if (Subscription.PlanBCounter > Subscription.PlanCCounter && Subscription.PlanCCounter < Subscription.PlanACounter) {
                System.out.println("standard" + Subscription.PlanBCounter + "\n" + " basic " + Subscription.PlanACounter + "\n" + "premium " + Subscription.PlanCCounter);
            }
        }  if (Subscription.PlanCCounter > Subscription.PlanBCounter) {
            if (Subscription.PlanCCounter > Subscription.PlanACounter && Subscription.PlanACounter > Subscription.PlanBCounter) {
                System.out.println(" premium " + Subscription.PlanCCounter + "\n" + "basic " + Subscription.PlanACounter + "\n" + "standard" + Subscription.PlanBCounter);
            } else if (Subscription.PlanCCounter > Subscription.PlanACounter && Subscription.PlanACounter < Subscription.PlanBCounter) {
                System.out.println("number of user who use premium plan is/are : " + Subscription.PlanCCounter + "\n and " + "number of  user who use Standerd plan is/are : " + Subscription.PlanBCounter + "\n" + " and number of user who use basic plan is/are : " + Subscription.PlanACounter);
            }
        }
    }

    /**
     * collect all revenue of the three plans
     * @return the total revenue
     */
    public   int DisplayRevenu() {
        return sub.CalcRevenu();


    }


}