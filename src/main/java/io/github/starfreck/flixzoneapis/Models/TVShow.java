package io.github.starfreck.flixzoneapis.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class TVShow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Long theMovieDbId;

    @JsonIgnore
    @OneToMany(mappedBy = "tvShow", cascade=CascadeType.ALL)
    private Set<Season> seasons;

    @JsonIgnore
    @OneToMany(mappedBy = "tvShow", cascade=CascadeType.ALL)
    private Set<Episode> episodes;

    public TVShow() {

    }

    public Set<Season> getSeasons() {
        return seasons;
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

    public void setSeasons(Set<Season> seasons) {
        this.seasons = seasons;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "TVShow{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", theMovieDbId=" + theMovieDbId +
                '}';
    }
}
