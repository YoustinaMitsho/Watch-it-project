package mitsho;
import nureen.*;
import person_based_movies.*;
import nureen.User;

import java.io.IOException;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String args[]) throws IOException {
        ArrayList<User> user = User.Read("oop_prpject_user_data.txt");
        ArrayList<Movie> movie = Movie.Read("OOP_Movies.txt");
        ArrayList<director> Director = director.Read("movie_persion_di.txt");
        ArrayList<cast> Cast = cast.Read("movie_persion_ca.txt");
        Admin admin = Admin.getInstance();
        //welcome();
        DisplayUserDiscoverPg(user , movie);
        //UserProfile();
    }

    public static void  register(ArrayList<User> user)
    {
        Scanner inputuser= new Scanner(System.in);
        //ArrayList users = new ArrayList();
        int choice_login;
        System.out.println("\"enter 1 for user /n\"+ \"enter 2 for admin\" ");

        choice_login=inputuser.nextInt();
        if (choice_login == 1)
        {
            System.out.println(" WELCOME  USER TO WATCHIT");
            System.out.println("enter your email:");
            String email= inputuser.next();//email
            System.out.println("enter your username:");
            String username= inputuser.next();//username
            System.out.println("enter your password:");
            int password= inputuser.nextInt();//password
            System.out.println("enter your first name:");
            String firstname= inputuser.next();//firstname
            System.out.println("enter your secondname:");
            String lastname= inputuser.next();//secondname
            System.out.println("enter your age");
            int age = inputuser.nextInt();//age
            System.out.println("enter your nationality:");
            String nationality= inputuser.next();//nationality
            System.out.println("enter your subscribtion type:");
            String subscription= inputuser.next();//subscribtion type
            User u = (User) user.get(user.size()-1);
            int idnew = u.id + 1;

            user.add(new User(idnew, username, password, firstname, lastname, email, age, nationality, subscription));
        }
            /*  public User(String username,int password,String Fname,String Lname,String email,int age,String nationality,String subscription){
        super( username,  password,  Fname,  Lname,  email);
        this.age=age;
        this.nationality=nationality;
        this.subscription=subscription;
    }*/
        else if(choice_login==2){
            System.out.println("can't register");

        }
    }
    public static void menu (ArrayList<User> user)
    {
        Scanner inputuser= new Scanner(System.in);
        int choice_enterapp;
        //boolen flag=true;
        while(true){
            System.out.println("enter 1 for registration \n"+ "enter 2 for login" );
            choice_enterapp=inputuser.nextInt();
            if (choice_enterapp == 1)
            {
                System.out.println(" WELCOME TO WATCHIT");
                register(user);
                break;
            } else if (choice_enterapp ==2) {
                System.out.println(" WELCOME TO WATCHIT");
                login (user);
                break;
            }
            else {
                System.out.println(" INVALID CHOICE ");

            }
        }




    }

    public static  personx login (ArrayList<User> user) {
        Scanner inputuser= new Scanner(System.in);
        boolean pass=false;
        boolean flag_of_enter=false;
        System.out.println("enter your email ");
        do {

            String entered_email =inputuser.next();

            for (User u:user) {
                if (entered_email.equals(u.getEmail())) {
                    flag_of_enter = true;
                }
                if (flag_of_enter == true) {
                    do {
                        System.out.println("enter password:");
                        String passwordx = inputuser.next();
                        if (passwordx.equals(u.getPassword())) {
                            System.out.println("welcome");
                            pass = true;
                            return u;
                        } else {
                            System.out.println("invalid pssword and enter again");
                        }
                    } while (pass == false);
                }
                break;
            }
            if(!flag_of_enter){
                System.out.println("invalid email enter again ");
                menu(user);
            }



        }while (flag_of_enter==false);

        return null;
    }

    // welcome msg:
    static void welcome(ArrayList<User> user){
        System.out.println("Welcome to Watch It, where your movie experience is personalized just for you!\n" +
                "Create your Watchlist to never miss a movie you want to see and easily access\n" +
                "your Favorites for instant enjoyment. Our intelligent Recommendations engine\n" +
                "tailors suggestions based on your preferences. Discover the Top 10 trending\n" +
                "movies and explore films by searching through genres, actors, or directors.\n" +
                "Manage your subscription seamlessly while enjoying uninterrupted streaming.\n" +
                " Watch It – where every movie is a curated experience designed for your\n" +
                "entertainment pleasure!");
        System.out.println("----------------------------------------------------------------------------------------");
        menu (user);
           /* int btn;
            System.out.println("1. Log In");
            System.out.println("2. Register");
            Scanner scan = new Scanner(System.in);
            btn = scan.nextInt();
            boolean flag = false;
            do {
                if(btn == 1){
                    System.out.println("log");
                    flag = true;
                } else if (btn == 2) {
                    System.out.println("reg");
                    flag = true;
                }
                else{
                    flag = false;
                    System.out.println("Invalid Input, Try again!");
                    btn = scan.nextInt();
                }
            }while(flag == false);*/
    }
    //Discover page:
    static void DisplayUserDiscoverPg(ArrayList<User> user, ArrayList<Movie> movies){
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Discover Page:");
        System.out.println("1. User Profile");
        System.out.println("2. Search");
        System.out.println("3. Display");
        System.out.println("4.log out");

        int input;
        Scanner scan = new Scanner(System.in);
        input = scan.nextInt();
        if(input == 1){
            UserProfile(movies, user);
        } else if (input == 2) {
            Search(movies, user);
        } else if (input == 3) {
            displayMovies(user, movies);}
//
        else if(input==4)
        {
            menu(user);
        }
        else{
            System.out.println("invalide choice!" );
            DisplayUserDiscoverPg(user, movies);
        }

    }

    //User profile:
    static void UserProfile(ArrayList<Movie> movies, ArrayList<User> user){
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("User profile:");//add f(x) edit user name and password
        System.out.println("1.delete\n2. Add\n3. Show \n4. Back");
        int btn; Scanner scan = new Scanner(System.in); btn = scan.nextInt();
        if(btn == 1){
            System.out.println("1.delete watch later\n2.delete from your favourite\n3. delete watched  \n4. Back");
            int DeleteInput;DeleteInput = scan.nextInt();
            if(DeleteInput==1){
                System.out.println("enter movie you want to delete:");
                String movie=scan.next();
                WatchLater.RemoveMovieFromWatchLater(movie);
            }
            else if(DeleteInput==3){
                System.out.println("enter movie you want to delete:");
                String movie=scan.next();
                Watched.RemoveMovieFromWatched(movie);
            }
            else if(DeleteInput==2){
                System.out.println("enter movie you want to delete:");
                String movie=scan.next();
                Favourite.RemoveMovieFromFavourite(movie );
            }else if (DeleteInput==4){
                UserProfile(movies, user);
            }
        } else if (btn == 2) {
            System.out.println("call add");
            System.out.println("1.add watch later\n2.add to your favourite\n 3. Back");
            int AddInput;AddInput = scan.nextInt();
            if(AddInput==1) {
                System.out.println("enter movie you want to add:");
                Movie.DisplayAllMovies();
                int choice = scan.nextInt();
                for (Movie m: movies) {
                    if(choice == m.MovieId){
                        m.is_WatchLater = true;
                        break;
                    }
                }
                WatchLater.Addwatchlater();
            }
            else if(AddInput==2){
                System.out.println("enter movie you want to add:");
                Movie.DisplayAllMovies();
                int choice = scan.nextInt();
                for (Movie movie: Movie.MoviesList) {
                    if(choice == movie.MovieId){
                        movie.is_favourite = true;
                        break;
                    }
                }
                Favourite.AddFavouritemovie();
            } else if (AddInput==3){
                UserProfile(movies, user);
            }
        } else if (btn == 3) {
            System.out.println("show:");
        }
        else if (btn == 4) {
            DisplayUserDiscoverPg(user, movies);
        } else {
            System.out.println("Invalid Input, Try again!");
            UserProfile(movies, user);
        }
    }

    // Search:
    static void Search(ArrayList<Movie> movies, ArrayList<User> user){
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Search Page:");
        System.out.println("Search by:");
        System.out.println("1. Movie\n2. Actor\n3. Director\n4. Genre\n5. Back");
        int btn; Scanner scan = new Scanner(System.in); btn = scan.nextInt();
        if(btn == 1){
            MovieSearch();
        } else if (btn == 2) {
            System.out.println("call search actor");
        } else if (btn == 3) {
            System.out.println("call search Director");
        } else if (btn == 4) {
            System.out.println("call search genre");
        } else if (btn == 5) {
            DisplayUserDiscoverPg(user, movies);
        } else {
            System.out.println("Invalid Input, Try again!");
            Search(movies, user);
        }
    }

    // Show Movie:  Not Done
   /* static void ShowMovie(Movie movie){
        System.out.println("--------------------------------------------------------------------------");
        //call function read in movie
        System.out.println("1. Watch\n2. Rate\n3. Add to favourite\n4. Add to watch later\n5. show movie genere\n6. Back");
        int input;Scanner scan = new Scanner(System.in); input = scan.nextInt();
        if(input == 1){
            System.out.println("call watch");
        } else if (input == 2) {
            System.out.println("call edit Rate");
        } else if (input == 3) {
            System.out.println("call Add to favourite");
        } else if (input == 4) {
            System.out.println("call watch later");
            WatchLater.DisplayWatchLater();
        } else if (input == 5) {
            System.out.println("call show movie genere");

        } else if (input == 6) {
            DisplayUserDiscoverPg();
        } else {
            System.out.println("Invalid Input, Try again!");
            ShowMovie(movie);
        }
    }*/

    static void MovieSearch(){
        String name;
        Scanner scan = new Scanner(System.in);
        name = scan.nextLine();
        Movie.MovieSearch(name);
    }
    static void displayMovies(ArrayList<User> user, ArrayList<Movie> movies){
        Scanner sc= new Scanner(System.in);
        System.out.println("1. ALL MOVIES");
        System.out.println("2.TOP RATED MOVIES");
        System.out.println("3. RECENT MOVIES");
        System.out.println("4. Back");
        int choose= sc.nextInt();
        if (choose==1){
            Movie.DisplayAllMovies();
        }
        else if(choose==2){
            Movie.TopMovies();
        }
        else if(choose==3) {
            //  Movie.UpCommingMovies();

        }
        else if(choose==4){
            DisplayUserDiscoverPg(user, movies);
        }
    }}