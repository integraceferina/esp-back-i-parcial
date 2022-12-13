package com.dh.movieservice.message;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageListener {


    /* @RabbitListener(queues = "${queue.movie.name}")
    public void receiveMessage(@Payload Movie movie) {
        System.out.println(movie);
    }*/
}
