package com.dh.app1av1;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("catalog")
@AllArgsConstructor
public class CatalogController {

    private final CatalogService service;
    private final RestTemplate restTemplate;
    private static final Logger logger = LoggerFactory.getLogger(CatalogController.class);

    private final String applicationName = "catalog-service";


    @GetMapping("{genre}")
    public ResponseEntity<?> getMoviesByGenre(@PathVariable String genre) {
        logger.info("GET request at ", applicationName);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getByGenre(genre));
    }

}
