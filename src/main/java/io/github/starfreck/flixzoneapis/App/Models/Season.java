package io.github.starfreck.flixzoneapis.App.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long seasonId;

    private String title;
    @Column(length = 1200)
    private String overview;
    private String posterPath;

    private String airDate;

    @JsonIgnore
    @OneToMany(mappedBy = "season",cascade=CascadeType.ALL)
    private Set<Episode> episodes;

    @JsonIgnore
    @ManyToOne(optional = false)
    private TVShow tvShow;

    public Season() {
    }

    public Season(long id, long seasonId, String title, String overview, String posterPath, String airDate, TVShow tvShow) {
        this.id = id;
        this.seasonId = seasonId;
        this.title = title;
        this.overview = overview;
        this.posterPath = posterPath;
        this.airDate = airDate;
        this.tvShow = tvShow;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(long seasonId) {
        this.seasonId = seasonId;
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

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getAirDate() {
        return airDate;
    }

    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    public Set<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Set<Episode> episodes) {
        this.episodes = episodes;
    }

    public TVShow getTvShow() {
        return tvShow;
    }

    public void setTvShow(TVShow tvShow) {
        this.tvShow = tvShow;
    }

    @Override
    public String toString() {
        return "Season{" +
                "id=" + id +
                ", seasonId=" + seasonId +
                ", title='" + title + '\'' +
                ", overview='" + overview + '\'' +
                ", posterPath='" + posterPath + '\'' +
                ", airDate='" + airDate + '\'' +
                '}';
    }
}
