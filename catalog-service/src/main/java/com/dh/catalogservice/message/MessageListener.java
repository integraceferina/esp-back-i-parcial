package com.dh.catalogservice.message;

import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.model.Serie;
import com.dh.catalogservice.service.CatalogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    private final CatalogService catalogService;
    private static final Logger log = LoggerFactory.getLogger(MessageListener.class);

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

    @Autowired
    public MessageListener(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

}
