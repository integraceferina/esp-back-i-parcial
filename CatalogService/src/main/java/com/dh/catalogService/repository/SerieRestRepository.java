package com.dh.catalogService.repository;

import com.dh.catalogService.models.Serie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "serie-service", path = "/series")
public interface SerieRestRepository {

    @GetMapping("/{id}")
    Serie getSerieById(@PathVariable Long id);

    @GetMapping("/genres/{genre}")
    List<Serie> getSeriesByGenre(@PathVariable String genre);
}
