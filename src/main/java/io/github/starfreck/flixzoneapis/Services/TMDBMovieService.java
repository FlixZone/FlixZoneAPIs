package io.github.starfreck.flixzoneapis.Services;

import io.github.starfreck.flixzoneapis.Models.Movie;
import io.github.starfreck.flixzoneapis.Models.TMDB.TMDBGenre;
import io.github.starfreck.flixzoneapis.Models.TMDB.TMDBMovie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.stream.Collectors;

@Service
public class TMDBMovieService {

    @Value("${tmdb.api.key}")
    private final String apiKey;
    @Value("${tmdb.img.base.url}")
    private final String imgBaseUrl;

    private final WebClient client;

    public TMDBMovieService() {
        apiKey = null;
        imgBaseUrl = "";
        client = WebClient.create("https://api.themoviedb.org/3/movie");
    }

    public void updateMovieDetails(Movie movie) {

        // Get Movie Details from TMDB APIs
        TMDBMovie tmdbMovie = getMovieDetails(movie.getTheMovieDbId());

        // Update the Movie
        String releaseYear = tmdbMovie.getRelease_date().split("-")[0];

        movie.setTitle(tmdbMovie.getTitle()+" ("+releaseYear+")");
        movie.setTagline(tmdbMovie.getTagline());
        movie.setOverview(tmdbMovie.getOverview());

        movie.setOriginalTitle(tmdbMovie.getOriginal_title());
        movie.setOriginalLanguage(tmdbMovie.getOriginal_language());

        movie.setPosterPath(imgBaseUrl+tmdbMovie.getPoster_path());

        String Genres = tmdbMovie.getGenres().stream().map(TMDBGenre::getName).collect(Collectors.joining(","));
        movie.setGenres(Genres);

        movie.setVoteCount(tmdbMovie.getVote_count());
        movie.setVoteAverage(tmdbMovie.getVote_average());

    }

    private TMDBMovie getMovieDetails(long tmdbId) {

        return client.get()
                .uri("/{tmdbId}?api_key={apiKey}&language=en-US", tmdbId, apiKey)
                .retrieve()
                .bodyToMono(TMDBMovie.class)
                .block();
    }
}
