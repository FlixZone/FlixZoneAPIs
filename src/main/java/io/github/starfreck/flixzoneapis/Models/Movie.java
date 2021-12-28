package io.github.starfreck.flixzoneapis.Models;


import javax.persistence.*;


@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int theMovieDbId;

    private String title;
    private String tagline;
    @Column(length = 1200)
    private String overview;

    private String originalTitle;
    private String originalLanguage;

    private String posterPath;
    private String genres;

    private int voteCount;
    private double voteAverage;

    private String telegramFileId;

    public Movie(){

    }

    public Movie(long id, int theMovieDbId, String title, String tagline, String overview, String originalTitle, String originalLanguage, String posterPath, String genres, int voteCount, double voteAverage, String telegramFileId) {
        this.id = id;
        this.theMovieDbId = theMovieDbId;
        this.title = title;
        this.tagline = tagline;
        this.overview = overview;
        this.originalTitle = originalTitle;
        this.originalLanguage = originalLanguage;
        this.posterPath = posterPath;
        this.genres = genres;
        this.voteCount = voteCount;
        this.voteAverage = voteAverage;
        this.telegramFileId = telegramFileId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTheMovieDbId() {
        return theMovieDbId;
    }

    public void setTheMovieDbId(int theMovieDbId) {
        this.theMovieDbId = theMovieDbId;
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

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getTelegramFileId() {
        return telegramFileId;
    }

    public void setTelegramFileId(String telegramFileId) {
        this.telegramFileId = telegramFileId;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", theMovieDbId=" + theMovieDbId +
                ", title='" + title + '\'' +
                ", tagline='" + tagline + '\'' +
                ", overview='" + overview + '\'' +
                ", originalTitle='" + originalTitle + '\'' +
                ", originalLanguage='" + originalLanguage + '\'' +
                ", posterPath='" + posterPath + '\'' +
                ", genres='" + genres + '\'' +
                ", voteCount=" + voteCount +
                ", voteAverage=" + voteAverage +
                ", telegramFileId='" + telegramFileId + '\'' +
                '}';
    }
}
