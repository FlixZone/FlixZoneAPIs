package io.github.starfreck.flixzoneapis.Repositories;

import io.github.starfreck.flixzoneapis.Models.Season;
import org.hibernate.sql.Delete;
import org.springframework.data.repository.CrudRepository;

public interface SeasonRepository extends CrudRepository <Season,Long> {

    public Iterable<Season> findAllByTvShowId(long tvShowId);

    public Season findSeasonByTvShowIdAndAndSeasonId(long tvShowId, long seasonId);

    public boolean existsSeasonByTvShowIdAndSeasonId(long tvShowId, long seasonId);

}
