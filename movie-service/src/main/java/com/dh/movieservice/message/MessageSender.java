package com.dh.movieservice.message;


import com.dh.movieservice.models.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    private final RabbitTemplate rabbitTemplate;
    private final Queue catalogQueue;
    private static final Logger log = LoggerFactory.getLogger(MessageSender.class);


    public void send(Movie movie) {
        log.info("[SEND MESSAGE TO " + this.catalogQueue.getName() + "] -> " + movie);
        this.rabbitTemplate.convertAndSend(this.catalogQueue.getName(), movie);
    }

    @Autowired
    public MessageSender(RabbitTemplate rabbitTemplate, Queue catalogQueue) {
        this.rabbitTemplate = rabbitTemplate;
        this.catalogQueue = catalogQueue;
    }

}
