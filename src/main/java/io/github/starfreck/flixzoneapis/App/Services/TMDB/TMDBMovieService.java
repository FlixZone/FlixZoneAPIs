package io.github.starfreck.flixzoneapis.App.Services.TMDB;

import io.github.starfreck.flixzoneapis.App.Models.Movie;
import io.github.starfreck.flixzoneapis.App.Models.TMDB.TMDBGenre;
import io.github.starfreck.flixzoneapis.App.Models.TMDB.TMDBMovie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.stream.Collectors;

@Service
public class TMDBMovieService {

    @Value("${tmdb.api.key}")
    private final String apiKey;

    @Value("${tmdb.api.movie.url}")
    private final String apiBaseUrl;

    @Value("${tmdb.img.base.url}")
    private final String imgBaseUrl;

    private WebClient client;

    public TMDBMovieService() {
        this.apiKey = null;
        this.apiBaseUrl = null;
        this.imgBaseUrl = null;
        this.client = null;

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

        client = WebClient.create(apiBaseUrl);

        return client.get()
                .uri("/{tmdbId}?api_key={apiKey}&language=en-US", tmdbId, apiKey)
                .retrieve()
                .bodyToMono(TMDBMovie.class)
                .block();
    }
}
