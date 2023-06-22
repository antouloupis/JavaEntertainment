import java.util.ArrayList;

public class Theama {

    public Theama(String showType, String title, int release_year, String[] tagType, String country, director director, ArrayList<actor> actors) {
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

    public director getDirector() {
        return director;
    }

    public void setDirector(director director) { this.director = director; }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    public ArrayList<actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<actor> actors) {
        this.actors = actors;
    }


    String showType;
    String title;
    int release_year;
    String[] TagType;
    String country;
    director director;
    ArrayList<actor> actors;

}

    class series extends Theama {

        int seasons;
        int episodes;
        int last_air;

        public series(String showType, String title, int release_year, String[] TagType, String country, director director, ArrayList<actor> actors, int seasons, int episodes, int last_air) {
            super(showType,title,release_year,TagType,country,director,actors);
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




    class director{

        public director(int id, String name, String website, String b_country) {
            this.id = id;
            this.name = name;
            this.website = website;
            this.b_country = b_country;
        }

        int id;
        String name;
        String website;
        String b_country;



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

    class actor{

        int id;
        String name;
        String website;
        String b_country;

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

