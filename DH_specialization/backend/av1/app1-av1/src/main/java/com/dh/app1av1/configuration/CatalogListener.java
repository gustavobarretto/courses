package com.dh.app1av1.configuration;

import com.dh.app1av1.entity.Catalog;
import com.dh.app1av1.service.CatalogService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CatalogListener {

    private final CatalogService service;

    @RabbitListener(queues = "QUEUE")
    public void receptor(MovieQueue movieQueue) {
        Catalog catalog = new Catalog();
        catalog.setGenre(movieQueue.getGenre());
        service.create(catalog);
    }
}
