package io.github.starfreck.flixzoneapis.App.Repositories;

import io.github.starfreck.flixzoneapis.App.Models.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface MovieRepository extends CrudRepository<Movie,Long> {

    public boolean existsMovieByTheMovieDbId(Long theMovieDbId);

    public Set<Movie> findAllByTitleIsContaining(String title);
}
