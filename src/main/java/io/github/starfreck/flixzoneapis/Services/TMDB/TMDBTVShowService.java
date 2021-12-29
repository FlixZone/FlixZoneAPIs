package io.github.starfreck.flixzoneapis.Services.TMDB;

import io.github.starfreck.flixzoneapis.Models.Episode;
import io.github.starfreck.flixzoneapis.Models.Season;
import io.github.starfreck.flixzoneapis.Models.TMDB.TMDBEpisode;
import io.github.starfreck.flixzoneapis.Models.TMDB.TMDBGenre;
import io.github.starfreck.flixzoneapis.Models.TMDB.TMDBSeason;
import io.github.starfreck.flixzoneapis.Models.TMDB.TMDBTVShow;
import io.github.starfreck.flixzoneapis.Models.TVShow;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.stream.Collectors;

@Service
public class TMDBTVShowService {

    @Value("${tmdb.api.key}")
    private final String apiKey;

    @Value("${tmdb.api.tv-show.url}")
    private final String apiBaseUrl;

    @Value("${tmdb.img.base.url}")
    private final String imgBaseUrl;

    private WebClient client;

    public TMDBTVShowService() {
        this.apiKey = null;
        this.apiBaseUrl = null;
        this.imgBaseUrl = null;
        this.client = null;
    }

    public void updateTVShowDetails(TVShow tvShow) {

        // Get TVShow Details from TMDB APIs
        TMDBTVShow tmdbtvShow = getTVShowDetails(tvShow.getTheMovieDbId());

        // Update the TVShow

        tvShow.setTitle(tmdbtvShow.getName());
        tvShow.setOverview(tmdbtvShow.getOverview());

        tvShow.setOriginalTitle(tmdbtvShow.getOriginal_name());
        tvShow.setOriginalLanguage(tmdbtvShow.getOriginal_language());

        tvShow.setPosterPath(imgBaseUrl+tmdbtvShow.getPoster_path());

        String Genres = tmdbtvShow.getGenres().stream().map(TMDBGenre::getName).collect(Collectors.joining(","));
        tvShow.setGenres(Genres);

        tvShow.setVoteCount(tmdbtvShow.getVote_count());
        tvShow.setVoteAverage(tmdbtvShow.getVote_average());
    }

    public void updateSeasonDetails(long theMovieDBId,Season season) {

        // Get TVShow Details from TMDB APIs
        TMDBSeason tmdbSeason = getSeasonDetails(theMovieDBId, season.getSeasonId());

        String releaseYear = tmdbSeason.getAir_date().split("-")[0];

        // Update the Season
        season.setTitle(tmdbSeason.getName()+" ("+releaseYear+")");
        season.setOverview(tmdbSeason.getOverview());
        season.setPosterPath(imgBaseUrl+tmdbSeason.getPoster_path());
        season.setAirDate(tmdbSeason.getAir_date());
    }

    public void updateEpisodeDetails(long theMovieDBId, long seasonId, Episode episode) {

        // Get TVShow Details from TMDB APIs
        TMDBEpisode tmdbEpisode = getEpisodeDetails(theMovieDBId, seasonId, episode.getEpisodeId());

        // Update the Season
        episode.setTitle(tmdbEpisode.getName());
        episode.setOverview(tmdbEpisode.getOverview());
        episode.setPosterPath(imgBaseUrl+tmdbEpisode.getStill_path());
        episode.setAirDate(tmdbEpisode.getAir_date());
        episode.setVoteCount(tmdbEpisode.getVote_count());
        episode.setVoteAverage(tmdbEpisode.getVote_average());

    }

    private TMDBTVShow getTVShowDetails(long tmdbId) {

        client = WebClient.create(apiBaseUrl);

        return client.get()
                .uri("/{tmdbId}?api_key={apiKey}&language=en-US", tmdbId, apiKey)
                .retrieve()
                .bodyToMono(TMDBTVShow.class)
                .block();
    }

    private TMDBSeason getSeasonDetails(long tmdbId, long seasonId) {

        client = WebClient.create(apiBaseUrl);

        return client.get()
                .uri("/{tmdbId}/season/{seasonId}?api_key={apiKey}&language=en-US", tmdbId, seasonId,apiKey)
                .retrieve()
                .bodyToMono(TMDBSeason.class)
                .block();
    }

    private TMDBEpisode getEpisodeDetails(long tmdbId, long seasonId, long episodeId) {

        client = WebClient.create(apiBaseUrl);

        return client.get()
                .uri("/{tmdbId}/season/{seasonId}/episode/{episodeId}?api_key={apiKey}&language=en-US", tmdbId, seasonId, episodeId, apiKey)
                .retrieve()
                .bodyToMono(TMDBEpisode.class)
                .block();
    }
}
