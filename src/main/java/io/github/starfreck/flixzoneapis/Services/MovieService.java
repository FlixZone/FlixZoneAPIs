package io.github.starfreck.flixzoneapis.Services;

import io.github.starfreck.flixzoneapis.Models.Movie;
import io.github.starfreck.flixzoneapis.Repositories.MovieRepository;
import io.github.starfreck.flixzoneapis.Services.TMDB.TMDBMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TMDBMovieService tmdbMovieService;

    public Set getAllMovies() {
        Set<Movie> movies = new HashSet<>();
        movieRepository.findAll().forEach(movies::add);
        return  movies;
    }

    public Movie getMovie(long movieId){
       return movieRepository.findById(movieId).get();
    }

    public void addMovie(Movie movie){
        // only Add if it doesn't exist ( The tmdb id check)
        if(!movieRepository.existsMovieByTheMovieDbId(movie.getTheMovieDbId())){
            // Update Required Details from TMDB APIs
            tmdbMovieService.updateMovieDetails(movie);
            movieRepository.save(movie);
        }

    }

    public void updateMovie(Movie movie){
        // Update Required Details from TMDB APIs
        tmdbMovieService.updateMovieDetails(movie);
        movieRepository.save(movie);
    }

    public void deleteMovie(long movieId){
        movieRepository.deleteById(movieId);
    }

    public Set<Movie> searchMovie(String title) {
        return movieRepository.findAllByTitleIsContaining(title);
    }
}
