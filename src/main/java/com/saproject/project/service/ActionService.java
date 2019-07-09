package com.saproject.project.service;

import com.saproject.project.entity.Action;

import java.util.List;

public interface ActionService {

    List<Action> findAll();

    Action findById(long id);

    void save(Action action);

    void deleteById(long id);

}