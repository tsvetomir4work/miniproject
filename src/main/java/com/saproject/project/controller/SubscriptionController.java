package com.saproject.project.controller;

import com.saproject.project.entity.Subscription;
import com.saproject.project.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/subscriptionapi")
public class SubscriptionController {

  private SubscriptionService subscriptionService;

  public SubscriptionController() {
    //default
  }

  @Autowired
  public SubscriptionController(SubscriptionService SubscriptionService) {
    this.subscriptionService = subscriptionService;
  }
  @RequestMapping(value = "/subscription", method = RequestMethod.GET)
  public List<Subscription> listAllSubscriptions(){
    return subscriptionService.findAll();
  }
  @RequestMapping(value = "/subscription/{id}", method = RequestMethod.GET)
  public Subscription getSubscriptionById(@PathVariable Long id){
    return subscriptionService.findById(id);
  }
  @RequestMapping(value = "/subscription/{id}", method = RequestMethod.POST)
  public ResponseEntity<Subscription> createSubscription(@RequestBody Subscription subscription){
    subscriptionService.save(subscription);
    return ResponseEntity.ok(subscription);
  }
  @RequestMapping(value = "/subscription/{id}", method = RequestMethod.DELETE)
  public Map<String, Boolean> deleteSubscription(@PathVariable Long id){
    subscriptionService.deleteById(id);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
}
