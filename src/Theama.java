import java.util.ArrayList;

public class Theama {

    public Theama(String showType, String title, int release_year, String[] tagType, String country, Person director, ArrayList<Person> actors, int id, ArrayList<UserRatings> RatingsList, int AverageRating) {
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
    private Person director;
    private ArrayList<Person> actors;
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

    public Person getDirector() {
        return director;
    }

    public void setDirector(Person director) { this.director = director; }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    public ArrayList<Person> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Person> actors) {
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

        public Series(String showType, String title, int release_year, String[] TagType, String country, Person director, ArrayList<Person> actors, ArrayList<Details> details, int last_air, int id, ArrayList<UserRatings> RatingsList, int AverageRating) {
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
