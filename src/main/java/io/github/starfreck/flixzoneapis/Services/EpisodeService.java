package io.github.starfreck.flixzoneapis.Services;

import io.github.starfreck.flixzoneapis.Models.Episode;
import io.github.starfreck.flixzoneapis.Models.Season;
import io.github.starfreck.flixzoneapis.Models.TVShow;
import io.github.starfreck.flixzoneapis.Repositories.EpisodeRepository;
import io.github.starfreck.flixzoneapis.Repositories.SeasonRepository;
import io.github.starfreck.flixzoneapis.Repositories.TVShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class EpisodeService {

    @Autowired
    private EpisodeRepository episodeRepository;

    @Autowired
    private  SeasonRepository seasonRepository;

    @Autowired
    private TVShowRepository tvShowRepository;

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

            episode.setSeason(season);
            episode.setTvShow(tvShow);

            episodeRepository.save(episode);

        }
    }

    public void updateEpisode(long tvShowId, long seasonId, Episode episode) {

        boolean hasEpisode = episodeRepository.existsEpisodeByTvShowIdAndSeason_IdAndEpisodeId(tvShowId, seasonId, episode.getEpisodeId());

        if (hasEpisode){

            Episode oldEpisode = episodeRepository.findEpisodeByTvShowIdAndSeason_IdAndEpisodeId(tvShowId, seasonId, episode.getEpisodeId());

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
