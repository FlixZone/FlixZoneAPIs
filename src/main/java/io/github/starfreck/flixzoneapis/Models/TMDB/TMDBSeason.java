package io.github.starfreck.flixzoneapis.Models.TMDB;

public class TMDBSeason {

    private String name;
    private String overview;
    private String air_date;
    private String poster_path;

    public TMDBSeason() {
    }

    public TMDBSeason(String name, String overview, String air_date, String poster_path) {
        this.name = name;
        this.overview = overview;
        this.air_date = air_date;
        this.poster_path = poster_path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getAir_date() {
        return air_date;
    }

    public void setAir_date(String air_date) {
        this.air_date = air_date;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }
}
