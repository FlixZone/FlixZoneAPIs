package io.github.starfreck.flixzoneapis.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long episodeId;
    private String title;
    @Column(length = 1200)
    private String overview;
    private String airDate;
    private String posterPath;

    private int voteCount;
    private double voteAverage;

    private String telegramFileId;

    @JsonIgnore
    @ManyToOne(optional = false)
    private Season season;

    @JsonIgnore
    @ManyToOne(optional = false)
    private TVShow tvShow;

    public Episode() {

    }

    public Episode(long id, long episodeId, String title, String overview, String airDate, String posterPath, int voteCount, double voteAverage, String telegramFileId, Season season, TVShow tvShow) {
        this.id = id;
        this.episodeId = episodeId;
        this.title = title;
        this.overview = overview;
        this.airDate = airDate;
        this.posterPath = posterPath;
        this.voteCount = voteCount;
        this.voteAverage = voteAverage;
        this.telegramFileId = telegramFileId;
        this.season = season;
        this.tvShow = tvShow;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(long episodeId) {
        this.episodeId = episodeId;
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

    public String getAirDate() {
        return airDate;
    }

    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
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

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public TVShow getTvShow() {
        return tvShow;
    }

    public void setTvShow(TVShow tvShow) {
        this.tvShow = tvShow;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "id=" + id +
                ", episodeId=" + episodeId +
                ", title='" + title + '\'' +
                ", overview='" + overview + '\'' +
                ", airDate='" + airDate + '\'' +
                ", posterPath='" + posterPath + '\'' +
                ", voteCount=" + voteCount +
                ", voteAverage=" + voteAverage +
                ", telegramFileId='" + telegramFileId + '\'' +
                '}';
    }
}

