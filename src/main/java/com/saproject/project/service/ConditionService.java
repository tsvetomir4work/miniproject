package com.saproject.project.service;

import com.saproject.project.entity.Condition;

import java.util.List;

public interface ConditionService {

    List<Condition> findAll();

    Condition findById(long id);

    void save(Condition condition);

    void deleteById(long id);

}