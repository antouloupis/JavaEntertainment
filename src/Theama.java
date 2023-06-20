public class Theama {


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

    public String getDirector() {
        return director;
    }





    public void setActors(String[] actors) {
        this.actors = actors;
    }

    public String getVtype() {
        return vtype;
    }

    public void setVtype(String vtype) {
        this.vtype = vtype;
    }

    String vtype;
    String title;
    String release_year;
    String[] TagType = new String[0];
    String country;
    String director;
    String[] actors = new String[0];


    class series extends Theama{

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


    class director{

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


    }

    class actor{
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

    }
}
