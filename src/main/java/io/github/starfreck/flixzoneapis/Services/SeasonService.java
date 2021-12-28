package io.github.starfreck.flixzoneapis.Services;

import io.github.starfreck.flixzoneapis.Models.Season;
import io.github.starfreck.flixzoneapis.Models.TVShow;
import io.github.starfreck.flixzoneapis.Repositories.SeasonRepository;
import io.github.starfreck.flixzoneapis.Repositories.TVShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SeasonService {

    @Autowired
    TVShowRepository tvShowRepository;

    @Autowired
    SeasonRepository seasonRepository;

    public Set<Season> getAllSeasons(long tvShowId) {
        Set<Season> seasons = new HashSet<>();
        seasonRepository.findAllByTvShowId(tvShowId).forEach(seasons::add);
        return  seasons;
    }

    public Season getSeason(long tvShowId, long seasonId){
        return seasonRepository.findSeasonByTvShowIdAndAndSeasonId(tvShowId, seasonId);
    }

    public void addSeason(long tvShowId, Season season) {

        boolean hasSeason = seasonRepository.existsSeasonByTvShowIdAndSeasonId(tvShowId, season.getSeasonId());

        if (!hasSeason){

            TVShow tvShow = tvShowRepository.findById(tvShowId).get();

            // Store TV Show
            season.setTvShow(tvShow);
            System.out.println(season);
            seasonRepository.save(season);
        }
    }

    public void updateSeason(long tvShowId, Season season){

        boolean hasSeason = seasonRepository.existsSeasonByTvShowIdAndSeasonId(tvShowId, season.getSeasonId());

        if (hasSeason) {

            Season oldSeason = seasonRepository.findSeasonByTvShowIdAndAndSeasonId(tvShowId, season.getSeasonId());

            oldSeason.setTitle(season.getTitle());
            System.out.println(oldSeason);
            seasonRepository.save(oldSeason);
        }
    }

    public void deleteSeason(long tvShowId, long seasonId){
        Season season = seasonRepository.findSeasonByTvShowIdAndAndSeasonId(tvShowId,seasonId);
        if(season != null){
            seasonRepository.deleteById(season.getId());
        }
    }
}
