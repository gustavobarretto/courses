package com.dh.weatherService.controller;

import com.dh.weatherService.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping()
    public Integer getTemperatureByCityAndCountry(@RequestParam String city, @RequestParam String country){
        return weatherService.getTemperature(city,country);
    }

}
