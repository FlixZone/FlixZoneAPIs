package io.github.starfreck.flixzoneapis.App.Models.TMDB;

public class TMDBEpisode {

    private int vote_count;
    private double vote_average;

    private String name;
    private String overview;
    private String air_date;
    private String still_path;

    public TMDBEpisode() {
    }

    public TMDBEpisode(int vote_count, double vote_average, String name, String overview, String air_date, String still_path) {
        this.vote_count = vote_count;
        this.vote_average = vote_average;
        this.name = name;
        this.overview = overview;
        this.air_date = air_date;
        this.still_path = still_path;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
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

    public String getStill_path() {
        return still_path;
    }

    public void setStill_path(String still_path) {
        this.still_path = still_path;
    }
}
