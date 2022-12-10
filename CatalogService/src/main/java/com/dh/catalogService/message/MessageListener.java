package com.dh.catalogService.message;

import com.dh.catalog.models.Movie;
import com.dh.catalog.models.Serie;
import com.dh.catalog.service.CatalogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    /* ========================== Attributes ========================== */

    private final CatalogService catalogService;
    private static final Logger log = LoggerFactory.getLogger(MessageListener.class);

    /* =========================== Methods =========================== */

    @RabbitListener(queues = "${queue.movie.name}")
    public void receiveMessageMovie(@Payload Movie movie) {
        try{
            log.info("[RECEIVE MESSAGE] MOVIE -> {}", movie);
            catalogService.getByGenre(movie.getGenre());
        }catch (Exception e){
            log.error("[ERROR] {}", e.getMessage());
        }
    }

    @RabbitListener(queues = "${queue.serie.name}")
    public void receiveMessageSerie(@Payload Serie serie) {
        try{
            log.info("[RECEIVE MESSAGE] SERIE -> {}", serie);
            catalogService.getByGenre(serie.getGenre());
        }catch (Exception e){
            log.error("[ERROR] {}", e.getMessage());
        }
    }


    /* ========================== Constructors ========================== */

    @Autowired
    public MessageListener(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

}