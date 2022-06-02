package com.dh.subscriptionservice.service.impl;

import com.dh.subscriptionservice.model.Subscription;
import com.dh.subscriptionservice.repository.ISubscriptionRepository;
import com.dh.subscriptionservice.service.ISubscrpcionService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService implements ISubscrpcionService {
    private ISubscriptionRepository subscriptionRepository;

    public SubscriptionService(ISubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }


    @Override
    public Subscription findSubscriptionByUserId(Integer userId) {
        return subscriptionRepository.findByUserId(userId);
    }
}
