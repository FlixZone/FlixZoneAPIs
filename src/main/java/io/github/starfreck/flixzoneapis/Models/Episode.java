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
    private String telegramFileId;

    @JsonIgnore
    @ManyToOne(optional = false)
    private Season season;

    @JsonIgnore
    @ManyToOne(optional = false)
    private TVShow tvShow;

    public Episode() {

    }

    public Episode(long id, long episodeId, String title, String telegramFileId, Season season, TVShow tvShow) {
        this.id = id;
        this.episodeId = episodeId;
        this.title = title;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTelegramFileId() {
        return telegramFileId;
    }

    public void setTelegramFileId(String telegramFileId) {
        this.telegramFileId = telegramFileId;
    }

    public long getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(long episodeId) {
        this.episodeId = episodeId;
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
                ", telegramFileId='" + telegramFileId + '\'' +
                ", season=" + season +
                '}';
    }
}

