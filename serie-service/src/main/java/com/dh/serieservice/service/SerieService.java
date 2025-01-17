package com.dh.serieservice.service;

import com.dh.serieservice.message.MessageSender;
import com.dh.serieservice.model.Chapter;
import com.dh.serieservice.model.Season;
import com.dh.serieservice.model.Serie;
import com.dh.serieservice.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService implements IEntityService<Serie> {


    private final SerieRepository serieRepository;
    private final SequenceGeneratorService sequenceGeneratorService;
    private final MessageSender messageSender;


    @Override
    public List<Serie> getAll() {
        return serieRepository.findAll();
    }

    @Override
    public Serie getById(Long id) {
        return serieRepository.findById(id).orElse(null);
    }

    @Override
    public Serie upsert(Serie entity) {

        entity.setId(sequenceGeneratorService.getSequenceNumber(Serie.SEQUENCE_NAME));
        entity.getSeasons().forEach(season -> {
            season.setId(sequenceGeneratorService.getSequenceNumber(Season.SEQUENCE_NAME));
            season.getChapters().forEach(chapter -> {
                chapter.setId(sequenceGeneratorService.getSequenceNumber(Chapter.SEQUENCE_NAME));
            });
        });

        messageSender.send(entity);
        return serieRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        serieRepository.deleteById(id);
    }

    public List<Serie> getSeriesByGenre(String genre) {
        return serieRepository.findAllByGenre(genre);
    }

    public void deleteAll() {
        serieRepository.deleteAll();
    }


    @Autowired
    public SerieService(SerieRepository serieRepository, SequenceGeneratorService sequenceGeneratorService, MessageSender messageSender) {
        this.serieRepository = serieRepository;
        this.sequenceGeneratorService = sequenceGeneratorService;
        this.messageSender = messageSender;
    }

}
