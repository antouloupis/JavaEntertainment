import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<director> directorList = new ArrayList();
    private ArrayList<actor> actorsList = new ArrayList<>();
    private ArrayList<Theama> theamata = new ArrayList<>();


    public static void main(String[] args) {

        System.out.println("What would you like to do?\n");
        int choice;
        do {
            System.out.println("1.Add new viewing\n2.Update viewing\n3.Search and rate\n4.Search for actor or director");
            choice = sc.nextInt();
        } while (choice < 1 || choice > 4);

        switch (choice){
            case(1):
                newView();

            default:
                System.out.println("end");



        }

    }

    private static void newView() {

        String type;
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
        int last_aired= 0;
        int episodes= 0;
        director director = null;
        ArrayList<actor> movieActors = new ArrayList<>();

        do {
                System.out.println("What type of viewing is it?(FILM/SERIES/MINISERIES)");
                sc.nextLine(); //to NOT read null in first try
                type = sc.nextLine().toUpperCase();
                System.out.println(type);
                if (type.equals("")) { System.out.println("fuckjava");}
        } while(!type.equals("FILM") && !type.equals("SERIES") && !type.equals("MINISERIES"));


        System.out.println("What is the title of the " + type + "?");
        title = sc.nextLine().toUpperCase();

        System.out.println("When was the release year of " + title + "?");
        release_year = sc.nextInt();

        System.out.println("What type of tag applies to the viewing? \n(Can be: Comedy/Horror)"); //FIX THIS LATER
        // do while mexri max arithmo tags h exit.

        int i = 0;
        boolean flag = true;

        while(i < 3 && flag) { //check if user wants to add more tags
            System.out.println("Tag Type " + (i + 1) + ":");

            if (i==0) {sc.nextLine();}

            TagType[i] = sc.nextLine();
            TagType[i] = TagType[i].toUpperCase();
            System.out.println("Tag applied " + TagType[i]);

            System.out.println("Would you like to add another tag?(YES/NO)");
            do {
                answer = sc.nextLine();
                answer = answer.toUpperCase();
                if (answer.equals("YES")) {
                    i++;
                } else if (answer.equals("NO")) {
                    flag = false;
                }
            } while (!answer.equals("NO") && !answer.equals("YES"));
        }

        if (i==3) { System.out.println("Maximum amount of tags reached"); } //ACCESSORY


        System.out.println("In which country was " + title + "produced?");
        country = sc.nextLine().toUpperCase();

        System.out.println("Who directed " + title + "?");
        directorName = sc.nextLine().toUpperCase();


        int id = -1;
        int counter = 0;

        for (director obj : directorList ) {
            if(obj.getName().equals(directorName)){

                directorWebsite = obj.getWebsite();
                directorBCountry = obj.getB_country();
                id = obj.getId();
                break;
            }
            counter++;
        }

        if (id == -1){
            System.out.println("Where was " + directorName + " born?");
            directorBCountry = sc.nextLine().toUpperCase();

            System.out.println("What is " + directorName + "'s website?");
            directorWebsite = sc.nextLine().toUpperCase();

            director = new director(counter,directorName,directorWebsite,directorBCountry);

        } else {
            director = directorList.get(counter);
        }

        System.out.println("Name some of the actors playing in " + title);

        i=0;
        flag = true;
        while(i < 10 && flag) { //check if user wants to add another actor
            System.out.println("What is the person's name?");

            System.out.println("Actor added");


            System.out.println("Would you like to add another actor?(YES/NO)");
            answer = sc.nextLine();
            answer.toUpperCase();
            if (answer == "YES") {
                i++;
            } else {
                flag = false;
            }
        }

        Theama theama = new Theama(type,title,release_year,TagType,country,director,movieActors);

        if (type=="Series" || type=="Miniseries") {

            series series = new series(type,title,release_year,TagType,country,director,movieActors,seasons, episodes, last_aired); //read these above

        } else {



        }



        }
    }