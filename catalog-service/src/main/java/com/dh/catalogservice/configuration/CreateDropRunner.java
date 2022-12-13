package com.dh.catalogservice.configuration;

import com.dh.catalogservice.repository.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
public class CreateDropRunner {

    private final CatalogRepository catalogRepository;

    // DROP DATA IN DATABASE WHEN APPLICATION IS SHUTDOWN
    @PreDestroy
    public void shutdown() {
        catalogRepository.deleteAll();
    }

    @Autowired
    public CreateDropRunner(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }
}