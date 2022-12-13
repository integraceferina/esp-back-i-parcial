package com.dh.catalogservice.message;

import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    /*private final RabbitTemplate rabbitTemplate;
    private final Queue catalogQueue;
    private static final Logger log = LoggerFactory.getLogger(MessageSender.class);*/


    /*public void send(Catalog catalog) {
        log.info("[SEND MESSAGE TO " + this.catalogQueue.getName() + "] -> " + catalog);
        this.rabbitTemplate.convertAndSend(this.catalogQueue.getName(), catalog);
    }*/


    /*@Autowired
    public MessageSender(RabbitTemplate rabbitTemplate, Queue catalogQueue) {
        this.rabbitTemplate = rabbitTemplate;
        this.catalogQueue = catalogQueue;
    }*/

}
