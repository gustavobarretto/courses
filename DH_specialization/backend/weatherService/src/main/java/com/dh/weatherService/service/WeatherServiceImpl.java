package com.dh.weatherService.service;

import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Override
    public Integer getTemperature(String city, String country) {
        return 25;
    }
}
