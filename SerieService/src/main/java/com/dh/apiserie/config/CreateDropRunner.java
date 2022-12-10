package com.dh.apiserie.config;

import com.dh.apiserie.models.Serie;
import com.dh.apiserie.repository.DbSequenceRepository;
import com.dh.apiserie.service.SerieService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;

@Component
public class CreateDropRunner {

    /* ===================== Attributes ===================== */

    private final SerieService serieService;
    private final DbSequenceRepository dbSequenceRepository;

    /* ===================== Methods ===================== */

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

    /* ===================== Constructors ===================== */

    @Autowired
    public CreateDropRunner(SerieService serieService, DbSequenceRepository dbSequenceRepository) {
        this.serieService = serieService;
        this.dbSequenceRepository = dbSequenceRepository;
    }
}
