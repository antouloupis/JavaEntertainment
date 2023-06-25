import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Director> directorList = new ArrayList();
    private static ArrayList<Actor> actorsList = new ArrayList<>();
    private static ArrayList<Theama> theamata = new ArrayList<>();


    public static void main(String[] args) {

        FillWithExamples();
        System.out.println("What would you like to do?\n");
        int choice;
        while (true) {
            do {
                System.out.println("1.Add new viewing\n2.Update viewing\n3.Search and rate\n4.Search for actor or director\n5.EXIT");
                choice = sc.nextInt();
            } while (choice < 1 || choice > 4);

            switch (choice) {
                case (1):
                    newView();
                case (5):
                    return;
                default:
                    System.out.println("Something went wrong");

            }
        }
    }

    private static void newView() {

        String type = null;
        String title;
        int release_year;
        String[] TagType = new String[3];
        String country;
        String directorName;
        String directorWebsite = "";
        String directorBCountry;
        String actorName;
        String actorWebsite;
        String actorBCountry;
        String answer;
        int seasons = 0;
        int last_aired = 0;
        int episodes = 0;
        Director director = null;
        Actor actor = null;
        ArrayList<Actor> movieActors = new ArrayList<>();
        boolean added;

        do {
            System.out.println("What type of viewing is it?(FILM/SERIES/MINISERIES)");
            if (type == null) {
                sc.nextLine();
            } //to NOT read null in first try
            type = sc.nextLine().toUpperCase();
            System.out.println(type);
        } while (!type.equals("FILM") && !type.equals("SERIES") && !type.equals("MINISERIES"));


        System.out.println("What is the title of the " + type + "?");
        title = sc.nextLine().toUpperCase();

        System.out.println("When was the release year of " + title + "?");
        release_year = sc.nextInt();

        int i = 0;
        boolean flag = true;

        while (i < 3 && flag) { //check if user wants to add more tags
            System.out.println("What type of tag applies to the viewing? \n(Can be: Comedy/Horror)");
            System.out.println("Tag Type " + (i + 1) + ":");

            if (i == 0) {
                sc.nextLine();
            }

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

        System.out.println("Name some of the actors playing in " + title);

        i = 0;
        flag = true;
        added = false;

        while (i < 10 && flag) { //check if user wants to add another actor
            System.out.println("What is the person's name?");
            actorName = sc.nextLine();

            id = -1;
            counter = 0;

            for (Actor exists : movieActors) {
                if (exists.getName().equals(actorName)) {
                    System.out.println("Actor has already been added to " + title);
                    added = true;
                    break;
                }
            }

            if (!added) {
                for (Actor obj : actorsList) {
                    if (obj.getName().equals(actorName)) {
                        id = obj.getId();
                        break;
                    }
                    counter++;
                }
                if (id == -1) { //if actor not found
                    System.out.println("Where was " + actorName + " born?");
                    actorBCountry = sc.nextLine().toUpperCase();

                    System.out.println("What is " + actorName + "'s website?");
                    actorWebsite = sc.nextLine().toUpperCase();

                    actor = new Actor(counter, actorName, actorWebsite, actorBCountry);
                    actorsList.add(actor);
                    movieActors.add(actor);
                } else {
                    actor = actorsList.get(counter);
                    movieActors.add(actor);
                }

                System.out.println("Actor added, " + actorName);
            } //if not added

            do {
                System.out.println("Would you like to add another actor?(YES/NO)");
                answer = sc.nextLine().toUpperCase();

                if (answer.equals("YES")) {
                    i++;
                    System.out.println(i);
                } else if (answer.equals("NO")) {
                    flag = false;
                }
            } while (!answer.equals("YES") && !answer.equals("NO"));

        }

        counter=0;

        for (Theama viewing : theamata) {
                counter++;
            }

        if (type.equals("SERIES") || type.equals("MINISERIES")) {

            Series series = new Series(type, title, release_year, TagType, country, director, movieActors, seasons, episodes, last_aired,counter); //read these above
            theamata.add(series);

        } else {

            Theama theama = new Theama(type, title, release_year, TagType, country, director, movieActors,counter);
            theamata.add(theama);
        }


    }


    private static void UpdateView() {



    }


    private static void FillWithExamples() {
        Actor actor = null;
        Director director = null;
        Theama theama = null;
        String[] TagType = new String[3];
        ArrayList<Actor> movieActors = new ArrayList<>();
        Series series = null;

        actor = new Actor(1,"RYAN GOSLING","","CANADA");
        actorsList.add(actor);

        actor = new Actor(2,"MATTHEW MCCONAUGHEY","GREENLIGHTS.COM","USA");
        actorsList.add(actor);

        actor = new Actor(3,"ANNE HATHAWAY","","USA");
        actorsList.add(actor);

        actor = new Actor(4,"LEONADRO DICAPRIO","","USA");
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
        movieActors.set(1,actorsList.get(2));
        movieActors.set(2,actorsList.get(3));
        theama = new Theama("FILM","INTERSTELLAR",2014,TagType,"CANADA",directorList.get(1),movieActors,1);
        theamata.add(theama);

        //WOLF OF WALLSTREET
        TagType[0] = "DRAMA";
        TagType[1] = "COMEDY";
        movieActors.set(1,actorsList.get(2));
        movieActors.set(2,actorsList.get(4));
        movieActors.set(3,actorsList.get(8));
        theama = new Theama("FILM","THE WOLF OF WALLSTREET",2013,TagType,"USA",directorList.get(2),movieActors,2);
        theamata.add(theama);

        //MAESTRO IN BLUE
        TagType[0] = "DRAMA";
        TagType[1] = null;
        movieActors.set(1,actorsList.get(5));
        movieActors.set(2,actorsList.get(6));
        movieActors.set(3,actorsList.get(7));
        series = new Series("SERIES","MAESTRO IN BLUE",2022,TagType,"GREECE",directorList.get(3),movieActors,1,9,2022,3);
        theamata.add(theama);

        //BARBIE
        TagType[0] = "COMEDY";
        TagType[1] = "ROMANCE";
        movieActors.set(1,actorsList.get(1));
        movieActors.set(2,actorsList.get(3));
        movieActors.set(3,actorsList.get(8));
        theama = new Theama("FILM","BARBIE",2023,TagType,"USA",directorList.get(4),movieActors,4);
        theamata.add(theama);

        //BETTER CALL SAUL
        TagType[0] = "DRAMA";
        TagType[1] = null;
        movieActors.set(1,actorsList.get(9));
        movieActors.set(2,actorsList.get(10));
        movieActors.set(3,actorsList.get(11));
        series = new Series("SERIES","BETTER CALL SAUL",2015,TagType,"USA",directorList.get(5),movieActors,6,13,2022,5);
        theamata.add(theama);


    }



}