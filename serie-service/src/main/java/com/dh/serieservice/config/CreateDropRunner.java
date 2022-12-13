package com.dh.serieservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.dh.serieservice.model.Serie;
import com.dh.serieservice.repository.DbSequenceRepository;
import com.dh.serieservice.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;

@Component
public class CreateDropRunner {

    private final SerieService serieService;
    private final DbSequenceRepository dbSequenceRepository;


    // CREATE DATA IN DATABASE WHEN APPLICATION IS STARTED
    @PostConstruct
    public void init() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Resource resource = new ClassPathResource("import.json");
        Serie[] series = objectMapper.readValue(resource.getInputStream(), Serie[].class);

        for (Serie serie : series) {
            serieService.upsert(serie);
        }

    }

    // DROP DATA IN DATABASE WHEN APPLICATION IS SHUTDOWN
    @PreDestroy
    public void shutdown() {
        serieService.deleteAll();
        dbSequenceRepository.deleteAll();
    }


    @Autowired
    public CreateDropRunner(SerieService serieService, DbSequenceRepository dbSequenceRepository) {
        this.serieService = serieService;
        this.dbSequenceRepository = dbSequenceRepository;
    }
}
