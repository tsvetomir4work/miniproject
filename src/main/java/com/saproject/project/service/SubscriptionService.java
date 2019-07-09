package com.saproject.project.service;

import com.saproject.project.entity.Subscription;

import java.util.List;

public interface SubscriptionService {

    List<Subscription> findAll();

    Subscription findById(long id);

    void save(Subscription sub);

    void deleteById(long id);



}