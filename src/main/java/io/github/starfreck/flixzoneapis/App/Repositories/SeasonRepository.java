package io.github.starfreck.flixzoneapis.App.Repositories;

import io.github.starfreck.flixzoneapis.App.Models.Season;
import org.springframework.data.repository.CrudRepository;

public interface SeasonRepository extends CrudRepository <Season,Long> {

    public Iterable<Season> findAllByTvShowId(long tvShowId);

    public Season findSeasonByTvShowIdAndAndSeasonId(long tvShowId, long seasonId);

    public boolean existsSeasonByTvShowIdAndSeasonId(long tvShowId, long seasonId);

}
