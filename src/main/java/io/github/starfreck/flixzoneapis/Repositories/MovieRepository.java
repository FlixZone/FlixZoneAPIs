package io.github.starfreck.flixzoneapis.Repositories;

import io.github.starfreck.flixzoneapis.Models.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface MovieRepository extends CrudRepository<Movie,Long> {

    // only add special methods

    public Set<Movie> findAllByTitleIsContaining(String title);
}
