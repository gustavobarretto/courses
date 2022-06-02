package com.dh.courseservice.repository;

import com.dh.courseservice.config.ConfigLoadBalancer;
import com.dh.courseservice.model.dto.SubscriptionDTO;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name= "subscription-service")
@LoadBalancerClient(
        name = "subscription-service",
        configuration = ConfigLoadBalancer.class
        )
public interface FeignSubscriptionRepository {

    @RequestMapping(method = RequestMethod.GET,value = "/subscription/find")
    ResponseEntity<SubscriptionDTO> findByUserId(@RequestParam Integer userId);
}
