package io.github.starfreck.flixzoneapis.App.Controllers;

import io.github.starfreck.flixzoneapis.App.Services.EpisodeService;
import io.github.starfreck.flixzoneapis.App.Models.Episode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/tv-shows/{tv-show-id}/seasons/{season-id}/episodes")
public class EpisodeController {

    @Autowired
    private EpisodeService episodeService;

    @GetMapping
    public Set<Episode> getAllEpisodes(@PathVariable("tv-show-id") long tvShowId, @PathVariable("season-id") long seasonId){
        return episodeService.getAllEpisodes(tvShowId, seasonId);
    }

    @GetMapping("/{id}")
    public Episode getEpisode(@PathVariable("tv-show-id") long tvShowId, @PathVariable("season-id") long seasonId, @PathVariable("id") long episodeId){
        return episodeService.getEpisode(tvShowId,seasonId,episodeId);
    }

    @PostMapping
    public void addEpisode(@PathVariable("tv-show-id") long tvShowId, @PathVariable("season-id") long seasonId, @RequestBody Episode episode){
        episodeService.addEpisode(tvShowId, seasonId, episode);
    }

    @PutMapping("/{id}")
    public void updateEpisode(@PathVariable("tv-show-id") long tvShowId, @PathVariable("season-id") long seasonId, @PathVariable("id") long episodeId, @RequestBody Episode episode){
        episode.setEpisodeId(episodeId);
        episodeService.updateEpisode(tvShowId, seasonId, episode);
    }

    @DeleteMapping("/{id}")
    public void deleteEpisode(@PathVariable("tv-show-id") long tvShowId, @PathVariable("season-id") long seasonId, @PathVariable("id") long episodeId){
        episodeService.deleteEpisode(tvShowId, seasonId, episodeId);
    }
}
