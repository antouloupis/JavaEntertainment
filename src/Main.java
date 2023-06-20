import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);

    public void main(String[] args) {

        System.out.println("What would you like to do?\n");
        int choice;
        do {
            System.out.println("1.Add new viewing\n2.Update viewing\n3.Search and rate\n4.Search for actor or director\n");
            choice = sc.nextInt();
        } while (choice < 1 || choice > 4);
        switch (choice){
            case(1):
                newView();



        }
    }

    private void newView() {

        String type;
        String title;
        String release_year;
        String[] TagType = new String[0];
        String country;
        String director;
        String[] actors = new String[0];
        String answer;

        do {
                System.out.println("What type of viewing is it?(Film/Series/Miniseries)");
                type = sc.nextLine();
        } while(type != "Film" || type!= "Series" || type!= "Miniseries");

        System.out.println("What is the title of the " + type);
        title = sc.nextLine();

        System.out.println("When was the release year of " + title + "?");
        release_year = sc.nextLine();

        System.out.println("What type of tag applies to the viewing? \n(Can be: Comedy/Horror"); //FIX THIS LATER
        // do while mexri max arithmo tags h exit.

        int i=0;
        boolean flag = true;
        while(i < 2 && flag) { //check if user wants to add more tags
            TagType[i] = sc.nextLine();
            TagType[i].toUpperCase();
            System.out.println("Tag applied");


            System.out.println("Would you like to add another tag?(YES/NO)");
            answer = sc.nextLine();
            answer.toUpperCase();
            if (answer == "YES") {
                i++;
            } else {
                flag = false;
            }

        }

        System.out.println("In which country was " + title + "produced?");
        country = sc.nextLine();

        System.out.println("Who directed " + title + "?");
        director = sc.nextLine();

        System.out.println("Name some of the actors playing in " + title);

        i=0;
        flag = true;
        while(i < 10 && flag) { //check if user wants to add another actor
            System.out.println("What is the person's name?");
            TagType[i] = sc.nextLine();
            TagType[i].toUpperCase();
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

        if (type=="Film") {
            Theama theama = new Theama();

            theama.setTagType(TagType);
            theama.setActors(actors);
            theama.setCountry(country);
            theama.setTitle(title);

            theama.setRelease_year(release_year);

        } else {

        }



        }
    }