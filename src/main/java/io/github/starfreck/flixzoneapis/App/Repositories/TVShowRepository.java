package io.github.starfreck.flixzoneapis.App.Repositories;

import io.github.starfreck.flixzoneapis.App.Models.TVShow;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface TVShowRepository extends CrudRepository<TVShow,Long> {

    public boolean existsTVShowByTheMovieDbId(Long theMovieDbId);

    public Set<TVShow> findAllByTitleIsContaining(String title);

}
