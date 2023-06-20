import java.util.Scanner;

public class Functions {

    Scanner sc = new Scanner(System.in);
    public void newView(){
        String type;
        do {
            System.out.println("What type of viewing is it?(Film/Series/Miniseries)");
            type = sc.nextLine();
        } while(type != "Film" || type!= "Series" || type!= "Miniseries");
            System.out.println("What is the title of the " + type);


    }
}
