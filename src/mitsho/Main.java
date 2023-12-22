package mitsho;
import com.sun.jdi.VMCannotBeModifiedException;
import nureen.*;
import person_based_movies.*;
import nureen.User;

import java.io.CharArrayReader;
import java.io.IOException;
import java.security.spec.RSAOtherPrimeInfo;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    /**
     *the main function which read all files in it and start our program
     * @param args array of string tha can take value before program work
     * @throws IOException
     */
public static void main(String args[]) throws IOException {

        ArrayList<Movie> movie = Movie.Read("OOP_Movies.txt");
        ArrayList<User> user = User.Read("oop_prpject_user_data.txt");
        ArrayList<director> Director = director.Read("director.txt");
        ArrayList<cast>Cast = cast.Read("cast.txt");
        Admin admin = Admin.getInstance();
        welcome(user, movie,admin,Director,Cast);

    }
    /***
     * closed program and save all changes
     * @param user the array list of all users we have
     * @param movie the array list of all movies we have
     * @param Director the array list of all directors pf movies we have
     * @param Cast the array list of all actors in all movies we have
     */
public static void closeprogram(ArrayList<User> user, ArrayList<Movie> movie, ArrayList<director> Director, ArrayList<cast> Cast){
        Movie.WriteFile("OOP_Movies.txt",movie);
        User.WriteFile("hager.txt",user);
        director.WriteFile("director.txt",Director);
        cast.WriteFile("cast.txt",Cast);
        System.out.println("closed program done");
    }
    /***
     * register the user to the program
     * @param user the array list of all users we have
     * @param movies the array list of all movies we have
     * @param admin one admin we have
     * @param di the array list of all directors pf movies we have
     * @param ca the array list of all actors in all movies we have
     */
public static void  register(ArrayList<User> user, ArrayList<Movie> movies,Admin admin,ArrayList<director>di,ArrayList<cast>ca) throws IOException {
        Scanner inputuser = new Scanner(System.in);
        String email;
        while (true) {
            System.out.println("enter your email:");
            email = inputuser.next();//email
            if (email.matches("^[a-zA-Z0-9_+&-]+(?:\\.[a-zA-Z0-9_+&-]+)*@(gmail\\.com|yahoo\\.com)$"))
            {
                for (User datauser:user) {
                    if (email.equals(datauser.getEmail())){
                        System.out.println("email was found before :) ");
                        register(user,movies,admin,di,ca);
                    }

                }
                break;
            } else {
                System.out.println("invalid email.make use to add \"@gmail.com\"or \"@yahoo.com\"");
            }
        }
        System.out.println("enter your username:");
        String username = inputuser.next();//username
        int password;
    while (true) {
        try {
            System.out.println("Enter integer password");
            password = inputuser.nextInt();
            String inputString = Integer.toString(password);
            if (inputString.length() >= 8 && inputString.length() <= 16) {
                break;
            } else {
                System.out.println("Invalid input length. It should be between 8 and 16.");
            }
        } catch (InputMismatchException e) {
            inputuser.next();
            System.out.println("Invalid input. Please enter an integer.");
        }
    }

        String firstname;
        while (true) {
            System.out.println("enter your first name:");
            firstname = inputuser.next();//secondname
            if (firstname.matches("^[a-zA-z]+$")) {
                break;
            } else {
                System.out.println("invalid name, please enter letters only");
            }
        }
        String lastname;
        while (true) {
            System.out.println("enter your last name:");
            lastname = inputuser.next();//secondname
            if (lastname.matches("^[a-zA-z]+$")) {
                break;
            } else {
                System.out.println("invalid name, please enter letters only");
            }
        }
        int age;
        while (true) {
            System.out.print("Enter an integer age: ");
            if (inputuser.hasNextInt()) {
                age = inputuser.nextInt();
                break;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                inputuser.next();
            }
        }
        String nationality;
        while (true) {
            System.out.println("enter your nationality:");
            nationality = inputuser.next();
            if (nationality.matches("^[a-zA-z]+$")) {
                break;
            } else {
                System.out.println("invalid nationality, please enter letters only");
            }
        }
        String subscription;
        while (true) {
            System.out.println("enter your subscribtion type: (basic or standard or premium )");
            subscription = inputuser.next();
            if (subscription.toLowerCase().equals("basic") || subscription.toLowerCase().equals("standard") || subscription.toLowerCase().equals("premium")) {

                break;
            } else {
                System.out.println("invalid choice");

            }
        }
        int month;
        while (true) {
            System.out.print("Enter current month: ");
            month = inputuser.nextInt();
            if (month>0&&month<13){
                System.out.println("month added");
                System.out.println("registration suceesful! welcome");
                break;

            }
             else {
                System.out.println("Invalid input");

            }
        }

        User u = (User) user.get(user.size() - 1);
        int idnew = u.getId() + 1;

        user.add(new User(idnew, username, password, firstname, lastname, email, age, nationality, subscription.toLowerCase(),month));
        login(user, movies,admin,di,ca);
    }
    /***
     *display to the user to choose register or login
     * @param user the array list of all users we have
     * @param movies the array list of all movies we have
     * @param admin the only admin we have
     * @param di the array list of all directors pf movies we have
     * @param ca the array list of all actors in all movies we have
     */
public static void menu (ArrayList<User> user, ArrayList<Movie> movies,Admin admin,ArrayList<director>di,ArrayList<cast>ca) throws IOException {
        Scanner inputuser= new Scanner(System.in);
        int choice_enterapp;
        while(true){
            System.out.println("enter 1 for registration \n"+ "enter 2 for login \n enter 3 for close the program " );
            choice_enterapp=inputuser.nextInt();
            if (choice_enterapp == 1)
            {
                System.out.println("WELCOME TO WATCHIT");
                register(user, movies,admin,di,ca);
                break;
            } else if (choice_enterapp ==2) {
                int enter;
                System.out.println("WELCOME TO WATCHIT");
                System.out.println("enter 1 for login as admin \n"+ "enter 2 for login as user");
                enter=inputuser.nextInt();
                if (enter==1){
                    login_admin(movies, admin, user,di,ca);
                }else if (enter==2){
                login (user, movies,admin,di,ca);
                break;
            }
           else {
                    System.out.println("invalid input");
                }
            }
            else if (choice_enterapp==3) {
                closeprogram(user,movies,di,ca);
              break;
            }
            else {
                System.out.println("INVALID CHOICE ");

            }
        }
    }
    /***
     *log in the user to the program and check if user register first or not
     * @param user the array list of all users we have
     * @param movies the array list of all movies we have
     * @param admin the only admin we have
     * @param di the array list of all directors pf movies we have
     * @param ca the array list of all actors in all movies we have
     */
public static  void login (ArrayList<User> user, ArrayList<Movie> movies,Admin admin,ArrayList<director>di,ArrayList<cast>ca) throws IOException {
        System.out.println("-----------");
        System.out.println("Welcome to Login:");
        Scanner inputuser= new Scanner(System.in);
        boolean pass=false;
        boolean flag_of_enter=false;
        System.out.println("enter your email ");
        String entered_email =inputuser.next();
        User userLogIn = null;
        do {
            for (User u:user) {
                if (entered_email.equals(u.getEmail())) {
                    flag_of_enter = true;
                }
                if (flag_of_enter == true) {
                    do {
                        System.out.println("enter password:");
                        int passwordx = inputuser.nextInt();
                        if (passwordx == u.getPassword()) {
                            System.out.println("welcome");
                            pass = true;
                            userLogIn = u;
                        } else {
                            System.out.println("invalid password, enter again");
                        }
                    } while (pass == false);
                }
                if(flag_of_enter && pass) break;
            }
        }while (flag_of_enter && !pass);
        if(!flag_of_enter){
            System.out.println("invalid email enter again ");
            menu(user, movies,admin ,di,ca);
        }
        if(pass){
            DisplayUserDiscoverPg(userLogIn, movies, user,admin,di,ca);
        }
    }
    /***
     *log in admin
     * @param movies the array list of all movies we have
     * @param admin the only admin we have
     * @param user the array list of all users we have
     * @param di the array list of all directors pf movies we have
     * @param ca the array list of all actors in all movies we have
     */
public static  void login_admin (ArrayList<Movie>movies,Admin admin,ArrayList<User> user,ArrayList<director>di,ArrayList<cast>ca) throws IOException {
        System.out.println("-----------");
        System.out.println("Welcome to Login:");
        Scanner inputadmin= new Scanner(System.in);
        System.out.println("enter your email ");
        String entered_email =inputadmin.next();
        int entered_pass;
        if(entered_email.equals(admin.getEmail()))
        {
            do{
            System.out.println("enter password");
            entered_pass= inputadmin.nextInt();
            if(entered_pass==admin.getPassword())
            {
                AdminProfile(user,movies,admin,di,ca);
                break;
            }
            else {
                System.out.println("incorrect password!!");
            }
        }while(entered_pass==admin.getPassword());
        }
        else {
            System.out.println("invalide");
        }
    }

    /***
     * the admin page and show its functionality
     * @param movies the array list of all movies we have
     * @param admin the only admin we have
     * @param user the array list of all users we have
     * @param di the array list of all directors pf movies we have
     * @param ca the array list of all actors in all movies we have
     */
static void AdminProfile(ArrayList<User> user,ArrayList<Movie> movies,Admin admin,ArrayList<director>di,ArrayList<cast>ca) throws IOException {
        Scanner inputAdmin = new Scanner(System.in);
        System.out.println("1-edit move info \n2-display the most subscribed plan\n3-display all movie data\n4-display month had the most revenue\n5-back");
        int admin_choice = inputAdmin.nextInt();
        if(  admin_choice == 1){
            EditedMovie(user,movies,admin,di,ca);
        }
        else if ( admin_choice == 2) {
            admin.displayplannumbers();
        }
        else if ( admin_choice == 3) {
            for (Movie modata:movies) {
                System.out.println(modata.displaymovie());
            }
        }
        else if( admin_choice ==4)
        {
            int maxmonth=0;
            int max =0;
            for ( int i = 1; i < 13; i++) {
                int res=0;
                for (User u : user) {
                    if (u.getMounth() == i) {
                        res += Subscription.ReturnRevenu(u.getSubscrebtion_type());
                    }
                }
                if(res>max){
                    max=res;
                    maxmonth=i;
                }
            }

            System.out.println("Most Revenue Month is " + maxmonth);
            int x=admin.DisplayRevenu();
            System.out.println("the total revenue is :"+x);
        }
        else if( admin_choice ==5){
            menu(user,movies,admin,di,ca);
        }


        else{
            System.out.println("invalid choice!" );

        }
        AdminProfile( user, movies, admin,di,ca);

    }

    /***
     *the welcome page tp witch it
     * @param movies the array list of all movies we have
     * @param admin the only admin we have
     * @param user the array list of all users we have
     * @param di the array list of all directors pf movies we have
     * @param ca the array list of all actors in all movies we have
     */
static void welcome(ArrayList<User> user, ArrayList<Movie> movies,Admin admin,ArrayList<director>di,ArrayList<cast>ca) throws IOException {
        System.out.println("Welcome to Watch It, where your movie experience is personalized just for you!\n" +
                "Create your Watchlist to never miss a movie you want to see and easily access\n" +
                "your Favorites for instant enjoyment. Our intelligent Recommendations engine\n" +
                "tailors suggestions based on your preferences. Discover the Top 10 trending\n" +
                "movies and explore films by searching through genres, actors, or directors.\n" +
                "Manage your subscription seamlessly while enjoying uninterrupted streaming.\n" +
                " Watch It – where every movie is a curated experience designed for your\n" +
                "entertainment pleasure!");
        System.out.println("----------------------------------------------------------------------------------------");
        menu (user, movies,admin,di,ca);
    }
    //Discover page:
    /***
     * the user page and its functionality
     * @param user an instant of users class
     * @param movies the array list of all movies we have
     * @param admin the only admin we have
     * @param users the array list of all users we have
     * @param di the array list of all directors pf movies we have
     * @param ca the array list of all actors in all movies we have
     */
static void DisplayUserDiscoverPg(User user, ArrayList<Movie> movies, ArrayList<User> users,Admin admin,ArrayList<director>di,ArrayList<cast>ca) throws IOException {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Discover Page:");
        System.out.println("1. User Profile");
        System.out.println("2. Search");
        System.out.println("3. Display");
        System.out.println("4. watch movies");
        System.out.println("5. to add rating to movie");
        System.out.println("6. log out");

        int input;
        Scanner scan = new Scanner(System.in);
        input = scan.nextInt();
        if(input == 1){
            UserProfile(movies, user, users,admin,di,ca);
        }
        else if (input == 2) {
            Search(movies, user, users,admin,di,ca);
        }
        else if (input == 3) {
            displayMovies(user, movies, users,admin,di,ca);
        }
        else if (input==4) {
            int wantedd;
            for (Movie Mo:movies) {
                System.out.println(Mo.displaymovie());
            }
            System.out.println("What movie id you want to watch ? ");
            wantedd=scan.nextInt();
            boolean f=false;
            for (Movie movid:movies) {
                if (movid.getMovieId()==wantedd&& ! movid.is_watched){
                    user.checknofmovies(movid,user.getAlreadyWatched(),user);
                    f= true;
                    break;
                }
            }
            if (f==true){
                DisplayUserDiscoverPg(user, movies, users,admin,di,ca);
            }
            else {
                System.out.println("movie not found");
                DisplayUserDiscoverPg(user, movies, users,admin,di,ca);
            }

        }
        else if (input==5) {
            int idrate;
            int rate;
            for (Movie m:movies) {
                System.out.println( m.displaymovie());
            }
            System.out.println("which  movie id you want to rate ?:");
            idrate=scan.nextInt();
            while (idrate>movies.size()) {
                System.out.println("invalid choice ");
                System.out.println("which  movie id you want to rate ?:");
                idrate=scan.nextInt();
            }
            System.out.println("enter rating between 1:10 ");
            rate=scan.nextInt();
            while (rate>10) {
                System.out.println("invalid rate ");
                System.out.println("enter rating between 1:10");
                rate=scan.nextInt();
            }
            addtare(movies,idrate,rate);
            DisplayUserDiscoverPg(user, movies, users,admin,di,ca);
        } else if(input==6)
        {
            menu(users, movies,admin,di,ca);
        }
        else{
            System.out.println("invalid choice!" );
            DisplayUserDiscoverPg(user, movies, users,admin,di,ca);
        }


    }

    /***
     * the user profile, its information, lists of movies and edit  this information
     * @param user an instant of users class
     * @param movies the array list of all movies we have
     * @param admin the only admin we have
     * @param users the array list of all users we have
     * @param di the array list of all directors pf movies we have
     * @param ca the array list of all actors in all movies we have
     */
static void UserProfile(ArrayList<Movie> movies, User user, ArrayList<User>users,Admin admin,ArrayList<director>di,ArrayList<cast>ca) throws IOException {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("User profile:");
        System.out.println("user id :"+ user.getId()+"\n username :"+user.getUsername()+"\n user email : "+user.getEmail()+"\nuser subscrebtion type : "+user.getSubscrebtion_type());
        System.out.println("1.delete movies \n2.Add movie to catagory \n3.Show movie\n4:edit personal information \n5.Back ");
        int btn;
        Scanner scan = new Scanner(System.in);
        btn = scan.nextInt();
        if(btn == 1){
            System.out.println("1.delete watch later\n2.delete from your favourite\n3. Back");
            int DeleteInput;
            DeleteInput = scan.nextInt();
            if(DeleteInput==1){
                WatchLater.DisplayWatchLater(user);
                if(user.getWatchLaterList().size()==0){
                    System.out.println("no movie to delet");
                    UserProfile(movies, user, users,admin,di,ca);
                }
                else{
                System.out.println("enterthe id of  movie you want to delete:");
                int x =scan.nextInt();
                WatchLater.RemoveMovieFromWatchLater(x,user);
                    UserProfile(movies, user, users,admin,di,ca);
            }
            }
            else if(DeleteInput==2){
                Favourite.DisplayFavourite(user);
                if(user.getFavouriteMovies().size()==0){
                    System.out.println("no movie to delet");
                    UserProfile(movies, user, users,admin,di,ca);
                }
                else{
                System.out.println("enter id of  movie you want to delete:");
                int movie;
                movie=scan.nextInt();
                Favourite.RemoveMovieFromFavourite(movie,user );
                    UserProfile(movies, user, users,admin,di,ca);
            }
            }
             else if (DeleteInput==3){
                UserProfile(movies, user, users,admin,di,ca);
            }
        }
        else if (btn == 2) {
            System.out.println("call add");
            System.out.println("1.add watch later\n2.add to your favourite\n 3. Back");
            int AddInput;AddInput = scan.nextInt();
            if(AddInput==1) {
                Movie.DisplayAllMovies();
                System.out.println("enter movie id you want to add:");
                int choice = scan.nextInt();
                for (Movie m: movies) {
                    if(choice == m.getMovieId()){
                        m.is_WatchLater = true;
                        WatchLater.Addwatchlater(m,user);
                        break;
                    }
                }
                UserProfile(movies, user, users,admin,di,ca);
            }
            else if(AddInput==2){
                Movie.DisplayAllMovies();
                System.out.println("enter number of movie you want to add:");
                int choice = scan.nextInt();
                for (Movie movie: Movie.MoviesList) {
                    if(choice == movie.getMovieId()){
                        movie.is_favourite = true;
                        Favourite.AddFavouritemovie(movie,user);
                        break;
                    }
                }
                UserProfile(movies, user, users,admin,di,ca);
            }
            else if (AddInput==3){
                UserProfile(movies, user, users,admin,di,ca);
            }
            UserProfile(movies, user, users,admin,di,ca);
        }
        else if (btn == 3) {
            System.out.println("show:");
            System.out.println("1.Display watch later\n2.Display to your favourite\n 3. Display watched\n 4.back ");
            int input= scan.nextInt();
            if (input==1) {
                System.out.println("watch later");
                WatchLater.DisplayWatchLater(user);
                UserProfile(movies, user, users,admin,di,ca);
            }
            else if (input==2){
                System.out.println("Display to your favourite");
                Favourite.DisplayFavourite(user );
                UserProfile(movies, user, users,admin,di,ca);
            }else if (input==3){
                System.out.println("Display watched");
                Watched.DisplayWatched(user);
                UserProfile(movies, user, users,admin,di,ca);
            }else if (input==4){
                System.out.println("back");
                UserProfile(movies, user, users,admin,di,ca);
            }
        } else if (btn == 4) {
            int choofinfo;
            System.out.println("user id :"+ user.getId()+"\n 1:username :"+user.getUsername()+"\n2: user email : "+user.getEmail()+"\n3:user subscrebtion type : "+user.getSubscrebtion_type()+"\n 4: back");
            System.out.println("what number you want to edit ?");
            choofinfo=scan.nextInt();
            if (choofinfo==1){
                System.out.println("enter new username");
                String Newusername=scan.next();
                user.setUsername(Newusername);
                UserProfile(movies, user, users,admin,di,ca);
            }
            else if (choofinfo==2){
                changeemail(user,users,movies,admin,di,ca);
                UserProfile(movies, user, users,admin,di,ca);
                }

            else if (choofinfo==3){
                    System.out.println("enter your subscribtion type: (basic or standard or premium )");
                    String Newsubscrebtion = scan.next();
                    if (Newsubscrebtion.toLowerCase().equals("basic") || Newsubscrebtion.toLowerCase().equals("standard") || Newsubscrebtion.toLowerCase().equals("premium")) {
                        user.setSubscrebtion_type(Newsubscrebtion);
                        UserProfile(movies, user, users,admin,di,ca);
                    } else {
                        System.out.println("invalid choice");
                        UserProfile(movies, user, users,admin,di,ca);

                    }
            }
            else if (choofinfo==4) {
                UserProfile(movies, user, users, admin, di, ca);
            }
        }
        else if (btn == 5) {
            DisplayUserDiscoverPg(user,movies, users,admin,di,ca);
        } else {
            System.out.println("Invalid Input, Try again!");
            UserProfile(movies, user, users,admin,di,ca);
        }
    }

    /***
     * the search page that can search by name of movie, actor,director or genera
     * @param user an instant of users class
     * @param movies the array list of all movies we have
     * @param admin the only admin we have
     * @param users the array list of all users we have
     * @param di the array list of all directors pf movies we have
     * @param ca the array list of all actors in all movies we have
     */
static void Search(ArrayList<Movie> movies, User user, ArrayList<User> users,Admin admin,ArrayList<director>di,ArrayList<cast>ca) throws IOException {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Search Page:");
        System.out.println("Search by:");
        System.out.println("1. Movie\n2. Actor\n3. Director\n4. Genre\n5. Back");
        int btn; Scanner scan = new Scanner(System.in); btn = scan.nextInt();
        if(btn == 1){
            MovieSearch();
            Search(movies, user, users,admin,di,ca);
        } else if (btn == 2) {
            System.out.println("call search actor");
            System.out.println("enter the first  name of actor you search for:");
            String ActorFname= scan.next();
            System.out.println("enter the second name of actor you search for:");
            String ActorLname= scan.next();
            Movie.MovieSearch_byActor( ActorFname, ActorLname);
            Search(movies, user, users,admin,di,ca);
        } else if (btn == 3) {
            System.out.println("call search Director");
            System.out.println("enter the first  name of director you search for:");
            String directorfname= scan.next();
            System.out.println("enter the second name of director you search for:");
            String directorlname= scan.next();
            Movie.MovieSearch_bydirector(directorfname,directorlname);
            Search(movies, user, users,admin,di,ca);
        } else if (btn == 4) {
            int i=1;
            System.out.println("enter genre:");
            String genre = scan.next();
            ArrayList<Movie> moveganara=Movie.ShowMovieGenre(genre);
            for (Movie data:moveganara) {
                System.out.println(i+data.getMovieTitle()+" and its discription : "+data.discription);
                ++i;
            }
            Search(movies, user, users,admin,di,ca);
        } else if (btn == 5) {
            DisplayUserDiscoverPg(user, movies, users,admin,di,ca);
        } else {
            System.out.println("Invalid Input, Try again!");
            Search(movies, user, users,admin,di,ca);
        }
    }
    /**
     * take name of movie from user
     */
static void MovieSearch(){
        String name;
        Scanner scan = new Scanner(System.in);
        System.out.println("enter your movie name ");
        name = scan.nextLine();
        Movie.MovieSearch(name);
    }
    /***
     * display page which can display all movies,top ratede or upcoming movies
     * @param user an instant of users class
     * @param movies the array list of all movies we have
     * @param admin the only admin we have
     * @param users the array list of all users we have
     * @param di the array list of all directors pf movies we have
     * @param ca the array list of all actors in all movies we have
     */
static void displayMovies(User user, ArrayList<Movie> movies, ArrayList<User> users,Admin admin,ArrayList<director>di,ArrayList<cast>ca) throws IOException {
        Scanner sc= new Scanner(System.in);
        System.out.println("1.ALL MOVIES");
        System.out.println("2.TOP RATED MOVIES");
        System.out.println("3.RECENT MOVIES");
        System.out.println("4.Back");
        int choose= sc.nextInt();
        if (choose==1){
            Movie.DisplayAllMoviesInfo();
            displayMovies(user, movies, users,admin,di,ca);
        }
        else if(choose==2){

           List<Movie>m =Top10movies.TopMovies();
            int i=1;
            for (Movie mo:m) {
                System.out.println(i+" : "+mo.getMovieTitle());
                ++i;
            }
            displayMovies(user, movies, users,admin,di,ca);
        }
        else if(choose==3) {
           ArrayList<Movie> Recent= Movie.UpCommingMovies();
            int i=1;
            for (Movie mo:Recent) {
                System.out.println(i+" : "+mo.getMovieTitle()+" "+mo.MovieDate+" and discreption "+mo.discription);
                ++i;
            }
            displayMovies(user, movies, users,admin,di,ca);
        }
        else if(choose==4){
            DisplayUserDiscoverPg(user, movies, users,admin,di,ca);
        }
        else {
            System.out.println("invalid input");
            DisplayUserDiscoverPg(user, movies, users,admin,di,ca);
        }
    }
    /***
     * ro change email of the users and check if it is valid or not
     * @param user an instant of users class
     * @param movies the array list of all movies we have
     * @param admin the only admin we have
     * @param users the array list of all users we have
     * @param di the array list of all directors pf movies we have
     * @param ca the array list of all actors in all movies we have
     */
static void changeemail(User user,ArrayList<User>users,ArrayList<Movie>movies,Admin admin,ArrayList<director>di,ArrayList<cast>ca) throws IOException {
Scanner scan=new Scanner(System.in);
    System.out.println("enter new email");
    String Newemail = scan.next();
    boolean flagforemail=false;

    if (Newemail.matches("^[a-zA-Z0-9_+&-]+(?:\\.[a-zA-Z0-9_+&-]+)*@(gmail\\.com|yahoo\\.com)$")) {
        for (User datauser : users) {
            if (Newemail.equals(datauser.getEmail())) {
                System.out.println("email was found before :) ");
                flagforemail=true;
                changeemail( user, users,movies,admin,di,ca);
            }
        }
    }
    else {
        System.out.println("invalid email.make use to add \"@gmail.com\"or \"@yahoo.com\"");
        flagforemail=true;
        changeemail( user, users,movies,admin,di,ca);

    }
    if (flagforemail==false) {
        user.setEmail(Newemail);
        UserProfile(movies, user, users,admin,di,ca);
    }
}
    /***
     * function add rate to specific movie
     * @param movies the array list of all movies
     * @param id id of the movie that will be rateded
     * @param rate rate that the user will give to specific movie
     */
public static void addtare(ArrayList<Movie>movies,int id,int rate){
    for (Movie m:movies) {
        if (m.getMovieId()==id){
            m.UserRating=rate;
            System.out.println("added rating done :) ");
        }
    }
}
    /***
     * the admin function that can add movies with actors and director of the movie or delete movie
     * @param movies the array list of all movies we have
     * @param admin the only admin we have
     * @param user the array list of all users we have
     * @param di the array list of all directors pf movies we have
     * @param ca the array list of all actors in all movies we have
     */
static void EditedMovie(ArrayList<User> user,ArrayList<Movie> movies,Admin admin,ArrayList<director>di,ArrayList<cast>ca) throws IOException {
        Scanner inputAdmin = new Scanner(System.in);
        System.out.println("---------------------------------------------------------------------------------------------------------" +
                "\n1-add movie\n2-delete movie\n3-back");
        int AdminChoice2ToMovies = inputAdmin.nextInt();
        if(  AdminChoice2ToMovies == 1){
            admin.add_movie(movies,ca,di);
        }
        else if (  AdminChoice2ToMovies == 2) {
            int deletid;
            for (Movie mo:movies) {
                System.out.println(mo.displaymovie());
            }
            System.out.println("whitch id pf movie you want to delete ?");
            deletid=inputAdmin.nextInt();
            while (deletid>movies.size()){
                System.out.println("invalid input try again ");
                System.out.println("which id of movie you want to delete ?");
                deletid=inputAdmin.nextInt();
            }
            admin.remove_movie(deletid,movies);

            EditedMovie( user, movies, admin,di,ca);
        }
        else if(  AdminChoice2ToMovies ==3){
            AdminProfile( user, movies, admin,di,ca);
        }
        else{
            System.out.println("invalid choice!" );

        }
        EditedMovie( user, movies, admin,di,ca);
    }
}


