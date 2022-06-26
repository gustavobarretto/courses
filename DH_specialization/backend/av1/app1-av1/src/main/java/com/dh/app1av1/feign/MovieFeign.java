package com.dh.app1av1.feign;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "movie-service")
@LoadBalancerClient(name = "movie-service",configuration = LoadBalancerClientConfiguration.class)
public interface MovieFeign {

    @RequestMapping(method = RequestMethod.GET, value = "movie/filter/{genre}")
    List<Object> findByGenre(@PathVariable String genre);


}
