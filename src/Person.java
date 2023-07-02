import java.util.ArrayList;

public class Person {

    private int id;
    private String name;
    private String website;
    private String b_country;
    private ArrayList<Theama> works;


    public Person(int id, String name, String website, String b_country, ArrayList<Theama> works) {
        this.id = id;
        this.name = name;
        this.website = website;
        this.b_country = b_country;
        this.works = works;
    }

    public void setWorks(ArrayList<Theama> works) {
        this.works = works;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getB_country() {
        return b_country;
    }

    public void setB_country(String b_country) {
        this.b_country = b_country;
    }


    public ArrayList<Theama> getWorks() {
        return works;
    }


}

class User {

    private String username;
    private String password;
    private String email;
    private ArrayList<Person> favorites;

    public User(String username, String password, String email, ArrayList<Person> favorites) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.favorites = favorites;
    }

    public ArrayList<Person> getFavorites() {
        return favorites;
    }

    public void setFavorites(ArrayList<Person> favorites) {
        this.favorites = favorites;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
