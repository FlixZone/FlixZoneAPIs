package io.github.starfreck.flixzoneapis.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class TVShow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long theMovieDbId;

    private String title;
    @Column(length = 1200)
    private String overview;

    private String originalTitle;
    private String originalLanguage;

    private String posterPath;
    private String genres;

    private int voteCount;
    private double voteAverage;

    @JsonIgnore
    @OneToMany(mappedBy = "tvShow", cascade=CascadeType.ALL)
    private Set<Season> seasons;

    @JsonIgnore
    @OneToMany(mappedBy = "tvShow", cascade=CascadeType.ALL)
    private Set<Episode> episodes;

    public TVShow() {

    }

    public TVShow(Long id, Long theMovieDbId, String title, String overview, String originalTitle, String originalLanguage, String posterPath, String genres, int voteCount, double voteAverage) {
        this.id = id;
        this.theMovieDbId = theMovieDbId;
        this.title = title;
        this.overview = overview;
        this.originalTitle = originalTitle;
        this.originalLanguage = originalLanguage;
        this.posterPath = posterPath;
        this.genres = genres;
        this.voteCount = voteCount;
        this.voteAverage = voteAverage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTheMovieDbId() {
        return theMovieDbId;
    }

    public void setTheMovieDbId(Long theMovieDbId) {
        this.theMovieDbId = theMovieDbId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Set<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(Set<Season> seasons) {
        this.seasons = seasons;
    }

    public Set<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Set<Episode> episodes) {
        this.episodes = episodes;
    }

    @Override
    public String toString() {
        return "TVShow{" +
                "id=" + id +
                ", theMovieDbId=" + theMovieDbId +
                ", title='" + title + '\'' +
                ", overview='" + overview + '\'' +
                ", originalTitle='" + originalTitle + '\'' +
                ", originalLanguage='" + originalLanguage + '\'' +
                ", posterPath='" + posterPath + '\'' +
                ", genres='" + genres + '\'' +
                ", voteCount=" + voteCount +
                ", voteAverage=" + voteAverage +
                '}';
    }
}
