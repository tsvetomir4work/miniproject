package com.saproject.project.service;

import com.saproject.project.entity.Subscription;
import com.saproject.project.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SubscriptionServiceImpl implements SubscriptionService {


    private SubscriptionRepository subscriptionRepository;

    @Autowired
    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public List<Subscription> findAll() {
        return subscriptionRepository.findAll();
    }

    @Override
    public Subscription findById(long id) {
        Optional<Subscription> result = subscriptionRepository.findById(id);

        Subscription subscription= null;

        if (result.isPresent()) {
            subscription = result.get();
        } else {
            throw new RuntimeException("Did not find Subscription id - " + id);
        }

        return subscription;
    }

    @Override
    public void save(Subscription subscription) {
        subscriptionRepository.save(subscription);
    }

    @Override
    public void deleteById(long id) {
        subscriptionRepository.deleteById(id);
    }

}

