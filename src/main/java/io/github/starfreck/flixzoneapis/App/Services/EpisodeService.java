package io.github.starfreck.flixzoneapis.App.Services;

import io.github.starfreck.flixzoneapis.App.Repositories.EpisodeRepository;
import io.github.starfreck.flixzoneapis.App.Repositories.SeasonRepository;
import io.github.starfreck.flixzoneapis.App.Repositories.TVShowRepository;
import io.github.starfreck.flixzoneapis.App.Services.TMDB.TMDBTVShowService;
import io.github.starfreck.flixzoneapis.App.Models.Episode;
import io.github.starfreck.flixzoneapis.App.Models.Season;
import io.github.starfreck.flixzoneapis.App.Models.TVShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class EpisodeService {

    @Autowired
    private EpisodeRepository episodeRepository;

    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private TVShowRepository tvShowRepository;

    @Autowired
    private TMDBTVShowService tmdbtvShowService;

    public Set<Episode> getAllEpisodes(long tvShowId, long seasonId) {
        Set<Episode> episodes = new HashSet<>();
        episodeRepository.findAllByTvShowIdAndSeason_Id(tvShowId, seasonId).forEach(episodes::add);
        return  episodes;
    }

    public Episode getEpisode(long tvShowId, long seasonId, long episodeId) {
        return episodeRepository.findEpisodeByTvShowIdAndSeason_IdAndEpisodeId(tvShowId, seasonId, episodeId);
    }

    public void addEpisode(long tvShowId, long seasonId, Episode episode) {

        boolean hasEpisode = episodeRepository.existsEpisodeByTvShowIdAndSeason_IdAndEpisodeId(tvShowId, seasonId, episode.getEpisodeId());

        if (!hasEpisode){


            TVShow tvShow = tvShowRepository.findById(tvShowId).get();
            Season season = seasonRepository.findSeasonByTvShowIdAndAndSeasonId(tvShowId, seasonId);

            // Update Episode
            tmdbtvShowService.updateEpisodeDetails(tvShow.getTheMovieDbId(), seasonId, episode);
            // Required?
            episode.setSeason(season);
            episode.setTvShow(tvShow);

            episodeRepository.save(episode);

        }
    }

    public void updateEpisode(long tvShowId, long seasonId, Episode episode) {

        boolean hasEpisode = episodeRepository.existsEpisodeByTvShowIdAndSeason_IdAndEpisodeId(tvShowId, seasonId, episode.getEpisodeId());

        if (hasEpisode){

            TVShow tvShow = tvShowRepository.findById(tvShowId).get();
            Episode oldEpisode = episodeRepository.findEpisodeByTvShowIdAndSeason_IdAndEpisodeId(tvShowId, seasonId, episode.getEpisodeId());

            // Update Episode
            tmdbtvShowService.updateEpisodeDetails(tvShow.getTheMovieDbId(), seasonId, episode);

            oldEpisode.setTitle(episode.getTitle());
            oldEpisode.setTelegramFileId(episode.getTelegramFileId());

            episodeRepository.save(oldEpisode);

        }
    }

    public void deleteEpisode(long tvShowId, long seasonId, long episodeId) {

        boolean hasEpisode = episodeRepository.existsEpisodeByTvShowIdAndSeason_IdAndEpisodeId(tvShowId, seasonId, episodeId);

        if (hasEpisode){

            Episode episode = episodeRepository.findEpisodeByTvShowIdAndSeason_IdAndEpisodeId(tvShowId, seasonId, episodeId);

            episodeRepository.deleteById(episode.getId());

        }
    }
}
