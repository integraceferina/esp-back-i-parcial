package com.dh.catalogservice.service;

import com.dh.catalogservice.model.Catalog;
import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.model.Serie;
import com.dh.catalogservice.repository.CatalogRepository;
import com.dh.catalogservice.repository.MovieRestRepository;
import com.dh.catalogservice.repository.SerieRestRepository;
import org.apache.commons.lang.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogService implements IEntityService<Catalog>{

    private final CatalogRepository catalogRepository;
    private final MovieRestRepository movieRestRepository;
    private final SerieRestRepository serieRestRepository;


    @Override
    public Optional<Catalog> getById(String id) {
        return catalogRepository.findById(id);
    }

    @Override
    public Catalog getByGenre(String genre) {

        String genero = WordUtils.capitalize(genre);

        List<Movie> movies = movieRestRepository.getMoviesByGenre(genero);
        List<Serie> series = serieRestRepository.getSeriesByGenre(genero);

        Catalog catalog = catalogRepository.findByGenre(genero).orElse(null);

        if(catalog != null){
            return catalogRepository.save(Catalog.builder().
                    id(catalog.getId()).
                    genre(genero).
                    movies(movies).
                    series(series).
                    build());
        }else {
            if(movies.size() > 0 || series.size() > 0) {
                return catalogRepository.save(Catalog.builder().genre(genero).movies(movies).series(series).build());
            }else{
                throw new RuntimeException("No movies or series were found for this genre " + genero);
            }
        }

    }

    @Override
    public Catalog upsert(Catalog entity) {
        return catalogRepository.save(entity);
    }

    @Autowired
    public CatalogService(CatalogRepository catalogRepository, MovieRestRepository movieRestRepository, SerieRestRepository serieRestRepository) {
        this.catalogRepository = catalogRepository;
        this.movieRestRepository = movieRestRepository;
        this.serieRestRepository = serieRestRepository;
    }
}
