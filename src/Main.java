
import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    static ArrayList<Director> directorList = new ArrayList<>();
    static ArrayList<Actor> actorsList = new ArrayList<>();
    static ArrayList<Theama> theamata = new ArrayList<>();
    static ArrayList<User> UserList = new ArrayList<>();
    private static User LoggedIn=null;


    public static void main(String[] args) {
        FillWithExamples();
        System.out.println("What would you like to do?\n");
        int choice;
        while (true) {
            do {
            System.out.println("1. Add new viewing\n2. Update viewing\n3. Search and rate\n4. Search for actor or director\n5. EXIT");
            choice = CheckIfNumber();

            } while (choice < 1 || choice >5);

            switch (choice) {
                case (1):
                    newView();
                    break;
                case(2):
                    UpdateView();
                    break;
                case(3):
                    LoggedIn = SearchAndRate(LoggedIn);
                    break;
                case(5):
                    System.out.println("Program will now exit");
                    return;
                default:
                    throw new IllegalStateException("Something went wrong");

            }
        }
    }

    private static User SearchAndRate(User LoggedIn) {

        boolean isNumber;
        String input;
        int year=0;
        Theama Viewing = null;
        ArrayList<Theama> YearViews =  new ArrayList<>();;
        ArrayList<Details> seasonDetails;
        int counter;
        User user=null;
        int rating=0;
        ArrayList<UserRatings> localRatings;
        int ratedCounter=0;
        int ratingTotal=0;
        int ratingAverage;
        boolean found=false;
        int reply;


        System.out.println("Please provide the release year or title");

        do {
            input = sc.nextLine();
        } while (input==null);

        isNumber = input.matches("\\d+");

        if (isNumber) {
            //user provided a year to search for
            year = Integer.parseInt(input);
            for (Theama exists : theamata) {
                if (exists != null && exists.getRelease_year() == (year)) {
                    if (exists instanceof Series) {
                        YearViews.add((Series) exists);
                    } else {
                        YearViews.add(exists);
                    }
                    found=true;
                }
            }
        } else {
            input = input.toUpperCase();
            //user provided a string, title to search for
            for (Theama exists : theamata) {
                if (exists != null && exists.getTitle().equals(input)) {
                    if (exists instanceof Series) {
                        YearViews.add((Series) exists);
                    } else {
                        YearViews.add(exists);
                    }
                    found=true;
                }
            }
        }

        if (found) {


            for (Theama obj : YearViews) {
                System.out.println("Id: " + obj.getId() + ", title: " + obj.getTitle() + ", release year: " + obj.getRelease_year() + ", type: " + obj.getShowType() + ", director: " + obj.getDirector().getName() + ", average rating: " + obj.getAverageRating());
                if (obj instanceof Series) {
                    Series series = (Series) obj;
                    counter = 0;
                    seasonDetails = series.getDetails();
                    for (Details details : seasonDetails) {
                        counter++;
                    }
                    System.out.println("Last on air: " + series.getLast_air() + ", total seasons: " + counter);
                }
            }//PRINT ALL DETAILS


            System.out.println("Would you like to rate any of the views?(YES/NO)");

            do { //read user answer
                input = sc.nextLine().toUpperCase();
            } while (!input.equals("NO") && !input.equals("YES"));

            if (input.equals("YES")) {
                if (LoggedIn == null) { //check if user is logged in
                    System.out.println("You must sign in first!");
                    System.out.println("Would you like to \n1.Sign Up\n2.Sign In");
                    do{
                        reply = CheckIfNumber();
                    } while (reply!=1 && reply!=2);
                    if (reply ==1){
                        user = SignUp();
                    } else {
                        user = SignIn(0);
                    }
                } else {
                    user = LoggedIn;
                }

                if (user != null) {

                    do {
                        System.out.println("Please type the TITLE or ID of the show you want to rate");
                        Viewing = (Theama) ReplyIDorTITLE(null);

                        if (Viewing != null) {
                            localRatings = Viewing.getRatingsList();

                            for (UserRatings obj : localRatings) {//count users that rated and total rating score
                                ratedCounter++;
                                ratingTotal = ratingTotal + obj.getRating();
                                if (obj.getUser().getEmail().equals(user.getEmail())) {
                                    System.out.println("You have already rated this show, rating: " + obj.getRating());
                                    rating = obj.getRating();
                                }
                            }

                            if (rating == 0) {
                                System.out.println("What rating would you like to give to " + Viewing.getTitle());

                                do {
                                    rating = sc.nextInt();
                                } while (rating < 1 || rating > 10);

                                UserRatings newRating = new UserRatings(user, rating);
                                localRatings.add(newRating);
                                Viewing.setRatingsList(localRatings);
                                //account for new rating
                                ratedCounter++;
                                ratingTotal = ratingTotal + rating;
                                ratingAverage = ratingTotal / ratedCounter;
                                Viewing.setAverageRating(ratingAverage);
                                System.out.println("Rating added successfully");

                            }
                        } else{
                                System.out.println("Viewing not found please try again");
                            }

                    } while (Viewing == null); //do untill viewing is found

            } else {
                System.out.println("Login/Signup error");
            }
        } else {  //user dont wanna rate
                System.out.println("Would you like to see detailed reviews about a viewing?(YES/NO)");
                do { //read user answer
                    input = sc.nextLine().toUpperCase();
                } while (!input.equals("NO") && !input.equals("YES"));

                if (input.equals("YES")){
                    System.out.println("Please type viewing ID or TITLE");
                    Viewing = (Theama) ReplyIDorTITLE(null);
                    if (Viewing!=null){
                        System.out.println("Reviews for "+Viewing.getTitle()+":");
                        localRatings = Viewing.getRatingsList();
                        for (UserRatings obj : localRatings){
                            System.out.println(obj.getUser().getUsername() + " " + obj.getRating());
                        }
                    }
                }

            }
        } else {
            System.out.println("No viewings found");
        }

        return user;

    }//endof search

    private static User SignIn(int tries) { //tries to sign in if not found then sign up

        User user=null;
        String input;
        String password;
        boolean invalid = false;
        int reply;

        System.out.println("Please type your email");
        do {
            input = sc.nextLine();
        } while (input==null || input.matches("\\d+"));

        input = input.toUpperCase(); //make uppercase

        System.out.println("Please type your password (case sensitive)");

        do { //check if email exists
            password = sc.nextLine();

        if(password!=null) {
            for (User obj : UserList) {
                if (input.equals(obj.getEmail()) && password.equals(obj.getPassword())) { //if both correct return user object
                    System.out.println("Login was successful. Welcome " + obj.getUsername());
                    return obj; //USER WAS FOUND AND IS RETURNED
                } else if (input.equals(obj.getEmail())) { //if it does , but password mismatch, ask for password again
                    invalid = true; //flag to check if email exists
                    System.out.println("Password is invalid");
                    break;
                }
            }
        }
        } while (invalid);
        //if you are here then email was wrong or user dont exist

        System.out.println("Email does not correspond to a user:" +input);
        if (tries<1) {
            System.out.println("Would you like to\n1.Sign up\n2.Retry\n3.Exit back to main program");
        } else {
            System.out.println("Would you like to\n2.Retry\n3.Exit back to main program");
        }
        do {
            reply = CheckIfNumber();
        } while (reply!=1 && reply!=2 && reply!=3);

        if (reply==1 && tries<1){ //Sign up and, if user has tried once or more to login , ignore
            return SignUp();
        } else if (reply==2){
            tries++;
            if (tries>2){//if tries are more than 2 return null
                System.out.println("Too many wrong tries!");
                return null;
            }
            user = SignIn(tries);//time for user to retry
        }
        return user;
    }

    private static User SignUp(){

        String input;
        String password;
        String username;
        User user;

        System.out.println("Please provide your email address");

        do {
            input = sc.nextLine();

            for(User obj : UserList) {
                if (input.toUpperCase().equals(obj.getEmail())){
                    System.out.println("Email was found, please type another email");
                    break;
                }
            }

        } while (input==null || input.matches("\\d+"));

        input = input.toUpperCase();

        System.out.println("Please type your password");

        do {
            password = sc.nextLine();
        } while (password==null);

        System.out.println("Please provide your full name");
        do {
            username = sc.nextLine();
        } while (username==null || username.matches("\\d+"));

        username = username.toUpperCase();

        user = new User(username,password,input);
        UserList.add(user);
        System.out.println("User added successfully: "+username);

        return user;

    }

    private static void newView() {

        String type = null;
        String title;
        int release_year=-1;
        String[] TagType = new String[3];
        String country;
        String directorName;
        String directorWebsite = "";
        String directorBCountry;
        String answer;
        Details details;
        int episodes;
        int seasons;
        int last_aired = -1;
        Director director = null;
        ArrayList<Actor> movieActors = new ArrayList<>();
        boolean added;
        int tNum;
        ArrayList<Details> seasonsAndEpisodes = new ArrayList<>();

        do {
            System.out.println("What type of viewing is it?(FILM/SERIES/MINISERIES)");
            type = sc.nextLine().toUpperCase();
        } while (!type.equals("FILM") && !type.equals("SERIES") && !type.equals("MINISERIES"));


        System.out.println("What is the title of the " + type + "?");
        title = sc.nextLine().toUpperCase();

        System.out.println("When was the release year of " + title + "?");
        release_year = CheckIfNumber();
           

        int i = 0;
        boolean flag = true;

        while (i < 3 && flag) { //check if user wants to add more tags
            System.out.println("What type of tag applies to the viewing? \n(Can be: Comedy/Horror)");
            System.out.println("Tag Type " + (i + 1) + ":");

            TagType[i] = sc.nextLine();
            TagType[i] = TagType[i].toUpperCase();
            System.out.println("Tag applied " + TagType[i]);


            do {
                System.out.println("Would you like to add another tag?(YES/NO)");
                answer = sc.nextLine().toUpperCase();
                if (answer.equals("YES")) {
                    i++;
                } else if (answer.equals("NO")) {
                    flag = false;
                }
            } while (!answer.equals("NO") && !answer.equals("YES"));
        }

        if (i == 3) {
            System.out.println("Maximum amount of tags reached");
        } //ACCESSORY


        System.out.println("In which country was " + title + " produced?");
        country = sc.nextLine().toUpperCase();

        System.out.println("Who directed " + title + "?");
        directorName = sc.nextLine().toUpperCase();


        int id = -1;
        int counter = 0;

        for (Director obj : directorList) {
            if (obj.getName().equals(directorName)) {
                id = obj.getId();
                break;
            }
            counter++;
        }

        if (id == -1) {
            System.out.println("Where was " + directorName + " born?");
            directorBCountry = sc.nextLine().toUpperCase();

            System.out.println("What is " + directorName + "'s website?");
            directorWebsite = sc.nextLine().toUpperCase();

            director = new Director(counter, directorName, directorWebsite, directorBCountry);//maybe it should be counter--

        } else {
            director = directorList.get(counter);
        }

        System.out.println("When was "+title+" last on air?");
        do {
            last_aired = CheckIfNumber();
        } while(last_aired < 1888);


        counter=0;

        for (Theama viewing : theamata) {
            counter++;
        }


        System.out.println("Name some of the actors playing in " + title);
        Series series = new Series(type, title, release_year, TagType, country, director, movieActors, seasonsAndEpisodes, last_aired,counter,null,-1);
        addActor(movieActors,series,0);



        if (type.equals("SERIES") || type.equals("MINISERIES")) {


            System.out.println("How many seasons does " + title + " have?");
            do {
                seasons = CheckIfNumber();
            } while (seasons<1);

            for (i = 1; i <= seasons; i++) {

                System.out.println("How many episodes does season " + i + " have?");
                do {
                    episodes = CheckIfNumber();
                } while(episodes<0);

                details = new Details(i,episodes);
                seasonsAndEpisodes.add(details);

            }

             //read these above
            theamata.add(series);

        } else {

            Theama theama = new Theama(type, title, release_year, TagType, country, director, movieActors,counter,null,-1);
            theamata.add(theama);
        }


    }

    private static int CheckIfNumber() {
        int number = -1;
        int tries=0;
        do {
            tries++;
        try {
            number = Integer.parseInt(sc.nextLine());

        } catch (NumberFormatException e){
            if (tries>0) {
                System.out.println("Please type a number");
            }
        } } while(number < 0);
        return number;
    }

    private static void UpdateView() {

        String input;
        int actorNum= 0;
        int seasons = 0;
        int last_aired = 0;
        int episodes = 0;
        Actor actor = null;
        ArrayList<Actor> movieActors = new ArrayList<>();
        ArrayList<Details> seasonsAndEpisodes;
        Details details;
        boolean added;
        Series updateSeries=null;
        int id=0;
        boolean isNumber;

        System.out.println("Please provide the ID or TITLE of the series you wish to edit");
        updateSeries = (Series) ReplyIDorTITLE("SERIES");


        if (updateSeries != null){
            seasonsAndEpisodes = updateSeries.getDetails();
            movieActors = updateSeries.getActors();
            System.out.println("Series found: " + updateSeries.getTitle());

            for(Details obj: seasonsAndEpisodes) { //count how many seasons total, print ep per seasons
                seasons++;
                System.out.println("Season " + seasons + " has " + seasonsAndEpisodes.get(seasons - 1).getEpisodes() + " episodes");
            }
            System.out.println();
            for (Actor obj : movieActors) {
                actorNum++;
                System.out.println("Actor named: " + obj.getName() + " is in this series");
            }

            System.out.println("\nLast year on air was: " + updateSeries.getLast_air());


            do {
                System.out.println("What would you like to update?(1.Season/Episodes 2.Add actors 3.Last year on air)");

                    id = CheckIfNumber();

            } while (id < 1 || id >3);

            if (id == 1) {

                do {
                    System.out.println("1.Add new season\n2.Alter amount of episodes in a season");
                        id = CheckIfNumber();
                } while (id < 1 || id >2);
                if (id == 1){
                    AddSeason(seasons,seasonsAndEpisodes);
                } else {
                    ChangeSeasonDetails(seasons,seasonsAndEpisodes);
                }

            } else if(id == 2){
                if(actorNum == 10) {
                    System.out.println("Maximum amount of actors ("+actorNum+") been reached for "+updateSeries.getTitle());
                } else {
                    addActor(movieActors,updateSeries,actorNum);
                }
            } else {
                System.out.println("Last year on air for "+updateSeries.getTitle()+" was "+updateSeries.getLast_air());
                System.out.println("What would you like to change it to?");

                do{
                    last_aired = CheckIfNumber();
                } while(last_aired<1888); //year of first movie
            }

        } else {
            System.out.println("Series was not found");
        }






    }

    private static Object ReplyIDorTITLE(String type) { //for when user wants to find a theama based on either name or id

        boolean isNumber;
        String input;
        int id;
        Object updateSeries=null;

        if (type==null){
            type = "I";
        }


        input = sc.nextLine();

        isNumber = input.matches("\\d+");

        if (isNumber) {
            //user provided an id to search for
            id = Integer.parseInt(input);
            for (Theama exists : theamata) {
                if (exists != null && exists.getId() == (id) && exists.getShowType().contains(type)) {
                        updateSeries = exists;
                        break;
                }
            }
        } else {
            input = input.toUpperCase();
            //user provided a string, title to search for
            for (Theama exists : theamata) {
                if (exists != null && exists.getTitle().equals(input) && exists.getShowType().contains(type)) {
                    updateSeries = exists;
                    break;
                }
            }
        }

        return updateSeries;
    }

    private static void addActor(ArrayList<Actor> movieActors, Series series, int totalActors) {

        Actor actor=null;
        int counter;
        String actorName;
        boolean added;
        boolean flag = true;
        String country;
        String actorWebsite;
        String answer;

        while (totalActors < 10 && flag) { //check if user wants to add another actor
            added = false;
            actor = null;
            System.out.println("Name the actor you want to add to " + series.getTitle());
            actorName = sc.nextLine().toUpperCase();

            counter = 0;
        if(movieActors!=null) {
            for (Actor exists : movieActors) {
                if (exists.getName().equals(actorName)) {
                    System.out.println("Actor has already been added to " + series.getTitle());
                    added = true;
                    break;
                }
            }
        }
            if (!added) { //not added to this specific theama
                for (Actor obj : actorsList) { //search if actor exists in actorlist
                    if (obj.getName().equals(actorName)) {
                        actor = obj;
                        break;
                    }
                    counter++;
                }
                if (actor==null) { //if actor not found in actor list
                    System.out.println("Where was " + actorName + " born?");
                    country = sc.nextLine().toUpperCase();

                    System.out.println("What is " + actorName + "'s website?");
                    actorWebsite = sc.nextLine().toUpperCase();

                    actor = new Actor(counter, actorName, actorWebsite, country);
                    actorsList.add(actor);
                    movieActors.add(actor);
                } else {
                    movieActors.add(actor);
                }
                System.out.println("Actor added to "+series.getTitle() +", " + actorName);
            }

            do { //ask if user wants to add another actor
                System.out.println("Would you like to add another actor?(YES/NO)");
                answer = sc.nextLine().toUpperCase();

                if (answer.equals("YES") && totalActors<9) {
                    totalActors++;
                    System.out.println(totalActors);
                } else if (answer.equals("NO")) {
                    flag = false;
                } else {
                    System.out.println("Maximum amount of actors reached.");
                    flag = false;
                    totalActors++;
                }
            } while (!answer.equals("YES") && !answer.equals("NO"));

        }



    }

    private static void AddSeason(int totalSeasons, ArrayList<Details> detailsArrayList) {

        int episodes=-1;

        System.out.println("How many episodes does the new season (" + (totalSeasons + 1) + ") have? If unsure type 0");
        do {
            episodes = CheckIfNumber();
        } while(episodes < 0);

        Details details = new Details(totalSeasons,episodes);
        detailsArrayList.add(details);
        System.out.println("Season added successfully: " + (totalSeasons+1) +", episodes: " + episodes);
    }

    private static void ChangeSeasonDetails(int totalSeasons, ArrayList<Details> detailsArrayList) {

        int season=-1;
        Details details=null;
        int episodes=-1;


        do {
            System.out.println("Which season would you like to change?");
        try{
            season = Integer.parseInt(sc.nextLine());
            details = detailsArrayList.get(season-1);

        } catch(NumberFormatException e){
            System.out.println("Please type a number");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Season " + season +" not found, there are " + totalSeasons +" seasons total");
        }
        } while(details==null);


        do {
            System.out.println("How many episodes should season "+season+ " have?");
            episodes = CheckIfNumber();
        } while(episodes < 0);

        details.setEpisodes(episodes);
        System.out.println("Season "+season+ " now has "+episodes+" episodes");

    }

    private static void FillWithExamples() {
        Actor actor;
        Director director;
        Theama theama;
        String[] TagType = new String[3];
        ArrayList<Actor> movieActors = new ArrayList<>();
        Series series = null;
        ArrayList<Details> detailsArrayList = new ArrayList<>();
        Details details;
        User user;
        UserRatings userRatings;
        ArrayList<UserRatings> RatingsList = new ArrayList<>();
        int averageRating;

        user = new User("JOHNDOE","password","JOHN@DOE.GR");
        UserList.add(user);

        user = new User("BABIS3","babispao13","BABIS13@GMAIL.COM");
        UserList.add(user);

        user = new User("MIKU","$@!aaa3399","MIKU@SONY.COM");
        UserList.add(user);

        actor = new Actor(1,"RYAN GOSLING","","CANADA");
        actorsList.add(actor);

        actor = new Actor(2,"MATTHEW MCCONAUGHEY","GREENLIGHTS.COM","USA");
        actorsList.add(actor);

        actor = new Actor(3,"ANNE HATHAWAY","","USA");
        actorsList.add(actor);

        actor = new Actor(4,"LEONARDO DICAPRIO","","USA");
        actorsList.add(actor);

        actor = new Actor(5,"CHRISTOFOROS PAPAKALIATIS","","GREECE");
        actorsList.add(actor);

        actor = new Actor(6,"KLELIA ANDRIOLATOU","","GREECE");
        actorsList.add(actor);

        actor = new Actor(7,"ORESTIS CHALKIAS","","GREECE");
        actorsList.add(actor);

        actor = new Actor(8,"MARGOT ROBBIE","","AUSTRALIA");
        actorsList.add(actor);

        actor = new Actor(9,"BOB ODENKIRK","","USA");
        actorsList.add(actor);

        actor = new Actor(10,"RHEA SEEHORN","","USA");
        actorsList.add(actor);

        actor = new Actor(11,"GIANCARLO ESPOSITO","","USA");
        actorsList.add(actor);


        director = new Director(1,"CHRISTOPHER NOLAN","","UNITED KINGDOM");
        directorList.add(director);

        director = new Director(2,"MARTIN SCORSESE","","USA");
        directorList.add(director);

        director = new Director(3,"CHRISTOFOROS PAPAKALIATIS","","GREECE");
        directorList.add(director);

        director = new Director(4,"GRETA GERWIG","","USA");
        directorList.add(director);

        director = new Director(5,"GEORGE VINCENT GILLIGAN JR.","","USA");
        directorList.add(director);



        //INTERSTELLAR
        TagType[0] = "SCI-FI";
        TagType[1] = "ADVENTURE";
        movieActors.add(actorsList.get(0));
        movieActors.add(actorsList.get(1));
        userRatings = new UserRatings(UserList.get(0),10);
        RatingsList.add(userRatings);
        userRatings = new UserRatings(UserList.get(1),9);
        RatingsList.add(userRatings);
        userRatings = new UserRatings(UserList.get(2),10);
        RatingsList.add(userRatings);
        averageRating = ((10+9+10)/3);
        theama = new Theama("FILM","INTERSTELLAR",2014,TagType,"CANADA",directorList.get(0),movieActors,1,RatingsList,averageRating);
        theamata.add(theama);

        //WOLF OF WALLSTREET
        TagType[0] = "DRAMA";
        TagType[1] = "COMEDY";
        movieActors = new ArrayList<>();
        movieActors.add(actorsList.get(1));
        movieActors.add(actorsList.get(3));
        movieActors.add(actorsList.get(7));
        RatingsList = new ArrayList<>();
        userRatings = new UserRatings(UserList.get(0),9);
        RatingsList.add(userRatings);
        userRatings = new UserRatings(UserList.get(1),8);
        RatingsList.add(userRatings);
        userRatings = new UserRatings(UserList.get(2),7);
        RatingsList.add(userRatings);
        averageRating = ((9+7+8)/3);
        theama = new Theama("FILM","THE WOLF OF WALLSTREET",2013,TagType,"USA",directorList.get(1),movieActors,2,RatingsList,averageRating);
        theamata.add(theama);

        //MAESTRO IN BLUE
        details = new Details(1,9);
        detailsArrayList.add(details);

        TagType[0] = "DRAMA";
        TagType[1] = null;
        movieActors = new ArrayList<>();
        movieActors.add(actorsList.get(4));
        movieActors.add(actorsList.get(5));
        movieActors.add(actorsList.get(6));
        RatingsList = new ArrayList<>();
        userRatings = new UserRatings(UserList.get(0),10);
        RatingsList.add(userRatings);
        userRatings = new UserRatings(UserList.get(1),10);
        RatingsList.add(userRatings);
        userRatings = new UserRatings(UserList.get(2),10);
        RatingsList.add(userRatings);
        averageRating = ((10+10+10)/3);
        series = new Series("SERIES","MAESTRO IN BLUE",2022,TagType,"GREECE",directorList.get(2),movieActors,detailsArrayList,2022,3,RatingsList,averageRating);
        theamata.add(series);

        //BARBIE
        TagType[0] = "COMEDY";
        TagType[1] = "ROMANCE";
        movieActors = new ArrayList<>();
        movieActors.add(actorsList.get(0));
        movieActors.add(actorsList.get(1));
        movieActors.add(actorsList.get(7));
        RatingsList = new ArrayList<>();
        userRatings = new UserRatings(UserList.get(0),7);
        RatingsList.add(userRatings);
        userRatings = new UserRatings(UserList.get(1),5);
        RatingsList.add(userRatings);
        userRatings = new UserRatings(UserList.get(2),8);
        RatingsList.add(userRatings);
        averageRating = ((7+5+8)/3);
        theama = new Theama("FILM","BARBIE",2023,TagType,"USA",directorList.get(3),movieActors,4,RatingsList,averageRating);
        theamata.add(theama);


        //BETTER CALL SAUL
        detailsArrayList = new ArrayList<Details>();
        details = new Details(1,10);
        detailsArrayList.add(details);

        details = new Details(2,10);
        detailsArrayList.add(details);

        details = new Details(3,10);
        detailsArrayList.add(details);

        details = new Details(4,10);
        detailsArrayList.add(details);

        details = new Details(5,10);
        detailsArrayList.add(details);

        details = new Details(6,13);
        detailsArrayList.add(details);

        TagType[0] = "DRAMA";
        TagType[1] = null;
        movieActors = new ArrayList<>();
        movieActors.add(actorsList.get(8));
        movieActors.add(actorsList.get(9));
        movieActors.add(actorsList.get(10));
        RatingsList = new ArrayList<>();
        userRatings = new UserRatings(UserList.get(0),9);
        RatingsList.add(userRatings);
        userRatings = new UserRatings(UserList.get(1),10);
        RatingsList.add(userRatings);
        userRatings = new UserRatings(UserList.get(2),9);
        RatingsList.add(userRatings);
        averageRating = ((9+10+9)/3);
        series = new Series("SERIES","BETTER CALL SAUL",2015,TagType,"USA",directorList.get(4),movieActors,detailsArrayList,2022,5,RatingsList,averageRating);
        theamata.add(series);


    }



}