package com.dh.catalogservice.repository;


import com.dh.catalogservice.model.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "movie-service", path = "/movies")
public interface MovieRestRepository {

    @GetMapping("/{id}")
    Movie getMovie(@PathVariable Long id);

    @GetMapping("/genres/{genre}")
    List<Movie> getMoviesByGenre(@PathVariable String genre);

}