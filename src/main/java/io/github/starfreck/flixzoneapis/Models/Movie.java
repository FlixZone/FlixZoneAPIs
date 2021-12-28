package io.github.starfreck.flixzoneapis.Models;

import javax.persistence.*;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int theMovieDbId;
    private String title;
    private String telegramFileId;

    public Movie(){

    }
    public Movie(long id, int theMovieDbId, String title, String telegramFileId) {
        this.id = id;
        this.theMovieDbId = theMovieDbId;
        this.title = title;
        this.telegramFileId = telegramFileId;
    }

    public int getTheMovieDbId() {
        return theMovieDbId;
    }

    public void setTheMovieDbId(int theMovieDbId) {
        this.theMovieDbId = theMovieDbId;
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

    public void setTelegramFileId(String telegramFileID) {
        this.telegramFileId = telegramFileID;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", theMovieDBID=" + theMovieDbId +
                ", title='" + title + '\'' +
                ", telegramFileID='" + telegramFileId + '\'' +
                '}';
    }
}
