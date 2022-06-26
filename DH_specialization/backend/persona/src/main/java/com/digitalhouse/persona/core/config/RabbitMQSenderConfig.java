package com.digitalhouse.persona.core.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQSenderConfig {

    @Value("${queue.persona.name}")
    private String personaQueue;

    @Bean
    public Queue queue() {
        return new Queue(this.personaQueue, false);
    }

}
