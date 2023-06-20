import java.util.ArrayList;

public class Theama {

    ArrayList<Object> actorList = new ArrayList<>(); //lists all actors

    public ArrayList<Object> getActorList() {
        return actorList;
    }

    ArrayList<director> directorList = new ArrayList<>(); //lists all directors

    public ArrayList<director> getDirectorList() {
        return directorList;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRelease_year() {
        return release_year;
    }

    public void setRelease_year(String release_year) {
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

    public Object getDirector() {
        return director;
    }

    public Object getActors() {
        return actors;
    }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    String showType;
    String title;
    String release_year;
    String[] TagType;
    String country;
    Object director;
    Object[] actors;


    static class series extends Theama {

        int seasons;
        int episodes;
        String last_air;

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

        public String getLast_air() {
            return last_air;
        }

        public void setLast_air(String last_air) {
            this.last_air = last_air;
        }
    }

    public void newDirector(String name,String website,String b_country){

        director director = new director();
        director.setB_country(b_country);
        director.setName(name);
        director.setWebsite(website);
        directorList.add(director);

    }

    public void newActor(String name,String website,String b_country){

        actor actor = new actor();
        actor.setB_country(b_country);
        actor.setName(name);
        actor.setWebsite(website);
        actorList.add(actor);

    }


}


    class director{


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

