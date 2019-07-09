package com.saproject.project.controller;

import com.saproject.project.entity.Action;
import com.saproject.project.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/actionapi")
public class ActionController {

  private ActionService actionService;

  public ActionController() {
    //default
  }

  @Autowired
  public ActionController(ActionService actionService) {
    this.actionService = actionService;
  }
  @RequestMapping(value = "/action", method = RequestMethod.GET, produces = { MediaTypes.HAL_JSON_UTF8_VALUE})
  public List<Action> listAllActions(){
    return actionService.findAll();
  }
  @RequestMapping(value = "/action/{id}", method = RequestMethod.GET)
  public Action getActionById(@PathVariable Long id){
    return actionService.findById(id);
  }
  @RequestMapping(value = "/action", method = RequestMethod.POST)
  public ResponseEntity<Action> createAction(@RequestBody Action action){
    actionService.save(action);

    return ResponseEntity.ok(action);
  }
  @RequestMapping(value = "/action/{id}", method = RequestMethod.DELETE)
  public Map<String, Boolean> deleteAction(@PathVariable Long id){
    actionService.deleteById(id);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
}