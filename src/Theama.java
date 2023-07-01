import java.lang.reflect.Array;
import java.util.ArrayList;

public class Theama {

    public Theama(String showType, String title, int release_year, String[] tagType, String country, Director director, ArrayList<Actor> actors, int id,ArrayList<UserRatings> RatingsList, int AverageRating) {
        this.showType = showType;
        this.title = title;
        this.release_year = release_year;
        TagType = tagType;
        this.country = country;
        this.director = director;
        this.actors = actors;
        this.id = id;
        this.AverageRating = AverageRating;
        this.RatingsList = RatingsList;
    }


    private ArrayList<UserRatings> RatingsList;
    private int AverageRating;
    private String showType;
    private String title;
    private int release_year;
    private String[] TagType;
    private String country;
    private Director director;
    private ArrayList<Actor> actors;
    private int id;

    public ArrayList<UserRatings> getRatingsList() {
        return RatingsList;
    }

    public void setRatingsList(ArrayList<UserRatings> ratingsList) {
        RatingsList = ratingsList;
    }

    public int getAverageRating() {
        return AverageRating;
    }

    public void setAverageRating(int AverageRating) {
        this.AverageRating = AverageRating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public String[] getTagType() {
        return TagType;
    }

    public void setTagType(String[] TagType) {
        this.TagType = TagType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) { this.director = director; }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}

    class Series extends Theama {

        private ArrayList<Details> details;
        private int last_air;

        public Series(String showType, String title, int release_year, String[] TagType, String country, Director director, ArrayList<Actor> actors, ArrayList<Details> details, int last_air, int id,ArrayList<UserRatings> RatingsList, int AverageRating) {
            super(showType,title,release_year,TagType,country,director,actors,id,RatingsList,AverageRating);
            this.details = details;
            this.last_air = last_air;
        }


        public int getLast_air() {
            return last_air;
        }

        public void setLast_air(int last_air) {
            this.last_air = last_air;
        }

        public ArrayList<Details> getDetails() {
            return details;
        }

        public void setDetails(ArrayList<Details> details) {
            this.details = details;
        }
    }

    class User {

        private String username;
        private String password;
        private String email;

        public User(String username, String password, String email) {
            this.username = username;
            this.password = password;
            this.email = email;
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

    class UserRatings{
        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        private User user;
        private int rating;

        public UserRatings(User user, int rating) {
            this.user = user;
            this.rating = rating;

        }


        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }
    }

    class Director{

        public Director(int id, String name, String website, String b_country) {
            this.id = id;
            this.name = name;
            this.website = website;
            this.b_country = b_country;
        }

        private int id;
        private String name;
        private String website;
        private String b_country;



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

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

    }

    class Actor{

        private int id;
        private String name;
        private String website;
        private String b_country;

        public Actor(int id, String name, String website, String b_country) {
            this.id = id;
            this.name = name;
            this.website = website;
            this.b_country = b_country;
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

    }

    class Details{
        private int number;
        private int episodes;



        public Details(int number, int episodes) {
            this.number = number;
            this.episodes = episodes;
        }

        public int getNumber() {
            return number;
        }


        public void setNumber(int number) {
            this.number = number;
        }

        public int getEpisodes() {
            return episodes;
        }

        public void setEpisodes(int episodes) {
            this.episodes = episodes;
        }
    }
