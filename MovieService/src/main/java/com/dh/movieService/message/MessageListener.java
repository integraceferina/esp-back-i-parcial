package com.dh.movieService.message;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageListener {

    /* =========================== Methods =========================== */

    /* @RabbitListener(queues = "${queue.movie.name}")
    public void receiveMessage(@Payload Movie movie) {
        System.out.println(movie);
    }*/
}
