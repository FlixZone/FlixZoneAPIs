package io.github.starfreck.flixzoneapis.Models.TMDB;

import java.util.List;

public class TMDBMovie {

    private String title;
    private String tagline;
    private String overview;

    private String release_date;
    private String original_title;
    private String original_language;

    private String poster_path;
    private List<TMDBGenre> TMDBGenres;

    private int vote_count;
    private double vote_average;

    public TMDBMovie() {
    }

    public TMDBMovie(String title, String tagline, String overview, String release_date, String original_title, String original_language, String poster_path, List<TMDBGenre> TMDBGenres, int vote_count, double vote_average) {
        this.title = title;
        this.tagline = tagline;
        this.overview = overview;
        this.release_date = release_date;
        this.original_title = original_title;
        this.original_language = original_language;
        this.poster_path = poster_path;
        this.TMDBGenres = TMDBGenres;
        this.vote_count = vote_count;
        this.vote_average = vote_average;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public List<TMDBGenre> getGenres() {
        return TMDBGenres;
    }

    public void setGenres(List<TMDBGenre> TMDBGenres) {
        this.TMDBGenres = TMDBGenres;
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

    @Override
    public String toString() {
        return "TMDBMovie{" +
                "title='" + title + '\'' +
                ", tagline='" + tagline + '\'' +
                ", overview='" + overview + '\'' +
                ", original_title='" + original_title + '\'' +
                ", original_language='" + original_language + '\'' +
                ", poster_path='" + poster_path + '\'' +
                ", genres=" + TMDBGenres +
                ", vote_count=" + vote_count +
                ", vote_average=" + vote_average +
                '}';
    }
}
