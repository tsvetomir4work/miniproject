package com.saproject.project.service;

import com.saproject.project.entity.Action;
import com.saproject.project.repositories.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ActionServiceImpl implements ActionService {


    private ActionRepository actionRepository;

    @Autowired
    public ActionServiceImpl(ActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }

    @Override
    public List<Action> findAll() {
        return actionRepository.findAll();
    }

    @Override
    public Action findById(long id) {
        Optional<Action> result = actionRepository.findById(id);

        Action action = null;

        if (result.isPresent()) {
            action = result.get();
        } else {
            throw new RuntimeException("Did not find action id - " + id);
        }

        return action;
    }

    @Override
    public void save(Action action) {
        actionRepository.save(action);
    }

    @Override
    public void deleteById(long id) {
        actionRepository.deleteById(id);
    }

}
