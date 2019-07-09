package com.saproject.project.service;

import com.saproject.project.entity.Condition;
import com.saproject.project.repositories.ConditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ConditionServiceImpl implements ConditionService {


    private ConditionRepository conditionRepository;

    @Autowired
    public ConditionServiceImpl(ConditionRepository conditionRepository) {
        this.conditionRepository = conditionRepository;
    }

    @Override
    public List<Condition> findAll() {
        return conditionRepository.findAll();
    }

    @Override
    public Condition findById(long id) {
        Optional<Condition> result = conditionRepository.findById(id);

        Condition condition = null;

        if (result.isPresent()) {
            condition = result.get();
        } else {
            throw new RuntimeException("Did not find condition id - " + id);
        }

        return condition;
    }

    @Override
    public void save(Condition condition) {
        conditionRepository.save(condition);
    }

    @Override
    public void deleteById(long id) {
        conditionRepository.deleteById(id);
    }

}

