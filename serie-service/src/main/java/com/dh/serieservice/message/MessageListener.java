package com.dh.serieservice.message;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageListener {


    /* @RabbitListener(queues = "${queue.serie.name}")
    public void receiveMessage(@Payload Serie serie) {
        System.out.println(movie);
    }*/
}
