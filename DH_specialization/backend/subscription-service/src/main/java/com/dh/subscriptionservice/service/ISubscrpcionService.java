package com.dh.subscriptionservice.service;

import com.dh.subscriptionservice.model.Subscription;

public interface ISubscrpcionService {

     Subscription findSubscriptionByUserId(Integer userId);

}
