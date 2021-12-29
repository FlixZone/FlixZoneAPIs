package io.github.starfreck.flixzoneapis.Services;

import io.github.starfreck.flixzoneapis.Models.TVShow;
import io.github.starfreck.flixzoneapis.Repositories.TVShowRepository;
import io.github.starfreck.flixzoneapis.Services.TMDB.TMDBTVShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class TVShowService {

    @Autowired
    private TVShowRepository tvShowRepository;

    @Autowired
    private TMDBTVShowService tmdbtvShowService;

    public Set<TVShow> getAllTVShows() {
        Set<TVShow> tvShows = new HashSet<>();
        tvShowRepository.findAll().forEach(tvShows::add);
        return  tvShows;
    }

    public TVShow getTVShow(long id){
        return tvShowRepository.findById(id).get();
    }

    public void addTVShow(TVShow tvShow){
        // only Add if it doesn't exist ( The tmdb id check)
        if(!tvShowRepository.existsTVShowByTheMovieDbId(tvShow.getTheMovieDbId())){
            // Update Required Details from TMDB APIs
            tmdbtvShowService.updateTVShowDetails(tvShow);
            tvShowRepository.save(tvShow);
        }
    }

    public void updateTVShow(TVShow tvShow){
        // Update Required Details from TMDB APIs
        tmdbtvShowService.updateTVShowDetails(tvShow);
        tvShowRepository.save(tvShow);
    }

    public void deleteTVShow(long id){
        tvShowRepository.deleteById(id);
    }

    public Set<TVShow> searchTVShow(String title) {
        return tvShowRepository.findAllByTitleIsContaining(title);
    }
}
