package com.dh.subscriptionservice.controllers;

import com.dh.subscriptionservice.model.Subscription;
import com.dh.subscriptionservice.service.ISubscrpcionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/subscription")
public class SubscriptionRestController {

    private ISubscrpcionService subscriptionService;

    @Value("${server.port}")
    private int serverPort;

    public SubscriptionRestController(ISubscrpcionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping("/find")
    public Subscription findSubscriptionByUser(@RequestParam Integer userId, HttpServletResponse response){
        System.out.println("PONG");
        response.addHeader("port", String.valueOf(serverPort));
        return subscriptionService.findSubscriptionByUserId(userId);
    }

}
