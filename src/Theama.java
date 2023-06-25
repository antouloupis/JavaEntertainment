import java.util.ArrayList;

public class Theama {

    public Theama(String showType, String title, int release_year, String[] tagType, String country, Director director, ArrayList<Actor> actors, int id) {
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

    private String showType;
    private String title;
    private int release_year;
    private String[] TagType;
    private String country;
    private Director director;
    private ArrayList<Actor> actors;
    private int id;

}

    class Series extends Theama {

        private int seasons;
        private int episodes;
        private int last_air;

        public Series(String showType, String title, int release_year, String[] TagType, String country, Director director, ArrayList<Actor> actors, int seasons, int episodes, int last_air, int id) {
            super(showType,title,release_year,TagType,country,director,actors,id);
            this.seasons = seasons;
            this.episodes = episodes;
            this.last_air = last_air;
        }


        public int getSeasons() {
            return seasons;
        }

        public void setSeasons(int seasons) {
            this.seasons = seasons;
        }

        public int getEpisodes() {
            return episodes;
        }

        public void setEpisodes(int episodes) {
            this.episodes = episodes;
        }

        public int getLast_air() {
            return last_air;
        }

        public void setLast_air(int last_air) {
            this.last_air = last_air;
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

