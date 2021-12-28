package io.github.starfreck.flixzoneapis.Controllers;


import io.github.starfreck.flixzoneapis.Models.Movie;
import io.github.starfreck.flixzoneapis.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/search")
    public Set<Movie> searchMovie(@RequestParam(name="title", required = false, defaultValue = "") String title){
        return  movieService.searchMovie(title);
    }

    @GetMapping
    public Set<Movie> getAllMovies(){
        return  movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable("id") long id){
        return movieService.getMovie(id);
    }

    @PostMapping
    public void addMovie(@RequestBody Movie movie){
        this.movieService.addMovie(movie);
    }

    @PutMapping("/{id}")
    public void updateMovie(@PathVariable("id") long id, @RequestBody Movie movie){
        movie.setId(id);
        movieService.updateMovie(movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable("id") long id){
        this.movieService.deleteMovie(id);
    }
}
