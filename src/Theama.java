public class Theama {

    class Viewing {
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

        public void setType(String[] type) {
            this.TagType = type;
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

        public void setDirector(String director) {
            this.director = director;
        }

        public String[] getActors() {
            return actors;
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
        String[] TagType;
        String country;
        String director;
        String[] actors;
    }

    class series extends Viewing{

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


}
