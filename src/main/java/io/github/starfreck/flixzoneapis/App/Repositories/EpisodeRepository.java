package io.github.starfreck.flixzoneapis.App.Repositories;

import io.github.starfreck.flixzoneapis.App.Models.Episode;
import org.springframework.data.repository.CrudRepository;


public interface EpisodeRepository extends CrudRepository <Episode,Long> {

    public Iterable<Episode> findAllByTvShowIdAndSeason_Id(long tvShowId, long seasonId);

    public Episode findEpisodeByTvShowIdAndSeason_IdAndEpisodeId(long tvShowId, long seasonId, long episodeId);

    public boolean existsEpisodeByTvShowIdAndSeason_IdAndEpisodeId(long tvShowId, long seasonId, long episodeId);

}
