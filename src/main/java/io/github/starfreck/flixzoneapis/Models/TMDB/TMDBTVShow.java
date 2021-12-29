package io.github.starfreck.flixzoneapis.Models.TMDB;

import java.util.List;

public class TMDBTVShow {

    private String name;
    private String overview;

    private String original_name;
    private String original_language;

    private String poster_path;
    private List<TMDBGenre> genres;

    private int vote_count;
    private double vote_average;

    public TMDBTVShow() {
    }

    public TMDBTVShow(String name, String overview, String original_name, String original_language, String poster_path, List<TMDBGenre> genres, int vote_count, double vote_average) {
        this.name = name;
        this.overview = overview;
        this.original_name = original_name;
        this.original_language = original_language;
        this.poster_path = poster_path;
        this.genres = genres;
        this.vote_count = vote_count;
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

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
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
        return genres;
    }

    public void setGenres(List<TMDBGenre> genres) {
        this.genres = genres;
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
}
