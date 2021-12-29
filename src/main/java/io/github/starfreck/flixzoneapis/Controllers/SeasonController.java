package io.github.starfreck.flixzoneapis.Controllers;

import io.github.starfreck.flixzoneapis.Models.Season;
import io.github.starfreck.flixzoneapis.Services.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/tv-shows/{tv-show-id}/seasons")
public class SeasonController {

    @Autowired
    private SeasonService seasonService;

    @GetMapping
    public Set<Season> getAllSeasons(@PathVariable("tv-show-id") long tvShowId){
        return seasonService.getAllSeasons(tvShowId);
    }

    @GetMapping("/{id}")
    public Season getSeason(@PathVariable("tv-show-id") long tvShowId, @PathVariable("id") long seasonId){
        return seasonService.getSeason(tvShowId,seasonId);
    }

    @PostMapping
    public void addSeason(@PathVariable("tv-show-id") long tvShowId, @RequestBody Season season){
        seasonService.addSeason(tvShowId, season);
    }

    @PutMapping("/{id}")
    public void updateSeason(@PathVariable("tv-show-id") long tvShowId, @PathVariable("id") long seasonId, @RequestBody Season season){
        season.setSeasonId(seasonId);
        seasonService.updateSeason(tvShowId, season);
    }

    @DeleteMapping("/{id}")
    public void deleteSeason(@PathVariable("tv-show-id") long tvShowId, @PathVariable("id") long seasonId){
        seasonService.deleteSeason(tvShowId, seasonId);
    }
}
