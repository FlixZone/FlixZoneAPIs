package io.github.starfreck.flixzoneapis.App.Models.TMDB;

public class TMDBGenre {

    int id;
    String name;

    public TMDBGenre() {
    }

    public TMDBGenre(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TMDBGenre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}