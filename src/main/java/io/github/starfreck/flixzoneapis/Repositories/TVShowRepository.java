package io.github.starfreck.flixzoneapis.Repositories;

import io.github.starfreck.flixzoneapis.Models.TVShow;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface TVShowRepository extends CrudRepository<TVShow,Long> {

    // only add special methods

    public boolean existsTVShowByTheMovieDbId(Long theMovieDbId);

    public Set<TVShow> findAllByTitleIsContaining(String title);


}
