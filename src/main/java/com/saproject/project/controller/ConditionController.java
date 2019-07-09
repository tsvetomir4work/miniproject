package com.saproject.project.controller;

import com.saproject.project.entity.Condition;
import com.saproject.project.service.ConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/conditionapi")
public class ConditionController {

  private ConditionService conditionService;

  public ConditionController() {
    //default
  }

  @Autowired
  public ConditionController(ConditionService conditionService) {
    this.conditionService = conditionService;
  }
  @RequestMapping(value = "/condition", method = RequestMethod.GET)
  public List<Condition> listAllConditions(){
    return conditionService.findAll();
  }
  @RequestMapping(value = "/condition/{id}", method = RequestMethod.GET)
  public Condition getConditionById(@PathVariable Long id){
    return conditionService.findById(id);
  }
  @RequestMapping(value = "/condition/{id}", method = RequestMethod.POST)
  public ResponseEntity<Condition> createCondtion(@RequestBody Condition condition){
    conditionService.save(condition);
    return ResponseEntity.ok(condition);
  }
  @RequestMapping(value = "/condition/{id}", method = RequestMethod.DELETE)
  public Map<String, Boolean> deleteCondition(@PathVariable Long id){
    conditionService.deleteById(id);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
}
