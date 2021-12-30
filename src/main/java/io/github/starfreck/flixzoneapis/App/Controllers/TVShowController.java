package io.github.starfreck.flixzoneapis.App.Controllers;

import io.github.starfreck.flixzoneapis.App.Models.TVShow;
import io.github.starfreck.flixzoneapis.App.Services.TVShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/tv-shows")
public class TVShowController {

    @Autowired
    private TVShowService tvShowService;

    @GetMapping("/search")
    public Set<TVShow> searchTVShow(@RequestParam(name="title", required = false, defaultValue = "") String title){
        return  tvShowService.searchTVShow(title);
    }


    @GetMapping
    public Set<TVShow> getAllTVShows(){
        return tvShowService.getAllTVShows();
    }

    @GetMapping("/{id}")
    public TVShow getTVShow(@PathVariable("id") long id){
        return tvShowService.getTVShow(id);
    }

    @PostMapping
    public void addTVShow(@RequestBody TVShow tvShow){
        tvShowService.addTVShow(tvShow);
    }

    @PutMapping("/{id}")
    public void updateTVShow(@PathVariable("id") long id, @RequestBody TVShow tvShow){
        tvShow.setId(id);
        System.out.println(tvShow);
        tvShowService.updateTVShow(tvShow);
    }

    @DeleteMapping("/{id}")
    public void deleteTVShow(@PathVariable("id") long id){
        tvShowService.deleteTVShow(id);
    }
}
