package com.dh.serieservice.controller;


import com.dh.serieservice.model.Chapter;
import com.dh.serieservice.model.Season;
import com.dh.serieservice.model.Serie;
import com.dh.serieservice.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {


    private final SerieService serieService;


    @GetMapping
    public ResponseEntity<?> getAllSeries() {
        return ResponseEntity.ok(serieService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSerieById(@PathVariable Long id) {
        return ResponseEntity.ok(serieService.getById(id));
    }

    @GetMapping("/genres/{genre}")
    public ResponseEntity<?> getSeriesByGenre(@PathVariable String genre) {
        return ResponseEntity.ok(serieService.getSeriesByGenre(genre));
    }

    @GetMapping("/fallback")
    public ResponseEntity<?> fallback() {
        Serie serieFallback = new Serie();
        Chapter chapterFallback = new Chapter();
        Season seasonFallback = new Season();

        serieFallback.setId(0L);
        serieFallback.setName("Serie without content");
        serieFallback.setGenre("Unknown");

        chapterFallback.setId(0L);
        chapterFallback.setName("Chapter without content");
        chapterFallback.setNumber(0L);
        chapterFallback.setUrlStream("https://cdn.dribbble.com/users/1249496/screenshots/14000121/media/47911b2981d74902155919dc58762d01.gif");

        seasonFallback.setId(0L);
        seasonFallback.setSeasonNumber(0);
        seasonFallback.setChapters(List.of(chapterFallback));
        serieFallback.setSeasons(List.of(seasonFallback));

        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body(serieFallback);
    }

    @PostMapping
    public ResponseEntity<?> createSerie(@RequestBody Serie serie) {
        return ResponseEntity.status(HttpStatus.CREATED).body(serieService.upsert(serie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSerie(@PathVariable Long id) {
        serieService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Autowired
    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }
}
